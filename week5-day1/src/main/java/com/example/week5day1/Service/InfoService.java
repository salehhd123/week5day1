package com.example.week5day1.Service;


import com.example.week5day1.Api.ApiException;
import com.example.week5day1.Dto.InfoDto;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Model.Info;
import com.example.week5day1.Repository.CustomerRepository;
import com.example.week5day1.Repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InfoService {

   private final CustomerRepository customerRepository;
   private final InfoRepository infoRepository;
    public  void addInfo(InfoDto infoDto){
        Customer customer = customerRepository.findCustomerById(infoDto.getCustomer_Id());

        Info info = new Info(null,infoDto.getAge(),infoDto.getEmail(),customer);
        infoRepository.save(info);
    }


    public void update(InfoDto infoDto){
        Info info = infoRepository.findInfoById(infoDto.getCustomer_Id());
        info.setAge(infoDto.getAge());
        info.setEmail(infoDto.getEmail());
        infoRepository.save(info);
    }


    public void  delete(Integer id){
        Customer customer = customerRepository.findCustomerById(id);
        Info info = customer.getInfo();
        infoRepository.delete(info);
    }


}
