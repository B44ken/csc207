package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.List;

import javax.swing.*;

import data_access.ChartImageFactory;
import data_access.UserData;
import entity.*;
import interface_adapter.get_insight.GetInsightController;
import interface_adapter.get_insight.GetInsightViewModel;
import use_case.get_insight.GetInsightInteractor;

/**
 * GetInsight View UI.
 */
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
        this.panelTax = new JPanel();

        final JButton taxCredits = new JButton("Tax Credits");
        taxCredits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                    repaint();
            }
        });

        final JPanel resourceButtons = new JPanel();
        resourceButtons.setLayout(new BoxLayout(resourceButtons, BoxLayout.Y_AXIS));

        final JButton scholarships = new JButton("Explore UofT Scholarships!");
        resourceButtons.add(scholarships);

        final ChartImageFactory api = new ChartImageFactory(userData.getHistory());
        final JPanel qrPanel = new JPanel();
        qrPanel.setLayout(new BoxLayout(qrPanel, BoxLayout.Y_AXIS));

        final JLabel finalQR = api.createQRCode();
        qrPanel.add(new JLabel("Scan for more information on Ontario tax deductions!"));
        qrPanel.add(finalQR);

        scholarships.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    final URI uri = new URI("https://www.registrar.utoronto.ca/finances-and-funding/awards-scholarships-bursaries-grants/");
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().browse(uri);
                    }
                    else {
                        System.out.println("Desktop not supported. Cannot open URL.");
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        title.setFont(title.getFont().deriveFont(24.0f));
        resourceButtons.setSize(400, 900);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        // this.add(expensesContainer);
        this.add(taxCredits);
        this.add(panelTax);
        this.add(resourceButtons);
        this.add(finalQR);
        this.add(bottomButtons, BorderLayout.AFTER_LAST_LINE);
        // repaint();
    }

    /**
     * Sets viewswitcher.
     * @param viewSwitcher vs.
     */
    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void setGetInsightController(GetInsightController getInsightController) {
        this.getInsightController = getInsightController;
    }

    /**
     * Repaint method for finding new Deductibles.
     */
    public void repaint() {
        if (this.userData != null) {
            final GetInsightInteractor interactor = new GetInsightInteractor(userData);
            final GetInsightController controller = new GetInsightController(interactor);
            setGetInsightController(controller);
            newInsights = getInsightController.execute(userData);
            this.panelTax.removeAll();
            panelTax.setLayout(new BoxLayout(panelTax, BoxLayout.Y_AXIS));
            for (Deductible t : newInsights) {
                final JLabel words =
                        new JLabel("We found " + t.getExpenseName() + " donation for " + t.getExpenseAmount()
                                + ", you are eligible for tax credit!");
                this.panelTax.add(words);
                final JButton button = new JButton("Click here to add" + t.getExpenseName() + " income credit!");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        userData.getHistory().add(t.getIncome());
                        userData.save();
                    }
                });
                this.panelTax.add(button);
            }
            this.add(panelTax);
        }
    }
}
