package com.buzhovych.controller;

import com.buzhovych.models.Notebook;
import com.buzhovych.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/notebooks")
public class NotebookController {
    private final NotebookService notebookService;

    @Autowired
    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping
    public List<Notebook> getAllNotebooks() {
        return notebookService.getAllNotebooks();
    }

    @GetMapping("/sorted-descend-by-producer")
    public List<Notebook> getSortedByProducer() {
        return notebookService.getSortedBy("producer");
    }

    @GetMapping("/16gb-plus")
    public List<Notebook> getAllWithMemoryMoreThan() {
        return notebookService.getAllWithMemoryMoreThan(16);
    }

    @GetMapping("/used")
    public List<Notebook> getAllUsed() {
        return notebookService.getAllUsed();
    }

    public void fillTable() {
        notebookService.addNotebookList(new ArrayList<>(List.of(
                new Notebook("k52jb", "Asus", "Intel i3", 2, false, "Plastic", 5000.0, "10.10.2012"),
                new Notebook("Pavilion", "HP", "AMD Ryzen 5", 32, true, "Plastic", 8000.0, "15.07.2018"),
                new Notebook("ROG Strix", "Asus", "Intel i7", 32, false, "Steel", 33000.0, "30.01.2020"),
                new Notebook("Aspire", "Acer", "AMD Ryzen 5", 8, false, "Steel", 20000.0, "10.11.2017"),
                new Notebook("IdeaPad", "Lenovo", "AMD A6", 4, false, "Plastic", 6600.0, "21.08.2015"),
                new Notebook("MacBook Air", "Apple", "Intel i3", 16, false, "Plastic", 30000.0, "11.09.2018"),
                new Notebook("G5", "Dell", "Intel i7", 32, false, "Steel", 38000.0, "12.05.2016"),
                new Notebook("IdeaPad", "Lenovo", "AMD A6", 4, true, "Plastic", 2800.0, "21.08.2015"),
                new Notebook("MateBook", "Huawei", "AMD Ryzen 5", 16, false, "Plastic", 8000.0, "02.12.2014"),
                new Notebook("Inspiron", "Dell", "Intel i3", 4, false, "Plastic", 9600.0, "27.11.2018"),
                new Notebook("Pavilion", "HP", "AMD Ryzen 5", 32, true, "STEEL", 8000.0, "15.07.2018"),
                new Notebook("Latitude", "Dell", "Intel i5", 8, true, "Plastic", 9000.0, "15.11.2020"),
                new Notebook("MacBook Pro", "Apple", "Intel i5", 8, false, "Plastic", 44000.0, "18.08.2018"),
                new Notebook("Inspiron", "Dell", "Intel i3", 4, true, "Plastic", 3200.0, "27.11.2018"),
                new Notebook("MacBook Air", "Apple", "Intel i3", 16, true, "Steel", 14000.0, "11.09.2018"),
                new Notebook("V130", "Lenovo", "Intel Celeron", 4, false, "Plastic", 8000.0, "23.10.2016"),
                new Notebook("Latitude", "Dell", "Intel i5", 8, false, "Plastic", 22000.0, "15.11.2020"),
                new Notebook("Swift 3", "Acer", "AMD Athlon", 8, false, "Plastic", 13000.0, "27.03.2020"),
                new Notebook("VivoBook", "Asus", "Intel Pentium", 4, false, "Plastic", 10000.0, "17.08.2019"),
                new Notebook("ZenBook", "Asus", "AMD Ryzen 7", 8, false, "Plastic", 24000.0, "17.08.2019")
        )));
    }
}
