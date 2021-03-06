package com.eunjinkoh.controller;

import com.eunjinkoh.controller.action.Action;
import com.eunjinkoh.controller.action.DashboardAction;
import com.eunjinkoh.controller.action.MovieListAction;
import com.eunjinkoh.controller.action.ProductDeleteAction;
import com.eunjinkoh.controller.action.ProductDeleteFormAction;
import com.eunjinkoh.controller.action.ProductInsertFormAction;
import com.eunjinkoh.controller.action.ProductListAction;
import com.eunjinkoh.controller.action.ProductUpdateFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("product_list_action")) {
			action = new ProductListAction();
		} else if(command.equals("dashboard_action")) {
			action = new DashboardAction();
		} else if(command.equals("product_insert_form_action")) {
			action = new ProductInsertFormAction();
		} else if(command.equals("product_update_form")) {
			action = new ProductUpdateFormAction();
		} else if(command.equals("product_delete_form")) {
			action = new ProductDeleteFormAction();
		} else if(command.equals("product_delete")) {
			action = new ProductDeleteAction();
		} else if(command.equals("movie_list")) {
			action = new MovieListAction();
		}
		
		return action;
	}
}
