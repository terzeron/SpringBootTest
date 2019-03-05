package com.terzeron.springboot;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee save(@NotNull @Valid final Employee employee) {
        LOGGER.debug("Creating {}", employee);
        return employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return employeeRepository.findAll();
    }
}
