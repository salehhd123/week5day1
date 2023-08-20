package com.example.week5day1.Controller;


import com.example.week5day1.Api.ApiResponse;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gg")
public class CustomerController {
private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(customerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Customer customer){
        customerService.add(customer);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Customer customer){
        customerService.update(id,customer);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        customerService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


}
