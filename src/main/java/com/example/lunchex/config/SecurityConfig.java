package com.example.lunchex.config;
/**作成日：2024/10/22 */
/**作成者：糸山  		*/
/**更新日：  			*/
/**更新者：  			*/

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {


//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//      http
//          .authorizeHttpRequests((requests) -> requests
//              .requestMatchers("/", "/home", "/css/**", "/js/**", "/login", "/index").permitAll()
//              .anyRequest().authenticated()
//          )
//          .formLogin((form) -> form
//              .loginPage("/login")
//              .loginProcessingUrl("/perform_login")
//              .defaultSuccessUrl("/index", false)
//              .failureUrl("/login?error=true")
//              .permitAll()
//          )
//          .logout((logout) -> logout
//              .logoutSuccessUrl("/login?logout=true")
//              .permitAll()
//          );
//
//      return http.build();
//  }	
	
	
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

}
