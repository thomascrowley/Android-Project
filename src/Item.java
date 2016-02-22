import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * created by Jordan
 *
 * Class to represent a food or drink item
 */

public class Item {

	private String thisName;
	private String thisFoodOrDrink;
	private String thisCategory;
	private double thisPrice; 
	private int categoriesSize;
	private String[] categories;
	
	private DecimalFormat decimalTester;
	private double modulo;
	private int decimalLength;
	
	private String itemString;
	
	//Getter methods for item object parameters
	public String getThisName() {
		return thisName;
	}

	public String getThisFoodOrDrink() {
		return thisFoodOrDrink;
	}

	public String getThisCategory() {
		return thisCategory;
	}

	public double getThisPrice() {
		return thisPrice;
	}

    //Setters not needed as any item input is final (if its done with it can be removed)

	//Initialises variables, creates valid categories list and tests parameters
	Item(String name, String foodOrDrink, String category, double price) {
		thisName = name;
		thisFoodOrDrink = foodOrDrink;
		thisCategory = category;
		thisPrice = price;

		//Potentially incomplete
		categoriesSize = 30;
		categories = new String[categoriesSize];

		categories[0] = "Fish";
		categories[1] = "Meat";
		categories[2] = "Starter";
		categories[3] = "Sharer";
		categories[4] = "Burger";
		categories[5] = "Sandwich";
		categories[6] = "Dessert";
		
		categories[7] = "Soft Drink";
		categories[8] = "Wine";
		categories[9] = "Cocktail";
		
		testCategory();
		testFoodOrDrink();
		testPrice();
	}

	//Ensures a valid category has been input
	public void testCategory() {
		if (!(Arrays.asList(categories).contains(thisCategory))) {
			throw new IllegalArgumentException("Error: invalid " +
					"category, ensure each word is capitalized.");
		}
	}

	//Ensures a valid keyword has been input for food or drink
	public void testFoodOrDrink() {
		if (!(thisFoodOrDrink.equals("Food") || 
				thisFoodOrDrink.equals("Drink"))) {
			throw new IllegalArgumentException("Error: " +
					"foodOrDrink must be input as 'Food' " +
					"or 'Drink' only");
		}		
	}

	//Ensures the price entered is to 2 decimal places
	public void testPrice() {
		modulo = thisPrice % 1;
		decimalTester = new DecimalFormat("#.00");
		decimalLength = (decimalTester.format(modulo).length() - 1);
		
		if (decimalLength > 2) {		
			throw new IllegalArgumentException("Error: price " +
					"must be entered in the form xx.xx, with " +
					"up to 2 decimal places.");
		}
	}

	//Prints all valid categories for the user
	public void showCategories() {
		System.out.println("Valid Categories: ");
		System.out.println("");
		for (String thisString: categories) {
			System.out.println(thisString);
		}
	}

	//Returns a formatted string of the Item
	@Override public String toString() {
		itemString = (thisName + " " + thisFoodOrDrink + " " + 
						thisCategory + " £" + thisPrice);
		return itemString;
	}


	public static void main(String[] args) {

	}
}

//http://stackoverflow.com/questions/21825862/validation-to-check-a-double-for-2-decimal-places
