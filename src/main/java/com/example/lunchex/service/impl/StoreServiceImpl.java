// 作成　深田　1016　メモ：内容をあまり理解してない節がある
// 　　　　　　　　　メモ：Integer id のidは別の名前でいいかも
package com.example.lunchex.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//エンティティ
import com.example.lunchex.entity.Stores;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor


public class StoreServiceImpl {
	
	private final StoreMapper stroeMapper;  
		
	@Override
	public List<Stores> findAllStores() {
        return StoreMapper.selectAll();
    }

	@Override
    public Stores findByIdStores (Integer id) {
        return StoreMapper.selectById(id);
    }

	
	@Override
    public void insertStores(Store store) {
        StoreMapper.insert(store);
    }

	@Override
	    public void updateStores(Stroe store) {
		   StoreMapper.update(store);
	    }

	 @Override
	 public void deleteStores(Integer id) {
		   StoreMapper.delete(id);
	    }
	
	}

	
	
	
	
	
	
	
	
	
	

