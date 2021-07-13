package com.steve.timesheet.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<E> extends JpaRepository<E,Long> {
}
