# Local database Setup

## 1. Create a Database

1.1 Open **pgAdmin**.  
1.2 Select your PostgreSQL server.  
1.3 Right-click on **Databases**.  
1.4 Create a new database (just provide a name, nothing else).

## 2. Connect the Database to IntelliJ

2.1 On the right panel, click on **Database**.  
2.2 Click on the **+** sign.  
2.3 Click **Data Source**.  
2.4 Select **PostgreSQL**.  
2.5 Input the username and password for your database (if you followed the steps from 'data & AI', the username is `postgres` and the password is `Student_1234`).  
2.6 Click **Test Connection**. If successful, click **OK**.

## 3. Select the Relevant Database

3.1 While having the **Database** panel open, click on the number next to your newly created PostgreSQL database (it should be named `postgres@localhost`) and select your database.  
3.2 Then, click on the numbers next to your database and select **All Schemas**.

## 4. Modify the Connection String

4.1 Open the `DBConnect` interface located in the `managers` package.  
4.2 You will find the connection string inside:

```java
String connectionUrl = "jdbc:postgresql://localhost:5432/Test?user=postgres&password=Student_1234";
```

4.3 Analyze the string:

- **jdbc**: The driver being used.
- **postgresql**: The type of database.
- **://localhost**: The location of the database. For now, it runs on the localhost (this may change later).
- **:5432**: The port the database listens to for traffic. (5432 is the default, but it may differ based on your configuration. To check in pgAdmin, right-click on the server you're using (likely named `PostgreSQL 17`), select **Properties**, then go to **Connection** and check the line named **Port**.)
- **Test**: The name of the database. Replace this part with the name you gave your database.
- **user=postgres**: The database owner name. This may vary depending on how you set up the server.
- **password=Student_1234**: The database password. This may vary depending on your setup steps.

4.4 Change the connection string values as needed.

**Note:** Before doing this step, test if you can access the database through the connection string. If successful, you can skip Step 6.

## 5. Add a JDBC Driver Dependency (if necessary)

5.0 Download the JDBC driver from [https://jdbc.postgresql.org/download/](https://jdbc.postgresql.org/download/).  
5.1 In IntelliJ, click on **File** in the top left corner and select **Project Structure**.  
5.2 On the left panel, select **Modules**.  
5.3 On the right part of the window, select **Dependencies**.  
5.4 Click the **+** icon under **Module SDK**.  
5.5 Select **JARs or Directories**.  
5.6 A new window will open. Select the downloaded JDBC driver (the `.jar` file).

Now you have a running database, and every time you run `Main`, it will check for table existence. In case the correct tables don't exist, it will create them.


# Git Guide

## 1. First Clone
1. Open any terminal and navigate to the location where you want to save this project locally.
2. Once there, type `git clone https://github.com/Pepeeeeeeeeee/HalmaMaven.git` into the terminal.
3. You should now have the project stored locally.
4. If this didn’t work, try initializing Git first by typing `git init` before attempting to clone the repository again.

## 2. Creating Branches
1. Initialize Git (if not already initialized) by typing `git init`.
2. Create a new branch and switch to it using `git switch -c name_of_branch`.
3. Display all available branches (both local and remote) with `git branch -a`.
4. Push your branch to the repository and set it as a remote branch using `git push --set-upstream origin name_of_branch`.

## 3. Push into Repository
1. Add any newly created or modified files by typing `git add .`.
2. Commit your changes with a message by using `git commit -m "commit message"`.  
   (The message should describe the changes, e.g., `"Added a class"`, `"Fixed a bug"`, `"Changed a method"`).
3. Push your changes into the repository using `git push`.

## 4. Pull Requests (Ignore This for Now)
1. Pull requests are almost the same as merge requests in GitLab and work similarly.
2. **Please do not merge your branch into `main` by yourself.**  
   Have at least one person review the code before merging.

## 5. Pull from Repository
1. Pull the latest changes from the `main` branch using `git pull origin main`.
