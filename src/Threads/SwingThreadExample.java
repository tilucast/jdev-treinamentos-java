package Threads;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class SwingThreadExample extends JDialog {

    private JPanel jpanel = new JPanel(new GridBagLayout());

    private JLabel describeField = new JLabel("Current date and time - 1");
    private JTextField currentDate = new JTextField();

    private JLabel describeField2 = new JLabel("Current date and time - 2");
    private JTextField currentDate2 = new JTextField();

    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");

    final private Runnable threadx = () -> threadcode(currentDate);

    final private Runnable thready = () -> threadcode(currentDate2);

    SwingThreadExample() {
        AtomicReference<Thread> newthreadx = new AtomicReference<>(new Thread());
        AtomicReference<Thread> newthready = new AtomicReference<>(new Thread());

        setTitle("Threads Example With Dates");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 2;
        grid.insets = new Insets(5, 10, 5, 5);
        grid.anchor = GridBagConstraints.WEST;

        describeField.setPreferredSize(new Dimension(200, 25));
        jpanel.add(describeField, grid);

        currentDate.setPreferredSize(new Dimension(200, 25));
        grid.gridy++;
        currentDate.setEditable(false);
        jpanel.add(currentDate, grid);

        grid.gridy++;

        describeField2.setPreferredSize(new Dimension(200, 25));
        jpanel.add(describeField2, grid);

        currentDate2.setPreferredSize(new Dimension(200, 25));
        grid.gridy++;
        currentDate2.setEditable(false);
        jpanel.add(currentDate2, grid);

        grid.gridy++;

        start.setPreferredSize(new Dimension(92, 25));
        grid.gridwidth = 1;
        jpanel.add(start, grid);
        grid.gridx++;
        stop.setPreferredSize(new Dimension(92, 25));
        jpanel.add(stop, grid);

        start.addActionListener(event -> {
            stop.setEnabled(true);
            start.setEnabled(false);
            newthreadx.set(new Thread(threadx));
            newthreadx.get().start();
            newthready.set(new Thread(thready));
            newthready.get().start();
        });
        stop.addActionListener(event -> {
            stop.setEnabled(false);
            start.setEnabled(true);
            newthreadx.get().stop();
            newthready.get().stop();
        });

        add(jpanel, BorderLayout.WEST);
        stop.setEnabled(false);
        setVisible(true);
    }

    private void threadcode(JTextField currentDate){
        while(true){
            currentDate.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
