package cn.itcast.bookmanager.demo;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

public class jframe {
    private JFrame jf;
    private JButton button1;
    private JLabel jl;
    @Test
    public void show(){
        JFrame jf = new JFrame("☺☺☺☺☺☺");
        jf.setTitle("☺☺☺☺☺☺");
        jf.setBounds(100,100,100,100);
        jf.getContentPane().setLayout(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JPanel jp = new JPanel();
        JLabel jl = new JLabel();
        jf.setTitle("☺☺☺☺☺☺");
        jf.setBounds(100,100,1000,1000);
        jp.setBackground(new Color(100,150,200));
        jl.setText("郑培昊我最帅");
        jl.setBounds(10,10,800,200);
        jl.setFont(new Font("幼圆", Font.ITALIC,50));
        jf.add(jl);
        jf.add(jp);
        jf.setVisible(true);
    }
}
