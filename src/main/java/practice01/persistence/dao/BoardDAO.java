package practice01.persistence.dao;


import java.sql.*;
import practice01.persistence.dto.BoardDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    public List<BoardDTO> findAll(){

        String sql = "SELECT * FROM BOARD";
        String url = "jdbc:mysql://100.101.10.83/fusion-project?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";

        List<BoardDTO> boardDTOs = new ArrayList<>();

        try (
                Connection conn = DriverManager.getConnection(url, "apsode", "kunbolee0212@");
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