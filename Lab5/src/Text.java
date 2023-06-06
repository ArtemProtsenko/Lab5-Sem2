import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Text {
    private final StringBuilder text;
    private final String firstLetter;
    private final int indexOfSortingLetter;

    public Text(StringBuilder text, String firstLetter, int indexOfSortingLetter) {
        this.text = text;
        this.firstLetter = firstLetter;
        this.indexOfSortingLetter = indexOfSortingLetter;
    }

    public String[] FindAndSortVowelWords(){
        StringBuilder wordsStr = new StringBuilder();

        Separator.removeSeparators(text);

        int prevIndex = 0;
        int nextIndex;
        wordsStr.append(text.substring(prevIndex, text.indexOf(" ", prevIndex))).append(" ");
        while (text.indexOf(" ", prevIndex) != -1) {
            prevIndex = text.indexOf(" ", prevIndex) + 1;
            nextIndex = text.indexOf(" ", prevIndex);

            if (nextIndex == -1){
                nextIndex = text.length();
            }

            wordsStr.append(text.substring(prevIndex, nextIndex)).append(" ");
        }

        wordsStr.deleteCharAt(wordsStr.lastIndexOf(" "));

        String[] words = wordsStr.toString().split(" ");

        String[] firstLetters;

        if (Objects.equals(firstLetter.toLowerCase(), "голосна")){
            firstLetters = Letter.getVowelsArr();
        }
        else {
            firstLetters = Letter.getConsonantsArr();
        }

        StringBuilder foundWords = new StringBuilder();

        for(String word : words) {
            for (String letter : firstLetters){
                if (word.toLowerCase().indexOf(letter) == 0){
                    foundWords.append(word.toLowerCase()).append(" ");
                }
            }
        }

        foundWords.deleteCharAt(foundWords.lastIndexOf(" "));

        String[] vowelsWordsArr = foundWords.toString().split(" ");

        Arrays.sort(vowelsWordsArr, new Comparator<String>() {
            @Override
            public int compare(String letter1, String letter2) {
                if(letter1.length() > indexOfSortingLetter && letter2.length() > indexOfSortingLetter){
                    return letter1.charAt(indexOfSortingLetter) - letter2.charAt(indexOfSortingLetter);
                }
                else if(letter1.length() == indexOfSortingLetter){
                    return ' ' - letter2.charAt(indexOfSortingLetter);
                }
                else{
                    return letter1.charAt(indexOfSortingLetter) - ' ';
                }
            }
        });

        return vowelsWordsArr;
    }
}
