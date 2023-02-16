package lists;

import interfaces.IntegerList;
import java.util.Arrays;


public class MyIntegerList implements IntegerList {
    private final int INITIAL_SIZE = 0xF;
    private int size ;
    private Integer[] list ;

    public MyIntegerList() { clear(); }
    public MyIntegerList(int size) {
        list = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        if (list.length == size) grow();
        return list[size++] = item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkBounds(index);
        if (size == list.length)  grow();
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
        return item;
    }

    public void grow (){
        var newList = new Integer[list.length + (list.length>>1) ];
        System.arraycopy(list, 0, newList, 0, list.length);
        list = newList;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkBounds(index);
        return list[index]=item;
    }

    @Override
    public Integer remove(Integer item) {

        if (!contains(item)) throw new IllegalArgumentException(" элемент отсутствует в списке ");
        this.remove(indexOf(item));
        return item;
    }

    @Override
    public Integer remove(int index) {
        checkBounds(index);
        size--;
        var result = list[index];
        System.arraycopy(list, index + 1, list, index, size-index );
        list[size]=null;
        return result;
    }

    @Override
    public boolean contains(Integer item) {
//        for ( Integer s: list )
//            if ( s != null && s.equals(item))
//                return true;
//        return false;
//        mergeSort(list);

        quickSort( list, 0, size-1);
        return binarySearch(item);

    }

    public void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            var partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        var pivot = arr[end];
        var i = (begin - 1);

        for (var j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int left, int right) {
        var temp = arr[left];  arr[left] = arr[right];  arr[right] = temp;
    }

//    private void sortInsertion() {
//        for (int i = 1; i < size ; i++) {
//            int temp = list[i];
//            int j = i;
//            while (j > 0 && list[j - 1] >= temp) {
//                list[j] = list[j - 1];
//                j--;
//            }
//            list[j] = temp;
//        }
//    }

    private boolean binarySearch(int element) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == list[mid])  return true;
            if (element < list[mid])    max = mid - 1;
                else  min = mid + 1;
        }
        return false;
    }



    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++)
            if ( list[i].equals(item))
                return i;

        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1 ; i >= 0; i--)
            if (list[i].equals(item))
                return i;

        return -1;
    }

    @Override
    public Integer get(int index) {
        checkBounds(index);
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {

        if (size != otherList.size()) return false;
        for (int i = 0; i < size; i++)
            if (!list[i].equals(otherList.get(i)))
                return false;

        return true;
    }


    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        size = 0;
        list = new Integer[INITIAL_SIZE];
    }

    @Override
    public Integer[] toArray() { return Arrays.copyOf(list,size); }

    public void checkBounds(int index) {
        if ( index < 0 || index >= size )
            throw new ArrayIndexOutOfBoundsException ( " выход индекса за границы массива " );
    }

    @Override
    public String toString() {
        return "MyIntegerList{" + "INC=" + INITIAL_SIZE +", size=" + size +", list=" + Arrays.toString(list) +'}';
    }

}
