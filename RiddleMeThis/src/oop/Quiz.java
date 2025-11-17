
package oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener{
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String [10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    JButton lifeline, next, submit;
    ButtonGroup groupopt;
    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name){
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        qno = new JLabel();
        qno.setBounds(80, 20, 470, 50);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(qno);
        
        question = new JLabel();
        question.setBounds(115, 20, 700, 50);
        question.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(question);
        
        questions[0][0] = "What is always coming but never arrives?";
        questions[0][1] = "Yesterday";
        questions[0][2] = "Tomorrow";
        questions[0][3] = "Success";
        questions[0][4] = "Bad Luck";

        questions[1][0] = "What can be broken but never held?";
        questions[1][1] = "A Promise";
        questions[1][2] = "Ice";
        questions[1][3] = "Cloud";
        questions[1][4] = "A Window";

        questions[2][0] = "What is it that lives if it is fed, and dies if you give it a drink?";
        questions[2][1] = "Fire";
        questions[2][2] = "A Sponge";
        questions[2][3] = "A Turtle";
        questions[2][4] = "Sand";

        questions[3][0] = "What word describes a man who does not have all his fingers on one hand?";
        questions[3][1] = "Abnormal";
        questions[3][2] = "Handsome";
        questions[3][3] = "Normal";
        questions[3][4] = "Sane";

        questions[4][0] = "What starts with “e” and ends with “e” but only has one letter in it?";
        questions[4][1] = "Earthquake";
        questions[4][2] = "Educate";
        questions[4][3] = "Eradicate";
        questions[4][4] = "Envelope";

        questions[5][0] = "If it takes eight men ten hours to build a wall, how long would it take four men?";
        questions[5][1] = "6 Hours";
        questions[5][2] = "No time";
        questions[5][3] = "2 Years";
        questions[5][4] = "30 Minutes";

        questions[6][0] = "What has a face and two hands, but no arms or legs?";
        questions[6][1] = "A Clock";
        questions[6][2] = "A Swordfish";
        questions[6][3] = "A Coin";
        questions[6][4] = "Smartphone";

        questions[7][0] = "How many seconds are there in a year?";
        questions[7][1] = "6644";
        questions[7][2] = "12";
        questions[7][3] = "12586980";
        questions[7][4] = "64";

        questions[8][0] = "Some months have 31 days, others have 30 days, but how many have 28 days?";
        questions[8][1] = "12";
        questions[8][2] = "1";
        questions[8][3] = "4";
        questions[8][4] = "6";

        questions[9][0] = "I am an odd number. Take away one letter and I become even. What number am I?";
        questions[9][1] = "Seven";
        questions[9][2] = "Eleven";
        questions[9][3] = "Nine";
        questions[9][4] = "Four";
        
        answers[0][1] = "Tomorrow";
        answers[1][1] = "A Promise";
        answers[2][1] = "Fire";
        answers[3][1] = "Normal";
        answers[4][1] = "Envelope";
        answers[5][1] = "No time";
        answers[6][1] = "A Clock";
        answers[7][1] = "12";
        answers[8][1] = "12";
        answers[9][1] = "Seven";
        
        opt1 = new JRadioButton();
        opt1.setBounds(100, 80, 470, 50);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(100, 120, 470, 50);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(100, 160, 470, 50);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(100, 200, 470, 50);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(opt4);
        
        groupopt = new ButtonGroup();
        groupopt.add(opt1);
        groupopt.add(opt2);
        groupopt.add(opt3);
        groupopt.add(opt4);
        
        lifeline = new JButton("Lifeline");
        lifeline.setBounds(110, 295, 80, 35);
        lifeline.setBackground(new Color(54, 138, 62));
        lifeline.setForeground(Color.WHITE);
        lifeline.setFont(new Font("Tahoma", Font.BOLD, 13));
        lifeline.addActionListener(this);
        add(lifeline);
        
        next = new JButton("Next");
        next.setBounds(200, 295, 80, 35);
        next.setBackground(new Color(140, 208, 237));
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Tahoma", Font.BOLD, 13));
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(290, 295, 80, 35);
        submit.setBackground(new Color(142, 110, 245));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 13));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setSize(850, 440); //Width, Length
        setLocation(650, 250); //Left, Top
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == lifeline){
            if(count == 2 || count == 4 || count == 6 || count == 8 || count == 9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else{
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }else if(ae.getSource() == next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            if(groupopt.getSelection() == null){
                useranswers[count][0] = "";
            }else{
                useranswers[count][0] = groupopt.getSelection().getActionCommand();
            }
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }else if(ae.getSource() == submit){
            ans_given = 1;
            if(groupopt.getSelection() == null){
                    useranswers[count][0] = "";
                }else{
                    useranswers[count][0] = groupopt.getSelection().getActionCommand();
                }
                for(int i = 0; i < useranswers.length; i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        score += 10;
                    }
                }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        String time = "Timer Left: " + timer + " seconds!";
        g.setColor(new Color(240, 86, 127));
        g.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        if(timer > 0){
            g.drawString(time, 100, 300);
        }else{
            g.drawString("Times Up!!!", 100, 300);
        }
        
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given = 0;
            timer = 20;
        }else if(timer < 0){
            timer = 20;
            
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                if(groupopt.getSelection() == null){
                    useranswers[count][0] = "";
                }else{
                    useranswers[count][0] = groupopt.getSelection().getActionCommand();
                }
                for(int i = 0; i < useranswers.length; i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, score);
            }else{
                if(groupopt.getSelection() == null){
                    useranswers[count][0] = "";
                }else{
                    useranswers[count][0] = groupopt.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }   
        }
    }
    
    public void start(int count){
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupopt.clearSelection();
    }
    
    public static void main(String[] args){
        new Quiz("User");
    }
}
