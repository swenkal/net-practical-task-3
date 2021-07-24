# net-practical-task-3
Practical task 3 for study

## parent package: com.edunetcracker.lms.ksndr.pdsh

### first
**Task**  
Develop a program that forms an SQL statement.
SQL inserts rows into the:

  - T_GroupSelected <id_Student, firstName, lastName, id_Group> table

from the:

  - T_Student <id_Student, firstName, lastName, id_Group, dolgCount> table  

of those students who belong to a certain group (string parameter)  
and the number of debts (integer parameter) which exceeds the specified value.

In a SQL statement, string values must be framed single quotes.

### second
**Task**  
Develop a Person class.
- function that returns Surname N.P. 
    - The function should take into account the possibility of missing values in the Name and Patronymic fields. 

Optimize the program in terms of performance.

### third
**Task**  
Modify the address class which from the resulting format string:

- "Country [d] Region [d] City [d] Street [d] House [d] Block [d] Room"   
([d] - separator, for example, “comma”) 

Method selects the corresponding parts and writes them into the corresponding fields of the class Address.  
Provide two implementations of this method:
 - separator - only comma (use the split () method);
 - separator - any of the characters,.; - (StringTokenizer class).
 
It should be remembered that there should be no spaces at the beginning and at the end of the parsed part of the address.  
All address fields are string.  
Design a validation class with at least four address lines.

### fourth
**Task**  
Implement the Shirt class.  
The toString () method displays the explanation and meaning of the fields line by line.  
Convert the string array to an array of class Shirt and output it to
console.

### fifth
**Task**  
Design a class that receives a string representation
phone number in one of two possible string formats:
- +< Country code >< Number 10 digits >,  
for example “+79175655655” or "+104289652211"
- 8<Number 10 digits> for Russia,  
for example "89175655655"

Convert the resulting string to the format:
- +< Country Code >< Three Digits >-< Three Digits >-< Four Digits >
