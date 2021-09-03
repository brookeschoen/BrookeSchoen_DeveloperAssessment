package com.developerassessment;

/**
 * class UserAccount: data structure that has the following components:
 * filePath, userAccountFile, allUserAccountNumbers, allUserBalances, accountNumber, balance
 *
 * filePath - path of the flat file that contains the account numbers and corresponding balances (UPDATE APPROPRIATELY)
 * userAccountFile - initializes the file from filePath
 * allUserAccountNumbers - stores all the account numbers in userAccountFile
 * allUserBalances - stores all the account balances in userAccountFile
 * accountNumber - stores the user's individual account number
 * balance - stores the user's individual account balance
 *
 * Constructor: UserAccount()
 * Methods:
 *      setAccountNumber(int accountNumber)
 *      readAccountNumbersAndBalancesFromFile()
 *      boolean accountNumberExists(int accountNumber)
 *      float getUserBalance()
 *      ArrayList<Float> getAllUserBalances()
 *      updateBalance(float newBalance)
 *      updateUserAccountFile()
 *
 * @author (Brooke Schoen)
 * @version (09/02/2021)
 */

import java.io.*;
import java.util.*;

public class UserAccount
{
    private final String filePath = "BrookeSchoen_DeveloperAssessment/UserAccountInfo";
    private final File userAccountFile = new File(filePath);
    private ArrayList<Integer> allUserAccountNumbers;
    private ArrayList<Float> allUserBalances;
    private int accountNumber;
    private float balance;

    public UserAccount()
    {
        readAccountNumbersAndBalancesFromFile();
    }

    // sets the user's account number to the UserAccount object
    public void setAccountNumber(int accountNumber)
    {
        if (accountNumberExists(accountNumber))
        {
            this.accountNumber = accountNumber;
        }
        else
        {
            System.out.println("Please enter a valid account number.");
            System.exit(0);
        }
    }

    // reads in all the account numbers and stores them in allUserAccountNumbers
    // reads in all the account balances and stores them in allUserAccountBalances
    private void readAccountNumbersAndBalancesFromFile()
    {
        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(userAccountFile));
            String line = reader.readLine();
            allUserAccountNumbers = new ArrayList<Integer>();
            allUserBalances = new ArrayList<Float>();

            while (line != null)
            {
                final StringTokenizer tokenizer = new StringTokenizer(line, ",");

                while(tokenizer.hasMoreTokens())
                {
                    allUserAccountNumbers.add(Integer.parseInt(tokenizer.nextToken()));
                    allUserBalances.add(Float.parseFloat(tokenizer.nextToken()));
                }

                line = reader.readLine();
            }

            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
    }

    // checks if user entered a valid account number
    private boolean accountNumberExists(int accountNumber)
    {
        return allUserAccountNumbers.contains(accountNumber);
    }

    // returns user's balance based on their account number
    public float getUserBalance()
    {
        final int accountNumberListPosition = allUserAccountNumbers.indexOf(this.accountNumber);
        this.balance = allUserBalances.get(accountNumberListPosition);

        return this.balance;
    }

    // returns each user account balance stored in allUserBalances
    public ArrayList<Float> getAllUserBalances()
    {
        return allUserBalances;
    }

    // replaces the old balance from allUserBalances with the new one after calling either charge or deposit methods
    public void updateBalance(float newBalance)
    {
        final int balanceListPosition = allUserBalances.indexOf(this.balance);
        allUserBalances.remove(balanceListPosition);

        this.balance = newBalance;
        allUserBalances.add(balanceListPosition, this.balance);

        updateUserAccountFile();
    }

    // rewrites userAccountFile to accurately display the current accounts and balances
    private void updateUserAccountFile()
    {
        try
        {
            final FileWriter writer = new FileWriter(userAccountFile);
            writer.write("");
            writer.flush();

            for (int accountNumber : allUserAccountNumbers)
            {
                writer.write(accountNumber + "," + allUserBalances.get(allUserAccountNumbers.indexOf(accountNumber)));
                writer.write("\n");
            }

            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }

        System.exit(0);
    }
}