import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class ItemsFrame extends JFrame {
    private ItemCollection items;
    private JTextArea itemsArea;
    private JButton stationaryItemB, labItemB, allItemB, countB, exitB;
    private JPanel buttons;

    public ItemsFrame() {
        items = new ItemCollection();
        setSize(700, 500);
        setLayout(new BorderLayout());
        createComponents();
    }

    public void createComponents() {
        itemsArea = new JTextArea(items.toString());
        add(itemsArea, BorderLayout.CENTER);
        createButtonsPanel();
        add(buttons, BorderLayout.SOUTH);
    }

    public void createButtonsPanel() {
        buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        stationaryItemB = new JButton("Add Stationary Item");
        labItemB = new JButton("Add Lab Item");
        allItemB = new JButton("Display All Items");
        countB = new JButton("Show Count");
        exitB = new JButton("Exit");
        ButtonListener buttonListener = new ButtonListener();
        stationaryItemB.addActionListener(buttonListener);
        labItemB.addActionListener(buttonListener);
        allItemB.addActionListener(buttonListener);
        countB.addActionListener(buttonListener);
        exitB.addActionListener(buttonListener);
        buttons.add(stationaryItemB);
        buttons.add(labItemB);
        buttons.add(allItemB);
        buttons.add(countB);
        buttons.add(exitB);
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==stationaryItemB) {
                String name = JOptionPane.showInputDialog("Please enter stationary item name:");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Please enter stationary item id:"));
                int size = Integer.parseInt(JOptionPane.showInputDialog("Please enter stationary item size:"));
                items.putStationaryItem(new StationaryItem(name, id, size));
            }
            else if(e.getSource()==labItemB) {
                String name = JOptionPane.showInputDialog("Please enter lab item name:");
                int id = Integer.parseInt(JOptionPane.showInputDialog("Please enter lab item id:"));
                String type = JOptionPane.showInputDialog("Please enter lab item type:");
                items.putLabItem(new LabItem(name, id, type));
            }
            else if(e.getSource()==allItemB) {
                itemsArea.setText(items.toString());
            }
            else if(e.getSource()==exitB) {
                exit(0);
            }
            else if(e.getSource()==countB) {
                itemsArea.setText("Number of Stationary Items: " + Integer.toString(StationaryItem.getCount()) +
                        "\nNumber of Lab Items: " + Integer.toString(LabItem.getCount()) +
                        "\nNumber of Collections: " + Integer.toString(ItemCollection.getCount()));
            }
        }
    }
}