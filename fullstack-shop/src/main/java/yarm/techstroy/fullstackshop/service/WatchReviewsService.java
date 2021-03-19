package yarm.techstroy.fullstackshop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import yarm.techstroy.fullstackshop.model.WatchItem;
import yarm.techstroy.fullstackshop.model.WatchReviews;
import yarm.techstroy.fullstackshop.repository.WatchItemRepository;
import yarm.techstroy.fullstackshop.repository.WatchReviewsRepository;
import yarm.techstroy.fullstackshop.request.RequestBodyAddReview;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WatchReviewsService {

    private final WatchReviewsRepository watchReviewsRepository;
    private final WatchItemRepository watchItemRepository;

    public WatchReviewsService(WatchReviewsRepository watchReviewsRepository, WatchItemRepository watchItemRepository) {
        this.watchReviewsRepository = watchReviewsRepository;
        this.watchItemRepository = watchItemRepository;
    }


    public List<WatchReviews> getAllReviews() {
        return watchReviewsRepository.findAll();
    }

    public List<WatchReviews> getNeedRevs(Long itemId) {
        return watchReviewsRepository.getRev(itemId);
    }

//    public Optional<WatchItem> addNewReview(@RequestParam Map<String, String> body) {
//        Optional<WatchItem> watchItem = watchItemRepository.findById(body.get("itemId"));
//        if (watchItem.isPresent()) {
//            WatchReviews newReview = new WatchReviews(
//                    requestBody.getUserName(),
//                    requestBody.getRating(),
//                    requestBody.getReviewText(),[]
//                    watchItem.get()
//            );
//            watchReviewsRepository.save(newReview);
//        }
//        return watchItem;
//    }

    public Optional<WatchItem> addNewReview(RequestBodyAddReview requestBody) {
        Optional<WatchItem> watchItem = watchItemRepository.findById(requestBody.getItemId());
        if (watchItem.isPresent()) {
            WatchReviews newReview = new WatchReviews(
                    requestBody.getUserName(),
                    requestBody.getRating(),
                    requestBody.getReviewText(),
                    watchItem.get()
            );
            watchReviewsRepository.save(newReview);
        }
        return watchItem;
    }

    public void deleteAll() {
        watchReviewsRepository.deleteAll();
    }
}
