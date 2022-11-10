package PP13_8;

public class MazeRunner {

	public static void main(String[] args) {
		/*
S ########
#        #
# ### ## #
# #    # #
# #  # # #
# ## #####
# #      #
# # #  # #
##### ####
#   #    E
# #    # #
##########
		 */
		Maze m = new Maze("O ########\n"
				+ "#        #\n"
				+ "# ### ## #\n"
				+ "# #    # #\n"
				+ "# #  # # #\n"
				+ "# ## #####\n"
				+ "# #      #\n"
				+ "# # #  # #\n"
				+ "##### ####\n"
				+ "#   #    X\n"
				+ "# #    # #\n"
				+ "##########");
		
		BackTrackSolution BTS = new BackTrackSolution();
		m.printPath(BTS.solve(m));
	}

}

/*

O*########
#*****   #	
# ###*## #
# # ** # #
# # *# # #
# ##*#####
# # **   #
# # #* # #
#####*####
#   #****X
# #    # #
##########

*/