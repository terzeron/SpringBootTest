package com.terzeron.springboot;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface EmployeeService {
    List<Employee> getList();

    Employee save(@NotNull @Valid final Employee employee);

}
