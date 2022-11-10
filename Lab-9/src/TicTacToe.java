import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
/**
 * GUI for the Tic Tac Toe Game
 * @author Jonathan Dang | Zaojia Zhao
 *
 */
public class TicTacToe extends JFrame{
	private static final int FRAME_SIDE_LENGTH = 900;
	
	private ArrayList<Rectangle2D.Double> _zones = new ArrayList<Rectangle2D.Double>();
	private boolean _turn = true; //True = X's turn | False = O's turn
	private String[][] _boardState = new String[3][3];
	private int _Counter = 0;
	
	/**
	 * Constructs and executes a Tic Tac Toe Game
	 */
	public TicTacToe()
	{
		createZones();
		setDefaultBoardState();
		
		MouseListener ML = new TicTacToeListener();
		addMouseListener(ML);

		setTitle("TicTacToe");
		setSize(FRAME_SIDE_LENGTH,FRAME_SIDE_LENGTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Public Override for the Paint method given from .windows library
	 */
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Line2D.Double verticalLine1 = new Line2D.Double(new Point2D.Double(FRAME_SIDE_LENGTH/3,0),
				new Point2D.Double(FRAME_SIDE_LENGTH/3,FRAME_SIDE_LENGTH));
		Line2D.Double verticalLine2 = new Line2D.Double(new Point2D.Double((FRAME_SIDE_LENGTH/3) * 2,0),
				new Point2D.Double((FRAME_SIDE_LENGTH/3) * 2,FRAME_SIDE_LENGTH));
		
		Line2D.Double horizontalLine1 = new Line2D.Double(new Point2D.Double(0,FRAME_SIDE_LENGTH/3),
				new Point2D.Double(FRAME_SIDE_LENGTH,FRAME_SIDE_LENGTH/3));
		Line2D.Double horizontalLine2 = new Line2D.Double(new Point2D.Double(0,(FRAME_SIDE_LENGTH/3) * 2),
				new Point2D.Double(FRAME_SIDE_LENGTH,(FRAME_SIDE_LENGTH/3) * 2));
		
		g2.draw(verticalLine1);
		g2.draw(verticalLine2);
		g2.draw(horizontalLine1);
		g2.draw(horizontalLine2);
	}
	
	/**
	 * TicTacToe Mouse Listener
	 * @author Jonathan Dang | Zaojia Zhao
	 *
	 */
	public class TicTacToeListener implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) {
			Graphics g = getGraphics();
			if(_Counter < 9)
			{
				for(int i = 0; i < 9; i++)
				{
					if(_zones.get(i).contains(getMousePosition()) && _boardState[i/3][i%3].isEmpty())
					{
						markSquare(i + 1);
						turnChange();
						break;
					}
				}
			}
			else
			{
				JFrame f= new JFrame();
				int option = JOptionPane.showConfirmDialog(f,"Game Over: No More Possible Moves!\n" + "Restart the game?");
				
				if(option == JOptionPane.YES_OPTION)
				{
					_Counter = 0;
					
					g.clearRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());
					setDefaultBoardState();
					repaint();
				}
				else
				{
					dispose();
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/**
	 * Changes the turn and keeps track of the amount of turns
	 * Also displays whose turn it is.
	 */
	private void turnChange()
	{
		_turn = !_turn;
		
		JFrame f = new JFrame();  
	    JOptionPane.showMessageDialog(f,_turn ? "It is X's Turn" : "It is O's Turn"); 
	    _Counter++;
	}
	
	/**
	 * Sets the private _boardState to it's default setting
	 */
	private void setDefaultBoardState()
	{
		for(int i = 0 ; i < 3; i++)
		{
			for(int t = 0; t < 3; t++)
			{
				_boardState[i][t] = "";
			}
		}
	}
	
	/**
	 * Marks the pos a certain player's marker depending on the turn
	 * @param pos The position
	 */
	private void markSquare(int pos)
	{
		if(pos <= 0 || pos > 9)
			throw new IllegalArgumentException("Invalid Position");
		Graphics2D g2 = (Graphics2D)this.getGraphics();
		X xPiece;
		O oPiece;
		if(_turn)
		{
			switch(pos)
			{
			case(1):
				xPiece = new X(0,0);
				xPiece.draw(g2);
				_boardState[0][0] = "X";
				break;
			case(2):
				xPiece = new X(0,300);
				xPiece.draw(g2);
				_boardState[1][0] = "X";
				break;
			case(3):
				xPiece = new X(0,600);
				xPiece.draw(g2);
				_boardState[2][0] = "X";
				break;
			case(4):
				xPiece = new X(300,0);
				xPiece.draw(g2);
				_boardState[1][0] = "X";
				break;
			case(5):
				xPiece = new X(300,300);
				xPiece.draw(g2);
				_boardState[1][1] = "X";
				break;
			case(6):
				xPiece = new X(300,600);
				xPiece.draw(g2);
				_boardState[1][2] = "X";
				break;
			case(7):
				xPiece = new X(600,0);
				xPiece.draw(g2);
				_boardState[2][0] = "X";
				break;
			case(8):
				xPiece = new X(600,300);
				xPiece.draw(g2);
				_boardState[2][1] = "X";
				break;
			case(9):
				xPiece = new X(600,600);
				xPiece.draw(g2);
				_boardState[2][2] = "X";
				break;
			}
		}
		else
		{
			switch(pos)
			{
			case(1):
				oPiece = new O(0,0);
				oPiece.draw(g2);
				_boardState[0][0] = "O";
				break;
			case(2):
				oPiece = new O(0,300);
				oPiece.draw(g2);
				_boardState[1][0] = "O";
				break;
			case(3):
				oPiece = new O(0,600);
				oPiece.draw(g2);
				_boardState[2][0] = "O";
				break;
			case(4):
				oPiece = new O(300,0);
				oPiece.draw(g2);
				_boardState[1][0] = "O";
				break;
			case(5):
				oPiece = new O(300,300);
				oPiece.draw(g2);
				_boardState[1][1] = "O";
				break;
			case(6):
				oPiece = new O(300,600);
				oPiece.draw(g2);
				_boardState[1][2] = "O";
				break;
			case(7):
				oPiece = new O(600,0);
				oPiece.draw(g2);
				_boardState[2][0] = "O";
				break;
			case(8):
				oPiece = new O(600,300);
				oPiece.draw(g2);
				_boardState[2][1] = "O";
				break;
			case(9):
				oPiece = new O(600,600);
				oPiece.draw(g2);
				_boardState[2][2] = "O";
				break;
			}
		}
	}
	
	/**
	 * Creates the mouse clicker detection zones
	 */
	private void createZones()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int t = 0; t < 3; t++)
			{
				_zones.add(new Rectangle2D.Double(i*300,t*300,300,300));
			}
		}
	}
}
