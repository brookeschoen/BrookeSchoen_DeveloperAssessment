package com.developerassessment;

import java.util.ArrayList;

public class UserFunctions
{
    private static final UserAccount user = new UserAccount();

    // "Print the balance of the required account number."
    public static void check(int accountNumber)
    {
        user.setAccountNumber(accountNumber);
        System.out.printf("%.2f%n", user.getUserBalance());
        System.exit(0);
    }

    // "Adds amount to the balance of the provided account number."
    public static void deposit(int accountNumber, float amount)
    {
        if (amount < 0 || amount > 10000)
        {
            System.out.println("Please enter a valid amount");
            System.exit(0);
        }
        else
        {
            user.setAccountNumber(accountNumber);
            float newBalance = user.getUserBalance() + amount;
            user.updateBalance(newBalance);
        }
    }

    /*
    "Subtracts amount from the balance of the provided account number. Prints an error message and exits without
    modifying the balance if the resulting balance would be negative."
    */
    public static void charge(int accountNumber, float amount)
    {
        if (amount < 0 || amount > 10000)
        {
            System.out.println("Please enter a valid amount");
            System.exit(0);
        }
        else
        {
            user.setAccountNumber(accountNumber);
            float newBalance = user.getUserBalance() - amount;

            if (newBalance < 0)
            {
                System.out.println("Balance is less than 0. Cannot charge account.");
                System.exit(0);
            }
            else
            {
                user.updateBalance(newBalance);
            }
        }
    }

    // "Prints the total balance remaining in all accounts"
    public static void total()
    {
        final ArrayList<Float> userBalances = user.getAllUserBalances();
        float totalBalanceOfUsers = 0;

        for (float balance : userBalances)
        {
            totalBalanceOfUsers += balance;
        }

        System.out.printf("%.2f%n", totalBalanceOfUsers);
        System.exit(0);
    }
}
