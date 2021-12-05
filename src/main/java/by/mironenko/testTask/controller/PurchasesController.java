package by.mironenko.testTask.controller;

import by.mironenko.testTask.dto.PuechasesDto;
import by.mironenko.testTask.dto.PurchasesDto;
import by.mironenko.testTask.service.PurchasesService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/purchases", produces = MediaType.APPLICATION_JSON_VALUE)
public class PurchasesController {
    private final PurchasesService purchasesService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PurchasesDto> getAllPurchases() {
        return purchasesService.getAll();
    }

    @RequestMapping(value = "/{purchases_id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PurchasesDto getPurchaseById(@NonNull @PathVariable("purchases_id") Long id) {
        return purchasesService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long createPurchase(@RequestBody PurchasesDto purchasesDto) {
        return purchasesService.save(purchasesDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePurchase(@RequestBody PurchasesDto purchasesDto) {
        purchasesService.update(purchasesDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePurchaseById(@NonNull @PathVariable("id") Long id) {
        purchasesService.deleteById(id);
    }
}
