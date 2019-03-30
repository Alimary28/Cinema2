package Tests;

import Domain.ClientCard2;
import Domain.ClientCardValidator2;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientCardService2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientCardService2Test {



    private IValidator<ClientCard2> clientCard2Validator = new ClientCardValidator2();
    private IRepository<ClientCard2> clientCard2Repository = new InMemoryRepository<>(clientCard2Validator);
    private ClientCardService2 clientCardService2 = new ClientCardService2(clientCard2Repository);


    @Test
    void addOrUpdate() {

        clientCardService2.addOrUpdate(1,"Andreica","Anda","191090912","04.02.1981","19.08.2012");
        assertEquals(1, clientCardService2.getAll().size());

        clientCardService2.addOrUpdate(1,"Andreica","Anda","191090912","04.02.1981","29.08.2012");


        assertEquals("29.08.2012", clientCardService2.getAll().get(0).getRegistrationDate());


    }

    @Test
    void remove() {

        clientCardService2.addOrUpdate(1,"Andreica","Anda","191090912","04.02.1981","19.08.2012");
        clientCardService2.remove(1);

        assertEquals(0, clientCardService2.getAll().size());
    }

    @Test
    void getAll() {

        clientCardService2.addOrUpdate(1,"Andreica","Anda","191090912","04.02.1981","19.08.2012");
        assertEquals(1, clientCardService2.getAll().size());

    }
}