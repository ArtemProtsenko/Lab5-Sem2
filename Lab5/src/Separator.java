public class Separator {
    static String separators = ",.!;:'?";
    static String[] separatorsArr = separators.split("");

    public static void removeSeparators(StringBuilder givenStringBuilder){
        for(String i : separatorsArr){
            int index = 0;
            while(givenStringBuilder.indexOf(i, index) != -1){
                index = givenStringBuilder.indexOf(i, index);
                givenStringBuilder.deleteCharAt(index);
            }
        }

    }
}
