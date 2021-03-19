package yarm.techstroy.fullstackshop.controller;

import org.springframework.web.bind.annotation.*;
import yarm.techstroy.fullstackshop.model.WatchItem;
import yarm.techstroy.fullstackshop.service.WatchItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/watch-items/")
public class WatchItemController {

    private final WatchItemService watchItemService;

    public WatchItemController(WatchItemService watchItemService) {
        this.watchItemService = watchItemService;
    }

    @GetMapping("get")
    public List<WatchItem> getAllItems() {
        return watchItemService.getItems();
    }

    @GetMapping(value = "get", params = {"itemId"})
    public Optional<WatchItem> getItemById(@RequestParam Long itemId) {
        return watchItemService.getItems(itemId);
    }

    @PostMapping(value = "add")
    public List<WatchItem> addNewWatchItem(@RequestBody WatchItem newItem) {
        watchItemService.addItem(
                newItem.getTitle(),
                newItem.getPrice(),
                newItem.getImgPath(),
                newItem.getTag()
        );
        return watchItemService.getItems();
    }

    @DeleteMapping(value = "delete")
    public String deleteAllWatchItems() {
        watchItemService.deleteData();
        return "ok";
    }

    @DeleteMapping(value = "delete", params = {"itemId"})
    public String deleteWatchItemById(@RequestParam Long itemId) {
        watchItemService.deleteData(itemId);
        return "ok";
    }
}
