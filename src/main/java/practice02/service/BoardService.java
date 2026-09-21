package practice02.service;


import practice02.persistence.dao.BoardDAO;
import practice02.persistence.dto.BoardDTO;

import java.util.List;

public class BoardService {
    private final BoardDAO boardDAO;

    public BoardService(BoardDAO boardDAO) { //의존성 주입
        this.boardDAO = boardDAO;
    }
    public List<BoardDTO> findAll(){
        List<BoardDTO> all = boardDAO.findAll();
        return all;
    }
}

