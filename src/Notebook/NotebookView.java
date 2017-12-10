package Notebook;

// Ivana Lim #6 S15A


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotebookView extends JFrame implements ItemListener, ActionListener
{
	private Notebook nbk;			/* a reference to the Notebook object that will be viewed */
	
	private JComboBox cbPages;		/* combo box for selecting the page to be viewed */
	private JTextArea taContent;	/* text area where the content of the page will be displayed */
	private JButton btnSave;		/* button to update the contents of the page in the notebook and
									   to save contents of the page to a file */
	private JButton btnUpdate;		/* button to update contents of the page in the notebook */
	private JButton btnPrevious;	/* button to save contents of the page to a file */
	private JButton btnNext;		/* button to save contents of the page to a file */
	private JTextField tfTitle;		/* text field for the title of the page */
	//File f = new File("Z:\\FE\\Files.txt");
	
	public NotebookView (Notebook nbk)
	{
		super ("Notebook Viewer");
		
		this.nbk = nbk;
		
		
		/* defines the settings of the JFrame */
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		setSize (500, 700);
		
		/* places the components on the JFrame */
		initView ();
		
		setVisible (true);
	}
	
	/* places the contents on the JFrame */
	public void initView ()
	{
		setLayout (new BorderLayout ());
		
		JPanel topPanel = new JPanel ();
		topPanel.setLayout (new GridLayout (0, 1));
		
		/* combo box for selecting the page to view */
		JPanel topPanelCombo = new JPanel ();
		cbPages = new JComboBox (nbk.getPages ());
		cbPages.setEditable (false);
		cbPages.addItemListener (this);
		cbPages.setSelectedIndex (0);
		
		JScrollPane scroll = new JScrollPane (cbPages);
		topPanelCombo.add (new JLabel ("Select: "));
		topPanelCombo.add (scroll);
		
		/* next or preview page navigation buttons */
		JPanel topPanelButtons = new JPanel ();
		
		btnNext = new JButton ("Next Page");
		btnNext.addActionListener(this);
		
		btnPrevious = new JButton ("Previous Page");
		btnPrevious.addActionListener(this);
		
		topPanelButtons.add(btnPrevious);
		topPanelButtons.add(btnNext);

		
		/* components for the title of the page */
		JPanel titlePanel = new JPanel ();
		titlePanel.add (new JLabel ("Page Title:  "));
		tfTitle = new JTextField (20);
		titlePanel.add (tfTitle);

		topPanel.add (topPanelCombo);
		topPanel.add (topPanelButtons);
		topPanel.add (titlePanel);
		add (topPanel, BorderLayout.NORTH);
		
		/* text area for page content */
		taContent = new JTextArea ();
		JScrollPane textScroll = new JScrollPane (taContent);
		
		add (textScroll, BorderLayout.CENTER);
		
		/* buttons for update and save */
		JPanel bottomPanel = new JPanel ();
		btnUpdate = new JButton ("Update");
		btnUpdate.addActionListener(this);
		
		btnSave = new JButton ("Save to File");
		btnSave.addActionListener(this);

		bottomPanel.add (btnUpdate);
		bottomPanel.add (btnSave);
		
		add (bottomPanel, BorderLayout.SOUTH);
		
		updateEnabledButtons (0);
	}
	
	/* enables/disables the Next and Previous buttons depending on the page number currently being viewed */
	public void updateEnabledButtons (int page)
	{
		if (page == nbk.getCapacity () - 1)
		{
			btnNext.setEnabled (false);
			btnPrevious.setEnabled (true);
		}
		else if (page == 0)
		{
			btnPrevious.setEnabled (false);
			btnNext.setEnabled (true);
		}
		else
		{
			btnNext.setEnabled (true);
			btnPrevious.setEnabled (true);
		}
		btnUpdate.setEnabled (true);
		btnSave.setEnabled (true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equalsIgnoreCase("Next Page"))
		{
			nbk.nextPage();
			cbPages.setSelectedIndex(nbk.getPageNumber());
		}
		else if (e.getActionCommand().equalsIgnoreCase("Previous Page"))
		{
			nbk.previousPage();
			cbPages.setSelectedIndex(nbk.getPageNumber());
		}
		else if (e.getActionCommand().equalsIgnoreCase("Update"))
		{
			int index = cbPages.getSelectedIndex ();
			//nbk.setPageNumber(index);
			//updateEnabledButtons (index);
			nbk.setPageTitle(tfTitle.getText());
			nbk.setPageContent(taContent.getText());
		}
		else if (e.getActionCommand().equalsIgnoreCase("Save to File"))
		{
			//int index = cbPages.getSelectedIndex ();
			//nbk.setPageNumber(index);
			String s = "Page"+ (nbk.getPageNumber()+1)+ " - "+nbk.getPageTitle();
			File f = new File("C:\\Users\\Robin\\Desktop\\Java files to be jarred\\Notebook\\"+s+".txt");
			nbk.saveToFile(f);
			JOptionPane.showMessageDialog(null,s+" saved in "+"Z:\\FE\\"+s+".txt","Save to File",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/* methods of ItemListener */
	public void	itemStateChanged(ItemEvent e)
	{
		//Invoked when an item has been selected or deselected by the user.
		int index = cbPages.getSelectedIndex ();
		nbk.setPageNumber (index);
		updateEnabledButtons (index);
		if (nbk.getPageTitle () != null)
			tfTitle.setText (nbk.getPageTitle ());
		else
			tfTitle.setText ("");
		taContent.setText (nbk.getPageContent ());
	}
	
	
	public static void main (String[] args)
	{
		NotebookView nbkv = new NotebookView (new Notebook (15));
	}
}