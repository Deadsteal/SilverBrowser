// Made by Nikhil Jain
// No patent intended

package main;

import java.awt.Dimension;
import java.awt.Window;
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
		searchBar.setPreferredSize(new Dimension(this.getWidth() - 100, 50));
//		searchBar.
		
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
		searchButton.setPreferredSize(new Dimension(85, 50));

		// put the go button next to the search bar in a cheeky manner
		layoutManager.putConstraint(SpringLayout.WEST, searchButton, 5, SpringLayout.EAST, searchBar);
		
//		// the searchbutton will always be 5 px away from the edge of the window
//		layoutManager.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, this);
		
		// the searchbar will always be 5 px away from the edge of the window
		layoutManager.putConstraint(SpringLayout.WEST, searchBar, 5, SpringLayout.WEST, this);
				
		
		this.add(searchBar);
		this.add(searchButton);

		this.setVisible(true);
		
	}
	
	
	
	public static void main(String args[]) {
		// create a new window
		BrowserWindow newWindow = new BrowserWindow();
	}
	
}
