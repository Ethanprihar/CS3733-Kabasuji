package kabasuji.controller;

import kabasuji.model.Kabasuji;
import kabasuji.view.PlayLevelPanel;
import kabasuji.view.TopLevelApplication;

public class LosingScreenController {
	PlayLevelPanel panel;
	Kabasuji kabasuji;
	TopLevelApplication app;
	
	public LosingScreenController(Kabasuji kabasuji, PlayLevelPanel panel) {
		this.panel = panel;
		this.kabasuji = kabasuji;
	}
	
	public void update(){
		panel.losingScreen();
		panel.repaint();
	}
}
