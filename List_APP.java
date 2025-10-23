package list_app;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;
import java.util.Scanner;

public class List_APP {
	static Scanner usin = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Creating lists and variables
		PrintStream so = System.out;
		List<Object> items = new ArrayList<>();
		int selection = 0, loop = 1, num_entries = 0, removal = 0, rem_num_entries = 0;
		Object entry;
		
		//Creating a while loop
		while (loop == 1) {
			
			//Retrieving what the user wants to do
			so.println("Please Select an option\n1.Add to the list\n2.Remove items from the list\n3.Edit the list");
			so.print("Selection: ");
			selection = usin.nextInt();
			
			//If the user wants to add to the list
			if (selection == 1) {
				so.print("How many entries into the list: ");
				num_entries = usin.nextInt(); //Retrieving the number of entries
				for (int i = 0; i <= num_entries - 1; i++) {
					so.print("Entry: ");
					entry = usin.next();
					items.add(entry); //Adding entry to the list
				}
			}
			//Checking to make sure the list has been populated
			if (items.isEmpty() == false) {
				//If the user wants to remove from the list
				if (selection == 2) {
					//Printing the list
					for (int i = 0; i < items.size(); i++) {
						so.println(i+1 + ":" + items.get(i));
					}
					so.print("Enter how many entries you would like to remove: ");
					rem_num_entries = usin.nextInt();
					for(int i = 0; i <= rem_num_entries - 1; i++) {
					so.print("Please Select the item to remove: ");
					removal = usin.nextInt() - 1;
					items.set(removal, " "); //Removing the selected item
					}
					for (int i = 0; i <= items.size(); i++) items.remove(" ");
				}
				//If the user wants to edit the list
				else if (selection == 3) {
					//Printing the list
					for (int i = 0; i < items.size(); i++) {
						so.println(i+1 + ":" + items.get(i));
					}
					//Asking the user how many times they want to change the list
					so.print("Enter how many entries you would like to Edit: ");
					rem_num_entries = usin.nextInt();
					
					//Retrieving where the user wants to change and setting to that index
					for(int i = 0; i <= rem_num_entries - 1; i++) {
						so.print("Select item to change: ");
						removal = usin.nextInt() - 1;
						so.print("Changed to: ");
						entry = usin.next();
						items.set(removal, entry);
					}
					
				}
			}
			//Reminding the user to first populate the list before interacting
			else if (items.isEmpty() == true) so.println("Please populate the list first");
			//If the user places an invalid entry
			else so.print("Invalid entry");
			
			so.print("Would you like to continue(1 - yes, 0 - no): ");
			loop = usin.nextInt();
		}
		so.println("Your final list:");
		//Printing the final list
		for (int i = 0; i < items.size(); i++) {
			so.println(i+1 + ":" + items.get(i));
		}
	}
}
