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
		System.out.println("★★ mapperまでの動作確認");
//		// ★全件検索
		System.out.println("=== 全件検索 ===");
//		for (Stores row : mapper.selectStoreListAll()) {
//			System.out.println(row);
//		}   
		for (Stores row : mapper.selectStoreListPickDt()) {
			System.out.println(row);
		}
		System.out.println();
		
        // ★１件検索
        System.out.println("=== １件検索 ===");
        System.out.println(mapper.findById(1));
        System.out.println();
        
        // ★登録
        // 登録データ作成
        Stores stores = new Stores();
        stores.setStore_name("俺のフレンチ");
        stores.setStore_tel("9876-5732");
        stores.setStore_address("京都市～");
        stores.setStore_url("www.abc.com");
        stores.setUser_mail("xyz@lmn.co.jp");           
        mapper.insert(stores);
        System.out.println("=== 登録確認 ===");
        System.out.println(mapper.findById(4));
        System.out.println();
        
        // ★更新
        Stores target = mapper.findById(4);
        target.setStore_name("あたいのイタリアン");
        target.setStore_tel("0000-0000");
        target.setStore_address("心斎橋～");
        target.setStore_url("www.def.com");
        target.setUser_mail("opq@rsl.co.jp");          
        mapper.update(target);
        System.out.println("=== 更新確認 ===");
        System.out.println(mapper.findById(4));
        System.out.println();
        
        // ★削除
        mapper.delete(4);
        System.out.println("=== 削除確認 ===");
        for (Stores row : mapper.selectStoreListAll()) {
            System.out.println(row);        
        }     
        System.out.println();
    }
}