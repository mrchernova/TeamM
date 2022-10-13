package by.trucking.service;

import by.trucking.model.Client;
import by.trucking.model.Order;
import by.trucking.repository.ClientRepository;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public class ClientServiceImpl  implements ClientService{
    ClientRepository clientRepository;
    UserService userService;

    public ClientServiceImpl(ClientRepository clientRepository, UserService userService){
        this.clientRepository = clientRepository;
        this.userService = userService;
    }


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
        return clientRepository.getById(id);
    }

    @Override
    public Client getByTitle(String title) {
        return clientRepository.getByTitle(title);
    }

    @Override
    public List<Client> getClients() {

        return clientRepository.getClients();
    }
}
