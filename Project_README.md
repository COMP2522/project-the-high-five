This is a simple Tower Defense game created in Java. The objective of the game is to prevent enemies from reaching the right side of the game map by building towers that will shoot them down.

Gameplay

The game takes place on a 2D game map with a fixed path that the enemies will follow. The player has a set amount of money that they can use to buy and upgrade towers. The towers will automatically shoot at enemies as they move along the path. The player must strategically place their towers in order to prevent the enemies from reaching the end of the path.

In addition to the basic gameplay and installation instructions, this Tower Defense game has some specific features:

The UI class manages the user interface elements of a game. It contains methods for displaying the current level number, current score, number of enemies defeated, the player's current health using red and black hearts, and the player's current coins. The class also loads up UI elements such as coinImage, redHeart, and blackHeart. The displayHP method uses if-else statements to display a combination of red and black hearts depending on the player's current health. The displayText method displays text on the screen using a specified x and y coordinate. The constructor takes in a Window object for accessing the LevelManager and updating the game display. The setup method loads up the UI elements.

Installation 

Install the Java JDK and JRE
Download or clone the repository 
Open the project in your favourite Java IDE
Compile and run the game

Game Controls

Click on a tower on the bottom panel once to select it.
Click on the game map to place the selected tower (do not drag).
Press the 'm' key to go back to the main menu.
Press the escape key to quit the game.

Individual Contributions

Cheryl

Database Handling: I implemented a database system that stores the player's high score and game state. The game now reads and writes this data at regular intervals to ensure that the player's progress is always saved and up-to-date. The game reads the JSON game data from the database when the game is loaded, allowing them to continue their game from where they left off.

Menu Screen: I created a user-friendly menu screen that allows the player to start a new game, load a saved game, or view the high scores. This menu screen is easy to navigate.

Non-Blocking Concurrent/Asynchronous Processing: I added a non-blocking concurrent/asynchronous processing system that runs at regular intervals to save game data in the background.

Persistent Data State: I incorporated a non-trivial persistent data state that saves the player's progress and game state in a JSON file. This ensures that the player's progress is always saved, even if they exit the game or shut down their computer.

Winning/Losing Screens: I created winning and losing screens that are displayed at the end of each game. These screens provide feedback to the player and allow them to submit their name and their highscore to the leaderboard.

Highscore Writing to the Database: I implemented a system that writes the player's high score to the database at the end of each game. This ensures that the high score list is always up-to-date and reflects the player's latest score.

Game State Persistence: I implemented a game state persistence system that ensures the player's progress is always saved and up-to-date. This system saves the game state to a file or database at regular intervals, ensuring that the player's progress is always up-to-date.

JSON Game Data: I designed and implemented a JSON game data structure that stores the player's progress and game state. This data structure includes information such as the player's high score, game level, tower upgrades, and enemy progress.

Writing Game Data to File: I implemented a system that writes the JSON game data to a local file. This system ensures that the player's progress is always saved and up-to-date, even if they exit the game or shut down their computer.

Reading Game Data from File: I created a system that reads the JSON game data from the local file as the game is playing. 

Aric 

Bullet: Implemented the Bullet and BulletManager classes. The Bullet has methods to move it and check whether it has hit a target or not. If a Bullet hits a target our goes out of bounds, the BulletManager removes it from the window. BulletManager also handles updating all the Bullets in the list. 

UI: I made the user interface elements of a game. I created methods for displaying the current level number, current score, number of enemies defeated, the player's current health using red and black hearts, and the player's current coins. 

In addition to the aforementioned contributions, I also created a robust suite of tests to ensure correct functionality of those classes. Furthermore, I contributed to troubleshooting wherever the game logic coincided with either the Bullets or the UI. 

Credits
This game was created by Aric, Cheryl, Gursidh, Quan, and Victor

