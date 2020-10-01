package com.buzhovych;

import com.buzhovych.controller.NotebookController;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements ApplicationRunner {
    private final NotebookController notebookController;

    public Main(NotebookController notebookController) {
        this.notebookController = notebookController;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        notebookController.fillTable();
    }
}
