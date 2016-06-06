package com.srh.repositories;

import com.srh.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

/**
 * Created by RaghavendraKulkarni on 6/6/2016.
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Serializable>{
}
