package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;
    private int index;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (check(resume.getUuid())) {
            storage[index] = resume;
        } else {
            System.out.println("No resume found with this uuid - " + resume.getUuid() + "! Check the data entry is correct.");
        }
    }

    public void save(Resume resume) {
        if (!(check(resume.getUuid()))) {
            storage[size] = resume;
            if (size < storage.length) {
                size++;
            } else {
                System.out.println("The number of resumes has reached its maximum value. Further addition is not possible.");
            }
        } else {
            System.out.println("A resume with this uuid: " + resume.getUuid() + " already exists! Check the data entry is correct.");
        }
    }

    public Resume get(String uuid) {
        if (check(uuid)) {
            return storage[index];
        }
        return null;
    }

    public void delete(String uuid) {
        if (check(uuid)) {
            if (size - 1 - index >= 0) System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            size--;
        } else {
            System.out.println("No resume found with this uuid - " + uuid + "! Check the data entry is correct.");
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