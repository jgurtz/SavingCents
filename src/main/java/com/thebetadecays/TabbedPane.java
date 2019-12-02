package com.thebetadecays;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import javax.swing.*;

/*  TO DO
    Add event listeners to buttons, text fields?
    align/justify components
 */
 
/**
 * TabbedPane is the main panel that runs the GUI for Saving Cents
 * It will have 4 tabs, Dashboard, Expense, Contacts, and Reports
 * @author Skyler Novak
 */
public class TabbedPane extends JFrame {

    // Panels
    private JTabbedPane jtp = new JTabbedPane();
    private JPanel jp1 = new JPanel(); // Dashboard
    private JPanel jp2 = new JPanel(); // Expenses
    private JPanel jp3 = new JPanel(); // Contacts
    private JPanel jp4 = new JPanel(); // Reports

    // Add Layout Managers

    // Labels
    private JLabel label1 = new JLabel(); // Dashboard Label
    private JLabel label2 = new JLabel(); // Expenses Label
    private JLabel label3 = new JLabel(); // Contacts Label
    private JLabel label4 = new JLabel(); // Reports Label
    private JLabel expConName = new JLabel();
    private JLabel expAmt = new JLabel();
    private JLabel expDate = new JLabel();
    private JLabel expCatLabel = new JLabel();
    private JLabel expSubCatLabel = new JLabel();
    private JLabel expMemo = new JLabel();

    // Text Fields
    private JTextField expConTF = new JTextField(25);
    private JTextField expAmtTF = new JTextField(25);

    // Text Area
    private JTextArea expMemoTF = new JTextArea(5, 50);

    // Buttons
    private JButton expAdd = new JButton("Add");
    private JButton expEdit = new JButton("Edit");
    private JButton expDel = new JButton("Delete");

    // Combo Boxes
    private JComboBox expCategories;
    private JComboBox expSubCat;

    // Window params
    private final int WINDOW_WIDTH = 647;
    private final int WINDOW_HEIGHT = 400;

    // String Arrays  --  Categories/Sub-categories
    String categories[] = {"Housing", "Transportation", "Food", "Utilities", "Insurance", "Medical & Healthcare",
            "Saving & Investments", "Personal", "Entertainment", "Miscellaneous"};
     
    /**
     * Default Constructor
     * @author Skyler Novak
     */
    public TabbedPane() {
         
        // initialize Pane values
        setTitle("Saving Cents");
        pack(); // Sets window large enough for all elements to appear
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  // sets size of window (ratio is golden rectangle)
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Build & populate content panes
        buildPanel();

    } // Constructor

    /**
     * Create panel object, populate with components,
     * and add to content pane of JFrame object
     * @author Skyler Novak
     */
    private void buildPanel() {

        // add JTabbedPane object to JFrame content pane
        getContentPane().add(jtp);

        // Create labels for each tab/Pane
        label1.setText("You are in area of Tab1 - DASHBOARD");
        label2.setText("You are in area of Tab2 - EXPENSES");
        label3.setText("You are in area of Tab3 - CONTACTS");
        label4.setText("You are in area of Tab4 - REPORTS");

        // Add labels to the correct panel -- Remove as panel is worked on
        jp1.add(label1);
        jp3.add(label3);
        jp4.add(label4);

        // add components to Expense Tab
        buildExpenseTab();

        // Add panes to tabs
        jtp.addTab("Dashboard", jp1);
        jtp.addTab("Expense", jp2);
        jtp.addTab("Contacts", jp3);
        jtp.addTab("Reports", jp4);

    } // buildPanel()

    /**
     * method to build the expense tab in the TabbedPane frame
     * populates with panels and components
     * @author Skyler Novak
     */
    private void buildExpenseTab() {

        // Set layout manager for expense tab
        jp2.setLayout(new GridLayout(7, 1));

        // Panels to use for Expense Tab
        JPanel expPanel1 = new JPanel();
        JPanel expPanel2 = new JPanel();
        JPanel expPanel3 = new JPanel();
        JPanel expPanel4 = new JPanel();
        JPanel expPanel5 = new JPanel();
        JPanel expPanel6 = new JPanel();
        JPanel expPanel7 = new JPanel();

        // Combo Box for categories & item listener
        expCategories = new JComboBox(categories);
        expSubCat = new JComboBox(categories);
        expCategories.addItemListener(this::itemStateChanged);
        // need item listener for sub-cat

        // Define labels for Expense Tab
        expConName.setText("Contact Name");
        expAmt.setText("Amount");
        expDate.setText("The Date Timestamp will be recorded");
        expCatLabel.setText("Category");
        expSubCatLabel.setText("Sub-Category");
        expMemo.setText("Memo");

        // Add components to Panels
        expPanel1.add(expConName);
        expPanel1.add(expConTF);
        expPanel1.add(expCatLabel);
        expPanel1.add(expCategories);
        expPanel2.add(expAmt);
        expPanel2.add(expAmtTF);
        expPanel2.add(expSubCatLabel);
        expPanel2.add(expSubCat);
        expPanel3.add(expDate);
        expPanel4.add(expMemo);
        expPanel5.add(expMemoTF);
        expPanel7.add(expAdd);
        expPanel7.add(expEdit);
        expPanel7.add(expDel);

        // Add panels to Expense Tab
        jp2.add(expPanel1);
        jp2.add(expPanel2);
        jp2.add(expPanel3);
        jp2.add(expPanel4);
        jp2.add(expPanel5);
        jp2.add(expPanel6);
        jp2.add(expPanel7);

        // Action Listeners
        expAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // addExpense(Double amt, ZonedDateTime dt, String contact, String cat, String subCat, String memo) {

                String con = expConTF.getText();
                String amt = expAmtTF.getText();
                ZonedDateTime dt = ZonedDateTime.now();




                System.out.println(con);

            } // actionPerformed()

        }); // expAdd.addActionListener

    } // buildExpenseTab()

    /**
     * function for itemListener implementation
     * @author Skyler Novak
     * @param e
     */
    public void itemStateChanged(ItemEvent e)
    {
        // EXAMPLE CODE ONLY  --  DO NOT USE
        /*

        // if the state combobox is changed
        if (e.getSource() == c1) {

            l1.setText(c1.getSelectedItem() + " selected");
        }

        */
    }

    /**
     * Main function to run TabbedPane frame
     * @author Skyler Novak
     * @param args
     */
    public static void main(String[] args) {
         
        TabbedPane tp = new TabbedPane();

    } // Main

} // TabbedPane
