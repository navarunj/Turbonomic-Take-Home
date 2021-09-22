import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FriendlyWords {
    public static void main(String[] args) {

        List<String> myWords = new ArrayList<>();

        //Read from the file, one line at a time.
        //Store each line in myWords.
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myWords.add(data);
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //usedIndexes will keep track of which indexes in myWords have already been used
        //for friendly word output.
        List<Integer> usedIndexes = new ArrayList<>();

        System.out.println("-----------------------------------");
        System.out.println("Friendly words:");

        for(int i=0; i<myWords.size(); i++) {

            boolean foundFriendlyWord = false;

            //Setting up a line of output, which may or may not get printed
            String myOutputLine = myWords.get(i);

            for(int j=0; j<myWords.size(); j++) {
                if(i!=j) {

                    //Check this word against every other word in the list, to see if it
                    //has anagrams.
                    if (AnagramChecker.isAnagram(myWords.get(i), myWords.get(j))) {
                        foundFriendlyWord = true;
                        myOutputLine += " " + myWords.get(j);
                        usedIndexes.add(j);
                    }
                }
            }

            if(foundFriendlyWord) {
                //Check if this index has already been used, to avoid duplicates.
                if(!usedIndexes.contains(i)) {
                    //Print out the line of output, which contains two or more words.
                    System.out.println(myOutputLine);
                }
            }
        }



    }
}
