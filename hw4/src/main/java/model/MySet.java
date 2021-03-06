package model;
import java.util.Random;
public class MySet<E> implements SimpleSet<E> {
    private E[] backingArray;
    private int size;
    public MySet() {
        backingArray = (E[]) (new Object[1]);
        size = 0;
    }

    /**
     * Adds the passed in element to the set.
     * @param e the element to be added to the set
     */
    @Override
    public boolean add(E e) {
        if (!contains(e)) {
            if (backingArray.length == size) {
                E[] tempBackingArray = (E[])
                    (new Object[backingArray.length * 2]);
                for (int i = 0; i < backingArray.length; i++) {
                    tempBackingArray[i] = backingArray[i];
                }
                backingArray = tempBackingArray;
            }
            backingArray[size] = e;
            size++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes the passed in element from the set if it is
     * contained in the set, then returns the removed element
     * otherwise throws as ElementDoesNotExistException
     * @param e the element to be removed
     * @return E the element that was removed
     */
    @Override
    public E remove(E e) throws ElementDoesNotExistException {
        if (contains(e)) {
            for (int i = 0; i < size; i++) {
                if (backingArray[i] == null && e == null) {
                    backingArray[i] = null;
                    for (int j = i; j < (size - 1); j++) {
                        backingArray[j] = backingArray[j + 1];
                    }
                    if (backingArray.length == size) {
                        backingArray[size - 1] = null;
                    }
                    size--;
                    //return e;
                } else if (backingArray[i] != null
                    && backingArray[i].equals(e)) {
                    backingArray[i] = null;
                    for (int j = i; j < size - 1; j++) {
                        backingArray[j] = backingArray[j + 1];
                    }
                    if (backingArray.length == size) {
                        backingArray[size - 1] = null;
                    }
                    size--;
                    //return e;
                }
            }
        } else {
            throw new ElementDoesNotExistException("The element doesn't exist "
                + " in backing array");
        }
        return e;
    }

    /**
     * Returns true if the passed in element is contained in
     * the set.
     * Returns false if the passed in element is not contained
     * in the set.
     * @param e the element to be checked
     * @return whether the passed in element is contained
     * in the set
     */
    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (backingArray[i] == null && e == null) {
                return true;
            } else if (backingArray[i] != null && backingArray[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * removes all the passed in elements from the set then returns them
     * throws a ElementDoesNotExistException if one of the passed in elements
     * is not in the set.
     * NOTE: this method should not remove ANY elements from the set
     * if it throws a ElementDoesNotExistException
     * @param e the elements to be removed from the set
     * @return E[] the elements that were removed from the set
     */
    @Override
    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        int sizeSubtract = 0;
        E[] tempBackingArray = (E[]) (new Object[backingArray.length]);

        for (int i = 0; i < size; i++) {
            tempBackingArray[i] = backingArray[i];
        }
        for (int j = 0; j < e.length; j++) {
            for (int k = 0; k < size; k++) {
                if (e[j] == null && tempBackingArray[k] == null) {
                    tempBackingArray[k] = null;
                    for (int m = k; m < (size - 1); m++) {
                        tempBackingArray[m] = tempBackingArray[m + 1];
                    }
                    int newSize = size - sizeSubtract;
                    if (tempBackingArray.length == (newSize)) {
                        tempBackingArray[size - 1] = null;
                    }
                    sizeSubtract++;
                } else if (tempBackingArray[k] != null
                    && e[j].equals(tempBackingArray[k])) {
                    tempBackingArray[k] = null;
                    sizeSubtract++;
                    for (int m = k; m < size - 1; m++) {
                        tempBackingArray[m] = tempBackingArray[m + 1];
                    }
                    int newSize = size - sizeSubtract;
                    if (tempBackingArray.length == (newSize)) {
                        tempBackingArray[size - 1] = null;
                    }
                    sizeSubtract++;
                } else {
                    throw new ElementDoesNotExistException("The element doesn't"
                        + " exist in backing array");
                }
            }
        }
        backingArray = tempBackingArray;
        size -= sizeSubtract;
        return e;
    }

    /**
     * Removes all elements from the set.
     */
    @Override
    public void clear() {
        for (int i = 0; i < backingArray.length; i++) {
            backingArray[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the number of elements contained in the set.
     * @return int the number of elements in the set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns false if the set contains 1 or more elements and
     * returns true if the set contains no elements.
     * @return boolean whether the set contains any elements
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns a random element from the set.
     * NOTE: because the set has no ordering returning any element in the
     * set is effectively returning a "random" element
     * throws a ElementDoesNotExistException if there are no elements
     * in the set
     * HINT: you may import java.util.Random to help with this if
     * you want
     * @return E a random element from the set
     */
    @Override
    public E getRandomElement() throws ElementDoesNotExistException {
        Random rand = new Random();
        int randIndex = rand.nextInt(size);
        if (isEmpty()) {
            throw new ElementDoesNotExistException("The element doesn't exist "
                + " in backing array");
        } else {
            return backingArray[randIndex];
        }
    }

    /**
     * Returns an array of all the elements contained within the SimpleSet.
     * There should be no nulls in the array.
     * @return an array containing all the elements contained
     * within the set
     */
    @Override
    public E[] toArray() {
        E[] tempBackingArray = (E[]) (new Object[size]);
        for (int i = 0; i < size; i++) {
            tempBackingArray[i] = backingArray[i];
        }
        return tempBackingArray;
    }

    /**
     * Calculates and returns a String representation of this object.
     * Any String that shows each individual element's toString
     * is acceptable.
     * @return String the String representation of this object
     */
    @Override
    public String toString() {
        //E[] tempBackingArray = this.toArray();
        String myString = "";
        for (int i = 0; i < size; i++) {
            if (backingArray[i] == null) {
                myString += "null ";
            } else {
                myString += backingArray[i].toString() + "  ";
            }
        }
        return myString;
    }
}
