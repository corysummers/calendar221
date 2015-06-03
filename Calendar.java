
public class Calendar {
	
	// Initialize variables
	private extDate printed;
	Day firstDay;
	
	// Default constructor
	public Calendar() {
		printed = new extDate(1, 1, 1500);
		firstDay = new Day(firstDayOfMonth(1, 1500));
	}
	
	// User defined constructor
	public Calendar(int m, int y) {
		printed = new extDate(m, 1, y);
		firstDay = new Day(firstDayOfMonth(m, y));
	}
	
	// Find first day of month by using 1/1/1500 as reference
	public int firstDayOfMonth(int m, int y) {
		Date second = new Date(m, 1, y);
		return second.daysSinceStart() % 7;
	}

	// Get
	public Day getFirstDay() {
		return this.firstDay;
	}
	
	public extDate getExtDate() {
		return this.printed;
	}
	
	// Print the calendar
	public void printCalendar() {
		// Print Mon, Year and weekday names
		System.out.printf("%s\n%-8s%-8s%-8s%-8s%-8s%-8s%-8s\n", printed.printMonthYear(), "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
		// Set d equal to first day of month
		int d = firstDayOfMonth(printed.getMonth(), printed.getYear());
		
		//Place first day on calendar
		for (int i = 0; i < d; i++) {
			System.out.printf("%-8s", "");
		}
		//Print rest of calendar until day amount is reached
		for (int i = 1; i <= printed.getDayAmount(printed.getMonth()); i++) {
			System.out.printf("%-8s", i);
			// Move to next line
			if (((i + d) % 7 == 0) || (i == printed.getDayAmount()))
				System.out.println();
		}
	}
}
