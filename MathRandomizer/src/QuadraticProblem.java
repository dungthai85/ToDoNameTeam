import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class QuadraticProblem {

	private JFrame frmQuadraticExercise;
	private JTextField textFieldAnswer1;
	private JTextField textFieldAnswer2;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private double[] fieldValues = new double[3];
	private JLabel lblRoot1;
	private JLabel lblRoot2;
	private JLabel lblCorrect;
	private JLabel lblIncorrect;

	public static void main(String[] args) {
		try {
			QuadraticProblem window = new QuadraticProblem();
			window.frmQuadraticExercise.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public QuadraticProblem() {
		initialize();
	}

	private void initialize() {
		frmQuadraticExercise = new JFrame();
		frmQuadraticExercise.setTitle("Quadratic Exercise");
		frmQuadraticExercise.setBounds(100, 100, 600, 500);
		frmQuadraticExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuadraticExercise.getContentPane().setLayout(null);

		JLabel lblHowTo = new JLabel("");
		lblHowTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHowTo.setVerticalAlignment(SwingConstants.TOP);
		lblHowTo.setBounds(10, 11, 246, 125);
		frmQuadraticExercise.getContentPane().add(lblHowTo);
		// TODO Add to lblHowTo
		lblHowTo.setText("<html>Solve the quadratic equation and type each answer into a text box. Each answer must have two"
				+ " numbers right of the decimal point, except for trailing zeros.</html>");

		JLabel lblEquation = new JLabel("ax^2 + bx + c = 0");
		lblEquation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEquation.setBounds(320, 26, 239, 39);
		frmQuadraticExercise.getContentPane().add(lblEquation);

		lblA = new JLabel("a = ");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblA.setBounds(320, 182, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblA);

		lblB = new JLabel("b = ");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblB.setBounds(320, 234, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblB);

		lblC = new JLabel("c = ");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblC.setBounds(320, 292, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblC);

		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					QuadFormula form = new QuadFormula();
					double[] solution = form.quadForm(fieldValues[0], fieldValues[1], fieldValues[2]);
					DecimalFormat df = new DecimalFormat("###.00");
					solution[0] = Double.parseDouble(df.format(solution[0])); // Shortens the numbers
					solution[1] = Double.parseDouble(df.format(solution[1]));
					solution[2] = Double.parseDouble(df.format(solution[2]));
					String answerString1 = textFieldAnswer1.getText();
					String answerString2 = textFieldAnswer2.getText();
					if (answerString1.equals("") || answerString2.equals("")) { // A field was left blank
						JOptionPane.showMessageDialog(null, "Please type a number into each field.", "Blank field", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					double answer1 = Double.parseDouble(answerString1);
					double answer2 = Double.parseDouble(answerString2);
					if ((answer1 == solution[0] && answer2 == solution[1]) || (answer2 == solution[0] && answer1 == solution[1])) {
						// The answer is correct
						lblCorrect.setVisible(true);
						lblIncorrect.setVisible(false);
					}
					else { // The answer is incorrect
						lblIncorrect.setVisible(true);
						lblCorrect.setVisible(false);
					}
					lblRoot1.setVisible(true);
					lblRoot1.setText("Root 1 = " + solution[0]); // Display the answers
					if (solution[0] != solution[1]) {
						lblRoot2.setVisible(true);
						lblRoot2.setText("Root 2 = " + solution[1]);
					}
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(0);
				}
			}
		});
		btnCheck.setBounds(401, 402, 89, 23);
		frmQuadraticExercise.getContentPane().add(btnCheck);

		textFieldAnswer1 = new JTextField();
		textFieldAnswer1.setBounds(370, 339, 149, 20);
		frmQuadraticExercise.getContentPane().add(textFieldAnswer1);
		textFieldAnswer1.setColumns(10);

		textFieldAnswer2 = new JTextField();
		textFieldAnswer2.setBounds(370, 370, 149, 20);
		frmQuadraticExercise.getContentPane().add(textFieldAnswer2);
		textFieldAnswer2.setColumns(10);

		lblRoot1 = new JLabel("Root 1 = ");
		lblRoot1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRoot1.setBounds(320, 100, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblRoot1);
		lblRoot1.setVisible(false);

		lblRoot2 = new JLabel("Root 2 = ");
		lblRoot2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRoot2.setBounds(320, 136, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblRoot2);
		lblRoot2.setVisible(false);

		lblCorrect = new JLabel("Correct");
		lblCorrect.setForeground(Color.GREEN);
		lblCorrect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorrect.setBounds(330, 68, 74, 25);
		frmQuadraticExercise.getContentPane().add(lblCorrect);
		lblCorrect.setVisible(false);

		lblIncorrect = new JLabel("Incorrect");
		lblIncorrect.setForeground(Color.RED);
		lblIncorrect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIncorrect.setBounds(445, 68, 89, 25);
		frmQuadraticExercise.getContentPane().add(lblIncorrect);

		Quadratic fields = new Quadratic(); // Generates coefficients
		fieldValues[0] = fields.get("A");
		fieldValues[1] = fields.get("B");
		fieldValues[2] = fields.get("C");
		lblA.setText("A = " + fieldValues[0]); // Puts the coefficients into their labels
		lblB.setText("B = " + fieldValues[1]);
		lblC.setText("C = " + fieldValues[2]);

		JButton btnNewProblem = new JButton("New problem");
		btnNewProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblCorrect.setVisible(false); // Resets the window elements
					lblIncorrect.setVisible(false);
					lblRoot1.setVisible(false);
					lblRoot2.setVisible(false);
					textFieldAnswer1.setText("");
					textFieldAnswer2.setText("");
					Quadratic fields = new Quadratic(); // Generates new coefficients
					fieldValues[0] = fields.get("A");
					fieldValues[1] = fields.get("B");
					fieldValues[2] = fields.get("C");
					lblA.setText("A = " + fieldValues[0]); // Puts the new coefficients into their labels
					lblB.setText("B = " + fieldValues[1]);
					lblC.setText("C = " + fieldValues[2]);
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(0);
				}
			}
		});
		btnNewProblem.setBounds(10, 427, 113, 23);
		frmQuadraticExercise.getContentPane().add(btnNewProblem);
		lblIncorrect.setVisible(false);
	}

}
