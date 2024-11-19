package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.*;

import interface_adapter.add_goal.AddGoalController;
import interface_adapter.add_goal.AddGoalViewModel;
import interface_adapter.income_history.IncomeHistoryViewModel;

public class GoalView extends JPanel implements ActionListener, PropertyChangeListener{
    private final String viewName = "Goal";
    private final GoalView viewModel;

    private final JButton Home;
    private final JButton Income;
    private final JButton Expense;


}