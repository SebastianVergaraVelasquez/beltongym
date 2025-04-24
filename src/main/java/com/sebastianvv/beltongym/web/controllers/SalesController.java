package com.sebastianvv.beltongym.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.sebastianvv.beltongym.domain.services.product.IProduct;
import com.sebastianvv.beltongym.domain.services.saleDetail.ISaleDetail;
import com.sebastianvv.beltongym.domain.services.sales.ISales;
import com.sebastianvv.beltongym.domain.services.user.IUser;
import com.sebastianvv.beltongym.persistence.entities.Product;
import com.sebastianvv.beltongym.persistence.entities.ProductDTO;
import com.sebastianvv.beltongym.persistence.entities.SaleDTO;
import com.sebastianvv.beltongym.persistence.entities.SaleDetail;
import com.sebastianvv.beltongym.persistence.entities.SaleDetailDTO;
import com.sebastianvv.beltongym.persistence.entities.Sales;
import com.sebastianvv.beltongym.persistence.entities.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/belton/sales")
public class SalesController {
    @Autowired
    private ISales salesService;
    @Autowired
    private ISaleDetail saleDetailService;
    @Autowired
    private IUser userService;
    @Autowired
    private IProduct productService;

    @GetMapping
    public List<Sales> getAll() {
        return salesService.findAll();
    }

    @GetMapping("/{id}")
    public Sales getById(@PathVariable int id) {
        return salesService.findById(id).get();
    }

    @PostMapping
    public Sales save(@RequestBody SaleDTO saleDTO) {
        Sales sale = new Sales();

        Optional<User> userOpt = userService.findByDocument(saleDTO.getDocument());
        if (userOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Usuario no encontrado con el documento: " + saleDTO.getDocument());
        }

        sale.setUser(userOpt.get());
        sale.setDate(saleDTO.getDate());

        Sales savedSale = salesService.save(sale);

        double total = 0.0;
        for (SaleDetailDTO saleDetailDTO : saleDTO.getSaleDetails()) {
            ProductDTO productDTO = saleDetailDTO.getProduct();
            Optional<Product> product = productService.findById(productDTO.getId());
            double subtotal = product.get().getPrice() * saleDetailDTO.getQuantity();
            total += subtotal;

            SaleDetail saleDetail = new SaleDetail();
            saleDetail.setProduct(product.get());
            saleDetail.setQuantity(saleDetailDTO.getQuantity());
            saleDetail.setSale(savedSale);
            saleDetailService.save(saleDetail);
        }

        savedSale.setTotal(total);
        return salesService.save(savedSale);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        salesService.deleteById(id);
    }
}