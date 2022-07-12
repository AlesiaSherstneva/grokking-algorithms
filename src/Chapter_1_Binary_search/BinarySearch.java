package Chapter_1_Binary_search;

public class BinarySearch {
    public static void main(String[] args) {

        //создаём массив из 240_000 элементов
        int[] array = new int[240_000];
        for (int i = 0; i < 240_000; i++) {
            array[i] = i+1;
        }
        System.out.println("Сформирован массив из " + array.length + " элементов.");

        //для поиска перебором худшим случаем будет искать последнее число в массиве
        System.out.println("Для поиска перебором потребовалось " + stupidSearch(array, array[array.length-1]) + " шагов.");

        //для бинарного поиска худшим случаем будет искать число, равное половине количества элементов минус один элемент
        System.out.println("Для бинарного поиска потребовалось " + binarySearch(array, array[(array.length) / 2 - 1]) + " шагов.");
    }

    static int stupidSearch(int[] array, int number) {
        int counter = 0;
        for (int element : array) {
            counter++;
            if (element == number) {
                break;
            }
        }
        return counter;
    }

    static int binarySearch(int[] array, int number) {
        int floor = array[0], ceil = array[array.length - 1], middle, counter = 0;
        while (floor != ceil) {
            counter++;
            middle = (floor + ceil) / 2;
            if (number > array[middle]) {
                floor = middle;
            } else if (number < array[middle]) {
                ceil = middle;
            } else {
                break;
            }
        }
        return counter;
    }
}
