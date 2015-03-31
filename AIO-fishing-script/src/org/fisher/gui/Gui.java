package org.fisher.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.fisher.Settings;
import org.fisher.extras.Antipattern;
import org.fisher.fish.Fish.FishTypes;
import org.fisher.fish.actions.Banker;
import org.fisher.fish.actions.Catcher;
import org.fisher.fish.actions.Dropper;
import org.fisher.gui.listeners.Mouse;
import org.fisher.task.Fisher;
import org.powerbot.script.rt6.ClientContext;

public class Gui extends JFrame {

	private static final long serialVersionUID = -6459107479519923715L;

	private JPanel contentPane = new JPanel();

	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel mainPanel = new JPanel();

	private static DefaultListModel fishModel = new DefaultListModel();
	public static DefaultListModel locationModel = new DefaultListModel();	

	public static JList fishList = new JList(fishModel);
	public static JList locationList = new JList(locationModel);

	private final JScrollPane fishScroller = new JScrollPane();
	private final JScrollPane locationScroller = new JScrollPane();

	public static JLabel lblFishType = new JLabel("Fish type : ");
	public static JLabel lblFishLocation = new JLabel("Location : ");
	public static JLabel lblMethodType = new JLabel("Method type : ");

	private JCheckBox droppingFish = new JCheckBox("Dropping");
	private JCheckBox antiPattern = new JCheckBox("Anti-pattern");

	private JCheckBox destroyingRocks = new JCheckBox("Destroy strange rocks");

	private final JButton startButton = new JButton("Start");


	public static void init(ClientContext ctx) {
		Gui frame = new Gui(ctx);
		frame.setVisible(true);
	}

	public Gui(final ClientContext ctx) {
		setResizable(false);
		setTitle("FN-Fisher - v"+Settings.BUILD);
		setBounds(100, 100, 600, 400);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Main settings", null, mainPanel, null);
		mainPanel.setLayout(null);
		fishScroller.setBounds(10, 24, 161, 278);

		mainPanel.add(fishScroller);

		fishScroller.setViewportView(fishList);
		locationScroller.setBounds(194, 24, 154, 278);

		mainPanel.add(locationScroller);

		fishList.addMouseListener(new Mouse(0));
		fishList.addMouseMotionListener(new Mouse(0));

		locationList.addMouseListener(new Mouse(1));
		locationList.addMouseMotionListener(new Mouse(1));

		locationScroller.setViewportView(locationList);
		lblFishType.setBounds(358, 26, 181, 14);

		mainPanel.add(lblFishType);
		lblFishLocation.setBounds(358, 50, 211, 14);

		mainPanel.add(lblFishLocation);
		lblMethodType.setBounds(358, 75, 181, 14);

		mainPanel.add(lblMethodType);
		droppingFish.setBounds(354, 100, 158, 23);

		mainPanel.add(droppingFish);
		antiPattern.setBounds(354, 130, 158, 23);

		mainPanel.add(antiPattern);
		startButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if (fishList.getSelectedValue() == null) {
					sendError("You need to select a fish type!");
					return;
				}
				if (!droppingFish.isSelected() && fishList.getSelectedValue() == FishTypes.LEAPING_TROUT ||
						!droppingFish.isSelected() && fishList.getSelectedValue() == FishTypes.LEAPING_SALMON ||
						!droppingFish.isSelected() && fishList.getSelectedValue() == FishTypes.LEAPING_STURGEON) {
					sendError("You can't bank this fish, please enable dropping");
					return;
				}
				if (locationList.getSelectedValue() == null && !droppingFish.isSelected()) {
					sendError("If your banking, please select a location,\n if not, select the dropping check box.");
					return;
				} else {
					Settings.INFO = (FishTypes) fishList.getSelectedValue();
					Settings.TILE_INDEX = +locationList.getSelectedIndex();
					if (antiPattern.isSelected()) {
						Fisher.taskList.addAll(Arrays.asList(new Catcher(ctx), 
								droppingFish.isSelected() ? new Dropper(ctx) : new Banker(ctx), new Antipattern(ctx)));
					} else if (!antiPattern.isSelected()) {
						Fisher.taskList.addAll(Arrays.asList(new Catcher(ctx), 
								droppingFish.isSelected() ? new Dropper(ctx) : new Banker(ctx)));
					}
					dispose();
				}
			}
		});
		startButton.setBounds(380, 210, 125, 70);

		mainPanel.add(startButton);

		if (Settings.DESTROYING_ROCKS_ENABLED) {
			destroyingRocks.setBounds(354, 160, 158, 23);
			mainPanel.add(destroyingRocks);
		}

		for (FishTypes types : FishTypes.values()) {
			fishModel.addElement(types);
		}

		for (int i = 0; i < mainPanel.getComponents().length; i++) {
			mainPanel.getComponents()[i].setFocusable(false);
		}

	}

	public void sendError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
	}
}
