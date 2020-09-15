package com.pmglobal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(HashMap<String,String> args){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		
		if(args.get("sort_field") == null && args.get("sort_order_mode") == null 
				&& args.get("filter_field") == null && args.get("filter_value") == null &&
				args.get("page") == null && args.get("page_size") == null) {
			
		}else {
			
			if(args.containsKey("sort_field")) {
				System.out.print("Order mode"+ args.get("sort_order_mode") + "\n \n");
				if(args.get("sort_order_mode").equals("asc")) {
					users = (List<User>) userRepository.findAll(Sort.by(args.get("sort_field")).ascending());
				} else {
					users = (List<User>) userRepository.findAll(Sort.by(args.get("sort_field")).descending());
				}
				
			}
			
			if(args.containsKey("filter_field")) {
				switch(args.get("filter_field")) {
				case "firstname":
					users = (List<User>) userRepository.findAllA(args.get("filter_value"));
					break;
				case "lastname":
					users = (List<User>) userRepository.findAllB(args.get("filter_value"));
					break;
				case "gender":
					users = (List<User>) userRepository.findAllC(args.get("filter_value"));
					break;
					default:
						users = (List<User>) userRepository.findAll(args.get("filter_value"));
						break;
				}

				
			}
			
		}
		
		return users;
	}
	
	public Optional<User> getUserById(int id){
		return userRepository.findById(id);
	}
		
	
	public User addUser(User users){
		return userRepository.save(users);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	

}
