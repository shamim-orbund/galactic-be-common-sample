package com.orbund.galactic.be.common.sample.service;

import com.orbund.galactic.be.common.entities.dto.BaseDto;

import java.util.Collection;
import java.util.Optional;


public interface GeneralService<S extends BaseDto> {

    Collection<S> getAll();
    Optional<S> findById(long id);

    Optional<S> persist(S dto);
    Optional<S> update(long id, S dto);

    boolean remove(long id);

}
