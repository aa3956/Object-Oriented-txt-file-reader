package task3;

import java.util.*;
import java.io.*;

public class Task3 {

    public static void main(String[] args) {
        
        String fileLocation = System.getProperty("user.dir");
        String dataPath = fileLocation + File.separator + "shark-data.txt";

        try {

            //Create a file instance
            File file = new File(dataPath);

            //Scanner for the file 
            Scanner input = new Scanner(file);

            //Create Shark object array for 25 sharks
            Shark[] sharks = new Shark[25];
            int currentIndex = 0;

            //Read data from a file
            while (input.hasNext()) {
                //Read all lines from file 
                String a = input.nextLine();

                //When the ":" is read it returns the array of each thing calling it using index[] numbers from 0-6
                String[] sharkData = a.split(":");

                //Here shark has 7 different attributes and are defined using the index of arrays
                sharks[currentIndex] = new Shark(sharkData[0], sharkData[1], Integer.parseInt(sharkData[2]), Integer.parseInt(sharkData[3]),
                        sharkData[4], Integer.parseInt(sharkData[5]), sharkData[6]);
                currentIndex += 1;
            }

            //Scanner for user input
            Scanner input2 = new Scanner(System.in);
            System.out.print("Enter search string for Latin names: > ");

            //Return String user entered
            String userInput = input2.nextLine();
            System.out.println("You entered string: \"" + userInput + "\"");
            
            //prints line
            System.out.println("The following matches have been found:- ");
            
            //Print common and latin names
            names(sharks, userInput);
            
            //Close the file
            input.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void names(Shark[] arr, String userInput) {
        
        //add the array of common and latin names to the set myList
        Set myList = new HashSet<>();
        
        //for loop to iterate through the array length
        for (int i = 0; i < arr.length; i++) {
            //The array of latin names is read as lowercase and checks if it contains the userInput to lowercase
            if (arr[i].getLatinName().toLowerCase().contains(userInput.toLowerCase())) {
                
                //String resultLeft is the common name of the shark which keeps it as it is
                String resultLeft = arr[i].getName() + " - Latin name: ";
                
                /*String resultRight is the latin name of the shark and reads it as lowercase and replaces 
                the userInput to lowercase first then to uppercase*/
                String resultRight = arr[i].getLatinName().toLowerCase().replace(
                        userInput.toLowerCase(), userInput.toUpperCase());
                
                //Gets the chracter of latin name at index 0
                char orCh = arr[i].getLatinName().charAt(0);
                
                //prints the results of both left and right strings
                String result = resultLeft + resultRight;
                
                //adds the result to myList set to be sorted
                myList.add(result); 
            }
        }
      
        //Sort the List array of sharks that are printed from users result 
        List<String> sortedList = new ArrayList<String>();
        sortedList.addAll(myList);
        Collections.sort(sortedList);
        
        //for loop to print the sortedList by common names of shark
        for(String s: sortedList){
            System.out.println(s);  
        }

    }
}
