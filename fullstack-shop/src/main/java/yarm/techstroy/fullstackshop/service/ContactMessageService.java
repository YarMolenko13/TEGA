package yarm.techstroy.fullstackshop.service;

import yarm.techstroy.fullstackshop.model.ContactMessage;
import yarm.techstroy.fullstackshop.repository.ContactMessageRepository;

import java.util.List;

public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public List<ContactMessage> getAllContactMessages() {
        return contactMessageRepository.findAll();
    }

    public void addNewContactM(ContactMessage message) {
        contactMessageRepository.save(message);
    }
}
