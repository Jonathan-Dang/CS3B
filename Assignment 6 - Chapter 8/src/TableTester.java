//Author: Jonathan Dang
//Project: Chapter 8 - 8.6
public class TableTester {
	public static void main(String[] args)
	{
		Table t = new Table();
		
		//String: John Jacob Astor,1763,1848
		t.addLine("John Jacob Astor,1763,1848");
		System.out.println(t.getEntry(1, 1));
		System.out.println(t.getEntry(1, 2));
		System.out.println(t.getEntry(1, 3));
		//String: "John Jacob "Jakey" Astor VI",1912,1992
		t.addLine("\"John Jacob \"Jakey\" Astor VI\",1912,1992");	
		System.out.println(t.getEntry(2, 1));
		System.out.println(t.getEntry(2, 2));
		System.out.println(t.getEntry(2, 3));
		
	}
}
/*
John Jacob Astor
1763
1848
"John Jacob ""Jakey"" Astor VI"
1912
1992
*/