package com.five.crm.service;

import com.five.crm.domain.Client;
import com.five.crm.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Client}.
 */
@Service
@Transactional
public class ClientService {

    private final Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Save a client.
     *
     * @param client the entity to save.
     * @return the persisted entity.
     */
    public Client save(Client client) {
        log.debug("Request to save Client : {}", client);
        return clientRepository.save(client);
    }

    /**
     * Update a client.
     *
     * @param client the entity to save.
     * @return the persisted entity.
     */
    public Client update(Client client) {
        log.debug("Request to save Client : {}", client);
        return clientRepository.save(client);
    }

    /**
     * Partially update a client.
     *
     * @param client the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Client> partialUpdate(Client client) {
        log.debug("Request to partially update Client : {}", client);

        return clientRepository
            .findById(client.getId())
            .map(existingClient -> {
                if (client.getDesignation() != null) {
                    existingClient.setDesignation(client.getDesignation());
                }
                if (client.getContact() != null) {
                    existingClient.setContact(client.getContact());
                }
                if (client.getPostec() != null) {
                    existingClient.setPostec(client.getPostec());
                }
                if (client.getEmail() != null) {
                    existingClient.setEmail(client.getEmail());
                }
                if (client.getTel() != null) {
                    existingClient.setTel(client.getTel());
                }
                if (client.getAdresse() != null) {
                    existingClient.setAdresse(client.getAdresse());
                }
                if (client.getBesoins() != null) {
                    existingClient.setBesoins(client.getBesoins());
                }
                if (client.getRemarques() != null) {
                    existingClient.setRemarques(client.getRemarques());
                }
                if (client.getForum() != null) {
                    existingClient.setForum(client.getForum());
                }

                return existingClient;
            })
            .map(clientRepository::save);
    }

    /**
     * Get all the clients.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        log.debug("Request to get all Clients");
        return clientRepository.findAll();
    }

    /**
     * Get one client by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Client> findOne(Long id) {
        log.debug("Request to get Client : {}", id);
        return clientRepository.findById(id);
    }

    /**
     * Delete the client by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Client : {}", id);
        clientRepository.deleteById(id);
    }
}
