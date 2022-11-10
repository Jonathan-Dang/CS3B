//Dang, Jonathan
//Lab 2 | 2-5
//This file does not take an input but outputs two frames in sequence
//as described in programming project 2-5
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TranslateDemo {
    public static void main(String[] args) {
        //Construct a frame and show it
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Translate Demo");
        frame.setSize(800,600);
        frame.setVisible(true);

        //Your work goes here: Construct a rectangle and set the frame bounds
        Rectangle box = new Rectangle(10,10,800,600);
        frame.setBounds(box);

        JOptionPane.showMessageDialog(frame, "Click OK to continue");

        //Your work goes here: Move the rectangle and set the frame bounds again
        box.setSize(400,400);
        box.translate(400,400);
        frame.setBounds(box);

        System.out.println("============================= MAIN END =======================");
    }
}
//There is no sample output due to the output being a Graphic