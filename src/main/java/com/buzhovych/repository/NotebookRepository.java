package com.buzhovych.repository;

import com.buzhovych.models.Notebook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends PagingAndSortingRepository<Notebook, Long> {

    List<Notebook> findByUsed(Boolean used);

    @Query("FROM Notebook notebook WHERE notebook.memoryGb >= :memoryGb")
    List<Notebook> findWithMemoryGreaterThanEqual(int memoryGb);
}
