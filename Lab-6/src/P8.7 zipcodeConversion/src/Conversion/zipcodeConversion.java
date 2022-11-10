package Conversion;

import java.util.Scanner;


public class zipcodeConversion 
{

	static String weight[]={"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	
	public static void zipToBar(String zip)
	{
	       String bars="|";
	       
	       int sum=0;
	       
	       if(zip.length() != 5)
	       {
	           System.out.println("INPUT ERROR: The zipcode must be 5 numbers long.");
	           return;
	       }
	      
	       for(int i=0; i<zip.length(); i++)
	       {
	           sum += Integer.parseInt(""+zip.charAt(i));
	           bars += weight[ Integer.parseInt(""+zip.charAt(i)) ];
	       }
	       
	       bars += weight[10-sum%10]+"|";
	       
	       System.out.println("Converting zipcode"+ zip +" to barcode we can get: ");
	       System.out.println(bars + '\n');      
	 }
	
	public static void barToZip(String bars)
	{
	       String zip="";
	       
	       if(bars.length() != 32)
	       {
	           System.out.println("INPUT ERROR: The bar code must be 32 characters long.");
	           return;
	       }
	       
	       if( (bars.charAt(0) != '|') || (bars.charAt(bars.length()-1) != '|') )
	       {
	           System.out.println("INPUT ERROR: The bar code must have full height frame bars on each side.");
	           return;
	       }
	       
	       int checking = 0,sum=0;
	       
	       for(int i=1;i<bars.length()-1;i+=5)
	       {	           
	           int weight7 ;
	           int weight4 ;
	           int weight2 ;
	           int weight1 ;
	           int weight0 ;
	           
	           if(bars.charAt(i) == ':' )
	        	   weight7 = 0;
	           else 
	        	   weight7 = 1;
	           
	           if(bars.charAt(i+1) == ':' )
	        	   weight4 = 0;
	           else 
	        	   weight4 = 1;
	           
	           if(bars.charAt(i+2) == ':' )
	        	   weight2 = 0;
	           else 
	        	   weight2 = 1;
	           
	           if(bars.charAt(i+3) == ':' )
	        	   weight1 = 0;
	           else 
	        	   weight1 = 1;
	           
	           if(bars.charAt(i+4) == ':' )
	        	   weight0 = 0;
	           else 
	        	   weight0 = 1;
	                                 
	           if(weight7 + weight4 + weight2 + weight1 + weight0 != 2 )
	           {
	               System.out.println("ERROR: There can only be exact 2 full bars in each bar code encoding.");
	               return;
	           }
	           
	           if(i!=bars.length()-6)
	           {
	               sum+=((7*weight7+ 4*weight4 + 2*weight2 + 1*weight1 + 0*weight0)%11);
	               zip+=((7*weight7+ 4*weight4 + 2*weight2 + 1*weight1 + 0*weight0)%11);
	           }
	           else
	               checking = ((7*weight7 + 4*weight4 + 2*weight2 + 1*weight1 +0*weight0 )%11);
	       }
	       
	       System.out.println("Translating "+bars+" to back to zip code we get: ");
	       System.out.println("\tZip : "+zip);
	       System.out.println("\tChecking : "+checking + "\n");
	       
	       if(checking != 10-sum%10)
	           System.out.println("CHECK ERROR: There is some mismatch of digits.");
	      
	   }
	  
	public static void main(String[] args)
	{
	   Scanner zb = new Scanner(System.in);
	       while(true)
	       {	         
	           System.out.println("Enter 1 to convert zipcode to barcode");
	           System.out.println("Enter 2 to convert barcode to zipcode");
	           System.out.println("Enter 0 to close this program");
	           System.out.print("\nWhat is your choice? ");
	          
	           int ch = zb.nextInt();
	           
	           String zip,bars;
	           
	           if(ch==0)
	               break;
	           else if(ch==1)
	           {
	               System.out.print("\nEnter a zip code: ");
	               zip = zb.next();
	               zipToBar(zip);
	           }
	           else if(ch==2)
	           {
	               System.out.print("\nEnter a bar code: ");
	               bars = zb.next();
	               barToZip(bars);
	           }
	           else
	               System.out.print("\nInvalid input!");
	       }

	   }

}

