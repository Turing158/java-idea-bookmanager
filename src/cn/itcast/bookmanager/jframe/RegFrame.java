package cn.itcast.bookmanager.jframe;


import cn.itcast.bookmanager.dao.UserDao;
import cn.itcast.bookmanager.model.User;
import cn.itcast.bookmanager.util.JdbcUtils;
import cn.itcast.bookmanager.util.ToolUtils;
import com.mysql.jdbc.Connection;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RegFrame extends JFrame {
	private JFrame jf;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_2;
	private JTextField textField_2;
	private JLabel label_3;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel usernameMes;
	private JLabel passwordMes;
	private JLabel phoneMes;
	private JLabel label_4;
	private JTextField textField_3;
	private JButton button;
	private JButton button_1;
	private JRadioButton rdbtnNewRadioButton;
	
	JdbcUtils dbUtil=new JdbcUtils();
	UserDao userDao=new UserDao();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	public RegFrame() {
		jf=new JFrame("用户注册");
		jf.getContentPane().setFont(new Font("幼圆", Font.BOLD, 16));
		jf.setBounds(600, 250,510, 410);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("用户名：");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("幼圆", Font.BOLD, 16));
		label.setBounds(110, 65, 75, 40);
		jf.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("幼圆", Font.BOLD, 14));
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(198, 71, 164, 30);
		jf.getContentPane().add(textField);
		
		textField.addFocusListener(new FocusListener() {		

			@Override
			public void focusGained(FocusEvent e) {
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
				String text = textField.getText();
				if(ToolUtils.isEmpty(text)){
					usernameMes.setText("✖用户名不能为空✖");
					usernameMes.setForeground(Color.RED);
				}else{
					usernameMes.setText("√");
					usernameMes.setForeground(Color.GREEN);
				}
			}
		});
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("幼圆", Font.BOLD, 16));
		label_1.setBounds(120, 108, 65, 40);
		jf.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 14));
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		textField_1.setBounds(198, 114, 164, 30);
		jf.getContentPane().add(textField_1);
		
		textField_1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {	
				String pwd=textField_1.getText();
				if(ToolUtils.isEmpty(pwd)){
					passwordMes.setText("✖密码不能为空✖");
					passwordMes.setForeground(Color.RED);
				}else{
					boolean flag=pwd.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
					if(flag){
						passwordMes.setText("√");
						passwordMes.setForeground(Color.GREEN);
					}else{
						JOptionPane.showMessageDialog(null, "密码需为6-16位数字和字母的组合");
						passwordMes.setText("");
					}
	
				}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
		
				
			}
		});
		
		label_2 = new JLabel("手机号：");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("幼圆", Font.BOLD, 16));
		label_2.setBounds(110, 150, 75, 40);
		jf.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(198, 156, 164, 30);
		jf.getContentPane().add(textField_2);
		
		textField_2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String phone=textField_2.getText();
				if(ToolUtils.isEmpty(phone)){
					phoneMes.setText("手机号不能为空");
					phoneMes.setForeground(Color.RED);
				}else{
					boolean flag=phone.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
					if(flag){
						phoneMes.setText("√");
						phoneMes.setForeground(Color.GREEN);
					}else{
						JOptionPane.showMessageDialog(null, "请输入正确的手机号格式");
						phoneMes.setText("");
					}
	
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
				
			}
		});
		
		label_3 = new JLabel("性别：");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("幼圆", Font.BOLD, 16));
		label_3.setBounds(123, 184, 65, 40);
		jf.getContentPane().add(label_3);
		
		rdbtnNewRadioButton = new JRadioButton("♂男");
		rdbtnNewRadioButton.setFont(new Font("幼圆", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(198, 192, 58, 23);
		jf.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("♀女");
		rdbtnNewRadioButton_1.setFont(new Font("幼圆", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(287, 192, 65, 23);
		jf.getContentPane().add(rdbtnNewRadioButton_1);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		
		usernameMes = new JLabel("");
		usernameMes.setFont(new Font("Dialog", Font.BOLD, 15));
		usernameMes.setBounds(372, 57, 122, 27);
		jf.getContentPane().add(usernameMes);
		
		passwordMes = new JLabel("");
		passwordMes.setFont(new Font("Dialog", Font.BOLD, 15));
		passwordMes.setBounds(372, 100, 122, 27);
		jf.getContentPane().add(passwordMes);
		
		phoneMes = new JLabel("");
		phoneMes.setFont(new Font("Dialog", Font.BOLD, 15));
		phoneMes.setBounds(372, 142, 122, 30);
		jf.getContentPane().add(phoneMes);

		
		button = new JButton("|注册|");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

						RegCheck(e);

			}
		});
		button.setFont(new Font("幼圆", Font.BOLD, 15));
		button.setBounds(120, 299, 75, 30);
		jf.getContentPane().add(button);
		
		button_1 = new JButton("|前往登录页面|");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				new LoginFrame();
			}
		});
		button_1.setFont(new Font("幼圆", Font.BOLD, 15));
		button_1.setBounds(245, 299, 132, 30);
		jf.getContentPane().add(button_1);
		
		lblNewLabel_1 = new JLabel("用户注册");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_1.setBounds(184, 10, 122, 51);
		jf.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(RegFrame.class.getResource("/tupian/regBG.png")));
		lblNewLabel.setBounds(0, 0, 494, 372);
		jf.getContentPane().add(lblNewLabel);
		
		jf.setVisible(true);
		jf.setResizable(true);
	}
	protected void RegCheck(ActionEvent e) {
		String username=textField.getText();
		String password=textField_1.getText();
		String phone=textField_2.getText();
		String sex="";
		if(rdbtnNewRadioButton.isSelected()){
			sex=rdbtnNewRadioButton.getText();
		}else{
			sex=rdbtnNewRadioButton_1.getText();
		}
		if (ToolUtils.isEmpty(username) || ToolUtils.isEmpty(password)|| ToolUtils.isEmpty(phone)) {
			JOptionPane.showMessageDialog(null, "请输入相关信息");
			return;
		}
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setPhone(phone);
		user.setRole(1);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			int i = userDao.addUser(con, user);
			if (i == 2) {
				JOptionPane.showMessageDialog(null, "✖该用户名已存在,请重新注册✖");
			} else if (i == 0) {
				JOptionPane.showMessageDialog(null, "✖注册失败✖");
			} else {
				JOptionPane.showMessageDialog(null, "✔注册成功✔");
				jf.dispose();
				new LoginFrame();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
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
		new RegFrame();
	}
}
