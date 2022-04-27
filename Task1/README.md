# Task 1 

 ## Exploratory testing notes:
 
- (Header)Header should be displayed 
   - "3 dots" menu icon should open menu on right side
   - Transfer button opens transfer page
   - When searching and before inputing anything user is able to swipe left and right through dates 
   - Filter button should open left side menu
- Filter screen: 
  - should display account selection button
    - account selection should display all enabled accounts
    - currency should be displayed under the account title
  - should display button for filtering by day, week, month, year, all interval and choose date
    - filter buttons should be highlighted when activated
    - filter button when activated should collapse filter menu and display main screen
  - Check if day filter works correctly
  - Check week filter date works correctly by settings "FirstDayOfWeek=Mon"
  - Check Month filter
  - Check Year filter
  - Check All filter
  - Check interval filter by setting a specific interval
  - Check choose date filter by choosing a specific filter
  - Check filter functionality for Cash, Payment card and all accounts work correctly
- Search screen
  - should display Cancel button
  - should display scan text when user presses on input field
  - should display "No records have been found. Try searchin..." when no searches are found for the given input
  - Search by category
  - Search by account
  - Search by note
  - Search by using '<' and '>' operands
- Menu screen
  - should display categories, accounts, currencies and seetings icons/buttons
    - categories
      - Show offer page when user tries to add new income category (restricted)
      - Show offer page when user tries to add new expense category (restricted)
      - Rename category
      - Change category icon functionality shows offer page (restricted)
      - Backup file should be created when merging categories
      - Disable category functionality removes icon from main page and greyes it out in the category list in the menu
    - account
      - Add new account 
      - Add new account initial account balance is reflected in the mainpage
    - currencies should display offer screen when clicked/pressed
    - settings
      - should display Labels Balance, General settings, synchronization, data backup
- Transfer screen 
  - should display date 
    - user should be able to select date
      - user should be able to swipe left to navigate to a previous month
      - user should be able to swipe right to navigate to the next month 
      - selected day of the month should be highlighted when selected
      - chosen date should be selected when pressing ok
  - should display input button
    - input button should display currency on the left side
    - input button default value should be 0 and right indented
    - backspace button should be displayed on the right
    - calculator should be displayed when activating input field
      - calculator should display save button
      - add note input field is displayed
    - 
    - 
  - transfer from one account to another
  - transfer between same account is restricted. Displays error message: "Accounts need to be different"
- Body Section / Main screen
  - should open main menu when swiping from the right edge to the left 
  - should open open filter screen when swiping from the left edge to the right 
  - should display all enabled category icons
  - should display income amount and expenses amount
  - should display circle diagram chart
  - should display percentage if expenses are added
  - should be able to add new expense by clicking on category icon
  - should display expense amount animation after adding expense
  - should display Balance screen when clicking the circle chart
  - should display category expense when click and hold on specific category
  - Swipe left to show previous day
  - Swipe on left on the date area to open the filters view
  - Swipe right on the date area to open the main menu
  - Add expense for a specific day and verify expense is added for that day
  - Add new income and verify income is shown on chosen day
  - Check balance is showing the correct transactions and the correct balance
  - Add expense for next day then filter for the whole week and check if Balance shows correct transactions and balance
- Footer
  - Balance should be display in the middle
  - should display three lines button on the left and on the right
  - should display '-' icon on the left for adding expenses
  - should display '+' icon on the right for adding income
  - opening Balance slides up and open balance screen
    - should display date and transaction records (expenses and income) for that date
      - income is marked with green dot
      - expenses are marked with red dot 
    - Balance screen should display transaction records (expenses and income)
    - on the right should display icon for choosing to display records by category and change icon to date
    - when by category is selected should display expenses and income by category
    - categories should collaps when clicked
    - categories should expand when clicked
    - records should be clickable and navigate to you to edit screen
    - balance screen should collaps 
    - balance screen should collaps when swiping from top to bottom 

  - '-' button should open new expense screen
    - new expanse should display selected date and is also a button
      - date screen should open when clicking the date button
        - user should be able to select desired date for the expense
      - expense input should be displayed
      - on the right of the input field account button should be displayed
        - user should be able to switch between accounts
        - 3 fingers touch should show functionality label for (Undo, cut, copy, Redo) when inputing 'add note'
  - '+' button should open new income screen
    - date screen should open when clicking the date button
        - user should be able to select desired date for the expense
        - expense input should be displayed
        - on the right of the input field account button should be displayed
        - user should be able to switch between accounts
        - 3 fingers touch should show functionality label for (Undo, cut, copy, Redo) when inputing 'add note'

  - ***BOUNDARY TESTING***
    - check maximum numbers or characters in fields and also minimum (max decimal points are 2)

## Bugs
Note: all bugs share the same system and app specifications
Device: iPhone 13 PRO MAX
Operating System: iOS 15.4.1
Monefy App version: 1.3.30

1. ***(app crashes)*** after inputing a negative number with 30 digites
Repro steps:
   - Open Monefy app
   - Navigate to main page
   - Click '+'
   - Input '5-6'.          output: -1
   - Input 30 digites "-999999999999999999999999999999" 
   - Result: app crashes

2. Distorted and unclear amount shown when press and hold on category icon
Repro steps:
   - Open Monefy app
   - Navigate to main page
   - press and hold category for 3-4 seconds       result: displays expenses
   - release press and quickly press and hold another category icon
   - Actual output/result: displays distorted image or amount of expenses

2. Main page calendar day didn't update after 00:00 o'clock
Repro steps:
   - Open Monefy app before 00:00
   - Navigate to main page or home screen
   - Wait until 00:00
   - **Expected output**: calendar day is updated
   - **Actual output**: calendar day is not updated user cannot swipe left to enter current day(there is no refresh button)
 
 3. Cannot scroll through elements when searching
Repro steps:
Given there is more than 10 transactions or records (expenses or incomes)
And an new expense is created
And expense note has 300 characters or more
When a user searches in the search functionality by inputing the first character
Then a list of records is shown
And the new expense with expense not of 300 or more characters is shown
**And user cannot scroll throught the list**

4. Phone keyboard blocks user interface when adding note to new transfer

Given a new transfer is initiated
When user inputs the amount
And inputs notes
Then keyboard is shown on top of the calculator
And keyboard doesn't go away even after pressing back button
 
(more like suggestions not bugs)  
5. User is able to transfer funds from cash to payment card without having any income on that day. However it reflects if user adds income later   
6. Missing reset functionality in calculator like 'AC'. 


Documentation for exploratory testing:  
1. https://www.perforce.com/blog/alm/what-is-exploratory-testing 
2. https://github.com/Maaikees/exploratory-testing/blob/master/exploratory-testing-with-the-team.md

## How I executed my exploratory testing
- First area to exploratory test were screen sections of the main screen: header, body, footer and then working from there on to sub screens. After that I tested main functionalities(scenarios/use cases) or basic flows (shortest path to certain use case). After making sure that the basic flow of a use case works as expected then I test the exception flow and in the end the alternative flows, which are alternatives routes other than the basic flow of a specific functionality.
- I spent about 3 minutes to test each basic functionality and 5-10 extra minutes to brainstorm on alternative routes or think of potential bugs on only 1 use case or functionality per time
- I executed boundary testing on all input or text fields. We need to mitigate risks such as not showing buttons, screen, making sure that animations are finished as expected so that they don't block screen functionalities, results of certaion use cases/ functionalities ...
