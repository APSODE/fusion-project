package practice01.persistence.view;

import practice01.persistence.dto.BoardDTO;

import java.util.List;
public class BoardView {
    public void printAll(List<BoardDTO> dtos) {
        System.out.println("모든 게시글");
        for (BoardDTO dto : dtos) {
            System.out.println("dto.toString() = " + dto.toString());
        }
    }
}