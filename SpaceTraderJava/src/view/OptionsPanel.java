package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import controller.Controller;

public class OptionsPanel extends JPanel {

	private static final long serialVersionUID = -4315002591794574841L;
	private Controller data;
	
	public OptionsPanel(Controller data) {
		this.data = data;
		setPreferredSize(new Dimension(600, 500));
	}
}
