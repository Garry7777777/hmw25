import lists.MyIntegerList;
import java.util.Arrays;
import java.util.Random;

public class Main {
//    задача:
//    требуется написать еще одну реализацию интерфейса из прошлого домашнего задания, но с дополнительными методами.
//    Необходимо:
//    Написать вторую реализацию интерфейса списка (скопировать и скорректировать первую) из прошлого домашнего задания,
//    но «подогнать» под работу с целыми числами, используя ссылочный тип Integer.
//    Добавить в реализацию приватный метод с самой быстрой из рассмотренных сортировок.
//    Для выявления самой быстрой сортировки следует сравнить сортировки по времени выполнения на случайно сгенерированном
//    массиве со 100 000 элементов.
//    Учесть, что для сравнения сортировок нужно использовать 3 разные копии массива, т. к. сортировать уже отсортированный
//    ранее массив некорректно. Код самого сравнения прикладывать по желанию.
//    Добавить в реализацию приватный метод бинарного поиска. Учесть, что метод contains уже был реализован в прошлом ДЗ.
//    Его следует переработать, осуществив сортировку (реализованную в шаге 2) и вызвав метод бинарного поиска.

    public static void main(String[] args) {

        var testArray1 = new int[10000];
        var random = new Random();
        Arrays.setAll(testArray1, i -> random.nextInt(100));
        var testArray2 = testArray1.clone();
        var testArray3 = testArray1.clone();

        // тест sortSelection
        long start = System.currentTimeMillis();
        sortSelection(testArray1);
        System.out.println("sortSelection = " + (System.currentTimeMillis() - start));

        // тест sortBubble
        start = System.currentTimeMillis();
        sortBubble(testArray2);
        System.out.println("sortBubble = " + (System.currentTimeMillis() - start));

        // тест sortInsertion
        start = System.currentTimeMillis();
        sortInsertion(testArray3);
        System.out.println("sortInsertion = " + (System.currentTimeMillis() - start));

// результаты проверок на самый быстрый метод => выбираем метод sortInsertion
//        sortBubble = 20787
//        sortSelection = 9895
//        sortInsertion = 1251


        var myIntList = new MyIntegerList();
        for( int i=0 ;i < 10000;i++) myIntList.add( random.nextInt(1000));

        start = System.currentTimeMillis();
        System.out.println("myIntList.contains(777) = " + myIntList.contains(777));
        System.out.println(" myIntList.contains = " + (System.currentTimeMillis() - start));


//        MyArrayList myList = new MyArrayList();
//        MyArrayList myOtherList = new MyArrayList(2);
//
//        System.out.println(myList.size());
//
//        myList.add("тест1"); myList.add("тест2"); myList.add("тест3"); myList.add("тест4");
//        myOtherList.add("тест1"); myOtherList.add("тест2"); myOtherList.add("тест3"); myOtherList.add("тест4");
//
//
//        System.out.println(myList);
//        System.out.println(myOtherList);
//
//        System.out.println("myList.remove(\"test4\") = " + myList.remove("тест4"));
//        System.out.println("myList.remove(1) = " + myList.remove(1));
//        System.out.println("myList.add(1, \"тест2\") = " + myList.add(1, "тест2"));
//        System.out.println(myList);
//        System.out.println("myList.contains(\"тест\") = " + myList.contains("тест"));
//        System.out.println("myList.contains(\"тест3\") = " + myList.contains("тест3"));
//        System.out.println("myList.indexOf(\"тест3\") = " + myList.indexOf("тест3"));
//        System.out.println("myList.lastIndexOf(\"тест3\") = " + myList.lastIndexOf("тест3"));
//        System.out.println("myList.equals(myOtherList) = " + myList.equals(myOtherList));
//        System.out.println("myOtherList.toArray() = " + Arrays.toString(myOtherList.toArray()));
//        myOtherList.clear();
//        System.out.println("myOtherList.isEmpty() = " + myOtherList.isEmpty());

    }

    public static boolean contains(int[] arr, int element) {
        for (int i : arr)  if (i == element) return true;
        return false;
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minElementIndex])
                    minElementIndex = j;
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1])
                    swapElements(arr, j, j + 1);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA]; arr[indexA] = arr[indexB]; arr[indexB] = tmp;
    }
}