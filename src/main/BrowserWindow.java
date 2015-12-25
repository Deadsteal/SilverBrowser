// Made by Nikhil Jain
// No patent intended

package main;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

import org.jsoup.Jsoup;

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

		displayPane = new JEditorPane();
		displayPane.setContentType("text/html");
		displayPane.setPreferredSize(new Dimension(this.getWidth() - 20, this.getHeight() - 150));
		
		// put the go button next to the search bar in a cheeky manner
		layoutManager.putConstraint(SpringLayout.WEST, searchButton, 5, SpringLayout.EAST, searchBar);
		
//		// the searchbutton will always be 5 px away from the edge of the window
//		layoutManager.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, this);

		// the searchbar will always be 5 px away from the edge of the window
		layoutManager.putConstraint(SpringLayout.WEST, searchBar, 5, SpringLayout.WEST, this);

		layoutManager.putConstraint(SpringLayout.NORTH, displayPane, 5, SpringLayout.SOUTH, searchBar);
//		layoutManager.putConstraint(SpringLayout.EAST, displayPane, 5, SpringLayout.EAST, this);
//		layoutManager.putConstraint(SpringLayout.WEST, displayPane, 5, SpringLayout.WEST, this);
				
		
		this.add(searchBar);
		this.add(searchButton);
		this.add(displayPane);
		
		this.setVisible(true);
		
		// test
		String display = "";
		try {
			display = sendGetRequest("http://facebook.com/");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
//		displayPane.setText(display);
		
	} // end of constructor
	
	private String sendGetRequest(String url) throws Exception {
		
//		URL urlObj = new URL(url);
//		
//		HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
//		
//		// add request header and assorted garbage
//		connection.setRequestMethod("GET");
//		connection.setRequestProperty("User-Agent", "silverbrowser.1"); // TODO: Fix this?
//		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5"); // make sure the response is in english
//	
//		// what response did the server send?
//		int responseCode = connection.getResponseCode();
//		System.out.println("Response code from " + url + " was " + Integer.toString(responseCode));
//	
//		// read the response
//		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	
//		String inputLine;
//		StringBuffer responseBuffer = new StringBuffer();
//		
//		while ((inputLine = in.readLine()) != null) {
//			responseBuffer.append(inputLine);
//		}
//		in.close();
//		
//		String response = responseBuffer.toString();		
//		
//		Jsoup.
//		
		
		// Jsoup reduced all this code to 1 line
		String html = Jsoup.connect(url).get().html();
		System.out.println(html);
		displayPane.setText(html);
		return html;
		
//		System.out.println(response);
//		
//		return response;
		
	}  // end of sendGetRequest
	
	
	public static void main(String args[]) {
		// create a new window
		
		try {
			BrowserWindow newWindow = new BrowserWindow();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	} // end of main
	
} // end of class
