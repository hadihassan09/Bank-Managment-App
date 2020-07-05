# Bank-Managment-System
This Project was built to focus on the different design patters in addition to the use of different database query's and functionalities

How To Run The App:
-------------------

1-You should run your sql server or what ever you use for sql..

2-Open your software to manege the database (MySQL Workbench for example) and export DATABASE.sql file and execute it.

3-Import bankManagmentSystem to your IDEA. (we prefare the use of intellij IDEA Community Edition)

4-In scr->sample->Classes->databaseClases edit the file(databaseConnection.java) and set the following:

	private String DBURL="jdbc:mysql://localhost:"PORTNUMBER"/bank_system";
	private String DBusername="DB USER";
	private  String DBpassword="DB PASSWORD";

``Edit PORTNUMBER and set it to your SQL Service Port``

``Edit DB USER and set it to your SQL User``

``Edit DB PASSWORD and set it to your SQL User Password``

Some Details for Login:
------------------------

Login as Admin:(Admin can add New Reception and Users)

	username: admin
	password: admin

Login as Reception:(Reception can ONLY add new Users)

	username: doctor
	password: doctor

Login as CustomeRS:

  	username1: hadi
	password1: hadi
	
	username2: zahwe
	password2: zahwe
  
----------------------------------------------------------------------------------------------------------
