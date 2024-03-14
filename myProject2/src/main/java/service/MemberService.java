package service;

import java.util.ArrayList;

import dao.BoardDao;
import dao.MemberDao;
import dto.MemberDto;
import dto.Pagination;

public class MemberService {

	private static final int listSize = 5;
	private static final int paginationSize = 5;

	public ArrayList<MemberDto> getMsgList(int pageNo) {
		return new MemberDao().selectList((pageNo - 1) * listSize, listSize);
	}

	public ArrayList<Pagination> getPagination(int pageNo) {

		ArrayList<Pagination> pgnList = new ArrayList<Pagination>();

		int numRecords = new MemberDao().getNumRecords();
		int numPages = (int) Math.ceil((double) numRecords / listSize);

		int firstLink = ((pageNo - 1) / paginationSize) * paginationSize + 1;
		int lastLink = firstLink + paginationSize - 1;
		if (lastLink > numPages) {
			lastLink = numPages;
		}

		if (firstLink > 1) {
			pgnList.add(new Pagination("이전", pageNo - paginationSize, false));
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

	public MemberDto getMsg(int num) {
		MemberDto dto = new MemberDao().selectOne(num);

		dto.setId(dto.getId().replace(" ", "&nbsp;"));
		dto.setEmail(dto.getEmail().replace("  ", "&nbsp;").replace("\n", "<br>"));

		return dto;
	}

	public MemberDto getMsgForWrite(int num) {
		return new MemberDao().selectOne(num);
	}

	public void signUpMsg(int memberno, String id, String email, String name) throws Exception {

		if (id == null || id.length() == 0 || email == null
			|| email.length() == 0 || name == null || name.length() == 0) {
			throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
		}
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setId(id);
		dto.setEmail(email);
		dto.setMemberno(memberno);

		new MemberDao().insertOne(dto);
	}

	public void updateMsg(String id, String email, String name, int memberno) throws Exception {
		System.out.println(name + email);
		if (name == null || name.length() == 0 || 
			email == null || email.length() == 0) {
			throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
		}
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setEmail(email);
		dto.setName(name);
		dto.setMemberno(memberno);
		new MemberDao().updateOne(dto);
	}

	public void deleteMsg(int memberno) {
		new MemberDao().deleteOne(memberno);
	}
}