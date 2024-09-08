package com.csc;

public class Grosspay {
    public double grossPay(double numberOfHoursWorked) {
        double grossPay;
        if (numberOfHoursWorked <= 40) {

            grossPay = numberOfHoursWorked * 16.78;
            return grossPay;

        } else {

            double overtime = numberOfHoursWorked - 40;
            double beforeOvertime = 16.78 * 40;
            double overtimePay = overtime * 25.17;
            grossPay = beforeOvertime + overtimePay;
            return grossPay;
        }
    }
}