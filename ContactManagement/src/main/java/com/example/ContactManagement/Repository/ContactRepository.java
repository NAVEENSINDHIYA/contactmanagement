package com.example.ContactManagement.Repository;

import com.example.ContactManagement.Entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity,Long>, JpaSpecificationExecutor<ContactEntity> {
}
