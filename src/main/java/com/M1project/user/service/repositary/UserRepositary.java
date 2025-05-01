package com.M1project.user.service.repositary;

import com.M1project.user.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary  extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for the User entity
    // You can add custom query methods here if needed

}
