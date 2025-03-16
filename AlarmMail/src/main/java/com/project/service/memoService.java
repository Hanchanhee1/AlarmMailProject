package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.memoEntity;
import com.project.mapper.MemoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class memoService {
	
	private final MemoMapper memoMapper;
	
	// 予約メモ進行中をAll照会
	public List<memoEntity> memoSelectAll() {
		return memoMapper.memoSelectAll();
	}
	
	// 予約メモ完了をAll照会
	public List<memoEntity> completSelectAll() {
		return memoMapper.completSelectAll();
	}
	
	// 予約メモ１つ照会
	public memoEntity memoOneSelect(int memo_Id) {
		return memoMapper.memoOneSelect(memo_Id);
	}
	
	// 約束メモ変更
	public int memoUpdate(memoEntity memoEntity) {
		return memoMapper.memoUpdate(memoEntity);
	}
	// 約束メモ削除
	public int memoDelete(int memo_Id) {
		return memoMapper.memoDelete(memo_Id);
	}
	
	// 約束メモ登録
	public int memoInsert(memoEntity memoEntity) {
		return memoMapper.memoInsert(memoEntity);
	}
	
	// メール送信条件
	public List<memoEntity> emailSend() {
		return memoMapper.emailSend();
	}
	
	// メモ状態変更
	public int updateMemoStatus() {
		return memoMapper.updateMemoStatus();
	}
}
