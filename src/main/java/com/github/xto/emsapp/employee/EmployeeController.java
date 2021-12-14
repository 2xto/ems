package com.github.xto.emsapp.employee;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor

@RestController
@RequestMapping("/employees")
class EmployeeController {
    private final EmployeeRepository repository;

    @PostMapping
    ResponseEntity<Employee> createEmployee(@RequestBody Employee toCreate) {
        Employee result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> readEmployee(@PathVariable int id){
        return repository.findById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
