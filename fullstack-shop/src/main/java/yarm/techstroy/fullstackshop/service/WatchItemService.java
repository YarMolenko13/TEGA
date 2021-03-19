package yarm.techstroy.fullstackshop.service;

import org.springframework.stereotype.Service;
import yarm.techstroy.fullstackshop.model.WatchItem;
import yarm.techstroy.fullstackshop.repository.WatchItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WatchItemService {

    private final WatchItemRepository watchItemRepository;

    public WatchItemService(WatchItemRepository watchItemRepository) {
        this.watchItemRepository = watchItemRepository;
    }

    public List<WatchItem> getItems() {
        return watchItemRepository.findAll();
    }

    public Optional<WatchItem> getItems(Long itemId) {
        return watchItemRepository.findById(itemId);
    }

    public void addItem(
            String title,
            Integer price,
            String imgPath,
            String tag
    ) {
        WatchItem newItem = new WatchItem(title, price, imgPath, tag);
        watchItemRepository.save(newItem);
    }

    public void deleteData() {
        watchItemRepository.deleteAll();
    }

    public void deleteData(Long itemId) {
        watchItemRepository.deleteById(itemId);
    }

}
