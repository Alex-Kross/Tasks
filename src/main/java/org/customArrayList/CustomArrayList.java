package org.customArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList {
    private Object[] listElement = {};
    private int numberDataInList = 0;

    /***
     * Expand size list on one element
     */
    private void grow(){
        Object []objects = new Object[numberDataInList + 1];
        for (int i = 0; i < numberDataInList; i++) {
            objects[i] = listElement[i];
        }
        listElement=objects;
        numberDataInList++;
    }

    /***
     * Add element via index
     * Use for expand list and for replace value in list
     * @param index
     * @param element
     * @param <E>
     */
    public <E> void  add(int index, E element){
        if (index > numberDataInList || index < 0) {   // if index out of bounds list
            throw new IndexOutOfBoundsException();
        }
        if (index == numberDataInList) {               // expand list if index more size list on one element
            grow();
            listElement[index] = element;
        } else {
            listElement[index] = element;              // usual replace value via index
        }
    }

    public <E> boolean addAll(Collection<? extends E> c) {
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
    public Object remove(int index){
        return new Object();
    }
    public boolean remove(Object o){
        return true;
    }
    public <E> void sort(Comparator<? super E> c){

    }

    @Override
    public String toString() {
        return Arrays.toString(listElement);
    }
}
