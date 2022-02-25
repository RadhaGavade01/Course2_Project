
public class LockedMeMain {

	public static void main(String[] args) {
		
		FileOperations.createMainFolderIfNotPresent("main");
		System.out.println( String.format("**************************************************************\n" + "** Welcome to LockedMe.com. \n"  + "**************************************************************\n"));
		System.out.println("You can use this application to :-\n" + "• Retrieve all file names in the \"main\" folder\n" + "• Search, add, or delete files in \"main\" folder.\n");
		
		Options.handleWelcomeScreenInput();
	}

	
}
