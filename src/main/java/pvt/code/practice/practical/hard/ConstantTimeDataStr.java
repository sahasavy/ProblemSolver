package pvt.code.practice.practical.hard;

import java.util.*;

/*
    Design a data structure that supports the following operations in constant time.
    1. insert an item
    2. remove an item
    3. search an item
    4. return a random element from the set of elements in the data structure
 */
public class ConstantTimeDataStr<T> {

    private final Map<T, Integer> elementIndexMap;
    private final List<T> elementList;
    private final Random random;

    public ConstantTimeDataStr() {
        elementIndexMap = new HashMap<>();
        elementList = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(T element) {
        if (elementIndexMap.containsKey(element)) {
            return false; // Element already exists
        }
        elementList.add(element);
        elementIndexMap.put(element, elementList.size() - 1); // Map<actualElement, currentIndex>
        return true;
    }

    public boolean remove(T element) {
        if (!elementIndexMap.containsKey(element)) {
            return false; // Element doesn't exist
        }

        int index = elementIndexMap.get(element);
        T lastElement = elementList.get(elementList.size() - 1);

        elementList.set(index, lastElement);
        elementIndexMap.put(lastElement, index);

        elementList.remove(elementList.size() - 1);
        elementIndexMap.remove(element);

        return true;
    }

    public boolean search(T element) {
        return elementIndexMap.containsKey(element);
    }

    public T getRandomElement() {
        if (elementList.isEmpty()) {
            return null; // No element to return
        }
        int randomIndex = random.nextInt(elementList.size());
        return elementList.get(randomIndex);
    }

    public static void main(String[] args) {
        ConstantTimeDataStr<Integer> ds = new ConstantTimeDataStr<>();

        System.out.println("Result: " + ds.insert(1001)); // true
        System.out.println("Result: " + ds.insert(2002)); // true
        System.out.println("Result: " + ds.insert(3003)); // true
        System.out.println("Result: " + ds.insert(3003)); // false

        System.out.println("Result: " + ds.search(2002)); // true
        System.out.println("Result: " + ds.getRandomElement()); // Random element from {1001, 2002, 3003}

        System.out.println("Result: " + ds.remove(2002)); //true
        System.out.println("Result: " + ds.search(2002)); // false

        System.out.println("Result: " + ds.getRandomElement()); // Random element from {1001, 3003}
    }
}
