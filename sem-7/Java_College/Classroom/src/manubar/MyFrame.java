package manubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame implements ActionListener {
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenuItem loadItems;
	JMenuItem saveItems;
	JMenuItem exitItems;

	MyFrame() {

		// Set basic frame properties
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);

		// Create menu bar and menus
		menuBar = new JMenuBar(); // create objects of MenuBar
		fileMenu = new JMenu("File"); // create a File menu
		editMenu = new JMenu("Edit"); // create an Edit menu
		helpMenu = new JMenu("Help"); // create a Help menu

		// Add Menus to MenuBar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		// Create menu items and set their names
		loadItems = new JMenuItem("Load");
		saveItems = new JMenuItem("save");
		exitItems = new JMenuItem("Exit");

		// Implements action Listener for menu items
		loadItems.addActionListener(this);
		saveItems.addActionListener(this);
		exitItems.addActionListener(this);

		// add MenuItems to menuBar
		fileMenu.add(loadItems);
		fileMenu.add(saveItems);
		fileMenu.add(exitItems);

		this.setJMenuBar(menuBar); // add menu bar to frame
		this.setVisible(true);
	}

	// Action Performed method to handle menu item action
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadItems) {
			System.out.println("Load Files");
		}
		if (e.getSource() == saveItems) {
			System.out.println("Save Files");
		}
		if (e.getSource() == exitItems) {
			System.exit(0);
		}

	}

}
