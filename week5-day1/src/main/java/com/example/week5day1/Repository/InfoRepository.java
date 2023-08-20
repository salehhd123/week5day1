package com.example.week5day1.Repository;

import com.example.week5day1.Model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository<Info,Integer> {

Info findInfoById(Integer id);
}
