
package oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener{
    String name;
    JButton back, start;

    Rules(String name){
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+name+" to RIDDLE ME THIS!");
        heading.setBounds(175, 30, 500, 50);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
        heading.setForeground(new Color(142, 110, 245));
        add(heading);
        
        JLabel rules = new JLabel("Welcome "+name+" to RIDDLE ME THIS!");
        rules.setBounds(100, 0, 500, 500);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>"+ 
                "1. Each riddle must be answered within X seconds. If time runs out, it counts as a wrong answer." + "<br><br>" +
                "2. You get only one attempt per riddle." + "<br><br>" +
                "3. Once you move to the next riddle, you cannot return to the previous one." + "<br><br>" +
                "4. There will be a 50/50 Lifeline button. Eliminate two incorrect options, leaving the correct answer and one incorrect option. The lifeline can only be used once." + "<br><br>" +
                "5. At the end of the quiz, a total score will be given." + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(140, 410, 80, 35);
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman", Font.BOLD, 16));
        back.addActionListener(this);
        add(back);
        
        start = new JButton("Start");
        start.setBounds(450, 410, 80, 35);
        start.setBackground(new Color(140, 208, 237));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("Times New Roman", Font.BOLD, 16));
        start.addActionListener(this);
        add(start);

        setSize(700, 550); //Width, Length
        setLocation(650, 250); //Left, Top
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            setVisible(false);
            new Quiz(name);
        }else{
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new Rules("User");
    }
}
