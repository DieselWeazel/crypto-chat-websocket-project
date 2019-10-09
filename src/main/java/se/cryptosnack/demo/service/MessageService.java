package se.cryptosnack.demo.service;
import se.cryptosnack.demo.model.SentDTO;
import java.util.List;
public interface MessageService<T, E> {

    List<T> loadHistory();
    T save(E e);

}
