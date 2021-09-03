package com.developerassessment;

public class Main extends UserFunctions
{
    public static void main(String[] args)
    {
        String userFunction = "";
        int accountNumber = 0;
        float amount = 0;

        if (args.length == 0)
        {
            System.out.println("Please enter an account function you would like to perform");
            System.exit(0);
        }
        else
        {
            userFunction = args[0];

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
