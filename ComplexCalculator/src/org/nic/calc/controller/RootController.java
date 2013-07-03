package org.nic.calc.controller;

import java.io.IOException;
import java.util.HashMap;

import org.nic.calc.util.IPaneController;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController extends StackPane
{
	private HashMap<String, Node> screens = new HashMap<>();
	
	public RootController()
	{
		super();
	}
	
	public void addScreen(String name, Node screen)
	{
		screens.put(name, screen);
	}
	
	public Node getScreen(String name)
	{
		return screens.get(name);
	}
	
	public boolean loadScreen(String name, String resouce)
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource(resouce));
			Parent loadScreen = (Parent) loader.load();
			
			IPaneController screenController = (IPaneController) loader.getController(); 
			screenController.setScreenParent(this);
			
			addScreen(name, loadScreen);
			
			return true;
			
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean setScreen(final String name)
	{
		if(screens.get(name) != null)
		{
			final DoubleProperty opacity = opacityProperty();
			
			if(!getChildren().isEmpty())
			{
				Timeline fade = new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
						new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
							
							@Override
							public void handle(ActionEvent e) {
								getChildren().remove(0);
								getChildren().add(0, screens.get(name));
								Timeline fadeIn = new Timeline(
										new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
										new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
								fadeIn.play();
							}
				}, new KeyValue(opacity, 0.0)));
				fade.play();
			}
			else
			{
				setOpacity(0.0);
				getChildren().add(screens.get(name));
				
				Timeline fadeIn = new Timeline(
						new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
						new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
				fadeIn.play();
			}
			return true;
		}
		else 
		{
			System.out.println("Screen hasn't been loaded!");
			return false;
		}
	}

}
