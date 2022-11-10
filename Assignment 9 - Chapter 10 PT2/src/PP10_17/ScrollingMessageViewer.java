//Author: Jonathan Dang
//Project: PP10.17
package PP10_17;

import javax.swing.JFrame;

public class ScrollingMessageViewer {
	public static void main(String[] args)
	{
		ScrollingMessage MNB = new ScrollingMessage();
		MNB.setTitle("Assignment 10.17");
		MNB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MNB.setVisible(true);
	}
}
