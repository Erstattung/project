package interfaces;

import java.util.List;

/**
 * Created by echerkas on 24.11.2015.
 */
public interface GenericDAOInterface <T> {


        T create(T t);


        T update(T t);


        void remove (T t);


        T getById(Long id);

        List<T> getAll();
}

//        T create(T t);
//
//        T update(T t);
//
//        void remove (T t);
//
//        T getById(Long id, Class xx);
//
//        List<T> getAll(Class xx);
//}
