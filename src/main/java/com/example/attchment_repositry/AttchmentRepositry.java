package com.example.attchment_repositry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attchment_res_model.AttchmentResModel;



@Repository
public interface AttchmentRepositry extends JpaRepository<AttchmentResModel, Long>{

}
