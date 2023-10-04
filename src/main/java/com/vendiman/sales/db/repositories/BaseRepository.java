package com.vendiman.sales.db.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

	@Query("SELECT e FROM #{#entityName} e")
	public List<T> findAll();

	@Query("SELECT e FROM #{#entityName} e")
	public Page<T> findAll(Pageable page);

	@Query("SELECT e FROM #{#entityName} e WHERE e.id = ?1")
	public T findOne(ID id);

}