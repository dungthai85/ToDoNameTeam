import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Initializes a window with a model triangle with side length and angles
 * for the user to solve.
 */
public class TriangleProblem {

	private JFrame frmTriangleExercise;
	private JTextField textFieldAngleA;
	private JTextField textFieldAngleB;
	private JTextField textFieldAngleC;
	private JTextField textFieldLengthA;
	private JTextField textFieldLengthB;
	private JTextField textFieldLengthC;

	public static void main(String[] args) {
		try {
			TriangleProblem window = new TriangleProblem();
			window.frmTriangleExercise.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		}
	}

	public TriangleProblem() {
		initialize();
	}

	private void initialize() {
		frmTriangleExercise = new JFrame();
		frmTriangleExercise.setTitle("Triangle Exercise");
		frmTriangleExercise.setBounds(100, 100, 600, 725);
		frmTriangleExercise.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTriangleExercise.getContentPane().setLayout(null);

		JLabel lblHowTo = new JLabel("");
		lblHowTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHowTo.setVerticalAlignment(SwingConstants.TOP);
		lblHowTo.setBounds(10, 11, 246, 727);
		frmTriangleExercise.getContentPane().add(lblHowTo);
		// The HTML tags wrap the text
		// TODO Add to lblHowTo
		lblHowTo.setText("<html>Enter the correct angles and side lengths for the given triangle.</html>");

		// TODO Generate side lengths and angles, add them to their textFields, and set editable for those textFields to false
		JLabel lblTriangle = new JLabel("");
		lblTriangle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriangle.setIcon(new ImageIcon(TriangleProblem.class.getResource("/resources/Triangle.png")));
		lblTriangle.setBounds(293, 21, 265, 309);
		frmTriangleExercise.getContentPane().add(lblTriangle);

		JLabel lblAngleA = new JLabel("Angle A =");
		lblAngleA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAngleA.setBounds(293, 361, 125, 25);
		frmTriangleExercise.getContentPane().add(lblAngleA);
		
		JLabel lblDegreeA = new JLabel("�");
		lblDegreeA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDegreeA.setBounds(490, 361, 20, 25);
		frmTriangleExercise.getContentPane().add(lblDegreeA);

		JLabel lblAngleB = new JLabel("Angle B =");
		lblAngleB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAngleB.setBounds(293, 413, 125, 25);
		frmTriangleExercise.getContentPane().add(lblAngleB);
		
		JLabel lblDegreeB = new JLabel("�");
		lblDegreeB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDegreeB.setBounds(490, 413, 20, 25);
		frmTriangleExercise.getContentPane().add(lblDegreeB);

		JLabel lblAngleC = new JLabel("Angle C =");
		lblAngleC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAngleC.setBounds(293, 461, 125, 25);
		frmTriangleExercise.getContentPane().add(lblAngleC);
		
		JLabel lblDegreeC = new JLabel("�");
		lblDegreeC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDegreeC.setBounds(490, 461, 20, 25);
		frmTriangleExercise.getContentPane().add(lblDegreeC);

		JLabel lblLengthA = new JLabel("Side a =");
		lblLengthA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLengthA.setBounds(293, 508, 125, 25);
		frmTriangleExercise.getContentPane().add(lblLengthA);

		JLabel lblLengthB = new JLabel("Side b =");
		lblLengthB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLengthB.setBounds(293, 553, 125, 25);
		frmTriangleExercise.getContentPane().add(lblLengthB);

		JLabel lblLengthC = new JLabel("Side c =");
		lblLengthC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLengthC.setBounds(293, 594, 125, 25);
		frmTriangleExercise.getContentPane().add(lblLengthC);

		textFieldAngleA = new JTextField();
		textFieldAngleA.setBounds(400, 367, 86, 20);
		frmTriangleExercise.getContentPane().add(textFieldAngleA);
		textFieldAngleA.setColumns(10);

		textFieldAngleB = new JTextField();
		textFieldAngleB.setBounds(400, 419, 86, 20);
		frmTriangleExercise.getContentPane().add(textFieldAngleB);
		textFieldAngleB.setColumns(10);

		textFieldAngleC = new JTextField();
		textFieldAngleC.setBounds(400, 467, 86, 20);
		frmTriangleExercise.getContentPane().add(textFieldAngleC);
		textFieldAngleC.setColumns(10);

		textFieldLengthA = new JTextField();
		textFieldLengthA.setBounds(400, 514, 86, 20);
		frmTriangleExercise.getContentPane().add(textFieldLengthA);
		textFieldLengthA.setColumns(10);

		textFieldLengthB = new JTextField();
		textFieldLengthB.setBounds(400, 559, 86, 20);
		frmTriangleExercise.getContentPane().add(textFieldLengthB);
		textFieldLengthB.setColumns(10);

		textFieldLengthC = new JTextField();
		textFieldLengthC.setBounds(400, 600, 86, 20);
		frmTriangleExercise.getContentPane().add(textFieldLengthC);
		textFieldLengthC.setColumns(10);

		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Add a call to the check method or class with the numbers in the textFields and the inputed answers
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(1);
				}
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheck.setBounds(400, 641, 86, 23);
		frmTriangleExercise.getContentPane().add(btnCheck);
	}

}