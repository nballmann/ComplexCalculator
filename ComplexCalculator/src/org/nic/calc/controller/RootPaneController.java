package org.nic.calc.controller;

import javafx.fxml.FXML;

import org.nic.calc.util.IPaneController;

public class RootPaneController implements IPaneController {

	private RootController rootController;
	
	@FXML
	private void handleExit()
	{
		System.exit(0);
	}
	
	
	@Override
	public void setScreenParent(RootController rootController) {
		this.rootController = rootController;
	}

}
