package com.example.week5day1.Service;


import com.example.week5day1.Api.ApiException;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Repository.CustomerRepository;
import com.example.week5day1.Repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private  final CustomerRepository customerRepository;
    private final InfoRepository infoRepository;


    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public void add(Customer customer){
        customerRepository.save(customer);
    }

    public void update(Integer id,Customer customer){
        Customer customer1 = customerRepository.findCustomerById(id);
        if (customer1==null){
            throw new ApiException("not found");
        }
        customer1.setName(customer.getName());
        customerRepository.save(customer1);

    }

    public void delete(Integer id){
        Customer customer = customerRepository.findCustomerById(id);
        if (customer==null){
            throw new ApiException("not found");
        }
        infoRepository.deleteById(id);
        customerRepository.delete(customer);
    }



}
