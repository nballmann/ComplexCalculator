package org.nic.calc.controller;

import javafx.fxml.FXML;

import org.nic.calc.util.IPaneController;
import org.nic.calc.view.AboutPopUp;

public class RootPaneController implements IPaneController {

	private RootController rootController;
	
	@FXML
	private void handleExit()
	{
		System.exit(0);
	}
	
	@FXML
	private void handleAbout()
	{
		new AboutPopUp(rootController.getStage());
	}
	
	
	@Override
	public void setScreenParent(RootController rootController) {
		this.rootController = rootController;
	}

}
