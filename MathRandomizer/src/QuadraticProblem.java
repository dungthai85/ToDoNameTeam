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

/**
 * Initializes a window with a model quadratic equation and coefficients
 * for the user to solve.
 */
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
	private JTextField textFieldAnswer1i;
	private JTextField textFieldAnswer2i;

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
					if (solution.length > 2) { // The solution has two roots
						solution[1] = Double.parseDouble(df.format(solution[1]));
					} else { // The solution has one root, so solution[1] is the discriminant instead of a different root
						solution[1] = solution[0];
					}
					String answerString1 = textFieldAnswer1.getText();
					String answerString2 = textFieldAnswer2.getText();
					String answerString1i = textFieldAnswer1i.getText();
					String answerString2i = textFieldAnswer2i.getText();
					if (answerString1.equals("") || answerString2.equals("")) { // A field for the real parts of the roots was left blank
						JOptionPane.showMessageDialog(null, "Please type a number into each left field.", "Blank field", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					double answer1 = Double.parseDouble(answerString1);
					double answer2 = Double.parseDouble(answerString2);
					double answer1i = 0;
					double answer2i = 0;
					if (answerString1i.equals("") == false && answerString2i.equals("") == false) {
						answer1i = Double.parseDouble(answerString1i);
						answer2i = Double.parseDouble(answerString2i);
					}
					if (solution.length < 3 || solution[2] > 0) { // The answer has one or two real roots
						if ((answer1 == solution[0] && answer2 == solution[1]) || (answer2 == solution[0] && answer1 == solution[1])) {
							// The answer is correct
							lblCorrect.setVisible(true);
							lblIncorrect.setVisible(false);
						} else { // The answer is incorrect
							lblIncorrect.setVisible(true);
							lblCorrect.setVisible(false);
						}
						lblRoot1.setVisible(true);
						lblRoot1.setText("Root 1 = " + solution[0]); // Display the answers
						if (solution[0] != solution[1]) {
							lblRoot2.setVisible(true);
							lblRoot2.setText("Root 2 = " + solution[1]);
						}
					} else { // The answer has two complex roots
						solution[1] = Math.abs(solution[1]);
						if (answer1 == solution[0] || answer2 == solution[0]) { // Checks the real parts of the root
							if (answer1i == solution[1] && answer2i == solution[1]) { // Checks the imaginary parts of the root
								// The answer is correct
								lblCorrect.setVisible(true);
								lblIncorrect.setVisible(false);
							} else { // The imaginary parts of the answer are incorrect
								lblIncorrect.setVisible(true);
								lblCorrect.setVisible(false);
							}
						} else { // The real parts of the answer are incorrect
							lblIncorrect.setVisible(true);
							lblCorrect.setVisible(false);
						}
						lblRoot1.setVisible(true);
						lblRoot1.setText("Root 1 = " + solution[0] + " + " + solution[1] + "i"); // Display the answers
						lblRoot2.setVisible(true);
						lblRoot2.setText("Root 2 = " + solution[0] + " - " + solution[1] + "i");
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
		textFieldAnswer1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAnswer1.setBounds(330, 339, 89, 20);
		frmQuadraticExercise.getContentPane().add(textFieldAnswer1);
		textFieldAnswer1.setColumns(10);

		textFieldAnswer2 = new JTextField();
		textFieldAnswer2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAnswer2.setBounds(330, 371, 89, 20);
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
		lblIncorrect.setVisible(false);

		Quadratic fields = new Quadratic(); // Generates coefficients
		fieldValues[0] = fields.get("A");
		fieldValues[1] = fields.get("B");
		fieldValues[2] = fields.get("C");
		lblA.setText("A = " + fieldValues[0]); // Puts the coefficients into their labels
		lblB.setText("B = " + fieldValues[1]);
		lblC.setText("C = " + fieldValues[2]);

		JButton btnNewProblem = new JButton("New problem");
		btnNewProblem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblCorrect.setVisible(false); // Resets the window elements
					lblIncorrect.setVisible(false);
					lblRoot1.setVisible(false);
					lblRoot2.setVisible(false);
					textFieldAnswer1.setText("");
					textFieldAnswer2.setText("");
					textFieldAnswer1i.setText("");
					textFieldAnswer2i.setText("");
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

		textFieldAnswer1i = new JTextField();
		textFieldAnswer1i.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAnswer1i.setBounds(458, 339, 89, 20);
		frmQuadraticExercise.getContentPane().add(textFieldAnswer1i);
		textFieldAnswer1i.setColumns(10);

		JLabel lblPlus = new JLabel("+");
		lblPlus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlus.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlus.setBounds(429, 342, 16, 14);
		frmQuadraticExercise.getContentPane().add(lblPlus);

		JLabel lbli1 = new JLabel("i");
		lbli1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbli1.setHorizontalAlignment(SwingConstants.CENTER);
		lbli1.setBounds(545, 339, 16, 25);
		frmQuadraticExercise.getContentPane().add(lbli1);

		textFieldAnswer2i = new JTextField();
		textFieldAnswer2i.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAnswer2i.setBounds(458, 371, 87, 20);
		frmQuadraticExercise.getContentPane().add(textFieldAnswer2i);
		textFieldAnswer2i.setColumns(10);

		JLabel lbli2 = new JLabel("i");
		lbli2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbli2.setHorizontalAlignment(SwingConstants.CENTER);
		lbli2.setBounds(545, 371, 16, 20);
		frmQuadraticExercise.getContentPane().add(lbli2);

		JLabel lblMinus = new JLabel("-");
		lblMinus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinus.setBounds(429, 373, 16, 14);
		frmQuadraticExercise.getContentPane().add(lblMinus);
	}
}
