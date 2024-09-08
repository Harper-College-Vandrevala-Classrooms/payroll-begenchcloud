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
        System.out.print("Please enter your hourly rate: ");
        double hourlyRate = scanner.nextDouble();
        scanner.close();
        System.out.print("");

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
        double insurance;

        if (numberOfDependants > 2) {
            insurance = 35.00;
        } else {
            insurance = 15.00;
        }

        double expenses = ssTax + fiTax + siTax + unionDues + insurance;
        double netPay = grossPay - expenses;

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
