/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Sep 7, 2022
 */

import java.util.List;
import java.util.Scanner;

import controller.CountryHelper;
import model.Country;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static CountryHelper lih = new CountryHelper();

	/**
	 * Add new country
	 */
	private static void addACountry() {
		System.out.print("Enter a country: ");
		String country = in.nextLine();
		System.out.print("Enter the capital: ");
		String capital = in.nextLine();
		System.out.print("Enter total population: ");
		int population = in.nextInt();
		Country toAdd = new Country(country, capital, population);
		lih.insertCountry(toAdd);

	}

	/**
	 * Delete country
	 */
	private static void deleteACountry() {
		System.out.print("Enter the country to delete: ");
		String country = in.nextLine();
		System.out.print("Enter the capital to delete: ");
		String capital = in.nextLine();
		System.out.print("Enter the population to delete: ");
		int population = in.nextInt();
		Country toDelete = new Country(country, capital, population);
		lih.deleteCountry(toDelete);

	}

	/**
	 * Update country
	 */
	private static void editACountry() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Country");
		System.out.println("2 : Search by Capital");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Country> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the Country's name: ");
			String countryName = in.nextLine();
			foundItems = lih.searchForItemByCountry(countryName);
		} else {
			System.out.print("Enter the Capital City: ");
			String capitalName = in.nextLine();
			foundItems = lih.searchForItemByCapital(capitalName);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Country l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Country toEdit = lih.searchForCountryById(idToEdit);
			System.out.println("Retrieved " + toEdit.getCapital() + " from " + toEdit.getCountry() + "with"
					+ toEdit.getPopulation());
			System.out.println("1 : Update Country");
			System.out.println("2 : Update Capital City");
			System.out.println("3 : Update Total Population");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Country: ");
				String newCountry = in.nextLine();
				toEdit.setCountry(newCountry);
			} else if (update == 2) {
				System.out.print("New Capital City: ");
				String newCapital = in.nextLine();
				toEdit.setCapital(newCapital);
			} else if (update == 3) {
				System.out.print("New Total Population: ");
				int newPopulation = in.nextInt();
				toEdit.setPopulation(newPopulation);

			}

			lih.updateCountry(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		runMenu();

	}

	/**
	 * Print user options and call on CountrHelper class to execute selection
	 */
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome, to your Country list: ---");
		while (goAgain) {
			System.out.println("*  Select and option below:");
			System.out.println("*  1 -- Add a Country");
			System.out.println("*  2 -- Edit a Country");
			System.out.println("*  3 -- Delete a Country");
			System.out.println("*  4 -- View all Countries");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addACountry();
			} else if (selection == 2) {
				editACountry();
			} else if (selection == 3) {
				deleteACountry();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Thank you, goodbye!   ");
				goAgain = false;
			}

		}

	}

	/**
	 * View a list of all countries
	 */
	private static void viewTheList() {
		List<Country> allCountries = lih.showAllCountries();
		for (Country singleCountry : allCountries) {
			System.out.println(singleCountry.returnItemDetails());
		}

	}

}
