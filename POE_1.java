/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_1;
import javax.swing.JOptionPane;
/**
 *
 * @author Khumbelo
 */
public class POE_1 {

    private static String username = "right or wrong username";
    private static String password = "right or wrong password";
    private static String name;
    private static String surname;

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            // Display the menu and get user's choice
            String choice = JOptionPane.showInputDialog(
                    "Choose an option:\n1. Register\n2. Login\n3. Exit"
            );

            // Before doing anything user makes a choise to register, log in, or exit. 
            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":
                    forLogingIn();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Unrecognized choice. Please choose from the choices; '1', '2', or '3'.");
            }
        }
    }

    public static void register() {
        name = JOptionPane.showInputDialog("Please enter your name");
        surname = JOptionPane.showInputDialog("Please enter your surname");

        do {
            username = JOptionPane.showInputDialog("Enter your username");
            if (!checkUserName(username)) {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        } while (!checkUserName(username));
        JOptionPane.showMessageDialog(null, "Username successfully captured.");

        do {
            password = JOptionPane.showInputDialog("Enter your password");
            if (!checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            }
        } while (!checkPasswordComplexity(password));
        JOptionPane.showMessageDialog(null, "Password successfully captured.");

        // After the correct credentials have been accepted, these messages display the user's information
        JOptionPane.showMessageDialog(null, "Name: " + name + "\nSurname: " + surname + "\nUsername: " + username + "\nPassword: " + password);
        JOptionPane.showMessageDialog(null, "Registration successful");
        JOptionPane.showMessageDialog(null, "NEXT step, LOGGING IN !!");

        // Call the login method after registration
        forLogingIn();
    }

// these following funtions are important
// i am gonna be using this function to check if username meets the requirements
    public static boolean checkUserName(String username) {
        //my username should be 5 charecters and posses an underscore. i make sure of that with the following source code 76
        return username.length() == 5 && username.contains("_");
    }
// for or checking if password meets the requirements
    public static boolean checkPasswordComplexity(String password) {
        // Password should have at least 8 characters, a capital letter, and a special character, so i give these attributes to my ussername right here on the next source code 82
        return password.length() >= 8 && !password.equals(password.toLowerCase()) && password.matches(".*\\d.*") && !password.matches("[A-Za-z0-9 ]*");
    }
// method to log in an existing user, the credentials that just signed-in on registration
    private static void forLogingIn() {
    boolean loginUser = false;
    // this while loop will loop until the user successfully logs in or chooses the canceling option
    while (!loginUser) {
        String enteredUsername = JOptionPane.showInputDialog("Enter your username:");
        // when the user clicks Cancel, exit the loop
        if (enteredUsername == null) {
            JOptionPane.showMessageDialog(null, "Login cancelled.");
            return;
        }
        String enteredPassword = JOptionPane.showInputDialog("Enter your password:");
        // when the user clicks Cancel, exit the loop
        if (enteredPassword == null) {
            JOptionPane.showMessageDialog(null, "Login cancelled.");
            return;
        }
        // this "IF" statement checks if entered username and password match the registered user's credentials
        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + name + ", " + surname + " it is great to see you again.");
            loginUser = true; // Setting "loginUser" to true so that it exits the loop
        } else {
            JOptionPane.showMessageDialog(null, "Username or Password Incorrect. Please try again.");
        }
    }
}
}





    



