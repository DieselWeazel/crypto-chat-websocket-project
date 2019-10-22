package se.cryptosnack.demo.service;
import se.cryptosnack.demo.model.SentDTO;
import java.util.List;
public interface EntityService<T, E> {

    List<T> loadAll();
    T save(E e);

}
