# LoanLedger

# GeektrustChallenges
Challenges on Geektrust with readable, scalable and optimized code.

# Challenge 1: [Loan Ledger Co.](https://www.geektrust.in/coding-problem/backend/ledger-co)

##### Problem context: 


##### Analysis:

 *	Model, DAO, Services, Utils module handle the Loan taking & repayment as well as balance checking functionalities.

##### Solution steps:
	1.	Identify model/bean classes required.
	2. 	Call service methods as per commands. Modify/update DB in Daos. Identify & Raise exceptions in invalid cases.

##### Java Version: 1.8

##### Objects:

 *  Loan[p,r,n, totalAmount, amountPaidSoFar :Integer;]
 *  ExtraLoanPayments[lumpSum: Integer; afterEmiNum: Integer]
 
> Assumption: 

 *	max total amounts to be paid is in the range of java integer (2^31-1)

> Note: 

 *	In this application, **Ledger** is responsible to provide balance amount at different EMI stages/period. 
In real time application, these values will be retrieved from database or file system or through any third party web service.
 
> Example:
```
SAMPLE INPUT-OUTPUT 1

INPUT:
LOAN IDIDI Dale 10000 5 4
LOAN MBI Harry 2000 2 2
BALANCE IDIDI Dale 5
BALANCE IDIDI Dale 40
BALANCE MBI Harry 12
BALANCE MBI Harry 0

OUTPUT:
IDIDI Dale 1000 55
IDIDI Dale 8000 20
MBI Harry 1044 12
MBI Harry 0 24

SAMPLE INPUT-OUTPUT 2

INPUT:
LOAN IDIDI Dale 5000 1 6
LOAN MBI Harry 10000 3 7
LOAN UON Shelly 15000 2 9
PAYMENT IDIDI Dale 1000 5
PAYMENT MBI Harry 5000 10
PAYMENT UON Shelly 7000 12
BALANCE IDIDI Dale 3
BALANCE IDIDI Dale 6
BALANCE UON Shelly 12
BALANCE MBI Harry 12

OUTPUT:
IDIDI Dale 1326 9
IDIDI Dale 3652 4
UON Shelly 15856 3
MBI Harry 9044 10
```