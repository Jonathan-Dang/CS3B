
public class SalesRecordTester {
	public static void main(String[] arg)
	{
		String filename = "sales.txt";
		SalesRecord sr = new SalesRecord(filename);
		sr.displayTotalSales();
	}
}
