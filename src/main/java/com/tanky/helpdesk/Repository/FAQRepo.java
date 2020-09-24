package com.tanky.helpdesk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tanky.helpdesk.Entity.FAQEntity;

@Repository
public interface FAQRepo extends JpaRepository<FAQEntity, Long> {



}
