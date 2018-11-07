package lt.bta.java2.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;

public class DaoImp<T> implements Dao<T> {

    private final EntityManager entityManager;

    public DaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T get(Class<T> entityClass, Object pk) {
        return entityManager.find(entityClass, pk);
    }

    @Override
    public void save(T t) {
        executeInsideTransaction(entityManager -> entityManager.persist(t));
    }

    @Override
    public void update(T t) {
        executeInsideTransaction(entityManager -> entityManager.merge(t));
    }

    @Override
    public void delete(T t) {
        executeInsideTransaction(entityManager -> entityManager.remove(t));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
