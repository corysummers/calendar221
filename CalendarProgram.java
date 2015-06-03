
public class CalendarProgram {
		
	public static void main(String[] args) {	
		
		extDate first = new extDate();
		extDate second = new extDate(4, 18, 2015);

		Calendar test = new Calendar(4, 2015);
		System.out.println(test.getExtDate());
		System.out.println(test.getFirstDay());
		System.out.println();
		test.printCalendar();
	}
}
