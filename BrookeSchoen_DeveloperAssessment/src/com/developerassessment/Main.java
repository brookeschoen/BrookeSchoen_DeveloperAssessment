package com.developerassessment;

/**
 * class Main
 *
 * Implements the methods in the UserFunctions class based on the user's input
 * Designed to be run from the command line
 *
 * @author (Brooke Schoen)
 * @version (09/02/2021)
 */

public class Main extends UserFunctions
{
    public static void main(String[] args)
    {
        String userFunction = "";   // stores the function the user enters
        int accountNumber = 0;      // stores the account number the user enters
        float amount = 0;           // stores the amount of money the user chooses to charge or deposit into their account

        if (args.length == 0)
        {
            System.out.println("Please enter an account function you would like to perform");
            System.exit(0);
        }
        else
        {
            userFunction = args[0].toLowerCase();

            switch(userFunction)
            {
                case "check":
                    accountNumber = Integer.parseInt(args[1]);
                    check(accountNumber);
                    break;
                case "deposit":
                    accountNumber = Integer.parseInt(args[1]);
                    amount = Float.parseFloat(args[2]);
                    deposit(accountNumber, amount);
                    break;
                case "charge":
                    accountNumber = Integer.parseInt(args[1]);
                    amount = Float.parseFloat(args[2]);
                    charge(accountNumber, amount);
                    break;
                case "total":
                    total();
                    break;
            }
        }
    }
}
