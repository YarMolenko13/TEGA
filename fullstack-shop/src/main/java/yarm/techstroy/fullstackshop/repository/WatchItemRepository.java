package yarm.techstroy.fullstackshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yarm.techstroy.fullstackshop.model.WatchItem;

@Repository
public interface WatchItemRepository extends JpaRepository<WatchItem, Long> {


}
