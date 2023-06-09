import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("C3 = " + 24 % 3 + ", type - StringBuilder.");
        System.out.println("C17 = " + 24 % 17 + ", Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.");

        // Я трохи модифікував завдання, щоб можна було вибирати літеру з якої починаються слова. Тобто не тільки голосні, а на вибір користувача.
        // Також не тільки за другою літерою, а за літерою вибраною користувачем.

        StringBuilder line = new StringBuilder("На постійній основі підприємство застосовує універсальні оригінальні технології бізнесу, зберігання даних та безпрограшних домовленостей. Одна з найбільших глобальних організацій надає широкий спектр послуг, зокрема послуги доставки кореспонденції, ремонт ювелірних виробів і годинників та передачу даних.");

        String firstLetter = "";

        while (!Objects.equals(firstLetter.toLowerCase(), "приголосна") && !Objects.equals(firstLetter.toLowerCase(), "голосна")){
            System.out.print("Введіть 'Приголосна' або 'Голосна', щоб вибрати першу букву слів, які будуть відсортовані: ");
            firstLetter = scanner.nextLine(); // Просимо задати літеру з якої починаються слова.
        }

        int indexOfSortingSymbol = -1;

        while (indexOfSortingSymbol < 0){
            System.out.print("Введіть номер символа в слові, за яким вони будуть відсортовані: ");
            indexOfSortingSymbol = scanner.nextInt(); // Просимо задати номер літери за якою відбудеться сортування.
        }

        Text text = new Text(line, firstLetter, indexOfSortingSymbol - 1); // Змінна типу текст.

        String[] sortedVowelWords = text.FindAndSortVowelWords(); // Масив відсортоаних слів.

        for(String i : sortedVowelWords) System.out.println(i);
    }
}