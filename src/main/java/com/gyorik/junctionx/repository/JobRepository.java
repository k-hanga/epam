package com.gyorik.junctionx.repository;

import com.gyorik.junctionx.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}