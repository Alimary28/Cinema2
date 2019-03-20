package Service;

import Domain.ClientCard2;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientCardService2 {

    private IRepository<ClientCard2> repository;

    public ClientCardService2(IRepository<ClientCard2> repository){
        this.repository = repository;
    }

    public void addOrUpdate(int id, String name, String firstName, String cnp, String birthDate, String registrationDate) {
        ClientCard2 existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (firstName.isEmpty()) {
                firstName = existing.getFirstname();
            }
            if (cnp.isEmpty()) {
                cnp = existing.getCnp();
            }
            if (birthDate.isEmpty()) {
                birthDate = existing.getBirthDate();
            }
            if (registrationDate.isEmpty()) {
                registrationDate = existing.getRegistrationDate();
            }
        }
        ClientCard2 clientCard2 = new ClientCard2(id, name, firstName, cnp, birthDate, registrationDate);
        repository.upsert(clientCard2);
    }


    /**
     * Searches clients whose fields contain a given text.
     * @param text the text searched for
     * @return A list of clients whose fields contain text.
     */
    public List<ClientCard2> fullTextSearch(String text) {
        List<ClientCard2> found = new ArrayList<>();
        for (ClientCard2 client : repository.getAll()) {
            // Might return false positives
            if (client.toString().contains(text)) {
                found.add(client);
            }
        }

        return found;
    }

    public void remove(int id) {
        repository.remove(id);
    }

    public List<ClientCard2> getAll() {
        return repository.getAll();
    }


}
