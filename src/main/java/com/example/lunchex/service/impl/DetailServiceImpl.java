// 作成　深田　1016　メモ：内容をあまり理解してない節がある
// 　　　　　　　　　メモ：Integer id のidは別の名前でいいかも



package com.example.lunchex.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lunchex.entity.Detail;
//エンティティ
import com.example.lunchex.entity.Stores;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor

public class DetailServiceImpl {

	private final Mapper detailMapper; 
	
	private final DetailMapper detailMapper;  
	
	@Override
	public List< Detail> findAllDetail() {
        return  DetailMapper.selectAll();
    }

	@Override
    public Stores findByIdDetail(Integer id) {
        return  DetailMapper.selectById(id);
    }

	
	@Override
    public void insertDetail (Detail detail) {
		DetailMapper.insert(detail);
    }

	@Override
	    public void updateDetail(Detail detail) {
		DetailMapper.update(detail);
	    }

	 @Override
	 public void deleteDetail(Integer id) {
		 DetailMapper.delete(id);
	    }
	
	}
