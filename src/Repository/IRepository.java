package Repository;

import Domain.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {

    T findById(int id);

    /**
     * Adds or updates an entity if it already exists.
     * @param entity the entity to add or update.
     */
    void upsert(T entity);

    /**
     * Removes an entity with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no entity with the given id.
     */
    void remove(int id);

    List<T> getAll();
}

