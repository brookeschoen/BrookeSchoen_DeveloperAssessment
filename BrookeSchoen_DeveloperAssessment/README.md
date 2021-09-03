# Brooke Schoen's Hy-Vee Developer Assessment - SE 1
***
This project is Brooke Schoen's submission for the Hy-Vee Financial
Department's Developer Assessment - SE 1. 

### Background
The assessment prompt is as follows:

>"Your employer, a fictional regional supermarket chain, is
experimenting with a system that will allow customers to use
their customer loyalty card as a debit card for their in-store
purchases in exchange for a discount on their bill. You have been
asked to create a simple program which will be used by store employees
to read and modify a user's account balance. For the pilot, it will
operate entirely from the command line and everything will be hand-entered
by the user. The customer's account information will be stored in a flat
file on the local machine and a separate process will handle synchronizing
them across other instances of the program, meaning you do not need to worry
about concurrency or any data other than what is stored in the file."

### Features
As required by the assessment, the project implements the following functions:

```java
public class UserFunctions 
{
    // "Print the balance of the required account number."
    public static void check(int accountNumber);
    
    // "Adds amount to the balance of the provided account number."
    public static void deposit(int accountNumber, float amount);
    
    // "Subtracts amount from the balance of the provided account number. 
    // Prints an error message and exits without modifying the balance if the resulting balance would be negative."
    public static void charge(int accountNumber, float amount);
    
    // "Prints the total balance remaining in all accounts"
    public static void total();
}
````

## General Information
***
**Author:** Brooke Schoen

**Project Status:** Complete

**Date Completed:** 09/02/2021

## Technologies
***
A list of technologies used in the project:
* Java 8
* Command line

## Installation
***
Use GitHub to clone the repository
```shell
$ git clone https://github.com/brookeschoen/BrookeSchoen_DeveloperAssessment.git
$ cd ~/BrookeSchoen_DeveloperAssessment/
$ javac -cp . com/developerassessment/*.java
```

## Usage
***
_Using test cases in [UserAccountInfo](/Users/brookeschoen/Desktop/BrookeSchoen_DeveloperAssessment/UserAccountInfo)_

```shell
#returns "0.00"
$ java -cp . com/developerassessment/Main check 2356544

$ java -cp . com/developerassessment/Main deposit 2356544 100.00

#returns "100.00"
$ java -cp . com/developerassessment/Main check 2356544
```

## Contributing
***
Pull requests are welcome. Please make sure to update tests as appropriate, and change 
the file path of "UserAccountInfo.txt" as needed.

Any major changes to the code is not allowed at this time.

## Acknowledgement
***
Thank you to the Hy-Vee Financial Software Development team for providing me with the
opportunity to complete this project. 

