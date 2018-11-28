import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class QuadraticProblem {

	private JFrame frmQuadraticExercise;
	private JTextField textFieldAnswer;

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
		lblHowTo.setBounds(10, 11, 246, 727);
		frmQuadraticExercise.getContentPane().add(lblHowTo);
		// TODO Add to lblHowTo
		lblHowTo.setText("<html>Solve the quadratic equation and type the answer into the text box.</html>");

		JLabel lblEquation = new JLabel("ax^2 + bx + c = 0");
		lblEquation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEquation.setBounds(320, 26, 239, 39);
		frmQuadraticExercise.getContentPane().add(lblEquation);

		// TODO Generate numbers for the coefficients and add them to their labels
		JLabel lblA = new JLabel("a = ");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblA.setBounds(320, 182, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblA);

		JLabel lblB = new JLabel("b =");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblB.setBounds(320, 234, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblB);

		JLabel lblC = new JLabel("c =");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblC.setBounds(320, 292, 225, 25);
		frmQuadraticExercise.getContentPane().add(lblC);

		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// TODO Add a call to the check method or class with the numbers in the labels and the inputed answer
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(0);
				}
			}
		});
		btnCheck.setBounds(402, 407, 89, 23);
		frmQuadraticExercise.getContentPane().add(btnCheck);

		textFieldAnswer = new JTextField();
		textFieldAnswer.setBounds(374, 361, 149, 20);
		frmQuadraticExercise.getContentPane().add(textFieldAnswer);
		textFieldAnswer.setColumns(10);
	}
}
