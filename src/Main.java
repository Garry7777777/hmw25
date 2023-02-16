import java.util.Arrays;

public class Main {

//    задача:
//    написать свою реализацию ArrayList. В данной задаче он должен работать только со строками.
//    Напишите реализацию этого интерфейса, выполнив все его методы. В качестве хранилища используйте массив.
//    В конструкторе должен задаваться размер массива внутри.
//    Список не должен добавлять или хранить в себе null. Т. е. в случае удаления элемента нужно смещать все
//    элементы на ячейку влево, а при добавлении в середину или начало — на ячейку вправо.
//    По желанию можно реализовать расширение массива.
//    Рекомендуется написать свои исключения и выбрасывать их в тех ситуациях, которые описаны в интерфейсе.
//    Если в какой-то из методов в качестве параметра приходит null, выбросить исключение.

    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();
        MyArrayList myOtherList = new MyArrayList(2);

        System.out.println(myList.size);

        myList.add("тест1"); myList.add("тест2"); myList.add("тест3"); myList.add("тест4");
        myOtherList.add("тест1"); myOtherList.add("тест2"); myOtherList.add("тест3"); myOtherList.add("тест4");


        System.out.println(myList);
        System.out.println(myOtherList);

        System.out.println("myList.remove(\"test4\") = " + myList.remove("тест4"));
        System.out.println("myList.remove(1) = " + myList.remove(1));
        System.out.println("myList.add(1, \"тест2\") = " + myList.add(1, "тест2"));
        System.out.println(myList);
        System.out.println("myList.contains(\"тест\") = " + myList.contains("тест"));
        System.out.println("myList.contains(\"тест3\") = " + myList.contains("тест3"));
        System.out.println("myList.indexOf(\"тест3\") = " + myList.indexOf("тест3"));
        System.out.println("myList.lastIndexOf(\"тест3\") = " + myList.lastIndexOf("тест3"));
        System.out.println("myList.equals(myOtherList) = " + myList.equals(myOtherList));
        System.out.println("myOtherList.toArray() = " + Arrays.toString(myOtherList.toArray()));
        myOtherList.clear();
        System.out.println("myOtherList.isEmpty() = " + myOtherList.isEmpty());


    }
}