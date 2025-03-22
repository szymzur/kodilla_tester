package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.CodeCoverageApplication; // Import klasy głównej aplikacji
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = CodeCoverageApplication.class) // Wskazanie klasy głównej aplikacji
class TaskListRepositoryTestSuite {

    @Autowired
    private TaskListRepository taskListRepository; // Repozytorium z automatycznym wstrzykiwaniem zależności

    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("Test List", "This is a test description");
        taskListRepository.save(taskList); // Zapisujemy obiekt TaskList w bazie danych
        String listName = taskList.getListName();

        // When
        List<TaskList> result = taskListRepository.findByListName(listName);

        // Then
        Assertions.assertEquals(1, result.size()); // Upewniamy się, że znaleziono dokładnie jeden wynik
        Assertions.assertEquals("Test List", result.get(0).getListName()); // Weryfikujemy nazwę listy
        Assertions.assertEquals("This is a test description", result.get(0).getDescription()); // Weryfikujemy opis

        // CleanUp
        int id = result.get(0).getId();
        taskListRepository.deleteById(id); // Usuwamy dane z bazy
    }
}
