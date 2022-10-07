package by.trucking.repository;

import by.trucking.model.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientRepository {
    Client save(Client client);

    Client edit(Client client);

    boolean delete(int id);

    Client getById(int id) throws SQLException;

    Client getByTitle(String title);

    List<Client> getClients();

}
