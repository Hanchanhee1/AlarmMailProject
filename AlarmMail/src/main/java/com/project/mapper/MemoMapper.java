package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.entity.memoEntity;

@Mapper
public interface MemoMapper {
	
	// 予約メモ進行中をAll照会
	List<memoEntity> memoSelectAll();
	
	// 予約メモ完了をAll照会
	List<memoEntity> completSelectAll();
	
	// 予約メモ１つ照会
	memoEntity memoOneSelect(int memo_Id);
	
	// 約束メモ変更
	int memoUpdate(memoEntity memoEntity);
	
	// 約束メモ削除
	int memoDelete(int memo_Id);
	
	// 約束メモ登録
	int memoInsert(memoEntity memoEntity);
	
	// メール送信条件
	List<memoEntity> emailSend();
	
	// メモ状態変更
	int updateMemoStatus();
	
}
