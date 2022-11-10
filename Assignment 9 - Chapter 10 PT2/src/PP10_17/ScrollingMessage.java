package PP10_17;

import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

@SuppressWarnings("serial")
/**
 * Scrolling Message Graphic Object
 * @author Jonathan Dang
 *
 */
public class ScrollingMessage extends JFrame {
	private final static int FRAME_WIDTH = 750;
	private final static int FRAME_HEIGHT = 500;
	private final static String DEFAULT_STRING = 
			"Somebody once told me the world is gonna roll me    \n"
			+ "I ain't the sharpest tool in the shed    \n"
			+ "She was looking kind of dumb with her finger and her thumb    \n"
			+ "In the shape of an \"L\" on her forehead    \n"
			+ "\n"
			+ "Well, the years start coming and they don't stop coming    \n"
			+ "Fed to the rules and I hit the ground running    \n"
			+ "Didn't make sense not to live for fun    \n"
			+ "Your brain gets smart but your head gets dumb    \n"
			+ "    \n"
			+ "So much to do, so much to see    \n"
			+ "So what's wrong with taking the back streets?    \n"
			+ "You'll never know if you don't go    \n"
			+ "You'll never shine if you don't glow    \n"
			+ "    \n"
			+ "Hey, now, you're an all-star, get your game on, go play    \n"
			+ "Hey, now, you're a rock star, get the show on, get paid    \n"
			+ "And all that glitters is gold    \n"
			+ "Only shooting stars break the mold    \n"
			+ "    \n"
			+ "It's a cool place and they say it gets colder    \n"
			+ "You're bundled up now wait 'til you get older    \n"
			+ "But the meteor men beg to differ    \n"
			+ "Judging by the hole in the satellite picture    \n"
			+ "    \n"
			+ "The ice we skate is getting pretty thin    \n"
			+ "The water's getting warm so you might as well swim    \n"
			+ "My world's on fire. How about yours?    \n"
			+ "That's the way I like it and I'll never get bored    \n"
			+ "    \n"
			+ "Hey, now, you're an all-star, get your game on, go play    \n"
			+ "Hey, now, you're a rock star, get the show on, get paid    \n"
			+ "And all that glitters is gold    \n"
			+ "Only shooting stars break the mold    \n"
			+ "    \n"
			+ "Go for the moon    \n"
			+ "Go for the moon    \n"
			+ "Go for the moon    \n"
			+ "Go for the moon    \n"
			+ "    \n"
			+ "Hey, now, you're an all-star, get your game on, go play    \n"
			+ "Hey, now, you're a rock star, get the show on, get paid    \n"
			+ "And all that glitters is gold    \n"
			+ "Only shooting stars    \n"
			+ "    \n"
			+ "Somebody once asked could I spare some change for gas    \n"
			+ "I need to get myself away from this place    \n"
			+ "I said yep, what a concept    \n"
			+ "I could use a little fuel myself    \n"
			+ "And we could all use a little change    \n"
			+ "    \n"
			+ "Well, the years start coming and they don't stop coming    \n"
			+ "Fed to the rules and I hit the ground running    \n"
			+ "Didn't make sense not to live for fun    \n"
			+ "Your brain gets smart but your head gets dumb    \n"
			+ "    \n"
			+ "So much to do, so much to see    \n"
			+ "So what's wrong with taking the back streets?    \n"
			+ "You'll never know if you don't go    \n"
			+ "You'll never shine if you don't glow    \n"
			+ "    \n"
			+ "Hey, now, you're an all star, get your game on, go play    \n"
			+ "Hey, now, you're a rock star, get the show on, get paid    \n"
			+ "And all that glitters is gold    \n"
			+ "Only shooting stars break the mold    \n"
			+ "    \n"
			+ "And all that glitters is gold    \n"
			+ "Only shooting stars break the mold     ";
	
	private JLabel _message;
	
	private JTextField _inputMessage;
	private JButton _confirmMessage;
	
	private int _delay = 100;
	private Timer _timer;
	private JSlider _delaySlider;
	
