package persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by echerkas on 24.11.2015.
 */
public abstract class GenericDAOImpl<T> implements GenericDAOInterface<T> {

    protected Class<T> entityClass;
    @PersistenceContext
    protected EntityManager entityManager;
    public GenericDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        t = (Class) pt.getActualTypeArguments()[0];
    }


    @Override
    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public void remove(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    @Override
    public T getById(Long id, Class xx) {
        return (T) entityManager.find(xx, id);
    }

    @Override
    public List<T> getAll(Class xx) {
        TypedQuery<T> query = entityManager.createQuery("from " + xx.getName(), xx);
        return query.getResultList();
    }
}