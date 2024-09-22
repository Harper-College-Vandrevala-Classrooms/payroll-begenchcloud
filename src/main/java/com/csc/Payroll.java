package com.csc;
import java.util.Scanner;

public class Payroll {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Payroll App!!!");
        System.out.println("");
        System.out.print("Please enter number of hours worked this week: ");
        int numberOfHoursWorked = scanner.nextInt();

        System.out.print("Please enter number of dependants: ");
        int numberOfDependants = scanner.nextInt();
        if (numberOfDependants < 0) {
            System.out.println("Number of dependants cannot be negative. Setting dependants to 0.");
            numberOfDependants = 0;
        }

        System.out.print("Please enter your hourly rate: ");
        double hourlyRate = scanner.nextDouble();
        while (hourlyRate < 0) {
            System.out.println("Hourly rate cannot be negative. Please re-enter your rate.");
            System.out.print("Please enter your hourly rate: ");
            hourlyRate = scanner.nextDouble();
        }

        int lifeInsuranceOption = 0;
        boolean validOption = false;
        while (!validOption) {
            System.out.println("Which life insurance plan do you want to select?");
            System.out.println("  (1) No plan");
            System.out.println("  (2) Single plan");
            System.out.println("  (3) Married plan");
            if (numberOfDependants > 0) {
                System.out.println("  (4) Married with children plan");
            }
            lifeInsuranceOption = scanner.nextInt();

            if (lifeInsuranceOption == 1 || lifeInsuranceOption == 2 || lifeInsuranceOption == 3 || (lifeInsuranceOption == 4 && numberOfDependants > 0)) {
                validOption = true;
            } else if (lifeInsuranceOption == 4 && numberOfDependants <= 0) {
                System.out.println("Sorry! You need at least one child to select that plan.");
            } else {
                System.out.println("Invalid option. Please select again.");
            }
        }

        scanner.close();

        double grossPay;
        if (numberOfHoursWorked <= 40) {
            grossPay = numberOfHoursWorked * hourlyRate;
        } else {
            double overtime = numberOfHoursWorked - 40;
            double beforeOvertime = hourlyRate * 40;
            double timeandHalf = hourlyRate * 1.5;
            double overtimePay = overtime * timeandHalf;
            grossPay = beforeOvertime + overtimePay;
        }

        double ssTax = grossPay * 0.06;
        double fiTax = grossPay * 0.14;
        double siTax = grossPay * 0.05;
        double unionDues = 10.00;
        double insurance = (numberOfDependants > 2) ? 35.00 : 15.00;

        double lifeInsuranceCost;
        if (lifeInsuranceOption == 2) {
            lifeInsuranceCost = 5.00;
        } else if (lifeInsuranceOption == 3) {
            lifeInsuranceCost = 10.00;
        } else if (lifeInsuranceOption == 4) {
            lifeInsuranceCost = 15.00;
        } else {
            lifeInsuranceCost = 0.00;
        }

        double expenses = ssTax + fiTax + siTax + unionDues + insurance + lifeInsuranceCost;
        double netPay = grossPay - expenses;

        if (netPay < 0) {
            netPay = grossPay - (ssTax + fiTax + siTax);
            System.out.println("");
            System.out.println("The employee still owes:");
            System.out.printf("   Union:   $%.2f\n", unionDues);
            System.out.printf("   Insurance:   $%.2f\n", insurance);
            System.out.printf("   Life Insurance:   $%.2f\n", lifeInsuranceCost);
        }

        System.out.println("Your payroll:");
        System.out.println("=====================================");
        System.out.println("Hours Worked: " + numberOfHoursWorked);
        System.out.println("Number of dependants: " + numberOfDependants);
        System.out.println("Hourly Rate: " + hourlyRate + " $/hr");
        System.out.printf("Gross Pay: $%.2f\n", grossPay);
        System.out.println("");
        System.out.printf("Social Security Tax: $%.2f\n", ssTax);
        System.out.printf("Federal Income Tax: $%.2f\n", fiTax);
        System.out.printf("State Income Tax: $%.2f\n", siTax);
        System.out.printf("Union Dues: $%.2f\n", unionDues);
        System.out.printf("Insurance Cost: $%.2f\n", insurance);
        System.out.printf("Life Insurance: $%.2f\n", lifeInsuranceCost);
        System.out.printf("Total: $%.2f\n", expenses);
        System.out.println("");
        System.out.printf("Net Pay: $%.2f\n", netPay);
        System.out.println("=====================================");
        System.out.println("");
        System.out.println("Thank you for using Payroll App!!!");
        System.out.println("Bye");
        System.exit(0);
    }
}
