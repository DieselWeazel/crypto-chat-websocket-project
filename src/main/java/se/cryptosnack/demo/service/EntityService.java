package se.cryptosnack.demo.service;
import java.util.List;

public interface EntityService<E> {

    List<E> loadAll();
    E save(E e);

}
