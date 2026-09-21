import practice01.persistence.dao.BoardDAO;
import practice01.persistence.dto.BoardDTO;
import practice01.persistence.service.BoardService;
import practice01.persistence.view.BoardView;

public static void main(String[] args) {
    BoardDAO boardDAO = new BoardDAO();
    BoardView boardView = new BoardView();
    BoardService boardService = new BoardService(boardDAO);
    List<BoardDTO> all = boardService.findAll();
    boardView.printAll(all);
}