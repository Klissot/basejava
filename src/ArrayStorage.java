import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        size();
        Arrays.fill(storage, 0, size,null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
        size();
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            } else {
                return null;
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                Resume temp = storage[i + 1];
                storage[i + 1] = storage[i];
                storage[i] = temp;
            }
        }
        storage[size] = null;
        size();
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) {
                count++;
            }
        }
        return Arrays.copyOf(storage, count);
    }


    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                size = i+1;
            }
        }
        return size;
    }
}
