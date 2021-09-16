import java.util.List;
import java.util.Scanner;

import controller.MarchingBandHelper;
import model.MarchingBand;

/**
 * @author Austin Donald - ajdonald
 * CIS175 - Fall 2021
 * Sep 15, 2021
 */
public class startProgram {
	static Scanner input = new Scanner(System.in);
	static MarchingBandHelper MBH = new MarchingBandHelper();
	public static void main(String [] args) {
		boolean again = true;
		int choice = 0;
		while (again) {
			System.out.println("What would you like to do?");
			System.out.println("Add a band: 1");
			System.out.println("Delete a band: 2");
			System.out.println("View all bands: 3");
			System.out.println("Update a band: 4");
			System.out.println("Search for a band: 5");
			System.out.println("Stop the program: 6");
			choice = input.nextInt();
			input.nextLine();
			if (choice == 1) {
				addABand();
			}
			else if (choice == 2) {
				deleteABand();
			}
			else if (choice == 3) {
				viewAllBands();
			}
			else if (choice == 4) {
				updateABand();
			}
			else if (choice == 5) {
				findABand();
			}
			else {
				MBH.cleanUp();
				again =false;
			}
		}
	}
	public static void addABand() {
		System.out.println("Enter the show name");
		String showName = input.nextLine();
		System.out.println("Enter the number of movements");
		int movementsNum = input.nextInt();
		System.out.println("Enter the number of marchers");
		int marchersNum = input.nextInt();
		MarchingBand newBand = new MarchingBand (movementsNum, marchersNum, showName);
		MBH.insertBand(newBand);
	}
	public static void deleteABand () {
		System.out.println("Enter the show name");
		String showName = input.nextLine();
		System.out.println("Enter the number of movements");
		int movementsNum = input.nextInt();
		System.out.println("Enter the number of marchers");
		int marchersNum = input.nextInt();
		MarchingBand toDelete = new MarchingBand (movementsNum, marchersNum, showName);
		MBH.deleteBand(toDelete);
	}
	public static void viewAllBands() {
		List<MarchingBand> allBands = MBH.showAllBands();
		for(MarchingBand singleBand : allBands) {
			System.out.println(singleBand.marchingBandDetails());
		}
	}
	public static void updateABand() {
		MarchingBand toEdit = new MarchingBand();
		System.out.println("Enter the show name");
		String showName = input.nextLine();
		List <MarchingBand> foundBands;
		foundBands = MBH.searchForBandByShowName(showName);
		if (!foundBands.isEmpty()) {
			System.out.println("Found Results.");
			for (MarchingBand M : foundBands) {
				System.out.println(M.marchingBandDetails());
				toEdit = M;
			}
			System.out.println("1 : Update show name");
			System.out.println("2 : Update number of movements");
			System.out.println("3 : Update number of marchers");
			int update = input.nextInt();
			input.nextLine();
			if (update == 1) {
				System.out.print("New show name: ");
				String newShowName = input.nextLine();
				toEdit.setShowName(newShowName);
			} else if (update == 2) {
				System.out.print("New number of movements: ");
				int newNumOfMovements = input.nextInt();
				toEdit.setNumOfMovements(newNumOfMovements);
			} else if (update == 3) {
				System.out.println("New number of marchers");
				int newNumOfMarchers = input.nextInt();
				toEdit.setNumOfMarchers(newNumOfMarchers);
			}

			MBH.updateBand(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}
	public static void findABand() {
		System.out.println("Enter the show name");
		String showName = input.nextLine();
		List <MarchingBand> foundBands;
		foundBands = MBH.searchForBandByShowName(showName);
		if(!foundBands.isEmpty()) {
			System.out.println("The results: ");
			for (MarchingBand M: foundBands) {
				System.out.print(M.marchingBandDetails());
			}
		}
		else {
			System.out.println("No results found");
		}
	}
}
