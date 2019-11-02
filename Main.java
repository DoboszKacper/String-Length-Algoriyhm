import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String read(String path) {
        String ascending = null;
        String ascendingCompare = null;
        String descending = null;
        String descendingCompare = null;
        String steam1 = "go1";
        String stream2 = "go2";
        int pop = 0;
        int previous = 0;


        File file = new File(path);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String curent = sc.next();
                if (steam1 == "go1") {//First step
                    previous = Integer.valueOf(curent);
                    descending = String.valueOf(previous);
                    steam1 = null;
                } else {//Next step
                    if (previous >= Integer.valueOf(curent)) {
                        previous = Integer.valueOf(curent);


                        //Descending
                        descending += " " + curent;

                        if (descendingCompare != null) {
                            if (descendingCompare.length() < descending.length()) {
                                descendingCompare = descending;
                            }
                        } else {
                            descendingCompare = descending;
                        }
                    }
                    if (previous < Integer.valueOf(curent)) {
                        previous = Integer.valueOf(curent);

                        //Descending
                        if (descendingCompare == null) {
                            descendingCompare = descending;
                            descending = curent;
                        } else {
                            if (descendingCompare.length() >= descending.length()) {
                                descending = curent;
                            } else {
                                descendingCompare = descending;
                            }
                        }
                    }
                }


                if (stream2 == "go2") {//First step
                    pop = Integer.valueOf(curent);
                    ascending = String.valueOf(pop);
                    stream2 = null;
                } else {//Next step
                    if (pop <= Integer.valueOf(curent)) {
                        pop = Integer.valueOf(curent);

                        //Ascending
                        ascending += " " + curent;
                        if (ascendingCompare != null) {
                            if (ascendingCompare.length() < ascending.length()) {
                                ascendingCompare = ascending;
                            }
                        }
                    }
                    if (pop > Integer.valueOf(curent)) {
                        pop = Integer.valueOf(curent);

                        //Ascending
                        if (ascendingCompare == null) {
                            ascendingCompare = ascending;
                            ascending = curent;
                        } else {
                            if (ascendingCompare.length() >= ascending.length()) {
                                ascending = curent;
                            } else {
                                ascendingCompare = ascending;
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Constant String
        if (descendingCompare == null) {
            descendingCompare = descending;
        }
        if (ascendingCompare == null) {
            ascendingCompare = ascending;
        }
        //Compare length
        if (descendingCompare.length() > ascendingCompare.length()) {
            return descendingCompare;
        }else {
            return ascendingCompare;
        }
    }



    public static void main(String[] args) {
        System.out.println(read("file.txt"));
    }
}