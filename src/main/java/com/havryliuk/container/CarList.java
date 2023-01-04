package com.havryliuk.container;

import com.havryliuk.model.Car;

import java.util.*;
import java.util.stream.Stream;

public class CarList<E extends Car> extends AbstractList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;


    public int getCountAllCars(){
        int count = 0;
        Node<E> target = firstNode;
        for (int i = 0; i < size; i++) {
            count += target.data.getCount();
            target = target.next;
        }
        return count;
    }

    public boolean add(E e) {
        final Node<E> last = lastNode;
        final Node<E> newNode = new Node<>(e, last, null);
        lastNode = newNode;
        if (last == null) {
            firstNode = newNode;
        } else {
            last.next = newNode;
        }
        size++;
        return true;
    }


    public boolean addFirst(E e) {
        addBefore(0, e);
        return true;
    }

    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == size ) {
            add(element);
        } else {
            addBefore(index, element);
        }
    }

    public int find (E element) {
        int counter;
        Node<E> target = firstNode;
        for (counter = 0; counter < size; counter++) {
            if (target.data.equals(element)) {
                return counter;
            }
            target = target.next;
        }
        throw new NoSuchElementException();
    }

    private void addBefore (int index, E element) {
        Node<E> current = getLinked(index);
        final Node<E> newNode;
            Node<E> previous = current.previous;
            newNode = new Node<>(element, previous, current);
            current.previous = newNode;
            if (previous != null)
                previous.next = newNode;
            else
                firstNode = newNode;
        size++;
    }



    public E remove(int index) {
        checkIndex(index);
        Node<E> toRemove = getLinked(index);
        unlink(toRemove);
        size--;
        return toRemove.getData();
    }

    private void unlink(Node<E> current) {
        if (current.previous == null && current.next == null){
            unlinkAll();
        } else if (current.previous == null) {
            unlinkFirst(current);
        } else if (current.next == null) {
            unlinkLast(current);
        } else {
            unlinkWithin(current);
        }
    }

    private void unlinkFirst(Node<E> first) {
        Node<E> nextNode = first.next;
        firstNode = nextNode;
        nextNode.previous = null;
    }

    private void unlinkWithin(Node<E> current) {
        Node<E> nextNode = current.next;
        Node<E> previousNode = current.previous;
        nextNode.previous = previousNode;
        previousNode.next = nextNode;
    }

    private void unlinkLast(Node<E> last) {
        lastNode = last.previous;
        lastNode.next = null;
    }

    private void unlinkAll() {
        firstNode = null;
        lastNode = null;
    }

    private void checkIndex (int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex (int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> target = getLinked(index);
        return target.getData();
    }

    private Node<E> getLinked(int index) {
        Node<E> target = firstNode;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target;
    }



    public E set(int index, E element) {
        checkIndex(index);
        Node<E> toUpdate = getLinked(index);
        E elementToReturn = toUpdate.getData();
        toUpdate.setData(element);
        Node<E> paired = toUpdate.currentElement;
        paired.setData(element);
        return elementToReturn;
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }



    public void clear() {
        unlinkAll();
        size = 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            Node<E> current = firstNode;
            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                counter++;
                return data;
            }
        };
    }



    public void print() {
         this.stream()
                .forEach(System.out::println);
    }

    private class Node<E> {
        private E data;
        private Node<E> currentElement;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            currentElement = new Node<>(this);
            this.next = next;
            this.previous = previous;
        }

        private Node(Node<E> currentElement) {
            this.data = currentElement.getData();
            this.currentElement = currentElement;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }



}