	@SuppressWarnings("rawtypes")
	private JComboBox _comboBox;
	private JCheckBox _italics;
	private JCheckBox _bold;
	
	private JSlider _redSlider;
	private JSlider _greenSlider;
	private JSlider _blueSlider;
	private JPanel _Color_and_Message;
	
	private JButton _reverseButton;
	private boolean _reverseEnabler = true;
	
	/**
	 * Constructs a JFrame Scrolling Message Program
	 */
	public ScrollingMessage()
	{
		createMessage();
		createTextField();
		createTextFieldButton();
		createReverseButton();
		createDelaySlider();
		
		createPanel();
		
		ActionListener AL = new ScrollingMessageActionListener();
		_timer = new Timer(_delay,AL);
		_timer.start();
	}
	
	/**
	 * Action Listener that controls scroll direction
	 * @author Jonathan Dang
	 *
	 */
	public class ScrollingMessageActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
		    if(_reverseEnabler)
		    {
		    	String oldText = _message.getText();
				String newText = oldText.substring(1) + oldText.substring(0,1);
			    _message.setText(newText);
		    }
		    else
		    {
		    	String oldText = _message.getText();
				String newText = oldText.substring(oldText.length()-1) + oldText.substring(0,oldText.length()-1);
			    _message.setText(newText);
		    }
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	//Reverse Button
	
