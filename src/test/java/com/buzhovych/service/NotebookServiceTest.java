package com.buzhovych.service;

import com.buzhovych.models.Notebook;
import com.buzhovych.repository.NotebookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NotebookServiceTest {
    private final List<Notebook> notebooksList = new ArrayList<>(List.of(
            new Notebook("Pavilion", "HP", "AMD Ryzen 5", 32, true, "Plastic", 8000.0, "15.07.2018"),
            new Notebook("k52jb", "Asus", "Intel i3", 2, false, "Plastic", 5000.0, "10.10.2012"),
            new Notebook("Kryo", "Zet", "Intel i3", 2, false, "Plastic", 5000.0, "10.10.2012")
    ));

    @Mock
    private NotebookRepository notebookRepositoryMock;

    @InjectMocks
    private NotebookService notebookService;

    @Test
    public void shouldAddNotebookList() {
        notebookService.addNotebookList(notebooksList);

        verify(notebookRepositoryMock).saveAll(notebooksList);
    }

    @Test
    public void shouldReturnAllNotebooks() {
        notebookService.getAllNotebooks();

        verify(notebookRepositoryMock).findAll();
    }

    @Test
    public void shouldReturnAllNotebooksDescendSortedByProducer() {
        String columnName = "producer";

        notebookService.getSortedBy(columnName);

        verify(notebookRepositoryMock).findAll(Sort.by(columnName).descending());
    }

    @Test
    public void shouldReturnAllWithMemoryMoreThan16gb() {
        int memory = 16;

        notebookService.getAllWithMemoryMoreThan(memory);

        verify(notebookRepositoryMock).findWithMemoryGreaterThanEqual(memory);
    }

    @Test
    public void shouldReturnAllUsedNotebooks() {
        boolean used = true;

        notebookService.getAllUsed();

        verify(notebookRepositoryMock).findByUsed(used);
    }
}
