//Person Class
//Author: Jonathan Dang
public class Person{
		//Private Variables
		private int _friendCount;
		private String _name;
		private String _friendNames;
		
		//Constructors
		/**
	 	Constructs a Person object with @param name and no friends. :^(
	    */
		public Person(String name) 
		{
			_name = new String(name);
			_friendCount = 0;
			_friendNames = new String();
		}
		
		/**
	 	Constructs a Person object with @param name and @param friends.
	 	Counts the friends, assuming that the string is separated properly with spaces. :^)
		*/
		public Person(String name, String friends)
		{
			_name = new String(name);
			_friendCount = _friendCounter(friends);
			_friendNames = new String(friends) + " ";
		}
		
		//Methods
		/**
	 	A function that adds @param P to the friends list
		*/
		public void befriend(Person P)
		{
			if(_friendCount == 0)
			{
				_friendNames += P.getName();
			}
			else
			{
				_friendNames += " " + P.getName();
			}
			_friendCount++;
		}
		
		/**
	 	A function that removes @param P from the friends list
	    */
		public void unfriend(Person P)
		{
			//Error Handling
			if(_friendCount == 0)
			{
				return;
			}
			_friendNames = _friendNames.replaceAll(P.getName(), "");
			_friendNames = _friendNames.replace("  ", " ");
			if(_friendNames.charAt(0) == ' ')
			{
				_friendNames = _friendNames.substring(1);
			}
			_friendCount--;
		}
		
		/**
	 	A function with no parameters, acting as a getter for the _friendCount variable.
	 	@returns _friendCount
		*/
		public int getFriendCount()
		{
			return _friendCount;
		}
		
		/**
	 	A function that returns the Name of this person object.
	 	@returns _name
	    */
		public String getName()
		{
			/**
			 	A function that returns the Name of this person object.
			 	@returns _name
			 */
			return _name;
		}
		
		/**
	 	A function that returns the friends' name object
	 	@returns _friendNames;
	    */
		public String getFriendNames()
		{
			return _friendNames;
		}
		
		/**
	 	A private function apart of the Person class made to count the amount of
	 	friends from @param friends
	 	
	 	@returns count
	    */
		private int _friendCounter(String friends)
		{
			int count = 0;
			for(int i = 0; i < friends.length(); i ++)
			{
				if(friends.charAt(i) == ' ')
				{
					if((i - 1 > 0) && (friends.charAt(i-1) != ' '))
					{
						count++;
					}
				}
			}
			
			if((friends.charAt(friends.length()-1) != ' ') && !friends.isEmpty())
			{
				count++;
			}
			return count;
		}
	}//Class: Person
