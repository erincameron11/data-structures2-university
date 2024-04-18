package citytable;

public class CityTable extends KeyedItem {

	private String country; //city name will be the searchKey 
	private int pop;

	public CityTable (String theCity, String theCountry, int newPop) { 
		super (theCity);
		country = theCountry;
		pop = newPop;
	}
	
	
    // Getter for country 
	public String getCountry() {
		return country;
	}


	// Setter for country
	public void setCountry(String country) {
		this.country = country;
	}


	// Getter for population
	public int getPop() {
		return pop;
	}


	// Setter for population
	public void setPop(int pop) {
		this.pop = pop;
	}
	

	// Method to print the keys
	public String toString () {
		return getKey() + ", " + country + " " + pop;
	}
	
	
	// Main Method
	public static void main(String[] args) {
		CityTable ct = new CityTable("Toronto", "Canada", 1500000);

	}

}// end City class