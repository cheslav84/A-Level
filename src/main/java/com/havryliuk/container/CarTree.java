package com.havryliuk.container;

import com.havryliuk.model.Car;


public class CarTree<E extends Car>  {
    private final CarComparator comparator = new CarComparator ();

    private Node<E> root;



    public int calculateCount(E car) {
        Node<E> current = getCurrent(root, car);
        return calculateCountRecursive(current);
    }

    public int calculateCountRecursive(Node<E> root) {
        if (root == null) {
            return 0;
        }
        return root.getData().getCount() + calculateCountRecursive(root.leftElement) + calculateCountRecursive(root.rightElement);
    }

    private Node<E> getCurrent(Node<E> current, E car) {
        if (current == null) {
//            return new Node<>(car);
            return null;
        }
        if (comparator.compare(car, current.data) < 0) {
            current = getCurrent(current.leftElement, car);
        } else if (comparator.compare(car, current.data) > 0) {
            current = getCurrent(current.rightElement, car);
        } else {
            return current;
        }
        return current;
    }



    public void add(E car) {
        root = addRecursive(root, car);
    }

    private Node<E> addRecursive(Node<E> current, E car) {
        if (current == null) {
            return new Node<>(car);
        }
        if (comparator.compare(car, current.data) < 0) {
            current.leftElement = addRecursive(current.leftElement, car);
        } else if (comparator.compare(car, current.data) > 0) {
            current.rightElement = addRecursive(current.rightElement, car);
        } else {
            return current;
        }
        return current;
    }



    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> root) {
        if (root == null)
            return "";
        return toString(root.leftElement) + "\n"
                + root.data + " "
                + toString(root.rightElement);
    }



    private static class Node<E> {
        private final E data;
        private Node<E> leftElement;
        private Node<E> rightElement;

        public Node(E data) {
            this.data = data;
            leftElement = null;
            rightElement = null;
        }

        public E getData() {
            return data;
        }
    }



}
