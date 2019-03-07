
package task2;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Task2 {
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
        
        //Read data from a file
        while (input.hasNext()) {
             //Read all lines from file 
            String a = input.nextLine();
            
            //When the ":" is read it returns the array of each thing calling it using index[] numbers from 0-6
            String[] sharkData = a.split(":"); 
            
            //Each shark has 7 different things which are name,latin name,length etc.
            sharks[currentIndex] = new Shark(sharkData[0], sharkData[1], Integer.parseInt(sharkData[2]), Integer.parseInt(sharkData[3]), 
            sharkData[4], Integer.parseInt(sharkData[5]), sharkData[6]);
            currentIndex += 1;
        }
        
        //Write the results into a new txt file in your working directory
        PrintWriter fileWrite = new PrintWriter("results.txt");
        
        //This call to the method prints the regions and its associated sharks
        checkSharks(sharks, fileWrite);
        
        //Close the file
        input.close();
        
        //Close Writing to file
        fileWrite.close();
        }
            catch(FileNotFoundException e){
                System.out.println(e);
            }
    }
    //Method to print all regions without having any duplicates in a list of strings
    public static List<String> printAllRegions(Shark[] arr){ 
      
       //List puts the regions into a set which will not contain duplicates and puts the set into alphabetical order
       List<String> regionsArr = new ArrayList<String>();
       
       //first loop to go through the array length and second to get the Oceanic regions and split them by ","
       for (int i = 0; i < arr.length; i++) {
           for(String myString: arr[i].getOceanicRegions().split(",")) {
               regionsArr.add(myString.trim());
            }
       }
       //Sort the list of regionsArr in Alphabetical order
       Set<String> sorted = new HashSet<>();
       sorted.addAll(regionsArr);
       regionsArr.clear();
       regionsArr.addAll(sorted);
       Collections.sort(regionsArr);
       
       return regionsArr;
    }
    
    //This method checks the associated sharks with each region
    public static void checkSharks(Shark[] arr, PrintWriter a){
        
       //List to contain the regions that i placed in previous method to get rid of duplicates and put in alphabetical order
       List<String> regionsList = printAllRegions(arr);
       
       //splittedRegions is the array for when we split the regions by the comma(,) and put it into its own list
       List<String> splittedRegions;
       //sharkRegions are the individual arrays of each regions which are seperated
       List<String> sharkRegions = new ArrayList<>();
       //sharkMatch is an array for the matched sharks and then when matched they are put in this array
       List<String> sharkMatch = new ArrayList<>(); 
      
       //for loop to go through that regionsList size and 
       for (int i = 0; i < regionsList.size(); i++){
           //Enhanced for loop to go through to check for its assigned region
           for (Shark arr1 : arr) {
               
               //Here I am splitting the regions using the comma and makes it an individual array
               splittedRegions = Arrays.asList(arr1.getOceanicRegions().split(","));
               
               //Adding the splitted regions to a list by itself and it streams through, maps the string and puts in list
               splittedRegions = splittedRegions.stream().map(String::trim).collect(Collectors.toList());
               
               //Store the splittedRegions into the sharkRegions array
               sharkRegions.addAll(splittedRegions);
               
               //Check if the sharkRegions array contains regionsList which is the initial list array were using
               if (sharkRegions.contains(regionsList.get(i))) {
                   //if it does add the sharkMatch and get the name into the array
                   sharkMatch.add(arr1.getName());
               }
               //Check for the next shark region
               sharkRegions.clear();  
           }
   
           //Sort the matched sharks 
           Collections.sort(sharkMatch);
           
           //Print the regions and its matched sharks
           System.out.println(regionsList.get(i) + " -> " + sharkMatch);
           
            //Print the results to the file 
           a.println(regionsList.get(i) + " -> " + sharkMatch);
           
           //Check for the next shark
           sharkMatch.clear();
       }
    }
}
        

                        
                                
            
           
    

        
