package org.nic.calc.controller;

import org.nic.calc.util.IPaneController;

public class RootPaneController implements IPaneController {

	private RootController rootController;
	
	@Override
	public void setScreenParent(RootController rootController) {
		this.rootController = rootController;
	}

}
