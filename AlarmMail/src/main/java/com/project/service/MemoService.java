package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.AlarmMailEntity;
import com.project.mapper.MemoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoService {
	
	private final MemoMapper memoMapper;
	
	// 予約メモ進行中をAll照会
	public List<AlarmMailEntity> getAllmemo1() {
		return memoMapper.selectAll1();
	}
	
	// 予約メモ完了をAll照会
	public List<AlarmMailEntity> getAllmemo2() {
		return memoMapper.selectAll2();
	}
	
	// 予約メモ１つ照会
	public AlarmMailEntity oneMemo(int Memo_No) {
		return memoMapper.oneSelect(Memo_No);
	}
	
	// 約束メモ変更
	public int updateMemo(AlarmMailEntity memoEntity) {
	    return memoMapper.update(memoEntity);
	}
	// 約束メモ削除
	public int deleteMemo(int Memo_No) {
	    return memoMapper.delete(Memo_No);
	}
}
