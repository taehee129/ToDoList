package model.board;

import java.util.List;

public interface MemoService {
	int insertMemo(MemoVO vo);
	void updateMemo(MemoVO vo);
	void deleteMemo(MemoVO vo);
	MemoVO getDBDate(MemoVO vo);
	List<MemoVO> getDBList(MemoVO vo);

}
