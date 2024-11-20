package com.maverick.tasks.repo;

import com.maverick.tasks.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepo extends JpaRepository<Tasks, Integer > {
}
