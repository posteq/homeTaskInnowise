package by.innowise.tkachuk.entity;

import by.innowise.tkachuk.observer.Observable;
import by.innowise.tkachuk.observer.Observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray implements Observable {
    private final long id;
    private final int[] array;
    private final List<Observer> observers = new ArrayList<>();

    public CustomArray(long id , int[] arr) {
        this.id = id;
        this.array = arr;
    }

    public long getId() {
        return id;
    }


    public int[] getArray() {
        return Arrays.copyOf(array,array.length);
    }

    public int getLength() {
        return array.length;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomArray that)) return false;

        return id == that.id && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "id=" + id +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }
}