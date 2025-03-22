package com.kodilla.hibernate.tasklist.repository;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TaskListRepositoryTestSuite {

    @Autowired
    private TaskListRepository taskListRepository;

    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("Test List", "This is a test description");
        taskListRepository.save(taskList);
        String listName = taskList.getListName();

        // When
        List<TaskList> result = taskListRepository.findByListName(listName);

        // Then
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Test List", result.get(0).getListName());
        Assertions.assertEquals("This is a test description", result.get(0).getDescription());

        // CleanUp
        int id = result.get(0).getId();
        taskListRepository.deleteById(id);
    }
}
