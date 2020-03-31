package gcSSilki;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.ref.SoftReference;
import java.util.HashMap;
public class HashLowMap <K, V> {
    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(HashLowMap.class.getName());

    /**
     * Composition of hashMap for keeping Softreference
     */
    private HashMap<K, SoftReference<V>> collect = new HashMap<>();

    /**
     * Insert value to CacheMap? create Softrefeence
     *
     * @param key   key to get information from Map
     * @param value object which will be created sofrreferense for
     * @retrun true if object is added, false in the other
     */

    public boolean insert(K key, V value) {
        collect.put(key, new SoftReference<>(value));
        return collect.get(key).equals(value);
    }

    /**
     * get object from cache collection,
     * if object is missing, it will be added to collection.
     *
     * @param key key to find object
     * @return value for key
     *
     *       получить объект из коллекции кеша,
     *       если объект отсутствует, он будет добавлен в коллекцию.
     *
     *       @парам ключ ключ, чтобы найти объект
     *       @ возвращаемое значение для ключа
     *
     */

    public V get(K key) {
        V temp = null;
        if (collect.containsKey(key)) {
            temp = collect.get(key).get();
        }
        return temp;
    }

    /**
     * Delete link from Map, according to key
     *
     * @param key key to find link for deliting
     * @return true if object have been deleted
     * Удалить ссылку в map, в соответствии с ключом
     *      *
     *      * @парам ключ ключ, чтобы найти ссылку для разделения
     *      * @return true, если объект был удален
     */

    public boolean delete(K key) {
        collect.remove(key);
        return collect.containsKey(key);
    }
}

