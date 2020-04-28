package com.mycompany;

import com.mycompany.dao.impl.UserRepository;
import com.mycompany.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {

//	@Autowired
//	@Qualifier("userDao1")
//	private UserDaoInter userDao;
//
	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceInter userService;

	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr=new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i = 0; i < 10; i++) {
					userService.getAllUser();
				}
//				User u=userRepository.findById(3).get();
//				System.out.println(userRepository.findByEmail("movsum617@gmail.com"));
//				System.out.println(userRepository.findByName("Movsum"));
//				List<User> list=userRepository.findAll();
//				System.out.println(list);
//				list=userRepository.findAll(Sort.by(Sort.Order.desc("name")));
//				System.out.println(list);
			}
		};
		return clr;
	}

//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr=new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				List<User> list=userDao.getAllUser();
//				System.out.println(list);
//			}
//		};
//		return clr;
//	}

}
