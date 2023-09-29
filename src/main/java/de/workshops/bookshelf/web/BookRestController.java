package de.workshops.bookshelf.web;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

    private final JdbcTemplate jdbc;

    public BookRestController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/title")
    public List<String> getTitles() {
        return jdbc.queryForList("SELECT 'Design Patterns' UNION ALL SELECT 'Clean Code'", String.class);
    }
}
