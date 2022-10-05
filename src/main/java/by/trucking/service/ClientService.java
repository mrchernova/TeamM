package by.trucking.service;

import by.trucking.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientService {

    Client save(Client client);

    Client edit(Client client);

    boolean delete(int id);

    Client getById(int id) throws SQLException;

    Client getByTitle(String title);

    List<Client> getClients();

}
