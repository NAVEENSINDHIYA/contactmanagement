package com.example.ContactManagement.Specification;

import com.example.ContactManagement.Entity.ContactEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactSpecification  {
    public Specification<ContactEntity> getContacts(ContactEntity request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            System.out.println("In Specification"+ request.getFirstName());
            if (request.getEmail() != null && !request.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("email"), request.getEmail()));
            }
            if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("firstName"), request.getFirstName()));
            }
            if (request.getLastName() != null && !request.getLastName().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("lastName"), request.getLastName()));
            }
            query.orderBy(criteriaBuilder.desc(root.get("firstName")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
