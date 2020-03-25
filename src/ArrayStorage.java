import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        size();
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                return resume;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        sort();
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            }
        }
        return Arrays.copyOf(storage, count);
    }


    int size() {
        sort();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size = i;
            }
        }
        return size;
    }

    void sort() {
        for(int i = storage.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if (storage[j] == null) {
                    storage[j] = storage [j+1];
                    storage[j + 1] = null;
                }
            }
        }
    }
}
