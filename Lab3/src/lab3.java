//Author: Jonathan Dang
//Project: 3.6
/*
 * The Project implements the Person and tests the basic functions that it has
 */
public class lab3 
{
	public static void main(String[] arg)
	{
		System.out.println("=================PROGRAM START=================");
		Person P1 = new Person("John");
		Person P2 = new Person("Swain");
		P2.befriend(P1);
		System.out.println(P2.getFriendNames());
		
		Person P3 = new Person("James", "John Swain Jorge Marge");
		System.out.println(P1.getName());
		System.out.println(P3.getName());
		
		System.out.println(P3.getFriendCount());
		System.out.println(P3.getFriendNames());
		P3.unfriend(P1);
		System.out.println(P3.getFriendNames());
		
		System.out.println("=================PROGRAM END=================");
	}
}

/*
=================PROGRAM START=================
John
John
James
4
John Swain Jorge Marge 
Swain Jorge Marge 
=================PROGRAM END=================
*/