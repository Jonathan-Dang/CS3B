//Author: Jonathan Dang
//Project: Assignment 6 - 8.1
public class ComboLockTester {
	public static void main(String[] arg)
	{
		System.out.println("=======================SYSTEM START=======================");
		//Combination: 29 34 1
		ComboLock lock1 = new ComboLock(29, 34, 1);
		
		//Testing for invalid turn order
		lock1.turnLeft(29);
		lock1.turnRight(34);
		lock1.turnLeft(1);
		if(lock1.open())
			System.out.println("Test 1: Opening Success");
		else
			System.out.println("Test 1: Opening Failed");
		
		lock1.reset();
		
		//Testing for Invalid Combination input
		lock1.turnRight(29);
		lock1.turnLeft(34);
		lock1.turnRight(0);
		if(lock1.open())
			System.out.println("Test 2: Opening Success");
		else
			System.out.println("Test 2: Opening Failed");
		
		lock1.reset();
		
		//Testing for Valid Combination and Turn order
		lock1.turnRight(29);
		lock1.turnLeft(34);
		lock1.turnRight(1);
		if(lock1.open())
			System.out.println("Test 3: Opening Success");
		else
			System.out.println("Test 3: Opening Failed");
		
		
		System.out.println("=======================SYSTEM  END =======================");
	}
}
/*
=======================SYSTEM START=======================
Test 1: Opening Failed
Test 2: Opening Failed
Test 3: Opening Success
=======================SYSTEM  END =======================
*/