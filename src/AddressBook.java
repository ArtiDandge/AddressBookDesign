
import java.util.*;
    
    class PersonAddressDetails{
	    	Scanner s = new Scanner(System.in);
	        private String first_name;
	        private String last_name;
	        private String city;
	        private String state;
	        private int zip;
	        private long phoneNo;
	    PersonAddressDetails(String first_name, String last_name, String city, String state,int zip, long phoneNo){
	        this.first_name = first_name;
	        this.last_name = last_name;
	        this.city = city;
	        this.state = state;
	        this.zip = zip;
	        this.phoneNo = phoneNo;
	    }
	    PersonAddressDetails(){
	    	//calling parameterized constructor in non-parameterized constructor
	    	this("","","","",0,0);
	    }
	    public void readPersonAddressDetails(){
	        System.out.println("First Name : "+first_name );
	        System.out.println("Last Name : "+last_name );
	        System.out.println("City : "+city );
	        System.out.println("State : "+state );
	        System.out.println("Zip : "+zip );
	        System.out.println("phoneNo : "+phoneNo );
	    }
	
	
			
			//Keeps track of how many address_entries are in the book
			private int address_entries = 0;
			PersonAddressDetails[] details;
			public void initEntries(int e){
				details = new PersonAddressDetails[e];
				for (int i = 0;i<details.length;i++){      //Initializes an array of address_entries, then loops through to initialize each individual entry
					details[i] = new PersonAddressDetails();
				}
			}
			public int getEntries(){
				return details.length;
			}
	
			//Adds an entry to the book
			public void add(String first_name, String last_name, String city, String state,int zip, long phoneNo){
				if (address_entries<details.length){
					details[address_entries] = new PersonAddressDetails(first_name, last_name, city, state, zip,phoneNo);
					address_entries++;
				}else {
			    	System.out.println("*************************************************\n"
			    	+ "Error: book is full. No insertion will be stored from now on. "
			    	+ "\nRe-Execute program and increase number of book address_entries\n"
			    	+ "*****************************************************");
				}
			}
		
			// Removes an entry from the book
			public void remove(int entry) {
				if (address_entries > 0) {
				details[entry] = new PersonAddressDetails();
				for (int i = 0; i < address_entries - entry; i++) {
				if (entry + 1 == address_entries)
					details[entry] = new PersonAddressDetails();
				else {
					PersonAddressDetails temp = details[entry + i];
					details[entry + i] = details[entry + i + 1]; // Removes an entry end moves each entry after it one
																	// backwards.
					details[entry + i + 1] = temp;
				}
			    }   address_entries--;
				} else System.out.println("Error: book is empty.");
			}
	
		    //Changes the values of an entry
		    public void edit(String first_name, String last_name, String city, String state,int zip, long phoneNo, int selection){
		        details[selection].first_name = first_name;
		        details[selection].last_name = last_name;
		        details[selection].city = city;
		        details[selection].state = state;
		        details[selection].zip = zip;
		        details[selection].phoneNo = phoneNo;
		    }
	
			//Sorts the book based on a part of the entry
			//int n is used to tell which part of the address_entries to base the sort on
			public void sort(int n){
			for(int i = 0;i<details.length;i++){
		        for (int j = 0;j<details.length;j++){
		        switch(n){
                case 1:
                    if (details[i].first_name.compareTo(details[j].first_name)<0){
                        PersonAddressDetails temp = details[i];
                        details[i] = details[j];
                        details[j] = temp;
                    }
                    break;
                case 2:
                    if (details[i].last_name.compareTo(details[j].last_name)<0){
                        PersonAddressDetails temp = details[i];
                        details[i] = details[j];
                        details[j] = temp;
                    }
                    break;
                case 3:
                    if (details[i].city.compareTo(details[j].city)<0){
                        PersonAddressDetails temp = details[i];
                        details[i] = details[j];
                        details[j] = temp;
                    }
                    break;
                case 4:
                    if (details[i].phoneNo <0 && details[j].phoneNo<0){
                	    PersonAddressDetails temp = details[i];
                        details[i] = details[j];
                        details[j] = temp;
                    }
                    break;
                default: 
                    System.out.println("Error: invalid field");
                        break;
		                }
		            }
		        }
		    }
		}

		public class AddressBook {
		    public static void main(String[] args){
	        Scanner s = new Scanner(System.in);
	        System.out.print("How many address books do you want to create? ");
	        int howManyPersonAddressDetailss;
	        int howManyEntries;
	
	        PersonAddressDetails[] library = new PersonAddressDetails[0];


            while(true){
            howManyPersonAddressDetailss = s.nextInt();
            if (howManyPersonAddressDetailss>0){
                library = new PersonAddressDetails[howManyPersonAddressDetailss];                   //This code decides how many books are in the array of books/the library
                break;
            }
            else System.out.print("You must create at least 1 address book.");
            }
	
	        for (int i=0;i<library.length;i++){
		           library[i] = new PersonAddressDetails(); //Fixed reference to null because each book in the library had not been initialized yet.
		            while(true){
	                System.out.print("How many address_entries in book "+i+"? ");
	                howManyEntries = s.nextInt();
	                if (howManyEntries>0) {
	                    library[i].initEntries(howManyEntries);                 //This code decides how many address_entries are in each book in the library
	                    break;
	                }
	                else System.out.println("You must create at least 1 PersonAddressDetails.");
	                }
		    }
	        boolean done = false;
	        int selectedPersonAddressDetails = 0;
	        int selection;
	        try{
	        while (done==false){

        	System.out.println("Select an option from below menu");
            System.out.println("1. Add an entry");
            System.out.println("2. Remove an entry");
            System.out.println("3. Edit an entry");
            System.out.println("4. View PersonAddressDetails PersonAddressDetails");
            System.out.println("5. Sort address book");
            System.out.println("5. Select another book");
            System.out.println("6. Exit the menu");
            System.out.print("> ");
           
            selection = s.nextInt();
            String first_name, last_name, city, state;
            int zip;
			long phoneNo;

            switch(selection){
            case 1: 
                System.out.print("First name? ");
                first_name = s.next();
                System.out.print("Last name? ");
                last_name = s.next();
                System.out.print("city? ");
                city = s.next();
                System.out.print("State? ");
                state = s.next();
                System.out.print("Zip? ");
                zip = s.nextInt();
                System.out.print("phoneNo? ");
                phoneNo = s.nextInt();
               
                library[selectedPersonAddressDetails].add(first_name, last_name, city, state, zip,phoneNo);
                break;
            case 2: 
                System.out.print("Which entry do you want to remove? (Enter the entry number that you want to remove)");
                int entry = s.nextInt();
                library[selectedPersonAddressDetails].remove(entry);
                break;
            case 3:
                System.out.print("Enter number of that entry which you want to edit?");
                int whichPersonAddressDetails = s.nextInt();
                System.out.print("First name? ");
                first_name = s.next();
                System.out.print("Last name? ");
                last_name = s.next();
                System.out.print("city? ");
                city = s.next();
                System.out.print("State? ");
                state = s.next();
                System.out.print("Zip? ");
                zip = s.nextInt();
                System.out.print("phoneNo? ");
                phoneNo = s.nextLong();
                library[selectedPersonAddressDetails].edit(first_name, last_name, city, state, zip, phoneNo, whichPersonAddressDetails);
                break;
            case 4:
             System.out.println("PersonAddressDetails "+(selectedPersonAddressDetails+1)+" is currently selected.");
           	 for (int i = 0;i<library[selectedPersonAddressDetails].getEntries();i++){
           	 System.out.println("===========PersonAddressDetails "+i+" ===========");
           	 library[selectedPersonAddressDetails].details[i].readPersonAddressDetails(); //Accessing the array of address_entries INSIDE the array of books/the library
           	 System.out.println("================================");
           	            }
           	    break;          

            case 5: 
                System.out.println("Sort alphabetically by which field?");
                System.out.println("1. Sort by first_name name");
                System.out.println("2. Sort by last_name name");
                System.out.println("3. Sort by city");
                System.out.println("4. Sort by phoneNo");
                library[selectedPersonAddressDetails].sort(s.nextInt());
                break;   
            case 6: 
                System.out.print("Select which book?");
                selectedPersonAddressDetails = s.nextInt();
                break;

                
            case 7:
                done = true;
                break;
           
            	
            default:
                System.out.print("Please choose a valid menu Option");
            }
            
          }
        }
          catch(Exception e) {
        	 
        	  System.out.println("Please correct input formate by re-executing this programe. \nFirst name Last name and city should be string and phone number should be interger");
        
         }
      }
    
    }
