package view;

import javax.swing.JFrame;

public class TestLayout extends JFrame {
	protected RootPanel rootPanel;
	public TestLayout(){
		this.setSize(1000,800);
		rootPanel = new RootPanel();
		this.add(rootPanel);
	}
	public static void main(String[] args){
		TestLayout layout = new TestLayout();
		layout.setVisible(true);
	}
}
