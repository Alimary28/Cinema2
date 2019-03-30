package Repository;

import Domain.Movie2;
import Domain.MovieValidator2;
import Domain.Entity;
import Domain.IValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryRepository<T extends Entity> implements IRepository<T>{

    private Map<Integer, T> programm = new HashMap<>();
    private IValidator<T> validator;

    public InMemoryRepository(IValidator<T> validator) {
        this.validator = validator;
    }


    public T findById(int id) {
        return programm.get(id);
    }

    /**
     * Adds or updates a entity if it already exists.
     * @param entity the entity to add or update.
     */
    public void upsert(T entity) {
        validator.validate2(entity);
        programm.put(entity.getId(), entity);
    }

    /**
     * Removes a entity with a given id.
     * @param id the id.
     * @throws InMemoryRepoException if there is no entity with the given id.
     */
    public void remove(int id) {
        if (!programm.containsKey(id)) {

            throw new InMemoryRepoException("There is no entity with the given id to remove.");
        }

        programm.remove(id);
    }

    public List<T> getAll() {
        return new ArrayList<>(programm.values());
    }

}
