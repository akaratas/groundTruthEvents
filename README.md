# groundTruthEvents

Ground-truth event determination for predicting evolution of communities
Version: July 2021
---------------------------------------
This folder contains all files for ground-truth event determination for predicting evolution of communities.
The task is described in the Appendix B section of the PhD Dissertation 'Tracking and Prediction of Evolution of Communities in Dynamic Networks' provided by Arzum KARATAŞ

The correspondent files are below.
	*JavaPrograms: The folder contains some Java source codes for table filling and text files needed by these source codes. 
	*exportTables.sql: The file for creating and filling some database tables.
	*queries.sql: The file for storing queries on the database tables for ground-truth event determination.
	*GroundTruthEvents_viaDBapp.txt: The text file including the determined ground-truth events
	

There are two ways for preparing a database application for this task. We recommend the follow the first way described below in terms of easiness.
1)a. Run "exportTables.sql" in Oracle SQL Developer to create and fill the following tables.
	- communities: It contains community identification numbers, their appearance time step for the first time and size of their members.
	- nodes: It contains which community belongs to which community at which time step.
        - intersections: It is used to determine the similarity between the community pairs.
        - matches: It is used to store matched community pairs and their respective evolution events.
        - notMatchedCommunities: It only holds the identification numbers of the communities not matched at the current time step.

	
  b. Run the SOL queries needed for approvement of the events in "queries.sql".	

2)a. Create tables using appropriate queries in "queries.sql" file.
  b. Run "CreateFillNodeQuery.java" file to fill communities and nodes tables in the database.
  c. Run the SOL queries needed for approvement of the events in "queries.sql".

  Note that you need to change path, pathfolder, database connection variables according to your environment.

  Oracle Database 11g Express Edition Release 11.2.0.2.0 -64 bit Production and Oracle SQL Developer 4.0.3 are used for database application.
  
