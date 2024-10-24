package com.example.lunchex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**作成日：2024/10/24 */
/**作成者：糸山  		*/
/**更新日：  			*/
/**更新者：  			*/

//CahtGptで調べたコード
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;

//perplexityで調べたコード
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//SrcurityFileterChainのBean定義
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
			//★HTTPリクエストに対するセキュリティ設定
			.authorizeHttpRequests(authz -> authz
			//「/login」へのアクセスは認証を必要としない
			.requestMatchers("/login").permitAll()
			// 認証が必要なページ(htmlが出来次第設定）
			//.requestMatchers("/admin/**", "/secure/**", "/home", "/").authenticated() 
			//その他のリクエストは認証が必要
			//.anyRequest().authenticated())
			//その他のページは認証不要
			.anyRequest().permitAll())
			//★フォームベースのログイン設定
			.formLogin(form -> form
			//カスタムログインページのURLを指定
			.loginPage("/login")
			);
			
		return http.build();
	}
}
//perplexityで調べたコード
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/", "/home", "/public/**").permitAll() // 認証不要のページ
//                .requestMatchers("/admin/**", "/secure/**").authenticated() // 認証が必要なページ
//                .anyRequest().permitAll() // その他のページは認証不要
//            )
//            .formLogin((form) -> form
//                .loginPage("/login")
//                .permitAll()
//            )
//            .logout((logout) -> logout
//                .permitAll()
//            );
//
//        return http.build();
//    }	
    
	//CahtGptで調べたコード（参考　※このまま動かしたらエラー）
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/", "/home", "/css/**", "/js/**", "/login").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin((form) -> form
//                .loginPage("/login")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/dashboard", true)
//                .failureUrl("/login?error=true")
//                .permitAll()
//            )
//            .logout((logout) -> logout
//                .logoutSuccessUrl("/login?logout=true")
//                .permitAll()
//            );
//
//        return http.build();
//    }

