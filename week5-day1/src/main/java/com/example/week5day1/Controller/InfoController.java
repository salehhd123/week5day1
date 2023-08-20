package com.example.week5day1.Controller;


import com.example.week5day1.Api.ApiResponse;
import com.example.week5day1.Dto.InfoDto;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Service.InfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class InfoController {
    private final InfoService infoService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid InfoDto infoDto){
        infoService.addInfo(infoDto);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update")
    public ResponseEntity update( @RequestBody @Valid InfoDto infoDto){
        infoService.update(infoDto);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        infoService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

}


