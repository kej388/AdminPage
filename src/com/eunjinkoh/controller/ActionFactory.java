package com.eunjinkoh.controller;

import com.eunjinkoh.controller.action.Action;
import com.eunjinkoh.controller.action.DashboardAction;
import com.eunjinkoh.controller.action.ProductInsertFormAction;
import com.eunjinkoh.controller.action.ProductListAction;

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
		}
		
		return action;
	}
}
