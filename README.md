# MortgageCalculator 
MortgagePlan.java version 2.0 15/2/2020
Written by Ahmad Ghafori

Usage
----------
The program is written to calculate the mortgage of a person based on 
the interest, the loan amount and the requested time period. 
The program will either read a file with list of prospects, 
calculate the monthly payment for each prospect and write it to a file or
let the user enter loan amount, interest, and time (in years).

Runtime
----------
The program will ask for one of two options, 1 will ask the user
for a filename and then proceed to read the file, calculate the monthly payment
for each prospect in file and write to file based on output in PDF.

Option 2 will ask for loan amount, interest, and time(in years) and then calculate
the monthly payment based on those values.

Restrictions
----------
Since I was restricted in using java.math I had to manually multiply values
using loops and simple maths.
