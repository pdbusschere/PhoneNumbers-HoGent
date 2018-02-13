package Models;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneNumberChecker {

    public HashMap<String, String> getCollection() {
        HashMap<String, String> dataSet = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(getClass().getResource("phone_data.txt").getFile()));
            while (scanner.hasNextLine()) {
                String[] line = parseLineFromFile(scanner.nextLine());
                dataSet.put(line[0], line[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSet;
    }

    public static String[] parseLineFromFile(String line){
        String[] result = line.split(",");
        result[1] = result[1].replaceAll("-", "").replaceAll(" ", "");
        return result;
    }

    public boolean checkIfNumberIsPrefixForCollection(String key, String number, HashMap<String, String> numbers){
        boolean result = false;
        if(number.isEmpty()){
            result = true;
        } else {
            for (Map.Entry me : numbers.entrySet()) {
                if(((String)me.getValue()).startsWith(number) && !numbers.get(key).equals(number)){
                    System.out.println("Prefix " + (String)me.getValue() + " for " + number);
                    result = true;
                }
            }
        }
        return result;
    }
}
