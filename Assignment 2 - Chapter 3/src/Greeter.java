
public class Greeter {
	//Member Variables
	public String _name;
	
	//Constructor
	/**
	 * Creates the object Greeter
	 */
	public Greeter()
	{
		_name = "";
	}
	/**
	 * Creates the object Greeter with a saved name
	 */
	public Greeter(String name)
	{
		_name = name;
	}
	
	
	//Methods
	/**
	 * Simply returns "Hello, World"
	 * @return "Hello, World"
	 */
	public String sayHello()
	{
		return "Hello, World";
	}
	
	/**
	 * Simply returns "Goodbye, World"
	 * @return "Goodbye, World"
	 */
	public String sayGoodbye()
	{
		return "Goodbye, World";
	}
	
	/**
	 * Simply returns a string that says a statement that includes the provided name
	 * @return stringed_message
	 */
	public String refuseHelp()
	{
		if(_name.isEmpty())
			return "";
		return "I am sorry, " + _name +  ". I am afraid I can’t do that.";
	}
}
