# csc207

Add an Expense Use Case <br />
Provides a View through an AddExpenseView class wherein the user can input information about the information of an expense including: <br />
- Name <br />
- Amount <br />
- Category(food, rent, etc.) <br />
- Date(Year, Month, Day) <br />
<br />
Input data for information is then taken through the addExpenseController class, then logged into user data. <br />
A JOptionPane will appear to display whether the adding of an expense is successful or not, depending on valid or invalid input of the user. <br />
Implemented in AddExpensePresenter class to prompt a prepareSuccessView and prepareFailView, which are methods designed to display the success or fail messages based on invalid input. <br />
User’s expense data is processed into Expense History UI, which displays all recent transactions. <br />
