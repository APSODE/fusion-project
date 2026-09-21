package practice02.persistence.dao;


import lombok.RequiredArgsConstructor;
import practice02.persistence.dto.BoardDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private final DataSource ds;

    public BoardDAO(DataSource ds) {
        this.ds = ds;
    }

    public List<BoardDTO> findAll(){

        String sql = "SELECT * FROM BOARD";
        List<BoardDTO> boardDTOs = new ArrayList<>();

        try (
                Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                BoardDTO boardDTO = new BoardDTO();

                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String contents = rs.getString("contents");
                LocalDateTime regdate =
                        rs.getTimestamp("regdate").toLocalDateTime();
                int hit = rs.getInt(6);

                boardDTO.setId(id);
                boardDTO.setTitle(title);
                boardDTO.setWriter(writer);
                boardDTO.setContents(contents);
                boardDTO.setRegdate(regdate);
                boardDTO.setHit(hit);

                boardDTOs.add(boardDTO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return boardDTOs;
    }
}
