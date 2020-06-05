package com.eunjinkoh.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 추상메소드. 자식이 오버라이드해야함
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;	
}
