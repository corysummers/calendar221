
public class Day {
	// Day class covers day names
	
	// Initialize variables
	private String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	private int current;
	
	// Default
	public Day() {
		this.current = 1;
	}
	
	// User defined constructor
	public Day(int today) {
		setDay(today);
	}
	
	// Set
	public void setDay(int d) {
		// If d is out of bounds for day values
		if (d <= 7)
			this.current = d;
		else 
			this.current = incrementWeekdays(d);
	}
	
	// Get
	public int getDay() {
		return this.current;
	}
	
	// Show next day
	public int getNextDay() {
		return ((this.current + 1) % 7);
	}
	
	// Show previous day
	public int getPreviousDay() {
		return ((this.current + 1) % 7);
	}
	
	// Increment weekdays by user defined amount
	// If greater than 7 return modulo
    public int incrementWeekdays(int days) {
        return (this.current + days) % 7; 
    }
	
	public String printDay() {
		return daysOfWeek[current];
	}
	
	// toString
	public String toString() {
		return "day is " + daysOfWeek[this.current];
	}
	
}
