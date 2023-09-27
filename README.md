# CS-200
Implementation and design documentation for CS200 - Software Engineering and Design

This was a semester long group project focused on the implementation of a Chocoholics Anonymous software system.

## Manual
This is the manual for the implementation of the CS200 Chocoholics Anonymous project.
The project is written in Java and is authored by Christian Darr, Jack Orear, Marisa Gibbons, Travis Klavenga, Olakunle Olaniyan, John Starling, and Tejas Bhadoria.

To begin viewing our project, you must clone this repository. Then import a project from GIT through Eclipse or your preffered Java IDE.

In your IDE, find and open the ANT file. From there, click the add buildfiles button and find the build.xml file. This will present you with a handful of options. Double-click on any of the options to run them. It is recommended to run the cleanall task first. Then, attempt to build the project using the build-project option. Finally, use the MainMenuRun option to run the main code. 

Alternatively, the main class is run through the MainMenu.java class in our src folder. Right click on the MainMenu.java class and run it as a Java application. If you encounter problems, please check the run configuration and select to run MainMenu.java as a Java application.

Once you proceed with the run, you will see our GUI menu. First, select whether you would like to log in as an operator, provider, or manager. The usernames and passwords for each type of user are as follows:
	- Operator: user3, pass3
	- Provider: user1, pass1
	- Manager: user2, pass2
	
Once you enter the login credentials, our program validates your login and takes you to the user-specific menu. Provided are the directions for utilizing each user-specific menu:

Operator:
- Choose whether to edit the member or provider database.
- You may then select to add, edit, or delete members or providers.
- In the add or edit case, double click the field(s) in which you would like to add or edit information.
- Ensure that the ID and Zip code are both numbers with no other characters, and to hit enter when you are done editing.
- If you enter an invalid format, our program will display an error message.
- If you choose to delete a member, you must enter their user ID.
- If you choose to edit a member, you must enter their user ID.
- The user IDs in our database are as follows: 001, 002, 003, 004.
- The program will then add, edit, or delete the intended member/provider.

Provider:
- On the provider menu, you may opt to view the provider directory or bill a service.
- To view the directory, select the "Provider directory" option and the services and their associated fees will be displayed.
- To bill a service, the program will prompt you to enter the necessary fields.
- These include the service name, service code, service fee, provider id, and member id.

Manager:
- Choose whether to generate a single report or all reports.
- In the case of a single report, select which report to generate.
- The program will automatically generate the report(s) selected, and will display a success message for each report.
- As part of our design, the "generate all reports" option performs the same functionality required in the main accounting procedure.
- The report outputs are found under the "reports" folder in our repository.
- Each type of report will be output into its corresponding folder.
	
At any point during the program run, you may select to return to main menu or exit the program using the red circle button in the top left. Once you have explored our project, you can then generate the JAR. The instructions for creating the JAR are as follows: In the Ant view, there is an option called createjar. Double-click that and an executable jar will be generated in the release folder.

Once you have created the JAR, you may test our methods using our test files. The test files all contain the word "Test" somewhere in their file name. For each test file, right click in your Package Explorer, and run as a JUnit test. The JUnit popup will be displayed, and each test case will pass, as indicated by the green bar. Alternatively, the Ant view allows you to select each test individually and run it, or run the spring23team4test option to run all tests.
