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

	public MemberDto getMember(int num) {
		MemberDto dto = new MemberDao().selectOne(num);
		dto.setId(dto.getId());
		dto.setEmail(dto.getEmail());
		return dto;
	}

	public MemberDto getMsgForWrite(int num) {
		return new MemberDao().selectOne(num);
	}

	public void signUp(String id, String email, String name) throws Exception {
		if (id == null || id.length() == 0 || 
			email == null || email.length() == 0 || 
			name == null || name.length() == 0) 
		{throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
		}
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setId(id);
		dto.setEmail(email);
		
		new MemberDao().insertOne(dto);
	}

	public void updateMember(String name, String email, int memberno) 
			throws Exception {
		if (name == null || name.length() == 0 || 
			email == null || email.length() == 0) {
			throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
		}
		MemberDto dto = new MemberDto();
		dto.setMemberno(memberno);
		dto.setEmail(email);
		dto.setName(name);		
		new MemberDao().updateOne(dto);
	}

	public void deleteMsg(int memberno) {
		new MemberDao().deleteOne(memberno);
	}
}