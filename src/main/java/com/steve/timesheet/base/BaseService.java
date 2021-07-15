package com.steve.timesheet.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseService<E extends BaseEntity, R extends BaseRepository<E>> {

    protected ApplicationContext context;

    private final R repository;

    protected final ObjectMapper mapper;


    public BaseService(ApplicationContext context, R repository) {
        this.context = context;
        this.repository = repository;
        this.mapper = context.getBean(ObjectMapper.class);
    }


    public E create(E e) {
        return this.repository.save(e);
    }

    public E findById(long id) {
        return this.repository.findById(id).orElseThrow();
    }

    public List<E> findAll() {
        return this.repository.findAll();
    }

    public Page<E> findPage(Pageable pageable){
        return this.repository.findAll(pageable);
    }

    public E replaceById(long id, E e) {
        return replace(findById(id), e);
    }

    public E updateById(long id, JsonPatch patch) {
        return apply(findById(id), patch);
    }

    public E removeById(long id) {
       return remove(this.findById(id));
    }

    private E replace(E source, E target) {
        target.setId(source.getId());
        target.setCreated(source.getCreated());
        target.setUpdated(source.getUpdated());
        return target;
    }

    private E remove(E e){
        this.repository.delete(e);
        return e;
    }

    private E apply(E e, JsonPatch patch) {
        try {
            JsonNode json = this.mapper.convertValue(e, JsonNode.class);
            return (E) this.mapper.treeToValue(patch.apply(json), e.getClass());
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        } catch (JsonPatchException exception) {
            throw new RuntimeException(exception);
        }

    }
}
