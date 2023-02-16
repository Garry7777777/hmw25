import lists.*;
import java.util.*;


public class Main {
//    привести реализацию ArrayList'а к одной из стандартных библиотек Java.
//    работу следует проводить с той реализацией, которая обрабатывает числа, а не строки.
//
//    Шаг 1. Реализовать приватный метод grow, который будет отвечать за расширение массива-хранилища
//              в 1,5 раза в ситуации, когда место закончилось.
//    Шаг 2. Добавить проверку на заполненность в метод add и, если массив заполнен, расширить его.
//    Шаг 3. Изменить реализацию сортировки на рекурсивную из последней шпаргалки. Выбор конкретной
//              сортировки лежит на вас.

    public static void main(String[] args) {

        var testArray1 = new int[10000];
        var random = new Random();
        Arrays.setAll(testArray1, i -> random.nextInt(1000));
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
        for( int i=0 ;i < 100000;i++) myIntList.add( random.nextInt(1000));


        start = System.currentTimeMillis();
        myIntList.contains(777);
        System.out.println(" myIntList.contains = " + (System.currentTimeMillis() - start));
        System.out.println("myIntList.size() = " + myIntList.size());


//  метод sortInsertion -  myIntList.contains = 106
//  метод quickSort        myIntList.contains = 21


        var myList = new MyIntegerList();
        var myOtherList = new MyIntegerList(2);

        System.out.println(myList.size());

        myList.add(1); myList.add(2); myList.add(3); myList.add(4);
        myOtherList.add(1); myOtherList.add(2); myOtherList.add(3); myOtherList.add(4);

        System.out.println(myList);
        System.out.println(myOtherList);





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