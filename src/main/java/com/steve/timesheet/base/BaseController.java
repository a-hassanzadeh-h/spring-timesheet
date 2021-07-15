package com.steve.timesheet.base;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<E extends BaseEntity, S extends BaseService<E, ?>> {

    private S service;

    public BaseController(S service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<E> create(@RequestBody E e) {
        return ResponseEntity.ok(this.service.create(e));
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<E>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping
    public ResponseEntity<Page<E>> findPage(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.service.findPage(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> replaceById(@PathVariable long id, @RequestBody E e) {
        return ResponseEntity.ok(this.service.replaceById(id, e));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<E> updateById(@PathVariable long id, @RequestBody JsonPatch patch) {
        return ResponseEntity.ok(this.service.updateById(id, patch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<E> removeById(@PathVariable long id) {
        return ResponseEntity.ok(this.service.removeById(id));
    }


}
