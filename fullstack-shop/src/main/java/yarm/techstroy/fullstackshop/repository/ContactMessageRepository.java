package yarm.techstroy.fullstackshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yarm.techstroy.fullstackshop.model.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
