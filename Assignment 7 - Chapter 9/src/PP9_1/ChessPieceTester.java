//Author: Jonathan Dang
//Project: PP 9.1
package PP9_1;
import java.util.ArrayList;

public class ChessPieceTester {
	public static void main(String[] arg)
	{
		//White Pawn Starting Position
		Pawn w1 = new Pawn("a2","white");
		ArrayList<String> w1Possible = w1.canMoveTo();
		for(int i = 0; i < w1Possible.size();i++)
		{
			System.out.print(w1Possible.get(i) + ", ");
		}
		System.out.println();
		
		//White Rook Starting Position
		Rook w2 = new Rook("a1","white");
		ArrayList<String> w2Possible = w2.canMoveTo();
		for(int i = 0; i < w2Possible.size();i++)
		{
			System.out.print(w2Possible.get(i) + ", ");
		}
		System.out.println();
		
		//White Knight Starting Position
		Knight w3 = new Knight("b1", "white");
		ArrayList<String> w3Possible = w3.canMoveTo();
		for(int i = 0; i < w3Possible.size(); i++)
		{
			System.out.print(w3Possible.get(i) + ", ");
		}
		System.out.println();
		
		//White Bishop Starting Position
		Bishop w4 = new Bishop("c1", "white");
		ArrayList<String> w4Possible = w4.canMoveTo();
		for(int i = 0; i < w4Possible.size(); i ++)
		{
			System.out.print(w4Possible.get(i) + ", ");
		}
		System.out.println();
		
		//White Queen Starting Position
		Queen w5 = new Queen("d1", "white");
		ArrayList<String> w5Possible = w5.canMoveTo();
		for(int i = 0; i < w5Possible.size(); i ++)
		{
			System.out.print(w5Possible.get(i) + ", ");
		}
		System.out.println();
		
		//White King Starting Position
		King w6 = new King("e1", "white");
		ArrayList<String> w6Possible = w6.canMoveTo();
		for(int i = 0; i < w6Possible.size(); i++)
		{
			System.out.print(w6Possible.get(i) + ", ");
		}
		System.out.println();
	}
}
/*
a3, a4, 
a2, a3, a4, a5, a6, a7, a8, b1, c1, d1, e1, f1, g1, h1, 
a7, b8, e7, d8, a5, b4, e5, d4, 
d2, e3, f4, g5, h6, b2, a3, 
e2, f3, g4, h5, c2, b3, a4, d2, d3, d4, d5, d6, d7, d8, b1, c1, d1, e1, f1, g1, h1, 
d1, d2, f1, f2, e2, 
*/
