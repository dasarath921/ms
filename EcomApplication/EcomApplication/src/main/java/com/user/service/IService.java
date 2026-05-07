package com.user.service;

public interface IService<T>{
	
	public T createUser(T t);
	public T getById(Long id);

}
