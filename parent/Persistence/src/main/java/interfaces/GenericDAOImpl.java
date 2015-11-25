package interfaces;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by echerkas on 24.11.2015.
 */
public abstract class GenericDAOImpl<T> implements GenericDAOInterface<T> {

    protected Class<T> entityClass;
    protected EntityManager entityManager;

    public GenericDAOImpl(){
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class) genericSuperclass
                .getActualTypeArguments()[0];
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
        t = entityManager.merge(t);
        entityManager.remove(t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(Long id) {
        return (T) entityManager.find(entityClass, id);
    }

    @Override
    public List<T> getAll() {
        TypedQuery<T> query = entityManager.createQuery("from " + entityClass.getName(), entityClass);
        return query.getResultList();
    }
}


//
//    public GenericDAOImpl() {
//        Type t = getClass().getGenericSuperclass();
//        ParameterizedType pt = (ParameterizedType) t;
//        entityClass = (Class) pt.getActualTypeArguments()[0];
//    }
//
//    public GenericDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//
//        @Override
//        public T create (T t){
//            entityManager.persist(t);
//            return t;
//        }
//
//        @Override
//        public T update (T t){
//            entityManager.merge(t);
//            return t;
//        }
//
//        @Override
//        public void remove (T t){
//            t = this.entityManager.merge(t);
//            this.entityManager.remove(t);
//        }
//
//        @Override
//        public T getById (Long id, Class xx){
//            return (T) entityManager.find(xx, id);
//        }
//
//        @Override
//        public List<T> getAll (Class xx){
//            TypedQuery<T> query = entityManager.createQuery("from " + xx.getName(), entityClass);
//            return query.getResultList();
//        }
//    }
//}
//
////        public GenericDaoImpl() {
////            ParameterizedType genericSuperclass = (ParameterizedType) getClass()
////                    .getGenericSuperclass();
////            this.entityClass = (Class) genericSuperclass
////                    .getActualTypeArguments()[0];
////        }
//
