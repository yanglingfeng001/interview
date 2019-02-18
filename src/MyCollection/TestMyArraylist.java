package MyCollection;

public class TestMyArraylist {
    public static void main(String[] args) {
        MyArraylist<Integer> list=new MyArraylist<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
    }
}
