package yarm.techstroy.fullstackshop.controller;

import org.springframework.web.bind.annotation.*;
import yarm.techstroy.fullstackshop.model.ContactMessage;
import yarm.techstroy.fullstackshop.model.WatchItem;
import yarm.techstroy.fullstackshop.model.WatchReviews;
import yarm.techstroy.fullstackshop.repository.ContactMessageRepository;
import yarm.techstroy.fullstackshop.request.RequestBodyAddReview;
import yarm.techstroy.fullstackshop.service.ContactMessageService;
import yarm.techstroy.fullstackshop.service.WatchItemService;
import yarm.techstroy.fullstackshop.service.WatchReviewsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/")
//        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
//        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
//)
public class MainRestController {

    private final WatchReviewsService watchReviewsService;
//    private final ContactMessageService contactMessageService;

    private final ContactMessageRepository contactMessageRepository;

    public MainRestController(WatchReviewsService watchReviewsService, ContactMessageRepository contactMessageRepository) {

        this.watchReviewsService = watchReviewsService;
//        this.contactMessageService = contactMessageService;

        this.contactMessageRepository = contactMessageRepository;
    }

    @GetMapping("get-all-reviews")
    public List<WatchReviews> getAllReviews() {
        return watchReviewsService.getAllReviews();
    }

    @GetMapping("get-need-reviews")
    public List<WatchReviews> getAllNeedReviews(@RequestParam Long itemId) {
        return watchReviewsService.getNeedRevs(itemId);
    }


    @PostMapping("add-review")
    public Optional<WatchItem>  addReview(@RequestBody RequestBodyAddReview requestBody) {
        return watchReviewsService.addNewReview(requestBody);
    }

    @DeleteMapping("delete-all-reviews")
    public String deleteReviews() {
        watchReviewsService.deleteAll();
        return "Ok";
    }

    @GetMapping("get-all-contacts-m")
    public List<ContactMessage> getAllContacts() {
        return contactMessageRepository.findAll();
    }

    @PostMapping("add-new-contact-m")
    public String addNewContactMessage(@RequestBody ContactMessage message) {
        contactMessageRepository.save(message);
        return "Ok";
    }

}


// в запросе передовать еще и id продукта , а потом искать его
// и создавать новый review с этим объектом