	/**
	 * Action Listener that controls Reverse Button activation
	 * @author Jonathan Dang
	 *
	 */
	public class ReverseButtonActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			_reverseEnabler = !_reverseEnabler;
		}
	}
	
	/**
	 * Creates the Reverse Button
	 */
	private void createReverseButton()
	{
		_reverseButton = new JButton("Reverse Direction");
		ActionListener AL = new ReverseButtonActionListener();
		_reverseButton.addActionListener(AL);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	//Message and Text Field
	
	/**
	 * Creates the JLabel with the scrolling message
	 */
	private void createMessage()
	{
		_message = new JLabel(DEFAULT_STRING);
		_message.setFont(new Font("Arial", 0, 25));
		_message.setBackground(Color.white);
	}
	
	/**
	 * Creates a JTextField in which changes the scrolling message's message
	 */
	private void createTextField()
	{	
		final int FIELD_WIDTH = 15;
		_inputMessage = new JTextField(FIELD_WIDTH);
		_inputMessage.setText("Set Your Message Here");
	}
	
	/**
	 * Action Listener that controls the Button to set the new message
	 * @author Jonathan Dang
	 *
	 */
	public class TextFieldButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			_message.setText(_inputMessage.getText());
			_inputMessage.setText("Set Your Message Here");
		}
	}
	
	/**
	 * Creates the Button that confirms Message change
	 */
	public void createTextFieldButton()
	{
		_confirmMessage = new JButton("Set Message");
		
		ActionListener AL = new TextFieldButtonListener();
		_confirmMessage.addActionListener(AL);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//Delay Section
	
	/**
	 * Action Listener that controls the delay
	 * @author pocke
	 *
	 */
	public class DelayListener implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e) {
			setDelay();
		}
	}
	
	/**
	 * Sets the Delay to the active JSlider
	 */
	private void setDelay()
	{
		_timer.setDelay(_delaySlider.getValue());
	}
	
	/**
	 * Creates the Delay Slider
	 */
	private void createDelaySlider()
	{
		ChangeListener AL = new DelayListener();
		_delaySlider = new JSlider(100,500,100);
		_delaySlider.addChangeListener(AL);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//Font
	
	/**
	 * Action Listener that controls The Special Font Styles
	 * @author Jonathan Dang
	 *
	 */
	public class FontListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			setLabelFont();
		}
	}
	
	/**
	 * Sets the Message's Font as specified within program
	 */
	private void setLabelFont()
	{
		String font = (String) _comboBox.getSelectedItem();
		
		int style = 0;
		if(_italics.isSelected())
		{
			style += Font.ITALIC;
		}
		if(_bold.isSelected())
		{
			style += Font.BOLD;
		}
		
		_message.setFont(new Font(font, style, 25));
	}
	
	/**
	 * Creates the Check Boxes for Italics and Bold
	 * @returns a JPanel as such
	 */
	private JPanel createCheckBoxes()
	{
		ActionListener AL = new FontListener();
		
		_italics = new JCheckBox("Italics");
		_italics.addActionListener(AL);
		
		_bold = new JCheckBox("Bold");
		_bold.addActionListener(AL);
		
		JPanel JP = new JPanel();
		JP.add(_italics);
		JP.add(_bold);
		JP.setBorder(new TitledBorder(new EtchedBorder(),"Style"));
		
		return JP;
	}
	
	/**
	 * Creates a Drop down menu box with 3 available Fonts
	 * @returns a JPanel with said functionality
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JPanel createComboBox()
	{
		_comboBox = new JComboBox();
		ActionListener AL = new FontListener();
		
		_comboBox.addItem("Arial");
		_comboBox.addItem("Monospaced");
		_comboBox.addItem("Serif");
		_comboBox.setEditable(true);
		_comboBox.addActionListener(AL);
		
		JPanel JP = new JPanel();
		JP.add(_comboBox);
		return JP;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//Background Color
	
	/**
	 * Action Listener that controls the Background color
	 * @author Jonathan Dang
	 *
	 */
	public class BackgroundColorListener implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e) {
			setBackgroundColor();
		}
	}
	
	/**
	 * Sets the Background color to the slider values
	 */
	private void setBackgroundColor()
	{
		int red = _redSlider.getValue();
		int green = _greenSlider.getValue();
		int blue = _blueSlider.getValue();
		
		_Color_and_Message.setBackground(new Color(red,green,blue));
		_Color_and_Message.repaint();
	}
	
	/**
	 * Creates the background color sliders
	 * @returns a JPanel with Slider Functionality
	 */
	private JPanel createBackgroundColorSlider()
	{
		JPanel JP = new JPanel();
		ChangeListener CL = new BackgroundColorListener();
		
		_redSlider = new JSlider(0,255,255);
		_redSlider.addChangeListener(CL);
		
		_greenSlider = new JSlider(0,255,255);
		_greenSlider.addChangeListener(CL);
		
		_blueSlider = new JSlider(0,255,255);
		_blueSlider.addChangeListener(CL);
		
		JP.setLayout(new GridLayout(3,2));
		
		JP.add(new JLabel("Red"));
		JP.add(_redSlider);
		
		JP.add(new JLabel("Green"));
		JP.add(_greenSlider);
		
		JP.add(new JLabel("Blue"));
		JP.add(_blueSlider);
		
		return JP;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Constructs the control panel that manipulates the message displayed
	 */
	private void createPanel()
	{
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(2,3));
		
		JPanel changeMessage = new JPanel();
		JPanel delayEditor = new JPanel();
		JPanel bgColor = createBackgroundColorSlider();
		bgColor.setBorder(new TitledBorder(new EtchedBorder(),"BackGround Color"));
		
		//Primary Setting
		
		//Color
		_Color_and_Message = new JPanel();
		setBackgroundColor();
		
		//Message
		_Color_and_Message.add(_message, BorderLayout.CENTER);
		add(_Color_and_Message,BorderLayout.CENTER);
		
		//Change the message
		changeMessage.add(_inputMessage);
		changeMessage.add(_confirmMessage);
		
		//Change the delay
		delayEditor.add(_delaySlider);
		delayEditor.setBorder(new TitledBorder(new EtchedBorder(),"Delay"));
		
		//Adding all sections of the control panel
		controlPanel.add(changeMessage);
		controlPanel.add(delayEditor);
		controlPanel.add(createCheckBoxes());
		controlPanel.add(createComboBox());
		controlPanel.add(bgColor);
		controlPanel.add(_reverseButton);
		add(controlPanel, BorderLayout.SOUTH);
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
	}
}