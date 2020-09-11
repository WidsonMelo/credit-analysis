# Credit Analysis
Credit Analysis An Api to request credit analysis for new users. The user requests a credit analysis proposal, the analysis is evaluated and approved (or disapproved) by another user with specific assignment for this function. Credit analysis is registered by one type of user (Pickup) and proven (or disapproved) by another type of user (Analyst).

## Problem
Develop a credit analysis system for new cardholders, where we must have users with two types of permission, namely:
* User to collect new card proposals: this user will be responsible for registering new cardholders. After the registration of the bearers, this user will only be allowed to check the results of the analyzes carried out by the analysts.
* Credit analyst user: this user will be responsible for checking the registered proposals, being able to approve or deny the granting of credit. The result of the analysis will be made available to the proposal capture user.

## Tecnologies
- MySQL 8.0.21
- Spring Boot 2.3.3
- JDK 1.8.0_261

## Notes
The file for configuring the database is in the directory below:
```
\src\main\resources\aplication.properties
```

Before starting the application, the entire database must be created and mapped for management. You must open your COMMAND LINE (MySQL) and paste all the contents of the script located in the directory below (bd.sql):
```
\bd.sql
```

## Instalation
To open the project on your computer (eclipse), use the following instructions:
Baixar este projeto em formato .zip.
```
Clone or Download > Download ZIP
```

Extract the project to your workspace folder.
At eclipse, import the project as a MAVEN project by following the steps below:
```
File > Import >  Maven > Existing Maven Projects (next) 
```

Navigate to the directory that contains the extracted project folder (browse):
```
File > Import >  Maven > Existing Maven Projects (next) > Finish
```

## Configuration information for starting database.
Use MySql version 8 installed on the machine. Manually create a database called 'bd' before starting the application according 'bd.sql' file.
Login MySql: root or your login MySql configuration
Password MySql: 123456 or your password MySql configuration
For any other observation, inspect the "application.properties" file and also the "pom.xml" file.

## Starting the application
After importing the project, Maven will download the necessary dependencies and this will take a few minutes, according to information in the lower left bar of the eclipse (Progress).
To starting application, do execute execute the class bellow.Executar a seguinte classe (Run As Java Application).
```
credit-analysis > com.widson.creditanalysis > CreditAnalysisApplication.java
```

## endpoint.txt file
The file endpoint.txt shows all the endpoints contemplated by the project, you can use as specified in this file.

## Autor
**Widson Gomes de Melo**
```
Linkedin https://www.linkedin.com/in/widsonmelo/
```

## Licence
This project is licensed under the Apache License - see the [LICENSE.md](LICENSE) file for details.
```