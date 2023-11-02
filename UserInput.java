import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class UserInput{

    public static boolean writeUsernamePassword(File security, String username, String password){ //write to File function
        try{ //attempt to create a new object with security
            FileWriter securityWriter = new FileWriter(security, false); //overwrite security.txt
                    
            //write information to file
            securityWriter.write(username + "\n"); 
            securityWriter.write(password + "\n");
            securityWriter.write("0");

            securityWriter.close(); //close FileWriter
            return true;
        }
        catch(IOException e){ //catch error with FileWriter
            System.out.println("Error creating new login.");
            return false;
        }
    }
    
    public static boolean checkUsername(Scanner input, String username){ //username check function
        String usernameInput;
        String exit = "Exit"; // to help leave loop
        System.out.println("Input Username: ");
        usernameInput = input.nextLine(); //store user attempt

        while(((usernameInput.equals(username) != true) && (usernameInput.equals(exit) != true))){ //loops forever until username is recognized or Exit is typed
            System.out.println("Username not recognized, please try again. Type Exit to give up.");
            usernameInput = input.nextLine(); //store next user attempt
        }

        if(usernameInput.equals(exit)){ //only returns false if the user typed Exit
            return false;
        }
        else{
            return true;
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

    public static boolean makePost(String post){ //function connects to server and updates the user's file

        //TO DO, connect to server and put user post there

        System.out.println("Post Successful.");
        return true;
    }

    public static boolean writeDate(File security, String username, String password){ //write to File function
        try{ //attempt to create a new object with security
            FileWriter securityWriter = new FileWriter(security, false); //overwrite security.txt
                    
            //rewrite login information to file
            securityWriter.write(username + "\n"); 
            securityWriter.write(password + "\n");

            long time = System.currentTimeMillis(); //get current time
            securityWriter.write(String.valueOf(time)); //write current time to file

            securityWriter.close(); //close FileWriter
            return true;
        }
        catch(IOException e){ //catch error with FileWriter
            System.out.println("Error adding date.");
            return false;
        }
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
           
            Scanner input = new Scanner(System.in); //user input scanner

            while(username.equals("temp")){ //while default username is given, a new one is requested, cannot give default username
                System.out.println("Please enter new username: ");
                username = input.nextLine(); //read new username
                
                System.out.println("Please enter new password: ");
                password = input.nextLine(); //read new password

                writeUsernamePassword(security, username, password);
            }

            if(checkUsername(input, username)){ //enter if username is given by user correctly
                if(checkPassword(input, password)){ //enter if password is given by user correctly  
                    if(checkTime(input, lastDate)){ //enter if the user is passed the valid post time
                        
                        int charLimit = giveCharLimit();//get character limit from database
                        String post = getPost(input, charLimit); //get post from user
                        makePost(post); //put user input into database
                        writeDate(security, username, password); //update file for date
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