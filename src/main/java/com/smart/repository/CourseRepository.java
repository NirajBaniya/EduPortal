package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
