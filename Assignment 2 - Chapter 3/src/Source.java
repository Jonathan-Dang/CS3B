//Author: Jonathan Dang
//Project: Assignment 2 Chapter 3
/*
 * This section displays the Battery, Voting Machine, and Greeter objects from
 * Projects 3.9, 3.12, and 3.14 PP
 */
public class Source {

	public static void main(String[] args) {
		System.out.println("========================PROGRAM START========================");
		//Battery Testing ===============================================================================
		System.out.println("Starting Battery Testing | Project 3.9");
		Battery b1 = new Battery(5000);
		b1.drain(3400);
		System.out.println("Battery with 5000 cap and 5000 charge being drained by 3400, leaving 1600");
		System.out.print("b1 Battery Remaining Charge: ");
		System.out.println(b1.getRemainingCapacity());
		b1.charge();
		System.out.println("Recharging Battery to 5000");
		System.out.print("b1 Battery Remaining Charge: ");
		System.out.println(b1.getRemainingCapacity());
		System.out.println("End of Battery Testing | Project 3.9");
		System.out.println("==============================================================================");
		//Voting Machine Testing =========================================================================
		System.out.println("Starting Voting Machine Testing | Project 3.12");
		VotingMachine vm = new VotingMachine();
		System.out.println("Making Democrats Win");
		vm.voteBlue();
		System.out.println("Winner: " + vm.getWinner() + " Democrat Votes: " + vm.getDemocratVotes() + "| Republican Votes"
				+ " " + vm.getRepublicanVotes());
		System.out.println("Clearing");
		vm.clear();
		System.out.println("Winner: " + vm.getWinner() + " Democrat Votes: " + vm.getDemocratVotes() + "| Republican Votes"
				+ " " + vm.getRepublicanVotes());
		System.out.println("Making Republicans Win");
		vm.voteRed();
		System.out.println("Winner: " + vm.getWinner() + " Democrat Votes: " + vm.getDemocratVotes() + "| Republican Votes"
				+ " " + vm.getRepublicanVotes());
		System.out.println("End of Voting Machine Testing | Project 3.12");
		System.out.println("==============================================================================");
		//Greeter Testing=================================================================================
		System.out.println("Starting Greeter Testing | Project 3.14");
		Greeter g1 = new Greeter();
		Greeter g2 = new Greeter("John");
		System.out.println("g1: " + g1.sayHello());
		System.out.println("g2: " + g2.sayHello());
		System.out.println(g2.sayGoodbye());
		System.out.println(g2.refuseHelp());
		System.out.println("End of Greeter Testing | Project 3.14");
		System.out.println("========================PROGRAM END===========================");
	}

}
/*
========================PROGRAM START========================
Starting Battery Testing | Project 3.9
Battery with 5000 cap and 5000 charge being drained by 3400, leaving 1600
b1 Battery Remaining Charge: 1600.0
Recharging Battery to 5000
b1 Battery Remaining Charge: 5000.0
End of Battery Testing | Project 3.9
==============================================================================
Starting Voting Machine Testing | Project 3.12
Making Democrats Win
Winner: Democrat Democrat Votes: 1| Republican Votes 0
Clearing
Winner: Tie Democrat Votes: 0| Republican Votes 0
Making Republicans Win
Winner: Republican Democrat Votes: 0| Republican Votes 1
End of Voting Machine Testing | Project 3.12
==============================================================================
Starting Greeter Testing | Project 3.14
g1: Hello, World
g2: Hello, World
Goodbye, World
I am sorry, John. I am afraid I can’t do that.
End of Greeter Testing | Project 3.14
========================PROGRAM END===========================
*/
