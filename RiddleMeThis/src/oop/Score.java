
package oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener{
    
    Score(String name, int score){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Thank you "+name+" for playing RIDDLE ME THIS!");
        heading.setBounds(40, 60, 470, 50);
        heading.setForeground(new Color(240, 86, 127));
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel scorenum = new JLabel("Your Score is: "+score);
        scorenum.setBounds(180, 120, 470, 50);
        scorenum.setForeground(new Color(140, 208, 237));
        scorenum.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(scorenum);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(206, 190, 110, 35);
        submit.setBackground(new Color(142, 110, 245));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 13));
        submit.addActionListener(this);
        add(submit);
        
        setSize(550, 350); //Width, Length
        setLocation(650, 250); //Left, Top
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args){
        new Score("User", 0);
    }
}
