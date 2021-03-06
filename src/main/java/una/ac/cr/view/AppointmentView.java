package una.ac.cr.view;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class AppointmentView extends JFrame {


    private JLabel labelFilter;

    private JTextField textFielFilter;

    private JButton buttonConfirm;
    private JButton buttonFilter;

    private JTable table;
    private DefaultTableModel tableModel;

    public AppointmentView(String titleView){
        super(titleView);

        // Using logger for project
        final Logger logger = LogManager.getLogger(AppointmentView.class);

        logger.debug("Design Pattern MVC: [VIEW]");

        this.getContentPane().setBackground(Color.lightGray);
        this.setSize(1300, 750);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        buttonConfirm = new JButton("Confirm");
        buttonConfirm.setBounds(500, 25, 100, 30);
        buttonConfirm.setName("save");
        buttonFilter = new JButton("Filter");
        buttonFilter.setBounds(390, 25, 100, 30);
        buttonFilter.setName("filter");

        labelFilter = new JLabel("Filter");
        labelFilter.setName("labelFilter");
        labelFilter.setBounds(200,30,150,20);

        textFielFilter= new JTextField();
        textFielFilter.setName("textFielFilter");
        textFielFilter.setBounds(240,30,150,20);

        table = new JTable();
        tableModel = new DefaultTableModel();

        // Create table model
        table.setName("mainTable");
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 100, 1260, 550);


        add(labelFilter);
        add(buttonConfirm);
        add(buttonFilter);
        add(textFielFilter);
        add(scrollPane);
    }

    public JLabel getLabelFilter() {
        return labelFilter;
    }

    public void setLabelFilter(JLabel labelFilter) {
        this.labelFilter = labelFilter;
    }

    public JTextField getTextFielFilter() {
        return textFielFilter;
    }

    public void setTextFielFilter(JTextField textFielFilter) {
        this.textFielFilter = textFielFilter;
    }

    public JButton getButtonConfirm() {
        return buttonConfirm;
    }

    public void setButtonConfirm(JButton buttonConfirm) {
        this.buttonConfirm = buttonConfirm;
    }

    public JButton getButtonFilter() {
        return buttonFilter;
    }

    public void setButtonFilter(JButton buttonFilter) {
        this.buttonFilter = buttonFilter;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
}
