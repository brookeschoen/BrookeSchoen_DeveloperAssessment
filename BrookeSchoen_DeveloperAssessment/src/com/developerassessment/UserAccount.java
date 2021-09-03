package com.developerassessment;

import java.io.*;
import java.util.*;

public class UserAccount
{
    private final String filePath = "/Users/brookeschoen/Desktop/BrookeSchoen_DeveloperAssessment/UserAccountInfo";
    private final File userAccountFile = new File(filePath);
    private ArrayList<Integer> allUserAccountNumbers;
    private ArrayList<Float> allUserBalances;
    private int accountNumber;            // the account number of the user
    private float balance;                // the current balance of the associated account number

    public UserAccount()
    {
        readAccountNumbersAndBalancesFromFile();
    }

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

    private boolean accountNumberExists(int accountNumber)
    {
        return allUserAccountNumbers.contains(accountNumber);
    }

    public float getUserBalance()
    {
        final int accountNumberListPosition = allUserAccountNumbers.indexOf(this.accountNumber);
        this.balance = allUserBalances.get(accountNumberListPosition);

        return this.balance;
    }

    public ArrayList<Float> getAllUserBalances()
    {
        return allUserBalances;
    }

    public void updateBalance(float newBalance)
    {
        final int balanceListPosition = allUserBalances.indexOf(this.balance);
        allUserBalances.remove(balanceListPosition);

        this.balance = newBalance;
        allUserBalances.add(balanceListPosition, this.balance);

        updateUserAccountFile();
    }

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

    public String toString()
    {
        return accountNumber + " " + String.format("%.2f", balance);
    }
}