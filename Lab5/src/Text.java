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

        Separator.removeSeparators(text); // Прибираємо розділові знаки.

        int prevIndex = 0;
        int nextIndex;
        wordsStr.append(text.substring(prevIndex, text.indexOf(" ", prevIndex))).append(" ");
        while (text.indexOf(" ", prevIndex) != -1) { // Перетворюємо тип Text в StringBuilder.
            prevIndex = text.indexOf(" ", prevIndex) + 1;
            nextIndex = text.indexOf(" ", prevIndex);

            if (nextIndex == -1){
                nextIndex = text.length();
            }

            wordsStr.append(text.substring(prevIndex, nextIndex)).append(" ");
        }

        wordsStr.deleteCharAt(wordsStr.lastIndexOf(" "));

        String[] words = wordsStr.toString().split(" "); // Розділяємо текст на масив слів.

        String[] firstLetters;

        if (Objects.equals(firstLetter.toLowerCase(), "голосна")){ // Задаємо масив який складається з голосних або приголосних літер за вводом користувача.
            firstLetters = Letter.getVowelsArr();
        }
        else {
            firstLetters = Letter.getConsonantsArr();
        }

        StringBuilder foundWords = new StringBuilder();

        for(String word : words) { // Заповнюємо змінну словами які починаються з голосних або приголосних літер за вводом користувача.
            for (String letter : firstLetters){
                if (word.toLowerCase().indexOf(letter) == 0){
                    foundWords.append(word.toLowerCase()).append(" ");
                }
            }
        }

        foundWords.deleteCharAt(foundWords.lastIndexOf(" "));

        String[] vowelsWordsArr = foundWords.toString().split(" "); // Ділимо знайдені слова на масив слів.

        Arrays.sort(vowelsWordsArr, new Comparator<String>() { // Сортуємо створений масив.
            @Override
            public int compare(String letter1, String letter2) { // Сортування.
                if(letter1.length() > indexOfSortingLetter && letter2.length() > indexOfSortingLetter){ // Якщо індекс заданої літери не виходить за слово, то сортується за цією літерою.
                    return letter1.charAt(indexOfSortingLetter) - letter2.charAt(indexOfSortingLetter);
                }
                else if(letter1.length() == indexOfSortingLetter){ // Якщо одне з слів менше за даний індекс, то замість літери береться пробіл і прирівнюється до іншої літери.
                    return ' ' - letter2.charAt(indexOfSortingLetter);
                }
                else{
                    return letter1.charAt(indexOfSortingLetter) - ' ';
                }
            }
        });

        return vowelsWordsArr; // Повернення відсортованого масиву.
    }
}
