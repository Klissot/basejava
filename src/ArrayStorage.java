import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size,null);
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i <= size; i++) {
            storage[size] = r;
            size++;
            break;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                for (int j = i; j < size; j++) {
                    Resume temp = storage[j+1];
                    storage[j+1] = storage[j];
                    storage[j] = temp;
                }
                size--;
            }
        }
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
        return size;
    }
}
