package grail.extras;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import grail.MVC.BridgeSceneController;
import grail.MVC.BridgeSceneMouseController;

@SuppressWarnings("serial")
public class Buttons extends JPanel implements PanelButton{
	
	static final int
		BUTTON_SIZE1 = 40,
		BUTTON_SIZE2 = 50,
		SAY_LOCATION1 = 10,
		PASS_LOCATION = 50,
		APPROACH_LOCATION = 100,
		BOUNDS_2 = 100,
		BOUNDS_3 = 95,
		BOUNDS_4 = 30,
		LAYOUT_1 = 1,
		LAYOUT_2 = 2,
		LOCATION = 200,
		FAIL_LOCATION = 150,
		LOCATION2_COMMON = 10;
		
	static final String
		SAY = "Avatr Talk",
		PASSED = "Avatar Pass?",
		FAILED = "Go To Gorge",
		APPROACH = "Avatar Go To Guard";
	
	JButton passed;
	JButton say;
	JButton failed;
	JButton approach;
	MouseListener listener;
	
	public Buttons() {
		
		passed = new JButton(PASSED);
		passed.setSize(BUTTON_SIZE2, BUTTON_SIZE1);
		passed.setBounds(BUTTON_SIZE2,BOUNDS_2,BOUNDS_3,BOUNDS_4);
		passed.setLayout(new GridLayout(LAYOUT_1, LAYOUT_2));
		passed.setLocation(LOCATION, LOCATION);
		passed.setFocusable(false);
		say = new JButton();
		say.setSize(BUTTON_SIZE2, BUTTON_SIZE1);
		say.setText(SAY);
		say.setLayout(new GridLayout(LAYOUT_1, LAYOUT_2));
		say.setLocation(SAY_LOCATION1, LOCATION2_COMMON);
		say.setFocusable(false);
		failed = new JButton();
		failed.setSize(BUTTON_SIZE2, BUTTON_SIZE1);
		failed.setText(FAILED);
		failed.setLayout(new GridLayout(LAYOUT_1, LAYOUT_2));
		failed.setLocation(FAIL_LOCATION, LOCATION2_COMMON);
		failed.setFocusable(false);
		approach = new JButton();
		approach.setSize(BUTTON_SIZE2, BUTTON_SIZE1);
		approach.setText(APPROACH);
		approach.setLayout(new GridLayout(LAYOUT_1, LAYOUT_2));
		approach.setLocation(APPROACH_LOCATION, LOCATION2_COMMON);
		approach.setFocusable(false);
		//listener = new BridgeSceneController((PanelButton)this);
		this.add(approach);
		this.add(failed);
		this.add(passed);
		this.add(say);
		this.setVisible(true);
	}
	
	@Override
	public JButton getPassed() {
		return passed;
	}
	@Override
	public JButton getSay() {
		return say;
	}
	@Override
	public JButton getFailed() {
		return failed;
	}
	@Override
	public JButton getApproach() {
		return approach;
	}
		
	
}
