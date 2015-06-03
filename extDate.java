
public class extDate extends Date {
	
	// Initialize variables
	String[] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	String monthName;
	
	// Default constructor
	public extDate() {
		super();
		monthName = monthArray[0];
	}
	
	// User defined constructor
	public extDate(int m, int d, int y) {
		setMonth(m);
		setDay(d);
		setYear(y);
		setMonthName(monthArray[m - 1]);
	}
	
	// Increment month
	public void incrementMonth(int a) {
		super.incrementMonth(a);
		setMonthName(monthArray[getMonth() - 1]);
	}
	
	// Set
	public void setMonthName(String m) {
		this.monthName = m;
	}
	
	// Get
	public String getMonthName() {
		return monthName;
	}
	
	// Print month name and year
	public String printMonthYear() {
		return this.getMonthName() + " " + this.getYear();
	}
	
	// Print full date as string
	public String toString() {
		return this.getMonthName() + " " + this.getDay() + ", " + this.getYear();
	}
}
