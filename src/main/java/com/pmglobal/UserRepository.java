package com.pmglobal;

import java.util.List;



import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

	List<User> findAll(Sort sort);
	
	@Query(value="SELECT * FROM user    WHERE date_of_birth= :val",nativeQuery = true)
	List<User> findAll(@Param("val") String val);
	
	@Query(value="SELECT * FROM user WHERE firstname =:val",nativeQuery = true)
	List<User> findAllA(@Param("val") String val);
	
	@Query(value="SELECT * FROM user    WHERE lastname= :val",nativeQuery = true)
	List<User> findAllB(@Param("val") String val);
	
	@Query(value="SELECT * FROM user WHERE gender = :val",nativeQuery = true)
	List<User> findAllC(@Param("val") String val);
}
