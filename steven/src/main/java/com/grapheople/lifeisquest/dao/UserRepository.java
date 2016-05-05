package com.grapheople.lifeisquest.dao;

import com.grapheople.lifeisquest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Steven Jee
 * @since v.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
