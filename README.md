Loan Repayment Calculator

The application has two functional methods

calculatePaymentPerMonth()

The function takes principal amount, paymentTermInYears, annulaRate percentage as its parameters The monthly rate is calculated from the term, and formula used is as below = (principal * monthlyRate * Math.pow(1 + monthlyRate, totalPayments)) / (Math.pow(1 + monthlyRate, totalPayments) - 1);

repaymentCalculator()

This function takes in loanAmount, loanTerm, annualInterestRate as its parameters 
The function loops for the loan term period in monthly basis so as to calculate interest from the outstanding balance as below
interestPayment = remainingBalance * (annualInterestRate / 100) / 12

the repayment are first applied on the interest before proceeding to the principal as below:
interest payment principalPayment = monthlyPayment - interestPayment; 
principal payment remainingBalance -= principalPayment;
