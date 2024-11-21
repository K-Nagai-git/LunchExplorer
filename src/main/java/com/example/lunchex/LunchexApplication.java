// 更新　永井　2024/10/22 15:29　テスト用をコメントアウト他
// 更新　永井　2024/11/14 テスト用を削除
package com.example.lunchex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
//@MapperScan("com.example.lunchex.repository")
public class LunchexApplication {
	public static void main(String[] args) {
		SpringApplication.run(LunchexApplication.class, args);
	}
}
