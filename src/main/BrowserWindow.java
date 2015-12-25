// Made by Nikhil Jain
// No patent intended

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.*;


public class BrowserWindow extends JFrame {

	// URL/search bar at top
	JTextField searchBar;
	
	// button to search/go
	JButton searchButton;
	
	// displays html response
	JEditorPane displayPane;

	// forward and back buttons
	JButton forwardButton, backButton;
	
	// list to store what pages you went to (for forward and backward button)
	ArrayList<String> websiteList;
	
	
	
	public BrowserWindow() {
		
		// init components
		SpringLayout layoutManager = new SpringLayout();
		
		this.setTitle("Silver Browser");
		this.setSize(1080, 720);
		this.setLayout(layoutManager);
		
		searchBar = new JTextField("Search Bar");
		searchBar.setSize(this.getWidth() - 100, 50);
		searchBar.setLocation(0, 0);
		
		// when you click on search bar, it highlights the text in it
		searchBar.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				searchBar.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				// do nothing
			}
		});
		
		searchButton = new JButton("Go");
		searchButton.setSize(50, 50);
		searchButton.setLocation(searchBar.getWidth() + 10, 0);
		
		this.add(searchBar);
		this.add(searchButton);

		this.setVisible(true);
		
	}
	
	
	
	public static void main(String args[]) {
		// create a new window
		BrowserWindow newWindow = new BrowserWindow();
	}
	
}
