package view;

import interface_adapter.income_history.IncomeHistoryState;
import interface_adapter.income_history.IncomeHistoryViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class IncomeHistoryView {

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.*;

import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomeViewModel;
//change above to what its actually called if its different

    public class IncomeHistory extends JPanel implements ActionListener, PropertyChangeListener {
        private final String viewName = "income history";
        private final IncomeHistoryViewModel viewModel;

        private final JButton Home;
        private final JButton Expense;
        private final JButton Goals;
        private IncomeHistory loginController;

        public LoginView(IncomeHistory incomeHistoryViewModel) {

            this.viewModel = IncomeHistoryViewModel;
            this.viewModel.addPropertyChangeListener(this);

            final JLabel title = new JLabel("Income History");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            final LabelTextPanel incomeHistory = new LabelTextPanel(new JLabel("Income"));

            final JPanel buttons = new JPanel();
            Home = new JButton("Home");
            buttons.add(Home);
            Expense = new JButton("Expense");
            buttons.add(Expense);

            // Add Chart API here!!

            Home.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(Home)) {
                                final IncomeHistoryState currentState = incomeHistoryViewModel.getState();

                                HomeController.execute(
                                );
                            }
                        }
                    }
            );

            Home.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(Home)) {
                                final IncomeHistoryState currentState = incomeHistoryViewModel.getState();

                                HomeController.execute(
                                );
                            }
                        }
                    }
            );


            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


            this.add(title);
            this.add();
            this.add(usernameErrorField);
            this.add(passwordInfo);
            this.add(buttons);
        }


        /**
         * React to a button click that results in evt.
         * @param evt the ActionEvent to react to
         */
        public void actionPerformed(ActionEvent evt) {
            System.out.println("Click " + evt.getActionCommand());
        }

//        @Override
//        public void propertyChange(PropertyChangeEvent evt) {
//            final IncomeHistory state = (IncomeHistory) evt.getNewValue();
//            usernameErrorField.setText(state.getLoginError());
//        }

        public String getViewName() {
            return viewName;
        }

        public void setLoginController(LoginController loginController) {
            this.loginController = loginController;
        }
}}
