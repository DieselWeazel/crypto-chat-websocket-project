package se.cryptosnack.demo.service;
import java.util.List;
public interface EntityService<T, E> {

    List<T> loadAll();
    E save(E e);

}
