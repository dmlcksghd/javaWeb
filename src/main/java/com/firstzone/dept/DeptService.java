package com.firstzone.dept;

import java.util.List;

public class DeptService {

	DeptDAO deptDao = new DeptDAO();

	// 1.모두조회
	public List<DeptDTO> selectAllService() {
		return deptDao.selectAll();
	}

	// 2.상세보기
	public DeptDTO selectByIdService(int deptid) {
		return deptDao.selectById(deptid);
	}

	// 3.입력
	public int insertService(DeptDTO dept) {
		
		return deptDao.insert(dept);
	}

	// 4.수정
	public int updateService(DeptDTO dept) {
		return deptDao.update(dept);
	}

	// 5.삭제
	public int deleteService(int deptid) {
		return deptDao.delete(deptid);
	}
}






