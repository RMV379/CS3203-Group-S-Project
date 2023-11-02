import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class UserInput{

    public static boolean checkUsername(Scanner input, String username){ //username check function
        String usernameInput;
        System.out.println("Input Username: ");
        usernameInput = input.nextLine(); //store user attempt
        
        //user chances to give correct username
        int chances = 0;
        int chanceCap = 5;

        while(((usernameInput.equals(username)) != true) && (chances < chanceCap)){ //only loop when the user gives an incorrect password and still has chances
            chances += 1;
            System.out.println("Username not recognized, please try again. " + (chanceCap - chances) + " chances remain.");
            //MAYBE remove username cap, but then this is an infinite loop until true
            usernameInput = input.nextLine(); //store next user attempt
        }

        if (chances < chanceCap){ //if user gets the correct username before losing their chances, return true
            return true;
        }
        else{ //if user goes over their chances, return false
            System.out.println("You have no more attempts to enter the username correctly.");
            return false;
        }
    }

    public static boolean checkPassword(Scanner input, String password){ //password check function
        String passwordInput;
        System.out.println("Input Password: ");
        passwordInput = input.nextLine(); //store user attempt

        //user chances to give correct password
        int chances = 0;
        int chanceCap = 5;

        while(((passwordInput.equals(password)) != true) && (chances < chanceCap)){ //only loop when the user gives an incorrect password and still has chances
            chances += 1;
            System.out.println("Incorrect Password, " + (chanceCap - chances) + " chances remain.");
            passwordInput = input.nextLine(); //store next user attempt
        }

        if (chances < chanceCap){ //if user gets the correct password before losing their chances, return true
            return true;
        }
        else{ //if user goes over their chances, return false
            System.out.println("You have no more attempts to enter the password correctly.");
            return false;
        }
    }

    public static boolean checkTime(Scanner input, long lastDate){ //post time check function
        long time = System.currentTimeMillis(); //call for the current time in miliseconds
        long dayCheck = 86400000; //24 hours in miliseconds

        if ((lastDate + dayCheck) < time){ //if it has been over 24 hours since the last post time, return true
            return true;
        }
        else{ //if it has been less than 24 hours since last post time, return false
            System.out.println("You are not able to make a new post for " + (lastDate + dayCheck - time) + " milliseconds."); // TO DO, change from miliseconds
            //TO DO, perhaps call a seperate function to get the time needed to display
            return false;
        }
    }

    public static int giveCharLimit(){ //function connects to server and gets the character limit for the day
        int limit = 1; //temp

        //TO DO, connect to server for character limit

        System.out.println("Character Limit today is: " + limit);

        return limit;
    }

    public static String getPost(Scanner input, int charLimit){ //function gets the user's String within the character limit
        String post = "a"; //temp

        //TO DO, read user post within character limit

        System.out.println("Your post is: " + post); //TO DO, ask for confirmation before proceeding

        return post;
    }

    public static void makePost(String post){ //function connects to server and updates the user's file

        //TO DO, connect to server and put user post there

        System.out.println("Post Successful.");
    }

    public static void main(String[] args){
        try { //attempt to read the login information from security.txt
            File security = new File("security.txt"); //file object
            Scanner securityReader = new Scanner(security); //file scanner
           
            //storing login information
            String username = securityReader.nextLine();
            String password = securityReader.nextLine();
            long lastDate = securityReader.nextLong();
            
            securityReader.close(); //close file scanner

            //TO DO set up username and password creation

            Scanner input = new Scanner(System.in); //user input scanner
            if(checkUsername(input, username)){ //enter if username is given by user correctly
                if(checkPassword(input, password)){ //enter if password is given by user correctly  
                    if(checkTime(input, lastDate)){ //enter if the user is passed the valid post time
                        
                        int charLimit = giveCharLimit();//get character limit from database
                        String post = getPost(input, charLimit); //get post from user
                        makePost(post); //put user input into database

                        //TO DO, update date last used
                    }
                }
            }            
            input.close(); //close user input scanner
        }
        catch (FileNotFoundException e) { //enter if security.txt cannot be found
            System.out.println("Login Information could not be found.");
        }
        
        System.out.println("Program Exiting, Goodbye."); //final output
    }
}