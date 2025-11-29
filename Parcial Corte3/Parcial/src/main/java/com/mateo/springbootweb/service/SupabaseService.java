package com.example.springbootweb.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class SupabaseService {
    private final JdbcTemplate jdbc;

    @Autowired
    public SupabaseService(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    // Simple example: fetch rows from 'items' table in Supabase (Postgres)
    public List<Map<String, Object>> listItems() {
        String sql = "SELECT id, name, description FROM items";
        return jdbc.queryForList(sql);
    }
}
