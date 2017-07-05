# GUI-JDBC
#Part I (This is for your own exercise; there is no need to hand in the run results):  
#1. GUI  
Create the GUI programs listed in Chapter 14 and 25 of the textbook using a Java IDE tool to generate the GUI code. You may use NetBeans or Eclipse as your IDE. These IDEs can be installed from textbook CD or download from Internet.  For each of the above java program, please add a Java utility class java.util.Calendar to display the date and time on the outputs.  Please generate the GUI code using an IDE such as Netbean or Eclipse, do not write the GUI code yourself.  

#2. JDBC  
  1. Create the database “books” from chapter 28 of the textbook in MySQL. The instructions and sql scripts can be found either from the lecture notes or textbook CD.  a. You can create your MySQL account in CS99 using the script at https://cs99.bradley.edu/~firewall/register.pl (You may need to use a version of IE or Firefox or Chrome that allows you to proceed and ignore the security warning, since CS99 HTTPS may still have some certificate issues at this time.)  b. Click the MySQL Book script link to download the SQL script to create the database. You can either create the books database use the phpMyAdmin or use the following commands:  $mysql –u username –p  >(type in password) … mysql> source mysqlbooks.sql; 
  2. Create and test the JDBC programs in chapter 28.
  ---------------------------------------------------------------------------------------------------------------------------  
  #Part II:  
  1. GUI  Design and develop a Book client GUI application program using NetBeans/Eclipse Java IDE tool to insert, update and delete Book data entries using stub functions (stub function is a place holder function that is empty except print out what it will do). Each group should have your unique GUI design.  Please generate the GUI code using an IDE, do not write the GUI code yourself.  The user interface window(s) should have as many of the following major GUI swing components (beans) as possible:  Basic Controls: JLabel, JTextfield/JPasswordField, JTextArea, JCheckBox, JButton, JRadioButton/ButtonGroup, JComboBox (Drop-down list), and JList/JScrollPane. Container components: JPanel, JTabbedPane, JDialog, JMenuBar, JMenu, JMenuItem, JCheckBoxMenuItem, and JRadioButtonMenuItem. (Extra Credit) Provide user with dynamically generated database tables and a data table (JTable) to insert, update and delete data entries. 2. JDBC  Develop a Java application program that implements the stub functions with sql statements against the MySQL Book database.  - Use connection string “jdbc:mysql://cs99.bradley.edu:3306/s_yourLoginName” for MySQL on cs99. 
    1. Develop a sqlQuery function using sql Statements to query the Book database tables.      Develop a sqlUpdate function using sql Prepared Statements to insert/delete/update the Book database tables.  
    2. Test the above functions with the Book database.  
  
#3. Two-Tier client-database System  Combine the 1 and 2 into a two-tier client/database application.  
    1. Rewrite the JDBC code in the Java application program into a Java JDBC class.  
    2. Redirect the I/O in GUI from the local stub functions to the JDBC class functions.  
    3. Test the GUI application with the Book database.
