package com.epam.topic4.task2;

import com.epam.topic4.LogFactory;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created by Timofey_Ryuzhov on 4/4/2016.
 */
/*
Выполнить свою реализацию ArrayList фиксированной длины, в реализацию ArrayList не подглядывать )
Обязательные методы помечены //required, остальные могут кидать new NotImplementedException()
В классе Main залогировать результаты всех операций
*/
public class FixedArrayList<E> implements List<E> {
    private int size;
    private Object[] elements;

    public FixedArrayList(int size) {
        elements = new Object[size];
        this.size = 0;
    }

    //required
    @Override
    public int size() {
        return size;
    }

    //required
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    //required
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        throw new NotImplementedException();
    }

    //required
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new NotImplementedException();
    }

    //required
    @Override
    public boolean add(E e) {
        if (size == elements.length)
            return false;

        elements[size] = e;
        size++;
        return true;
    }

    //required
    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);

        if (i >= 0) {
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    //required
    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] o = c.toArray();

        Integer countAddElement = 0;

        for (int i = 0; i < o.length; i++)
            if (size < elements.length) {
                elements[size] = o[i];
                size++;
                countAddElement++;
            } else return countAddElement > 0;

        return countAddElement > 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    //required
    @Override
    public void clear() {
        size = 0;
    }

    //required
    @Override
    public E get(int index) {
        return (E) elements[index];
    }

    //required
    @Override
    public E set(int index, E element) {
        if (index < 0 || index + 1 >= elements.length) throw new NotImplementedException();

        E oldElement = (E) elements[index];
        elements[index] = element;
        return oldElement;
    }

    //required
    @Override
    public void add(int index, E element) {
        if (index < 0 || index + 1 >= elements.length) throw new NotImplementedException();

        if (index < elements.length - 1)
            for (int i = size - 1; i > index; i--)
                elements[i] = elements[i - 1];

        elements[index] = element;

        if (elements.length > size) size++;
    }

    //required
    @Override
    public E remove(int index) {
        if (index < 0 || index + 1 >= elements.length) return null;

        E delElement = (E) elements[index];

        for (int i = index; i < size - 1; i++)
            elements[i] = elements[i + 1];

        size--;

        return delElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (get(i).equals(o)) return i;

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new NotImplementedException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new NotImplementedException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new NotImplementedException();
    }
}
