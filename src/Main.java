import java.util.*;

public class Main {

    // Add '-ea' to VM options to enable the asserts
    public static void main(String[] args) {
        // Testing totalVowels method
        assert totalVowels(new String[] {"a", "b", "c", "d", "e", "u"}) == 3;

        // Testing countUnique method
        List<Integer> numbers = Arrays.asList(3, 7, 3, -1, 2, 3, 7, 2, 15, 15);
        assert countUnique(numbers) == 5;

        // Testing minLength method
        assert minLength(new String[] {"To", "Tre", "Fire"} ) == 2;

        // Testing removeOddLength method
        ArrayList<String> input = new ArrayList<String>() {{
            add("lige");
            add("ulige");
        }};
        ArrayList<String> expectedOutput = new ArrayList<String>() {{
            add("lige");
        }};
        assert removeOddLength(input).equals(expectedOutput);

        // Testing containsThree method
        List<String> words = Arrays.asList("hej", "du", "er", "hej", "med", "hej");
        assert containsThree(words); // Asserts method returns true

        // Testing isUnique
        Map<String, String> trueMap = new HashMap<>();
        trueMap.put("Marty", "Stepp");
        trueMap.put("Stuart", "Reges");
        trueMap.put("Jessica", "Miller");
        trueMap.put("Amanda", "Camp");
        trueMap.put("Hal", "Perkins");
        Map<String, String> falseMap = new HashMap<>();
        falseMap.put("Kendrick", "Perkins");
        falseMap.put("Stuart", "Reges");
        falseMap.put("Jessica", "Miller");
        falseMap.put("Bruce", "Reges");
        falseMap.put("Hal", "Perkins");
        assert isUnique(trueMap);
        assert !isUnique(falseMap);

    }

    public static Boolean isUnique(Map<String, String> map) {
        // Checking each value in the map with itself.
        for (Map.Entry<String, String> oEntry : map.entrySet()){ // outerEntry
            int occ = 0;
            for(Map.Entry<String, String> iEntry : map.entrySet()){ // innerEntry
                //if(oEntry.getValue().equals(iEntry.getValue())){
                // For readability
                String outerValue = oEntry.getValue();
                String innerValue = iEntry.getValue();
                if(outerValue.equals(innerValue)){
                    occ++;
                }
                if(occ > 1){ // First occurrence is itself
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean containsThree(List<String> strings){
        for(String oS : strings){ // oS = outerString
            int occ = 0;
            for(String iS : strings){ // iS = innerString
                if(oS.equals(iS)){
                    occ++;
                }
                if(occ == 3){
                    return true;
                }
            }
        }

        return false;
    }

    public static ArrayList<String> removeOddLength(ArrayList<String> strings){
        ArrayList<String> retArray = new ArrayList<>();
        for(String s : strings){
            if(s.length() % 2 == 0){ // If odd length
                retArray.add(s);
            }
        }
        return retArray;
    }

    public static int minLength(String[] strings){
        // First comparison length
        int shortest = strings[0].length();
        // Comparing length of each string to the current shortest length found
        for(String str : strings){
            if(str.length() < shortest){
                shortest = str.length();
            }
        }
        return shortest;
    }

    // Gets the first number, compares it with the rest starting from its own position. If that number occurs again, it is not unique.
    // Gets the second number, compares it with rest starting from its own position. If that number does not occur in the rest of the list,
    // it must be unique!
    public static int countUnique(List<Integer> numbers){
        int uniqueNumbers = 0;
        if(numbers.isEmpty()){
            return uniqueNumbers;
        }
        int count = 0; // Used to only compare the current number with the rest of the list starting from its own position
        for (int num : numbers){
            int occ = 0;
            // Now comparing with the rest of the list (starting from its own position)
            for(int i = count; i < numbers.size(); i++){
                if(num == numbers.get(i)){
                    occ++;
                }
            }
            // The number itself is counted as an occurrence, therefore we only want 1 occurrence
            if(occ == 1){
                uniqueNumbers++;
            }
            count++;
        }
        return uniqueNumbers;
    }

    public static int totalVowels(String[] letters){
        int countedVowels = 0;
        if(letters.length == 0){
            return countedVowels;
        }
        String[] vowels = { "a", "e", "i", "o", "u", "y"}; // 'y' is a vowel, fight me
        // Looping through the letters to see if they match any of the vowels. Slow, but it works
        for (String l : letters){
            for (String v : vowels){
                if (l.equals(v)){
                    countedVowels++;
                }
            }
        }
        return countedVowels;
    }
}
