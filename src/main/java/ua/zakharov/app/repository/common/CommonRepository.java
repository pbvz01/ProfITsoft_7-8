package ua.zakharov.app.repository.common;

public interface CommonRepository<T> {
    T save(T model);
    Iterable<T> findAll();
    T findById(Long id);
    T findByLogin(String login);
    T findByLoginAndPassword(String login, String password);
}
