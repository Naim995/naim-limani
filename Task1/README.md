# Task 1 

 ## Exploratory testing notes:
- Filter:
  - Check if day filter works correctly
  - Check week filter date works correctly by settings "FirstDayOfWeek=Mon"
  - Check Month filter
  - Check Year filter
  - Check All filter
  - Check interval filter by setting a specific interval
  - Check choose date filter by choosing a specific filter
  - Check filter functionality for Cash, Payment card and all accounts work correctly
- Search
  - Search by category
  - Search by account
  - Search by note
  - Search by using '<' and '>' operands
  
- Menu
  - Show offer page when user tries to add new income category
  - Show offer page when user tries to add new expense category
- Transfer functionality
  - transfer between same account displays error message: "Accounts need to be different"
- Adding expenses and income
  - Add expense for a specific day and verify expense is added for that day
  - Add new income and verify income is shown on chosen day
  - Check balance is showing the correct transactions and the correct balance
  - Add expense for next day then filter for the whole week and check if Balance shows correct transactions and balance
  
- Swiping functionalities
  - Swipe left to show previous day
  - Swipe on left on the date area to open the filters view
  - Swipe right on the date area to open the main menu
- 
## Bugs
Device: iOS  
App version: 1.3.30

1. Check day filter didn't update itself after 00:00
Repro steps:
- Open Monefy app before 00:00
- Wait until 00:00
- Add day filter
- **Expected output**: calendar day is updated
- **Actual output**: calendar day is not updated

2. Potential bug
- After choosing a specific day in filter you cannot reset the filter to todays date.
Even if one unselects and selects day filter again.
  Repro steps:
- Open Monefy app
- Go to filters
- Add specific day filter
- Unselect day filter
- Select again
- **Expected output (supposedly)**: calendar day is reset and shows todays date
- **Actual output**: the specific day chosen previosly is still in the main display, is not highlighted as selected and to reset one needs to manually choose the todays date

3. Swipe left to see recrods for the previous period is not working
   Repro steps:
- Open Monefy app
- Actual output:

4. User is able to transfer funds from cash to payment card without having any income on that day. However it reflects if user adds income later

## How I executed my exploratory testing
- First area to exploratory test are the main functionalities or basic flows (shortest path to certain use case). After making sure that the basic flow of a use case
works as expected then I test the exception flow and in the end the alternative flow, which are alternatives routes other than the basic flow of a specific functionality.
- I spent about 5 minutes to test each basic functionality and 5 extra minutes to brainstorm on alternative routes or think of potential bugs on only 1 use case or functionality per time
- Taking into consideration that mathematical operations are tested in unit level I would focus testing on functionality calculations such as balance display after add income and expenses. Checking the colors under balance which define whether a record is an income or expense etcetera 
