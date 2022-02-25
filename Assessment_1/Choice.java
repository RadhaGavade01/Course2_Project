
import java.util.List;
import java.util.Scanner;

public class Options {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("\n\n****** Select the option number from below ******\n\n" + "1) Retrieve all files \n" + "2) Display menu for File operations\n" + "3) Exit program\n");
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileOperations.displayAllFiles("main");
					break;
				case 2:
					Options.handleFileMenuOptions();
					break;
				case 3:
					System.out.println(" The program is been exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select the appropriate  option from the above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}

	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("\n\n*** Select the option number from below. ***\n\n" + "1) Add a file. \n" + "2) Delete a file. \n" + "3) Search for a file. \n" + "4) Show Previous Menu.\n" + "5) Exit program.\n");
				FileOperations.createMainFolderIfNotPresent("main");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// Add file
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String fileToAdd = sc.next();
					
					FileOperations.createFile(fileToAdd, sc);
					
					break;
				case 2:
					// File delete
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();
					
					FileOperations.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = FileOperations.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which ever  file to delete?"
							+ "\n(Enter 0 if you want to delete all the elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						for (String path : filesToDelete) {
							FileOperations.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					// File searching
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();
					
					FileOperations.createMainFolderIfNotPresent("main");
					FileOperations.displayFileLocations(fileName, "main");

					
					break;
				case 4:
					// Previous menu
					return;
				case 5:
					// Exit
					System.out.println(" The program is been exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}

