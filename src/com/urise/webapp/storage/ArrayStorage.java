package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;
    private int index;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (check(r.getUuid())) {
            storage[index] = r;
        } else {
            System.out.println("Error!");
        }
    }

    public void save(Resume r) {
        if (!(check(r.getUuid()))) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Error!");
        }
    }

    public Resume get(String uuid) {
        if (check(uuid)) {
            return storage[index];
        } else {
            return null;
        }
    }

    public void delete(String uuid) {
        if (check(uuid)) {
            for (int j = index; j < size - 1; j++) {
                storage[j] = storage[j + 1];
            }
            size--;
        } else {
            System.out.println("Error!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public boolean check(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                return true;
            }
        }
        return false;
    }
}