For next week, you'll want to have a clear idea of what your project is going to be. Then, in the next lab, I will help you scope your project appropriately. In this repo, write the following:
1.	A one-liner (exactly 1 sentence) that describes your project.
Our group is planning to create a tower defense simulator consisting of enemy entities following a predestined path where they will systematically encounter the player’s “towers” trying to impede their movement. 
2.	A list of points (about 5-10 sentences) that describes how your project meets each of the requirement criteria.
-	We will use the processing.org libraries to create visual interfaces. Our game will have a visual interface to represent a map, characters, and enemies.
-	We are going to write test cases to ensure the game is working as we intended it to
-	We will save our game state in a database. (wave, points after every wave)
-	Our group will be documenting all the meetings, so we are aware of progress and keep ourselves within the scope. This will be done by having good commit messages, writing process reports…
3.	Answers to the below group discussion items (meetings, communication, roles, and expectations).
A large portion of your mark for this course will be work that you do within the context of a group. My expectations are that all group members contribute fully to the best of their abilities. Since everyone will have different abilities, preferences, and interests, this can sometimes be difficult to negotiate.
1.	Every group member must be on a common chat application, and must check and respond to messages within a day during normal business hours.
2.	Every group member must volunteer to take on project tasks and complete them by the associated deadlines. These tasks MUST be managed using GitHub issues. Each group member is responsible for creating and closing GitHub issues for tasks they have taken on.
3.	The group must meet at least once during the week outside of class time to discuss the status of project tasks. All group members must be present during this meeting.
4.	For official/important decision-making meetings, an ongoing minutes document must be maintained where attendance and group decisions are recorded.
5.	Groups must decide on a way of formally negotiating disputes. Default will be consensus with 2/3rds majority vote unless another system is explicitly decided upon.
If there are disputes that require mediation from me, I will be happy to help the group find a solution that is amenable to all. In your first group meeting, you will want to discuss the following:
1.	Meeting time and format: when will you meet and how?
a.	Monday after class, and Wednesdays if needed. Both in person.
2.	Communications expectations and format: what times of day are people available and by which medium?
a.	Efficient communication via Discord with an expectation of one business day to reply.
3.	Roles and responsibilities: who will do what part of the group aspects of the project, including project management?
a.	Facilitator • Moderates team discussions • Keeps the group on task • Ensures equal involvement • Ensures equal opportunities to learn, participate and earn respect 
-	Cheryl 
b.	Recorder • Distributes and hands in materials • Completes worksheets, written assignments or summaries for oral reports 
-	Aric 
c.	Reporter • Summarizes the group’s activities or conclusions • Assists the recorder with writing worksheets and group reports 
-	Victor 
d.	Timekeeper • Keeps the group aware of time constraints • Aids the facilitator in keeping the team on task • Consults with other teams if needed • Leaves the work area in good condition • Fills in for an absent member if there is no fifth member 
-	Gursidh
e.	Wild card • Fills in for an absent member
-	Quan
4.	Abilities and expectations: how much effort do people want to put into the project and in what areas do they have expertise?
a.	Our group is aiming for an A grade
Timeline: 
Week 1 
-	Finish UML diagrams and initiate GitHub issues 
Week 2 
-	Write major classes and define some preliminary methods 
Week 3 
-	Begin testing functionalities 
Week 4 
-	Flesh out classes 
Week 5 
-	Complete the asynchronous processing function 
-	Define non-trivial processing data state 
Week 6
-     Final testing and polish 


Aric's Individual Pitch 
Create the abstract class Sprite, Bullet and BulletManager classes, in addition to the Movable, Collidable, and Drawable interfaces that my classes will use. Will also create the User Interface for the game. 
Link to my individual UML: https://lucid.app/lucidchart/6374c9c3-ae59-4825-8218-2a28836e6774/edit?viewport_loc=-618%2C-560%2C2976%2C1618%2C0_0&invitationId=inv_78f664df-33f0-49ea-b901-db3ade92b6a6

Cheryl's Individual Pitch
Develop the Window class in which the game is played on and render the image depending on the game state (PLAYING, PAUSED, MENU).
Save Player information to a database to retrieve when the same Player is selected.
Write game data to the database (current level, number of towers, current score, creeps killed)
Retrieve data from database to load game progress.
Create Winning, Losing and Highscore screens.
Highscore writing capability to the database.
Writing the game state data to a local file for pushing and pulling at regular intervals.
Link to my diagram: [https://lucid.app/lucidchart/3c9cd7cd-8612-4432-92c6-f70b56f7127a/edit?viewport_loc=-898%2C-682%2C2466%2C1172%2C0_0&invitationId=inv_9125c3b1-e3f1-408a-96c3-a11f92cc0aa2](https://lucid.app/lucidchart/05253a12-b41a-43d8-ae31-ace8e2cb8f73/edit?viewport_loc=-1334%2C-1474%2C4607%2C2136%2C0_0&invitationId=inv_fb4ce3b8-ecf9-4917-bba8-71b489d63375)


Gursidh's Individual Pitch
Create a Tower class that implements a Tower Manager superclass. The Tower Manager will handle all the Tower objects. In addition, Tower will also implement the abstract class Sprite which also implements Collidable. Will also be creating the UI Manager class alongside Victor which is connected to Window. 
Link to my individual UML: https://lucid.app/lucidchart/66d6bb77-2ee2-492b-8749-46daf81ce463/edit?invitationId=inv_56290ed1-47ee-4efd-a527-bb2c8e1baaca&page=0_0#

Victor's Individual Pitch
Create a Enemy class that implements a Enemy Manager superclass. The Enemy Manager will manage all the Enemy objects and store them in an array. Also, Enemy will implement abstract class Sprite, as well as the interfaces Collidable and Movable. Finally, create an UI Manager class alongside Gursidh. 
Link to my individual UML: https://lucid.app/lucidchart/dceae253-d48a-4638-9fd2-3562ea5fa071/edit?beaconFlowId=D28BF4163CD052FB&invitationId=inv_97bfffd1-b9fa-49f5-b9ee-047342d68bb4&page=0_0#

In Class Check:
Cheryl's parts are approved and we should be able to keep re-writing data to the database as the player keeps playing the game. Gursidh and Victor should split the collidable interface, as well as working on their own classes, because Enemy and Tower will be the classes that implement this interface the most. Aric should continue his tasks but should be in charge of UI manager instead of Gursidh and Victor splitting it. Quan's tasks are approved as well.

Instructions on how to play the game:

