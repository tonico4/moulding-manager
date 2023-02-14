package com.mpm.mouldingmanager.repositories;

import com.mpm.mouldingmanager.entities.Mould;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouldRepository extends JpaRepository<Mould, Long> {
}
