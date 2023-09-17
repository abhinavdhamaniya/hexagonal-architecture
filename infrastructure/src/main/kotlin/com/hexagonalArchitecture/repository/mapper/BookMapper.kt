package com.hexagonalArchitecture.repository.mapper

import com.hexagonalArchitecture.book.Book
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.*

@Component
class BookMapper : RowMapper<Book> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Book =
        Book(
            id = UUID.fromString(rs.getString("ID")),
            name = rs.getString("NAME"),
            author = rs.getString("AUTHOR"),
            genre = rs.getString("GENRE")
        )
}