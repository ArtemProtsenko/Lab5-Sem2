public class Letter {
    private final StringBuilder letter;

    public Letter(StringBuilder letter) {
        this.letter = letter;
    }

    public StringBuilder getLetter() {
        return letter;
    }

    static String vowels = "уеїіаоєяю"; // Голосні літери.
    static String[] vowelsArr = vowels.split(""); // Масив голосних літер.

    static String consonants = "йцкнгшщзхфвпрлджґчсмтб"; // Приголосні літери.
    static String[] consonantsArr = consonants.split(""); // Масив приголосних літер.

    public static String[] getVowelsArr(){ // Геттер масиву голосних літер.
        return vowelsArr;
    }

    public static String[] getConsonantsArr(){ // Геттер приголосних літер.
        return consonantsArr;
    }
}
