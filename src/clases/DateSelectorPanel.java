package clases;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class DateSelectorPanel extends JPanel {
    private JComboBox<Integer> monthComboBox;
    private JComboBox<Integer> dayComboBox;

    public DateSelectorPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel monthLabel = new JLabel("Mes:");
        monthComboBox = new JComboBox<>();
        JLabel dayLabel = new JLabel("Día:");
        dayComboBox = new JComboBox<>();

        populateMonthComboBox();
        populateDayComboBox();

        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateDayComboBox();
            }
        });

        add(monthLabel);
        add(monthComboBox);
        add(dayLabel);
        add(dayComboBox);
    }

    private void populateMonthComboBox() {
        monthComboBox.removeAllItems();
        for (int i = 1; i <= 12; i++) {
            monthComboBox.addItem(i);
        }
    }

    private void populateDayComboBox() {
        dayComboBox.removeAllItems();
        int selectedMonth = (int) monthComboBox.getSelectedItem();
        int maxDay = getMaxDayOfMonth(selectedMonth);
        for (int i = 1; i <= maxDay; i++) {
            dayComboBox.addItem(i);
        }
    }

    private int getMaxDayOfMonth(int month) {
        int maxDay;
        if (month == 2) { // February
            maxDay = 28; // Default to 28 days
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (currentYear % 4 == 0 && (currentYear % 100 != 0 || currentYear % 400 == 0)) {
                maxDay = 29; // Leap year: 29 days
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30; // April, June, September, November: 30 days
        } else {
            maxDay = 31; // All other months: 31 days
        }
        return maxDay;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Date Selector Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);

            DateSelectorPanel dateSelectorPanel = new DateSelectorPanel();
            frame.add(dateSelectorPanel);

            frame.setVisible(true);
        });
    }
}





