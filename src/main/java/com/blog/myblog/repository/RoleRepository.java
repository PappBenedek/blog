package com.blog.myblog.repository;

import com.blog.myblog.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
