package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memoService")
public class MemoServiceImpl implements MemoService {
	@Autowired
	SpringMemoDAO memoDAO;

	@Override
	public int insertMemo(MemoVO vo) {
		return memoDAO.insertMemo(vo);
		
	}

	@Override
	public void updateMemo(MemoVO vo) {
		memoDAO.updateMemo(vo);
		
	}

	@Override
	public void deleteMemo(MemoVO vo) {
		memoDAO.deleteMemo(vo);
		
	}

	@Override
	public MemoVO getDBDate(MemoVO vo) {
		return memoDAO.getDBDate(vo);
		
	}

	@Override
	public List<MemoVO> getDBList(MemoVO vo) {
		return memoDAO.getDBList(vo);
		
	}

}
