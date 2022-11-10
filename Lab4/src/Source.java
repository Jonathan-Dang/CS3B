/*Author: Jonathan Dang
 *Project: Lab 4, 5.10
 *Purpose: Allows for the conversion of positive integers, up to 3,999, to Roman Numerals
 */
public class Source {
	public static void main(String[] arg)
	{
		System.out.println("=================================START===================================");
		
		System.out.println(Numeralize(1978));

		System.out.println("=================================END======================================");
	}
	
	/**
	 * A function that accepts a number from main in which would translate a number from
	 * 3,999 to 0 into its Roman Numeral Form
	 * @param entry Any number from 3,999 to 0
	 * @return A String with either an error message or Roman Numerals
	 */
	public static String Numeralize(int entry)
	{
		if(entry > 3999 && entry < 0)
		{
			return "	>ERROR: Out of Scope: (entry > 3999) || (entry < 0)";
		}
		
		String romanNumerals = filterEntry(entry);
		
		return romanNumerals;
	}
	
	private static String filterEntry(int entry)
	{
		String romanNumerals = translate(entry);
		
		if(entry > 1000)
			romanNumerals += translate(entry%1000);
		if(entry > 100)
			romanNumerals += translate(entry%1000%100);
		if(entry > 10)
			romanNumerals += translate(entry%1000%100%10);
		
		return romanNumerals;
	}

	/**
	 * A Function where it changes the entry into Roman Numerals
	 * @param entry is a single place positive integer in which would be translated
	 * @param numerals is the string that tells the machine what to write
	 * @return a translated number with the following characters from numerals
	 */
	private static String replaceIntRoman(int entry, String numerals)
	{
		String roman = "", overFive = "";
		char base = numerals.charAt(0);
		char baseFive = numerals.charAt(1);
		char baseAbove = numerals.charAt(2);
		
		switch(entry)
		{
		case(3):
			roman += base;
		case(2):
			roman += base;
		case(1):
			roman += base;
			break;
		case(4):
		{
			roman += base;
			roman += baseFive;
			break;
		}
		case(8):
			overFive += base;
		case(7):
			overFive += base;
		case(6):
			overFive += base;
		case(5):
		{
			roman += baseFive;
			roman += overFive;
			break;
		}
		case(9):
		{
			roman += base;
			roman += baseAbove;
			break;
		}
		default:
			break;
		}
		return roman;
	}
	
	/**
	 * Obtains a positive integer in which would be processed depending on the
	 * entry number
	 * @param a Positive integer that is in between and including 3,999 and 0
	 * @return a string that is the representation of that number but only to the highest degree
	 * 		   EX: 1300 would only calculate the thousand, returning "M" only.
	 */
	private static String translate(int entry)
	{
		int thou,hund,tens;
		thou = entry/1000;
		hund = entry%1000/100;
		tens = entry%1000%100/10;
		
		if(thou > 0)
		{
			return replaceIntRoman(thou,"M  ");
		}
		else if (hund > 0)
		{
			return replaceIntRoman(hund,"CDM");
		}
		else if (tens > 0)
		{
			return replaceIntRoman(tens,"XLC");
		}
		else if (entry > 0)
		{
			return replaceIntRoman(entry,"IVX");
		}
		
		return "";
	}
}
/*
=================================START===================================
MCMLXXVIII
=================================END======================================
*/
