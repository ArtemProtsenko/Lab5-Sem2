public class Letter {
    private final StringBuilder letter;

    public Letter(StringBuilder letter) {
        this.letter = letter;
    }

    public StringBuilder getLetter() {
        return letter;
    }

    static String vowels = "уеїіаоєяю";
    static String[] vowelsArr = vowels.split("");

    static String consonants = "йцкнгшщзхфвпрлджґчсмтб";
    static String[] consonantsArr = consonants.split("");

    public static String[] getVowelsArr(){
        return vowelsArr;
    }

    public static String[] getConsonantsArr(){
        return consonantsArr;
    }
}
