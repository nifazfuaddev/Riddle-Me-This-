
package oop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class QuizTest extends JFrame implements ActionListener{
    
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton buttonNext, buttonResult;
    ButtonGroup bg;
    
    int count = 0, questionNo = 0, x = 1, y = 1, now = 0;
    int n[] = new int [10];
    
    QuizTest(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i=0; i<5; i++){
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        
        buttonNext = new JButton("Next");
        buttonResult = new JButton("Result");
        buttonResult.setVisible(false); //Result button invisible
        buttonNext.addActionListener(this);
        buttonResult.addActionListener(this);
        add(buttonNext);
        add(buttonResult);
        setData();
        label.setBounds(30,40,450,20); //x, y, width, height
        radioButtons[0].setBounds(50,80,300,20); 
        radioButtons[1].setBounds(50,110,300,20); 
        radioButtons[2].setBounds(50,140,300,20); 
        radioButtons[3].setBounds(50,170,300,20); 
        buttonNext.setBounds(100,220,100,30); 
        buttonResult.setBounds(200,220,100,30); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //windowConstant
        setLayout(null);
        setLocation(250, 100); //x, y
        setVisible(true); //Result button visible
        setSize(600, 250); //width, height
        
    }
    
    void setData(){
        radioButtons[4].setSelected(true);
        if(questionNo==0){
            label.setText("Q1: What has a face and two hands but no arms or legs?");
            radioButtons[0].setText("A Chair");
            radioButtons[1].setText("A Human");
            radioButtons[2].setText("A Clock");
            radioButtons[3].setText("A Monster");
        }
        if(questionNo==1){
            label.setText("Q2: I have hundreds of wheels, but move I do not. Call me what I am; call me a lot. What am I?");
            radioButtons[0].setText("A Tank");
            radioButtons[1].setText("A Parking Lot");
            radioButtons[2].setText("A Dock");
            radioButtons[3].setText("A House");
        }
        if(questionNo==2){
            label.setText("Q3: What word contains 26 letters but only has three syllables?");
            radioButtons[0].setText("Radioimmunoelectrophoresis");
            radioButtons[1].setText("Balcony");
            radioButtons[2].setText("Alphabet");
            radioButtons[3].setText("Gallery");
        }
        if(questionNo==3){
            label.setText("Q4: What comes down but never goes up?");
            radioButtons[0].setText("Rain");
            radioButtons[1].setText("Gravity");
            radioButtons[2].setText("Boulder");
            radioButtons[3].setText("Life");
        }
        if(questionNo==4){
            label.setText("Q5: Which fish costs the most?");
            radioButtons[0].setText("Tiger Shark");
            radioButtons[1].setText("Clownfish");
            radioButtons[2].setText("Catfish");
            radioButtons[3].setText("Goldfish");
        }
        if(questionNo==5){
            label.setText("Q6: What is 3/7 chicken, 2/3 cat, and 2/4 goat?");
            radioButtons[0].setText("Platypus");
            radioButtons[1].setText("Cheetah");
            radioButtons[2].setText("A Mountain");
            radioButtons[3].setText("Chicago");
        }
        if(questionNo==6){
            label.setText("Q7: I am an odd number. Take away a letter and I become even. What number am I?");
            radioButtons[0].setText("Seven");
            radioButtons[1].setText("Thirteen");
            radioButtons[2].setText("Four");
            radioButtons[3].setText("Nine");
        }
        if(questionNo==7){
            label.setText("Q8: I sometimes run, but I can’t walk. What am I?");
            radioButtons[0].setText("An Old Man");
            radioButtons[1].setText("A Mouth");
            radioButtons[2].setText("A Stick");
            radioButtons[3].setText("A Nose");
        }
        if(questionNo==8){
            label.setText("Q9: Forward, I am heavy; backward, I am not. What am I?");
            radioButtons[0].setText("A Feather");
            radioButtons[1].setText("Ton");
            radioButtons[2].setText("Magnets");
            radioButtons[3].setText("A Piece of Paper");
        }
        if(questionNo==9){
            label.setText("Q10: Poor people have it. Rich people need it. If you eat it you die. What is it?");
            radioButtons[0].setText("Money");
            radioButtons[1].setText("Time");
            radioButtons[2].setText("Respect");
            radioButtons[3].setText("Nothing");
        }
        
         
    }
         
    boolean checkAns(){
        if(questionNo==0){
            return (radioButtons[2].isSelected());
        }
        if(questionNo==1){
            return (radioButtons[1].isSelected());
        }
        if(questionNo==2){
            return (radioButtons[2].isSelected());
        }
        if(questionNo==3){
            return (radioButtons[0].isSelected());
        }
        if(questionNo==4){
            return (radioButtons[3].isSelected());
        }
        if(questionNo==5){
            return (radioButtons[3].isSelected());
        }
        if(questionNo==6){
            return (radioButtons[0].isSelected());
        }
        if(questionNo==7){
            return (radioButtons[3].isSelected());
        }
        if(questionNo==8){
            return (radioButtons[1].isSelected());
        }
        if(questionNo==9){
            return (radioButtons[3].isSelected());
        }else{
            return false;
        }
        
    }
         
    public static void main(String[] args){
        new QuizTest("RIDDLE ME THIS!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonNext){
            if(checkAns()){
                count = count + 1; 
                questionNo++;
            }
            setData();
            if(questionNo==9){
                buttonNext.setEnabled(false);
                buttonResult.setVisible(true);
                buttonResult.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Result")){
            if(checkAns()){
                count = count + 1; 
                questionNo++;
                JOptionPane.showMessageDialog(this, "The Number of Correct Answers are: "+count);
                System.exit(0);
            }
        }
    } 
}
