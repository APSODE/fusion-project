package practice02;

import practice02.persistence.PooledDataSource;
import practice02.persistence.dao.BoardDAO;
import practice02.persistence.dto.BoardDTO;
import practice02.service.BoardService;
import practice02.view.BoardView;

import javax.sql.DataSource;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        DataSource dataSource = PooledDataSource.getDataSource();
        BoardDAO boardDAO = new BoardDAO(dataSource);
        BoardService boardService = new BoardService(boardDAO);
        BoardView boardView = new BoardView();

        List<BoardDTO> all = boardService.findAll();
        boardView.printAll(all);

    }
}