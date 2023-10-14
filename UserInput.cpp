#include <iostream>
#include <string>

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

    //checking for proper username
    checkUsername(username);

    //checking for proper password
    checkPassword(password);

    //TODO check the date last used

    //TODO give character limit

    //TODO put user input into a file

    //TODO update date last used

    return 0;
}