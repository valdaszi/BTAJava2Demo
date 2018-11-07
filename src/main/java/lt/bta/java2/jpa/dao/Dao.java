package lt.bta.java2.jpa.dao;

public interface Dao<T> {

    T get(Class<T> entityClass, Object pk);

    void save(T t);

    void update(T t);

    void delete(T t);

}
