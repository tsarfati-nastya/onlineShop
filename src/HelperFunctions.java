import java.util.Scanner;

public class HelperFunctions {


    public static String doesntContainNumber(String line){
        Scanner scanner = new Scanner(System.in);
        String stringToReturn;
        do {
            System.out.println(line);
            stringToReturn = scanner.nextLine();
        }while(stringToReturn.matches(".*[0-9].*"));
        return  stringToReturn;
    }

}
