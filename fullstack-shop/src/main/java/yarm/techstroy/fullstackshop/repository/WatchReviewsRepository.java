package yarm.techstroy.fullstackshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yarm.techstroy.fullstackshop.model.WatchItem;
import yarm.techstroy.fullstackshop.model.WatchReviews;

import java.util.List;

public interface WatchReviewsRepository extends JpaRepository<WatchReviews, Long> {
//
//    @Query(value = "SELECT * " +
//            "FROM watch_reviews " +
//            "WHERE item_id = 1", nativeQuery = true)
//    List<WatchReviews> getRev();


    @Query(value = "SELECT * " +
            "FROM watch_reviews " +
            "WHERE item_id = ?1 " +
            "ORDER BY created DESC", nativeQuery = true)
    List<WatchReviews> getRev(Long itemId);
}
