package idv.kuan.flashcard3.core.dao;

public interface Dao<T> {

	void add(T t);

	T get(Object id);

	void update(T t, Object o);

	void delete(Object o);

}
