package com.example.lunchex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.lunchex.entity.Stores;
import com.example.lunchex.repository.LunchexListMapper;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
//@MapperScan("com.example.lunchex.repository")
public class LunchexApplication {
	public static void main(String[] args) {
		SpringApplication.run(LunchexApplication.class, args)
		.getBean(LunchexApplication.class).exe();
	}

	//    /** DI */
	private final LunchexListMapper mapper;
	//    
	public void exe() {
//		// ★全件検索
		System.out.println("=== 全件検索 ===");
		for (Stores row : mapper.selectStoreListAll()) {
			System.out.println(row);
		}   
        // ★１件検索
        System.out.println("=== １件検索 ===");
        System.out.println(mapper.findById(1));
//        // ★登録
//        // 登録データ作成
//        ToDo todo = new ToDo();
//        todo.setTodo("リポジトリのテスト");
//        todo.setDetail("DBへの登録処理");
//        mapper.insert(todo);
//        System.out.println("=== 登録確認 ===");
//        System.out.println(mapper.selectById(4));
//        // ★更新
//        ToDo target = mapper.selectById(4);
//        target.setTodo("リポジトリのテスト：更新");
//        target.setDetail("DBへの更新処理");        
//        mapper.update(target);
//        System.out.println("=== 更新確認 ===");
//        System.out.println(mapper.selectById(4));
//        // ★削除
//        mapper.delete(4);
//        System.out.println("=== 削除確認 ===");
//        for (ToDo row : mapper.selectAll()) {
//            System.out.println(row);
//        }        
    }
}