package MyCollection;

import java.lang.annotation.ElementType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArraylist<E> implements List<E>{
    private int size;
    private E[] array;
    public MyArraylist()
    {
        array=(E[])new Object[10];//无法使用参数类型的数组，所以进行强制转化
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if(size>=array.length)
        {
            E[] bigger=(E[])new Object[array.length*2];
            System.arraycopy(array,0,bigger,0,array.length);
            array=bigger;
            bigger=null;
        }
        array[size]=e;
        ++size;
        return true;
    }

    //get非常简单 超出数组的边界则抛出一个异常，检测的是size而非数组的真实大小，所以不可访问数组内部未访问的元素
    @Override
    public E get(int index) {
        if(index<0||index>=size)
        {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    @Override
    public E set(int index,E e)//将新元素替换所给下标存储元素，返回被替换元素
    {
        E old=get(index);
        array[index]=e;
        return old;
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size;++i)
        {
            if(equals(o,array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        if(index<0||index>=size)
        {
            throw new IndexOutOfBoundsException();
        }
        add(element);//添加元素改变数组大小
        for(int i=size;i>index;--i)
        {
            array[i]=array[i-1];//右移一位，参考c语言
        }
        array[index]=element;

    }

    @Override//移除index处元素，数组元素循环左移一位
    public E remove(int index) {
        E e=get(index);
        for(int i=index;i<size-1;++i)
        {
            array[i]=array[i+1];//所有元素左移一位
        }
        --size;
        return e;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private boolean equals(Object target, Object element)//用于类内部的一个对象的比较，不属于接口的功能
    {
        if(target==null)//如果两个都为null则两个对象相等
            return (element==null);
        else
            return target.equals(element);//不为null调用对象
    }
}
