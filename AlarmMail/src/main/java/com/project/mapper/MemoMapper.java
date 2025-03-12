package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.entity.AlarmMailEntity;

@Mapper
public interface MemoMapper {
	
	// 予約メモ進行中をAll照会
	List<AlarmMailEntity> selectAll1();
	
	// 予約メモ完了をAll照会
	List<AlarmMailEntity> selectAll2();
	
	// 予約メモ１つ照会
	AlarmMailEntity oneSelect(int Memo_No);
	
	// 約束メモ変更
	int update(AlarmMailEntity memoEntity);
	
	// 約束メモ削除
	int delete(int Memo_No);
	
	// 約束メモ登録
	int insert(AlarmMailEntity memoEntity);

}
