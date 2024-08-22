package org.example;

public class LoanCalculator {

    // Core Function To Be Assessed
    public static void repaymentCalculator(double loanAmount, int loanTerm, double annualInterestRate) {
        // Calculate monthly payment
        double monthlyPayment = calculatePaymentPerMonth(loanAmount, loanTerm, annualInterestRate);
        double remainingBalance = loanAmount;
        double totalInterestPaid = 0;
        double totalAmountPaid = 0;


        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n", "Month", "PaymentMade", "PrincipalAmount", "InterestEarned", "OutStandingBalance");

        //   Calculations on Monthly Basis
        for (int month = 1; month <= loanTerm * 12; month++) {
            double interestPayment = remainingBalance * (annualInterestRate / 100) / 12;
            double principalPayment = monthlyPayment - interestPayment;
            remainingBalance -= principalPayment;

            // Ensure remaining balance does not become negative
            if (remainingBalance < 0) {
                remainingBalance = 0;
            }

            totalInterestPaid += interestPayment;
            totalAmountPaid += monthlyPayment;

            // Print the details for the current month
            System.out.printf("%-10d %-15.2f %-15.2f %-15.2f %-15.2f\n",
                    month, monthlyPayment, principalPayment, interestPayment, remainingBalance);
        }

        totalAmountPaid = loanAmount + totalInterestPaid;

        System.out.printf("\n Amount to be Paid in Total: %.2f\n", totalAmountPaid);
        System.out.printf(" Interest Paid to be Paid in Total: %.2f\n", totalInterestPaid);

    }

    public static void main(String[] args) {
        // Loan details
        double loanAmount = 100000; // Principal amount
        int loanTermYrs = 3; // Loan term
        double annualInterestRate = 5; // annual interest rate


        //Function to be assessed
        repaymentCalculator(loanAmount, loanTermYrs, annualInterestRate);


    }

    public static double calculatePaymentPerMonth(double principal, int termYears, double annualRate) {
        // Convert annual rate percentage to decimal and then to monthly rate
        double monthlyRate = (annualRate / 100) / 12;

        // Calculate total number of payments
        int totalPayments = termYears * 12;

        // Calculate monthly payment using the formula
        return (principal * monthlyRate * Math.pow(1 + monthlyRate, totalPayments)) /
                (Math.pow(1 + monthlyRate, totalPayments) - 1);
    }
}