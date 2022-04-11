package dvdlibrary.dao;

/**
 *
 * @author 17202
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.IOException;
import java.util.List;

import dvdlibrary.dto.DVD;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DVDLibraryDaoFI implements DVDLibraryDao {

    HashMap<String, DVD> hmap = new HashMap<String, DVD>();
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void addDVD(DVD dvd) {
        hmap.put(dvd.getTitle(), dvd);
    }

    @Override
    public void removeDVD(DVD dvd) {
        hmap.remove(dvd.getTitle());
    }

    @Override
    public void editDVD(DVD dvd) {
        hmap.replace(dvd.getTitle(), dvd);

    }

    @Override
    public List<DVD> listAllDVDs() {
        //list the keys

        List<DVD> list = new ArrayList<DVD>();
        for (DVD key : hmap.values()) {
            list.add(key);
        }
        return list;
    }

//    public void moviesReleasedNYears(int n) {
//        int year = LocalDate.now().getYear() - n;
//
//        List<DVD> withinYear = hmap.stream()
//                .filter((d) -> d.getReleaseDate(d).toYear() >= year));
//    }

    @Override
    public void displayDVD(DVD dvd) {
        System.out.println(dvd);
    }

    @Override
    public DVD findDVD(String title) {
        return hmap.get(title);
    }

    @Override
    public int loadFromFile(String fileName) {

        HashMap<String, DVD> loaded = new HashMap<>();
        int numberOfRecords = 0;
        try {

            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dvdField = data.split("::");

                DVD tmp = new DVD(dvdField[0], LocalDate.parse(dvdField[1], dtf), dvdField[2], dvdField[3], dvdField[4], dvdField[5]);
                loaded.put(tmp.getTitle(), tmp);
                numberOfRecords++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        hmap = loaded;
        return numberOfRecords;
    }

    @Override
    public int saveToFile(String fileName) {

        int numberOfRecords = 0;
        try {
            PrintWriter myWriter = new PrintWriter(new File(fileName));
            for (DVD dvd : hmap.values()) {
                //System.out.println(dvd.createDVDRecord());
                myWriter.write(dvd.createDVDRecord() + "\n");
                numberOfRecords++;
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return numberOfRecords;
    }
}
