
package task1;

import java.util.*;
import java.io.*;

public class Task1 {
    public static void main(String[] args){
       
     //Get file location   
     String fileLocation = System.getProperty("user.dir");
     String dataPath = fileLocation + File.separator + "shark-data.txt";
             
     try{
          
        //Create a file instance
        File file = new File(dataPath);
     
        //Scanner for the file 
        Scanner input = new Scanner(file);
        
        //Create Shark object array for 25 sharks
        Shark[] sharks = new Shark[25];
        int currentIndex = 0;
        
        while(input.hasNext()){
          //Read all lines from file 
          String a = input.nextLine();
          
          //each line is split using ":" and put into String array of sharkData
          String[] sharkData = a.split(":");
          
          //Here shark has 7 different attributes and are defined using the index of arrays
          sharks[currentIndex] = new Shark(sharkData[0], sharkData[1], Integer.parseInt(sharkData[2]), Integer.parseInt(sharkData[3]), 
          sharkData[4], Integer.parseInt(sharkData[5]), sharkData[6]);
          currentIndex += 1;         
        }
        
        //Write the results into a new txt file in your working directory
        PrintWriter fileWrite = new PrintWriter("results.txt");
        
        //Print the three largest sharks and write them to file
        System.out.println("---Three Largest Sharks---");
        sortArrLargest(sharks, fileWrite);
        
        //Print the three smallest sharks and write them to file
        System.out.println("---Three Smallest Sharks---");
        sortArrSmallest(sharks,fileWrite);
        
        //Print the total number of characters in latin names without whitespace characters and write them to file
        System.out.println("\n----------------------------------------------------");
        noOfLatinCharacters(sharks, fileWrite);
        
        //Print the total number of unique even and odd words in latin names and write them to file
        totalEvenAndOdd(sharks, fileWrite);
        
        //Close the file
        input.close();
        
        //Close Writing to file
        fileWrite.close();
     } 
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
    //Method to sort the array of sharks from largest to smallest
    public static void sortArrLargest(Shark[] arr, PrintWriter a){
        //temp variable 
        Shark temp;
        
        //largest shark from the object and array length
        Shark[] largest = new Shark[arr.length];
        
        //for loop to assign largest to the array of sharks 
        for (int i = 0; i < arr.length; i++){
            largest[i] = arr[i];
        }
        //for loops to go through the array and use temp to swap the largest for the one before
        for (int j = 0; j < largest.length - 1; j++){
            for (int k = j + 1; k < largest.length; k++){
                if (largest[j].getLength() < largest[k].getLength()){
                    temp = largest[k];
                    largest[k] = largest[j];
                    largest[j] = temp;
                }
            }
        }
        //Print the results to the console
        System.out.println(largest[0].getName() + ", Length = " + largest[0].getLength() + " centimeters"); 
        System.out.println(largest[1].getName() + ", Length = " + largest[1].getLength() + " centimeters");
        System.out.println(largest[2].getName() + ", Length = " + largest[2].getLength() + " centimeters \n");
        
        //Print the results to the file
        a.println("---Three Largest Sharks---");
        a.println(largest[0].getName() + ", Length = " + largest[0].getLength() + " centimeters"); 
        a.println(largest[1].getName() + ", Length = " + largest[1].getLength() + " centimeters");
        a.println(largest[2].getName() + ", Length = " + largest[2].getLength() + " centimeters \n");
    }
    
    //Method to sort the array of sharks from largest to smallest
    public static void sortArrSmallest(Shark[] arr, PrintWriter b){
        //temp variable 
        Shark temp;
        
        //smallest shark from the object and array length
        Shark[] smallest = new Shark[arr.length];
        for (int i = 0; i < arr.length; i++){
            smallest[i] = arr[i];
        }
        //for loops to go through the array and use temp to swap the largest for the one before
        for (int j = 0; j < smallest.length - 1; j++){
            for (int k = j + 1; k < smallest.length; k++){
                if (smallest[j].getLength() > smallest[k].getLength()){
                    temp = smallest[k];
                    smallest[k] = smallest[j];
                    smallest[j] = temp;
                }
            }
        }
        
        //Print the results to the console
         System.out.println(smallest[0].getName() + ", Length = " + smallest[0].getLength() + " centimeters");
         System.out.println(smallest[1].getName() + ", Length = " + smallest[1].getLength() + " centimeters");
         System.out.println(smallest[2].getName() + ", Length = " + smallest[2].getLength() + " centimeters");
         
         //Print the results to the file
         b.println("---Three Smallest Sharks---");
         b.println(smallest[0].getName() + ", Length = " + smallest[0].getLength() + " centimeters");
         b.println(smallest[1].getName() + ", Length = " + smallest[1].getLength() + " centimeters");
         b.println(smallest[2].getName() + ", Length = " + smallest[2].getLength() + " centimeters");
    }
   
   //Method to check for total characters of latin names without whitespace characters
   public static int noOfLatinCharacters(Shark[] array, PrintWriter c){
       
    //Total to keep track of the sum of characters  
    int total = 0;
    
    //for loop to go through the array and add to total number of characters without reading the whitespace characters
    for (int i = 0; i < array.length; i++){
      total += array[i].getLatinName().replace(" ", "").length();
    }
    
    //Print the total from the array
    System.out.println("Total number of letters in all Latin names = " + total);
    
    //Print results to file 
    c.println("--------------------------------------------------------");
    c.println("Total number of letters in all Latin names = " + total);
    
    //return the total because the method is not a void 
    return total;
   }
   
   //Method to check for total even latin names 
   public static int totalEvenAndOdd(Shark[] array, PrintWriter d){
       
    //even and odd variable to keep track of the sum of even characters in the latin names array index
    int even = 0;
    int odd = 0;
    
    //Using hashset to get rid of any duplicates
    Set sharkSet = new HashSet();
    
    //for loop to iterate through the array and checks if the characters length is even or odd and split the latin names into two indexes
    for (int i = 0; i < array.length; i++){
        //Split the latin names into a String array by the space character 
        String[] sharkLatinSplit = array[i].latinName.split(" ");
        
        //for loop to go through the splitted array length and add the latin names to the Set sharkSet
        for (int j = 0; j < sharkLatinSplit.length; j++){
            sharkSet.add(sharkLatinSplit[j]);
        }
    }
    
    //for-each loop to check if the latin names in the Set sharkSet are even or odd  
    for(Object s: sharkSet){
       if(s.toString().length() % 2 == 0){
         even++;
        }
        else 
          odd++;
    }
    
    //Print the result to the console
    System.out.println("Total number of unique even words in Latin names = " + even);
    System.out.println("Total number of unique odd words in Latin names = " + odd);
    
    //Print the results to the file 
    d.println("Total number of unique even words in Latin names = " + even);
    d.println("Total number of unique odd words in Latin names = " + odd);
    
    //return 
    return even;
   }
}
