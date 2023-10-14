#include <iostream>
#include <string>
#include <ctime>

using namespace std;

void checkUsername(string username){
    string usernameInput;
    cout << "Please Input Username: " << endl;
    cin >> usernameInput;
    while (usernameInput.compare(username) != 0) {
        cout << "Incorrect Username, please try again: " << endl;
        cin >> usernameInput;
    }
}

void checkPassword(string password){
    string passwordInput;
    cout << "Please Input Password: " << endl;
    cin >> passwordInput;
    while (passwordInput.compare(password) != 0) {
        cout << "Incorrect Password, please try again: " << endl;
        cin >> passwordInput;
    }
}

int main() {

    //TODO change to be read from file
    string username = "temp";
    string password = "temp";
    int lastDate = 0;

    //checking for proper username
    checkUsername(username);

    //checking for proper password
    checkPassword(password);

    //TODO check the date last used

    if ((lastDate + 86400) > time(NULL)){ //TODO make 86400 a variable
        cout << "You are not yet able to make a new post. Please try again later." << endl; //change to tell how long the person has to wait for
    }

    //TODO give character limit

    //TODO put user input into a file

    //TODO update date last used

    return 0;
}