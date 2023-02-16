import java.util.Arrays;


public class MyArrayList implements StringList {
    final int INCREMENT = 0x3;   // для тестов = 3
    private int size ;
    private String[] list ;

    public MyArrayList() { clear(); }

    public MyArrayList(int size) {
        list = new String[size];
    }

    @Override
    public String add(String item) {

        if(list.length == size){
            var buffer = new String[list.length + INCREMENT];
            System.arraycopy(list,0, buffer,0, size);
            list = buffer;
        }
        return list[size++]=item;
    }

    @Override
    public String add(int index, String item) {
        checkBounds(index);
        var inc = INCREMENT;
        if (list.length != size) inc = 0;

        String[] buffer = new String[list.length + inc];
        System.arraycopy(list, 0, buffer, 0, index);
        System.arraycopy(list, index, buffer, index + 1, size - index);
        buffer[index] = item;

        list = buffer;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkBounds(index);
        return list[index]=item;
    }

    @Override
    public String remove(String item) {

        if (!contains(item)) throw new IllegalArgumentException(" элемент отсутствует в списке ");
        this.remove(indexOf(item));
        return item;
    }

    @Override
    public String remove(int index) {
        checkBounds(index);
        size--;
        var result = list[index];
        System.arraycopy(list, index + 1, list, index, size-index );
        list[size]=null;
        return result;
    }

    @Override
    public boolean contains(String item) {
        for ( String s: list )
            if ( s != null && s.equals(item))
                return true;
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++)
            if ( list[i].equals(item))
                return i;

        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1 ; i >= 0; i--)
            if (list[i].equals(item))
                return i;

        return -1;
    }

    @Override
    public String get(int index) {
        checkBounds(index);
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {

        if( size != otherList.size()) return false;
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
        list = new String[INCREMENT];
        }

    @Override
    public String[] toArray() { return Arrays.copyOf(list,size); }

    public void checkBounds(int index) {
        if ( index < 0 || index >= size )
            throw new ArrayIndexOutOfBoundsException ( " выход индекса за границы массива " );
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "INC=" + INCREMENT +
                ", size=" + size +
                ", list=" + Arrays.toString(list) +
                '}';
    }

}
