package com.srh.mongo.repositories;

import com.srh.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

/**
 * Created by RaghavendraKulkarni on 6/7/2016.
 */

public interface PersonRepository extends PagingAndSortingRepository<Person,Serializable> {
}
