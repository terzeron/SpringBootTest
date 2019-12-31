package com.terzeron.springboot;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository repository;
    private final EmployeeResourceAssembler assembler;

    @GetMapping("/employees")
    public Resources<Resource<Employee>> all() {
        List<Resource<Employee>> employees = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(employees,
                linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @PostMapping("/employees")
    public ResponseEntity<Resource<Employee>> newEmployee(@RequestBody Employee newEmployee) throws URISyntaxException {
        Resource<Employee> resource = assembler.toResource(repository.save(newEmployee));
        return ResponseEntity.created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }
    // Location header로 응답을 줌

    @GetMapping("/employees/{id}")
    public Resource<Employee> one(@PathVariable Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return assembler.toResource(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Resource<Employee>> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) throws URISyntaxException {
        Employee updatedEmployee = repository.findById(id)
                .map(employee -> {
                    // update by id
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    // create with id
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
        Resource<Employee> resource = assembler.toResource(updatedEmployee);

        return ResponseEntity.created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Resource<Employee>> deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
