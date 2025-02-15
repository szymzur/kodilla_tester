package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerOtherTest {
    @Mock
    private BookService bookService;
    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        MockMvcBuilders RestAssuredMockMvc = null;
        RestAssuredMockMvc.standaloneSetup(bookController);
    }

    @Test
    void shouldFetchBooks() {
        // given
        when(bookService.getBooks())
                .thenReturn(List.of(
                        new BookDto("Title 1", "Author 2"),
                        new BookDto("Title 2", "Author 2"))
                );

        // when then
        RestAssuredMockMvc.when()
                .get("/books")
                .then()
                .body("$.size()", Matchers.equalTo(2))
                .body("[0].title", Matchers.equalTo("Title 1"))
                .body("[0].author", Matchers.equalTo("Author 2"))
                .body("[1].title", Matchers.equalTo("Title 2"))
                .body("[1].author", Matchers.equalTo("Author 2"))
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void shouldAddBook() {
        BookDto newBook = new BookDto("New Title", "New Author");

        // given
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(newBook)
                .when()
                .post("/books")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }
}
