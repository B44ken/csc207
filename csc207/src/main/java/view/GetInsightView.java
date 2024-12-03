package view;

import com.labrats.app.ViewNames;
import data_access.ChartAPI;
import data_access.ChartImageFactory;
import data_access.UserData;
import entity.*;
import interface_adapter.get_insight.GetInsightController;
import interface_adapter.get_insight.GetInsightViewModel;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.View;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetInsightView extends JPanel {
    private final JLabel title = new JLabel("Financial Insights");

    private ViewSwitcher viewSwitcher;

    private GetInsightViewModel viewModel;
    private GetInsightController getInsightController;
    private JPanel panelTax;

    private JLabel expensesContainer;

    private UserData userData;
    private List<Deductible> newInsights;

    public GetInsightView(BottomButtons bottomButtons, UserData userData) {
        this.userData = userData;

        JButton taxCredits = new JButton("Tax Credits");
        taxCredits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newInsights = getInsightController.execute(userData);
            }
        });

        JPanel resourceButtons = new JPanel();
        resourceButtons.setLayout(new BoxLayout(resourceButtons, BoxLayout.Y_AXIS));

        JButton scholarships = new JButton("Explore UofT Scholarships!");
        resourceButtons.add(scholarships);

        var api = new ChartImageFactory(userData.getHistory());
        JPanel qrPanel = new JPanel();
        qrPanel.setLayout(new BoxLayout(qrPanel, BoxLayout.Y_AXIS));

        JLabel finalQR = api.createQRCode();
        qrPanel.add(new JLabel("Scan for more information on Ontario tax deductions!"));
        qrPanel.add(finalQR);

        scholarships.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            URI uri = new URI("https://www.registrar.utoronto.ca/finances-and-funding/awards-scholarships-bursaries-grants/");
                            if (Desktop.isDesktopSupported()) {
                                Desktop.getDesktop().browse(uri);
                            } else {
                                System.out.println("Desktop not supported. Cannot open URL.");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
        });

        title.setFont(title.getFont().deriveFont(24.0f));
        resourceButtons.setSize(400, 900);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(title);
        // this.add(expensesContainer);
        this.add(taxCredits);
        this.add(panelTax);
        this.add(resourceButtons);
        this.add(finalQR);
        this.add(bottomButtons, BorderLayout.AFTER_LAST_LINE);
        repaint();
    }

    /**
     * Sets viewswitcher.
     * @param viewSwitcher
     */
    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void setGetInsightController(GetInsightController getInsightController) {
        this.getInsightController = getInsightController;
    }

    public void repaint() {
        if (getInsightController != null) {
            this.panelTax.removeAll();
            this.panelTax.add(newInsights);
        };
    }

    public JPanel populateTable(Deductible deductible) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("We found " + deductible.getExpenseName() + ", " + deductible.getExpense().getAmount() + ", you are eligible for tax credit!"));
        JButton button = new JButton("Click here to add Income credit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userData.getHistory().add(deductible.getIncome());
                userData.save();
            }
        });
        panel.add(button);
        return panel;
    }

//    public void renderExpensesContainer() {
//        JTextPane textPane = new JTextPane();
//        textPane.add("We found" + t.getName() +", " + t.getCategory() + ", you are eligible for tax credit!");
//
//        JButton addTaxButton = new JButton("Click here to add" + (t.getAmount() * 0.75) + "tax credits");
//        IncomeFactory incomeFactory = new IncomeFactory();
//        Income newIncome = incomeFactory.create(t.getName() + "tax credits", t.getAmount() * 0.75, "tax deductions", t.getDate());
//
//        addTaxButton.addActionListener(e -> {
//            userData.getHistory().getAllIncomes().add(newIncome);
//        });

    }

}
