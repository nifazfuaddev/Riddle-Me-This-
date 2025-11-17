
package oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    JButton rules, back;
    JTextField tfname;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("RIDDLE ME THIS!");
        heading.setBounds(250, 50, 300, 50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 24));
        heading.setForeground(new Color(240, 86, 127));
        add(heading);
        
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(264, 120, 300, 50);
        name.setFont(new Font("Tahoma", Font.BOLD, 20));
        name.setForeground(new Color(140, 208, 237));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(204, 190, 300, 35);
        tfname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(tfname);
        
        rules = new JButton("Next");
        rules.setBounds(264, 260, 80, 35);
        rules.setBackground(new Color(142, 110, 245));
        rules.setForeground(Color.WHITE);
        rules.setFont(new Font("Times New Roman", Font.BOLD, 16));
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(354, 260, 80, 35);
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);
        
        setSize(700, 450); //Width, Length
        setLocation(650, 250); //Left, Top
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        }else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new Login();
    }
}
