
public class Date {
	// Date variables
	protected int year, month, day;
	protected String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	protected int dayAmount;
	
	// Default constructor
	public Date() {
		this.setDate(1, 1, 1500);
	}
	
	// User defined constructor
	public Date(int m, int d, int y) {
		this.setDate(m, d, y);
	}
	
	// Set
	public void setDate(int m, int d, int y) {
		setYear(y);
		setMonth(m);
		setDay(d);
	}
	
	public void setYear(int y) {
		// Make sure year is between accepted values
		if ((y <= 9999) && (y >= 1500)) {
			this.year = y;
			checkLeapYear(this.year);
		}
		// Otherwise set year to default as 1500
		else
			this.year = 1500;
	}
	
	public void setMonth(int m) {
		// Make sure month is between accepted values
		if ((m >= 1) && (m <= 12)) {
			this.month = m;
			dayAmount = getDayAmount(this.month);
		}
		// Otherwise use the modulo of given value
		else if (m > 12) {
			this.month = m / 12;
			dayAmount = getDayAmount(this.month);
		}
	}
	
	public void setDay(int d) {
		// Check validity for amount of days in month
		if ((d <= getDayAmount(this.month)) && (d >= 1))
			this.day = d;
		else
			this.day = d % getDay();
	}
	
	public int getDayAmount(int m) {
		// Check day amounts for each month
		// Could have (should have?) used arrays, probably
		switch (m) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			return 31;
		case 4: case 6: case 9: case 11:
			return 30;
		// Check for leap year and set dayAmount accordingly
		case 2:
			if (checkLeapYear(this.year))
				return 29;
			else
				return 28;
		default:
			return 0;
		}
	}
	
	// Check leap year
	public boolean checkLeapYear(int y) {
		if (((y % 4 == 0) && !(y % 100 == 0)) || (y % 400 == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void incrementDay(int a) {
		// Set variable for days remaining in month
		int j = daysLeftMonth();
		
		// If user increment is greater than days remaining in month
		if (a > j) {
			// Not using i here - I could rewrite this but I don't need to for the 
			// actual calendar, so since it's working I'll leave it alone
			
			// While greater than remaining
			for (int i = 0; a > j; i++) {
				if (a > j) {
					// Set new increment amount to increment amount - days remaining
					a = a - j;
				}
				// Increment month and set j equal to next month's day remaining count
				incrementMonth(1);
				j = getDayAmount(getMonth());
			}
			setDay(a);
		}
		else
			setDay(getDay() + a);
	}
	
	public void incrementMonth(int a) {	
		// j equal to remaining months in year to determining when to increment year
		int j = 12 - getMonth();
		
		// If increment value greater than remaining months
		if (a > j) {
			for (int i = 0; a > j; i++) {
				if (a > j) {
					// Set increment value to value subtract remaining
					a = a - j;
				}
				// Increment year and set remaining months upon increment to 12
				incrementYear(1);
				j = 12;
			}
			setMonth(a);
			
			// If the current day number is higher than the month incremented to
			if (getDay() > getDayAmount(getMonth())) {
				// Set day to larger number subtract smaller number and then increment to next month
				setDay(getDay() - getDayAmount(getMonth()));
				incrementMonth(1);
			}
			
		}
		else {
			// Else when increment value within remaining months value
			setMonth(getMonth() + a);
			if (getDay() > getDayAmount(getMonth())) {
				setDay(getDay() - getDayAmount(getMonth()));
				incrementMonth(1);
			}
		}
	}
	
	public void incrementYear(int a) {
		// Make sure year within accepted values
		if (((getYear() + a) >= 1500) && ((getYear() + a) <= 9999)) {
			setYear(getYear() + a);
		}
		else
			setYear(1500);
	}
	
	// Days passed up to date
	public int daysThisYear() {
		int totalDaysPassed = 0;
		
		// Get day amount for each month and add it to total
		for (int i = 0; i < this.getMonth(); i++) {
			totalDaysPassed += getDayAmount(i);
		}
		// Add current day number to total
		totalDaysPassed += this.getDay();
		
		return totalDaysPassed;
	}
	
	// Days remaining in the year
	public int daysLeftYear() {
		// Extra day if leap year
		if (checkLeapYear(this.year))
			return 366 - this.daysThisYear();
		else
			return 365 - this.daysThisYear();
	}
	
	// Days since 1/1/1500
	public int daysSinceStart() {
		// Set temp equal to 1/1/1500
		Date temp = new Date();
		int total = 0;
		
		// Set i to 1500
		// Loop while counting toward current year
		for (int i = temp.getYear(); i < this.getYear(); i++) {
			if (this.checkLeapYear(i)) {
				total += 366;
			}
			else{
				total += 365;
			}
		}
		// After getting year values, add value for days up to current date
		total += this.daysThisYear();

		return total;
	}
	
	public int daysLeftMonth() {
		// Days left in current month is total days subtract current day
		return getDayAmount(this.month) - getDay();
	}
	
	// Get
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getDayAmount() {
		return this.dayAmount;
	}
	
	// Make copy of Date object
	public void makeCopy(Date otherDate) {
		this.month = otherDate.month;
		this.year = otherDate.year;
		this.day = otherDate.day;
	}
	
	// Return copy of Date object
	public Date getCopy() {
		Date temp = new Date();
		
		temp.month = this.month;
		temp.day = this.day;
		temp.year = this.year;
		
		return temp;
	}
	
	// toString
	public String toString() {
		return (this.getMonth()) + "/" + this.day + "/" + this.year + " - There are " + getDayAmount() + " days in the month.";
	}
	
}