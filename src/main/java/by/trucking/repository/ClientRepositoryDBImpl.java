package by.trucking.repository;

import by.trucking.model.*;
import by.trucking.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryDBImpl implements ClientRepository{

    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public Client edit(Client client) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Client getById(int id) throws SQLException {
       return null;
    }

    @Override
    public List<Client> getClients() {
        return null;
    }






    @Override
    public Client getByTitle(String title) {
        return null;
    }
}
