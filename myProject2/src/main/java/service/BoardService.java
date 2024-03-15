package service;

import java.util.ArrayList;

import dao.BoardDao;
import dto.BoardDto;
import dto.Pagination;



public class BoardService {

    private static final int listSize = 3;
    private static final int paginationSize = 3;

    public ArrayList<BoardDto> getMsgList(int pageNo) {
       return new BoardDao().selectList((pageNo - 1) * listSize, listSize);
    }

    public ArrayList<Pagination> getPagination(int pageNo) {

        ArrayList<Pagination> pgnList = new ArrayList<Pagination>();

        int numRecords = new BoardDao().getNumRecords();
        int numPages = (int)Math.ceil((double)numRecords / listSize);

        int firstLink = ((pageNo - 1) / paginationSize)
                        * paginationSize + 1;
        int lastLink = firstLink + paginationSize - 1;
        if (lastLink > numPages) {
            lastLink = numPages;
        }

        if (firstLink > 1) {
            pgnList.add(
                   new Pagination("이전", pageNo - paginationSize, false));
        }

        for (int i = firstLink; i <= lastLink; i++) {
            pgnList.add(new Pagination("" + i, i, i == pageNo));
        }

        if (lastLink < numPages) {
            int tmpPageNo = pageNo + paginationSize;
            if (tmpPageNo > numPages) {
                tmpPageNo = numPages;
            }
            pgnList.add(new Pagination("다음", tmpPageNo, false));
        }

        return pgnList;
    }


    public BoardDto getMsg(int num) {
        BoardDto dto = new BoardDao().selectOne(num, true);

        dto.setTitle(dto.getTitle().replace (" ",  "&nbsp;"));
        dto.setContent(dto.getContent().replace("  ",  "&nbsp;")
                                       .replace("\n", "<br>"));

        return dto;
    }

    public BoardDto getMsgForWrite(int num) {
        return new BoardDao().selectOne(num, false);
    }

    public void writeMsg(String name, String title, String content, int memberno)
            throws Exception {
        if (name  == null || name.length()  == 0 ||
            title   == null || title.length()   == 0 ||
            content == null || content.length() == 0) {
           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }
        BoardDto dto = new BoardDto();
        dto.setName    (name);
        dto.setTitle   (title);
        dto.setContent (content);
        dto.setMemberno(memberno);
        new BoardDao().insertOne(dto);
    }

    public void updateMsg(String title, String content, int boardno)
                    throws Exception {
        if (title   == null || title.length()   == 0 ||
            content == null || content.length() == 0) {
           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }
        BoardDto dto = new BoardDto();
        dto.setBoardno(boardno);        
        dto.setTitle  (title  );
        dto.setContent(content);        
        new BoardDao().updateOne(dto);
    }

    public void deleteMsg(int boardno) {
        new BoardDao().deleteOne(boardno);
    }
}