package clases;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class DateSelectorPanel extends JPanel {
    protected JComboBox<Integer> monthComboBox;
    protected JComboBox<Integer> dayComboBox;

    private boolean isMonthSelected = false;

    public DateSelectorPanel(JPanel mainPanel,int startYear) {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel monthLabel = new JLabel("Mes:");
        monthComboBox = new JComboBox<>();
        JLabel dayLabel = new JLabel("Día:");
        dayComboBox = new JComboBox<>();

        populateMonthComboBox();

        if (monthComboBox.getItemCount() > 0) {
            monthComboBox.setSelectedIndex(0);
        }

        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isMonthSelected) {
                    isMonthSelected = true;
                } else {
                    populateDayComboBox();
                    if (dayComboBox.getItemCount() > 0) {
                        dayComboBox.setSelectedIndex(0);
                    }
                }
            }
        });

        add(monthLabel);
        add(monthComboBox);
        add(dayLabel);
        add(dayComboBox);
        this.setVisible(true);
        mainPanel.add(this);

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
    public String getSelectedMonth() {
        String retorno="";
        if ((int)monthComboBox.getSelectedItem()<10){
            retorno=retorno+"0";
        }
        return retorno+ Integer.toString((int)monthComboBox.getSelectedItem());
    }

    public String getSelectedDay() {
        String retorno="";
        if ((int)dayComboBox.getSelectedItem()<10){
            retorno=retorno+"0";
        }
        return retorno+ Integer.toString((int)dayComboBox.getSelectedItem());
    }
}
