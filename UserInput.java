import java.util.Scanner;

class UserInput{
   
    private static boolean checkUsername(Scanner input, String username){
        String usernameInput;
        System.out.println("Input Username: ");
        usernameInput = input.nextLine();
        
        int chances = 0;
        int chanceCap = 5;

        while(((usernameInput.equals(username)) != true) && (chances < chanceCap)){
            chances += 1;
            System.out.println("Username not recognized, please try again. " + (chanceCap - chances) + " chances remain.");
            //Maybe remove username cap, but then this is an infinite loop until true
            usernameInput = input.nextLine();
        }
        if (chances < chanceCap){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean checkPassword(Scanner input, String password){
        String passwordInput;
        System.out.println("Input Password: ");
        passwordInput = input.nextLine();

        int chances = 0;
        int chanceCap = 5;

        while(((passwordInput.equals(password)) != true) && (chances < chanceCap)){
            chances += 1;
            System.out.println("Incorrect Password, " + (chanceCap - chances) + " chances remain.");
            passwordInput = input.nextLine();
        }
        if (chances < chanceCap){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean checkTime(Scanner input, long lastDate){
        long time = System.currentTimeMillis();
        long dayCheck = 86400;

        if ((lastDate + dayCheck) > time){
            System.out.println("You are not able to make a new post for " + (lastDate + dayCheck - time) + " milliseconds."); // TODO change from miliseconds
            //TODO perhaps call a seperate function to get the time needed to display
            return false;
        }
        else{
            return true;
        }
    }


    public static void main(String[] args){
        //TODO change to be read from file
        String username = "temp";
        String password = "temp";
        long lastDate = 0;
        
        Scanner input = new Scanner(System.in);

        //TODO, set up username and password creation

        //check for proper username
        boolean usernameCheck = checkUsername(input, username);

        //check for proper password
        boolean passwordCheck = checkPassword(input, password);

        //check for valid time, only if username and password are correct
        boolean timeCheck;
        if(usernameCheck && passwordCheck){
            timeCheck = checkTime(input, lastDate);
            if(timeCheck){
                System.out.println("Entered timecheck block"); //temp
                
                //TODO give character limit

                //TODO put user input into a file

                //TODO update date last used
            }
        }
        
        System.out.println("Goodbye!"); //temp

    }
}