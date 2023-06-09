public class Separator {
    static String separators = ",.!;:'?"; // Розділові знаки.
    static String[] separatorsArr = separators.split(""); // Масив розділових знаків.

    public static void removeSeparators(StringBuilder givenStringBuilder){ // Видалення роздільних знаків з StringBuilder.
        for(String i : separatorsArr){
            int index = 0;
            while(givenStringBuilder.indexOf(i, index) != -1){
                index = givenStringBuilder.indexOf(i, index);
                givenStringBuilder.deleteCharAt(index);
            }
        }

    }
}
