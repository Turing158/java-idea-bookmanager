package cn.itcast.bookmanager.jframe;

import cn.itcast.bookmanager.dao.UserDao;
import cn.itcast.bookmanager.model.User;
import cn.itcast.bookmanager.util.JFrameUtils;
import cn.itcast.bookmanager.util.JdbcUtils;
import cn.itcast.bookmanager.util.ToolUtils;
import com.mysql.jdbc.Connection;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
	public static User currentUser;
	private JFrame jf;
	private JTextField userNameText;
	private JTextField passwordText;
	private JComboBox<String> comboBox;
	
	UserDao userDao = new UserDao();
	JdbcUtils dbUtil = new JdbcUtils();
	public LoginFrame(){
				
		jf=new JFrame("图书管理");
		jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 14));
		jf.setBounds(600, 250, 500, 467);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(LoginFrame.class.getResource("/tupian/bg2.png")));
		lblNewLabel.setBounds(24, 10, 430, 218);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("用户名：");
		label.setFont(new Font("幼圆", Font.BOLD, 14));
		label.setBounds(129, 250, 60, 29);
		jf.getContentPane().add(label);
		
		userNameText = new JTextField();
		userNameText.setBounds(199, 252, 127, 25);
		jf.getContentPane().add(userNameText);
		userNameText.setColumns(10);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("幼圆", Font.BOLD, 14));
		label_1.setBounds(144, 289, 45, 29);
		jf.getContentPane().add(label_1);
		
		passwordText = new JPasswordField();
		passwordText.setColumns(10);
		passwordText.setBounds(199, 291, 127, 25);
		jf.getContentPane().add(passwordText);
		

		JButton button = new JButton("|登录|");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin(e);
			}
		});
		button.setBounds(153, 377, 65, 29);
		jf.getContentPane().add(button);
		
		JButton button_1 = new JButton("|注册|");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regUser(e);
			}
		});
		button_1.setBounds(263, 377, 65, 29);
		jf.getContentPane().add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/tupian/adBG3.png")));
		lblNewLabel_1.setBounds(0, 0, 484, 429);
		jf.getContentPane().add(lblNewLabel_1);
		
		jf.setVisible(true);
		jf.setResizable(true);
		
	}
	protected void regUser(ActionEvent e) {
		jf.setVisible(false);
		new RegFrame();
		
	}
	protected void checkLogin(ActionEvent e) {
		String userName = userNameText.getText();
		String password = passwordText.getText();
		int index = 1; //缺省设置为普通用户
		if (ToolUtils.isEmpty(userName) || ToolUtils.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "!用户名和密码不能为空!");
			return;
		}
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);

		//System.out.println(user);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			User loginUser = userDao.login(con, user);
			System.out.println("login :"+loginUser);
			currentUser = loginUser;
			if (loginUser == null) {
				JOptionPane.showMessageDialog(null, "✖登录失败✖");
			} else {

					jf.dispose();
				    new UserFrame();
			}
		} catch (Exception e21) {

			e21.printStackTrace();
			JOptionPane.showMessageDialog(null, "✖登录异常✖");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e31) {

				e31.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new LoginFrame();
	}
}
