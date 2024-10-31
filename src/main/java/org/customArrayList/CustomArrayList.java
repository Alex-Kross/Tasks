package org.customArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList {
    private Object[] listElement = {};
    private int numberDataInList = 0;

    /***
     * Expand size list on one element in certain index
     */
    private void grow(int index){
        Object []objects = new Object[numberDataInList + 1];
        for (int i = 0, j = 0; i < numberDataInList + 1; i++) {
            if (i != index) {
                objects[i] = listElement[j];
                j++;
            }
        }
        listElement=objects;
        numberDataInList++;
    }

    /***
     * Add element via index
     *
     * @param index
     * @param element
     * @param <E>
     */
    public <E> void  add(int index, E element){
        if (index > numberDataInList || index < 0) {   // if index out of bounds list
            throw new IndexOutOfBoundsException();
        }
        grow(index);
        listElement[index] = element;
    }

    /***
     * Add group of list elements in custom array list
     * @param c
     * @return
     * @param <E>
     */
    public <E> boolean addAll(Collection<? extends E> c) {
        for (E element: c) {
            grow(numberDataInList);
            listElement[numberDataInList - 1] = element;
        }
        return true;
    }

    /***
     * Remove all elements from list
     */
    public void clear(){
        if (numberDataInList != 0) {
            Arrays.fill(listElement, null);
            listElement = new Object[0];
            numberDataInList = 0;
        }
    }

    /***
     * Get element via index
     * @param index
     * @return
     */
    public Object get(int index){
        if (numberDataInList == 0) {                    // if list not have elements
            throw new IndexOutOfBoundsException();
        }
        if (index >= numberDataInList || index < 0) {   // if index out of bounds list
            throw new IndexOutOfBoundsException();
        }
        return listElement[index];
    }

    /***
     * Return true if this list not have elements
     * @return
     */
    public boolean isEmpty(){
        if (numberDataInList == 0) {
            return true;
        }
        return false;
    }

    /***
     * Shrink list on one element except element on index
     * @param index
     */
    public void reduce(int index){
        Object []object = new Object[numberDataInList - 1];
        for (int i = 0, j = 0; i < numberDataInList; i++) {
            if (i != index) {
                object[j] = listElement[i];
                j++;
            }
        }
        listElement = object;
        numberDataInList--;
    }

    /***
     * Remove element via index
     * @param index
     * @return
     */
    public Object remove(int index) {
        if (index > numberDataInList || index < 0) {   // if index out of bounds list
            throw new IndexOutOfBoundsException();
        }
        Object deleted = listElement[index];
        reduce(index);
        return deleted;
    }

    /***
     * Remove element via value of list
     * @param o
     * @return
     */
    public boolean remove(Object o){
        boolean isFound = false;
        int indexFound = 0;
        for (int i = 0; i < numberDataInList; i++) {
            if (listElement[i].equals(o)) {
                indexFound = i;
                isFound = true;
            }
        }
        reduce(indexFound);

        return isFound;
    }
    public <E> void sort(Comparator<? super E> c){

    }

    @Override
    public String toString() {
        return Arrays.toString(listElement);
    }
}
