package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Application;

public interface ApplicationRepository  extends JpaRepository<Application, Long>{

}
