package javaCalculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	/**
	 * Properties.
	 */
	private JFrame frame;
	private JPanel buttonPanel;
	private JTextField calculatorNumber;
	private int calculationOperator = 0;
	private int firstNumber;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() 
	{		
	
	initialize();
		
	 frame = new JFrame();
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setTitle("Java Calculator");
	 frame.setSize(300, 300);
	 frame.setLocationRelativeTo(null);
	 
	 calculatorNumber = new JTextField();
	 calculatorNumber.setHorizontalAlignment(JTextField.RIGHT);
	 calculatorNumber.setEditable(false);
	 
	 frame.add(calculatorNumber, BorderLayout.NORTH);

	 buttonPanel = new JPanel();
	 buttonPanel.setLayout(new GridLayout(4,4));
	 
	 frame.add(buttonPanel, BorderLayout.CENTER);
	 	 
	 for (int i = 0; i < 10; i++)
	 {
		 addNumberButton(buttonPanel, String.valueOf(i));
	 }
	 
	 addCalculationButton(buttonPanel, 1, "+");
	 subtractCalculationButton(buttonPanel, 2, "-");
	 multiplyCalculationButton(buttonPanel, 3, "*");
	 divideCalculationButton(buttonPanel, 4, "/");
	 powerOfTwoCalculationButton(buttonPanel, 5, "^2");
	 
	 JButton equalButton = new JButton("=");
	 equalButton.setActionCommand("=");
	 
	 equalButton.addActionListener(new ActionListener()
	 	{
		 	public void  actionPerformed(ActionEvent event)
		 	{
		 		if (!calculatorNumber.getText().isEmpty())
		 		{
		 			int secondNumber = Integer.parseInt(calculatorNumber.getText());
		 			
		 			if (calculationOperator == 1)
		 			{
		 				int calculate = firstNumber + secondNumber;
		 				calculatorNumber.setText(Integer.toString(calculate));
		 			}
		 			else if (calculationOperator == 2)
		 			{
		 				int calculate = firstNumber - secondNumber;
		 				calculatorNumber.setText(Integer.toString(calculate));
		 			}
		 			else if (calculationOperator == 3)
		 			{
		 				int calculate = firstNumber * secondNumber;
		 				calculatorNumber.setText(Integer.toString(calculate));
		 			}
		 			else if (calculationOperator == 4)
		 			{
		 				int calculate = firstNumber / secondNumber;
		 				calculatorNumber.setText(Integer.toString(calculate));
		 			}
		 			else if (calculationOperator == 5)
		 			{
		 				int calculate = firstNumber * firstNumber;
		 				calculatorNumber.setText(Integer.toString(calculate));
		 			}
		 		}
		 	}
	 	});
	 
	 buttonPanel.add(equalButton);
	 frame.setVisible(true);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addNumberButton(Container container, String name)
	{
		JButton button = new JButton(name);
		
		button.setActionCommand(name);
		button.addActionListener(this);
		container.add(button);
	}
	
	private void addCalculationButton(Container container, int action, String text)
	{
		JButton button = new JButton(text);
		
		button.setActionCommand(text);
		CalculatorAction addButton = new CalculatorAction(1);
		button.addActionListener(addButton);
		container.add(button);
	}
	
	private void subtractCalculationButton(Container container, int action, String text)
	{
		JButton button = new JButton(text);
		
		button.setActionCommand(text);
		CalculatorAction subtractButton = new CalculatorAction(2);
		button.addActionListener(subtractButton);
		container.add(button);
	}
	
	private void multiplyCalculationButton(Container container, int action, String text)
	{
		JButton button = new JButton(text);
		
		button.setActionCommand(text);
		CalculatorAction multiplyButton = new CalculatorAction(3);
		button.addActionListener(multiplyButton);
		container.add(button);
	}
	
	private void divideCalculationButton(Container container, int action, String text)
	{
		JButton button = new JButton(text);
		
		button.setActionCommand(text);
		CalculatorAction divideButton = new CalculatorAction(4);
		button.addActionListener(divideButton);
		container.add(button);
	}
	
	private void powerOfTwoCalculationButton(Container container, int action, String text)
	{
		JButton button = new JButton(text);
		
		button.setActionCommand(text);
		CalculatorAction powerOfTwo = new CalculatorAction(5);
		button.addActionListener(powerOfTwo);
		container.add(button);
	}

	public void actionPerformed(ActionEvent event) 
	{
		String action = event.getActionCommand();		
		calculatorNumber.setText(action);		
	}
	
	private class CalculatorAction implements ActionListener
	{
		private int operator;
		
		public CalculatorAction(int operation)
		{
			operator = operation;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			firstNumber = Integer.parseInt(calculatorNumber.getText());
			calculationOperator = operator;
		}
	}
	
	

}

