package com.sam.digicertbooksdemo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sam.digicertbooksdemo.services.BookService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void getBook_ShouldReturn404WhenIdIsInvalid() throws Exception {

        when(bookService.getBook(999)).thenReturn(null);

        mockMvc.perform(
            MockMvcRequestBuilders.get("/books/999")
        )
        .andExpect(status().isNotFound());
            
    }

}
