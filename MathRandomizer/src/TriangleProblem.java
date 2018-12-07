import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
	private JLabel lblCorrectAngleA;
	private JLabel lblCorrectAngleB;
	private JLabel lblCorrectAngleC;
	private JLabel lblCorrectLengthA;
	private JLabel lblCorrectLengthB;
	private JLabel lblCorrectLengthC;
	private JLabel lblCorrect;
	private JLabel lblIncorrect;
	private boolean SAS = false;
	private double side1 = 0; // Generated sides and angles
	private double side2 = 0;
	private double angle1 = 0;
	private double angle2 = 0;
	private boolean[] enteredLengths = new boolean[3]; // Records which field each length was entered in with the order [A, B, C]
	private boolean[] enteredAngles = new boolean[3]; // Records which field each angle was entered in with the order [A, B, C]
	private boolean isCorrect = true; // Keeps track if an entered angle or side is incorrect
	private boolean isGenerated = false;
	private double[] sides = new double[3];
	private double[] angles = new double[3];

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
		lblHowTo.setBounds(10, 11, 246, 162);
		frmTriangleExercise.getContentPane().add(lblHowTo);
		// The HTML tags wrap the text
		lblHowTo.setText("<html>Enter the correct angles and side lengths for the given triangle. Each answer must have"
				+ " two numbers right of the decimal point, except for trailing zeros.</html>");

		JLabel lblTriangle = new JLabel("");
		lblTriangle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriangle.setIcon(new ImageIcon(TriangleProblem.class.getResource("/resources/Triangle.png")));
		lblTriangle.setBounds(293, 21, 265, 309);
		frmTriangleExercise.getContentPane().add(lblTriangle);

		JLabel lblAngleA = new JLabel("Angle A =");
		lblAngleA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAngleA.setBounds(293, 361, 125, 25);
		frmTriangleExercise.getContentPane().add(lblAngleA);

		JLabel lblDegreeA = new JLabel("°");
		lblDegreeA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDegreeA.setBounds(490, 361, 20, 25);
		frmTriangleExercise.getContentPane().add(lblDegreeA);

		JLabel lblAngleB = new JLabel("Angle B =");
		lblAngleB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAngleB.setBounds(293, 413, 125, 25);
		frmTriangleExercise.getContentPane().add(lblAngleB);

		JLabel lblDegreeB = new JLabel("°");
		lblDegreeB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDegreeB.setBounds(490, 413, 20, 25);
		frmTriangleExercise.getContentPane().add(lblDegreeB);

		JLabel lblAngleC = new JLabel("Angle C =");
		lblAngleC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAngleC.setBounds(293, 461, 125, 25);
		frmTriangleExercise.getContentPane().add(lblAngleC);

		JLabel lblDegreeC = new JLabel("°");
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
					lblCorrectLengthA.setText("");
					lblCorrectLengthB.setText("");
					lblCorrectLengthC.setText("");
					lblCorrectAngleA.setText("");
					lblCorrectAngleB.setText("");
					lblCorrectAngleC.setText("");
					DecimalFormat df = new DecimalFormat("###.00");
					if (isGenerated == false) { // Retrieves the values from the textFields if they are not already generated
						sides[0] = Double.parseDouble(df.format(Double.parseDouble(textFieldLengthA.getText().trim())));
						sides[1] = Double.parseDouble(df.format(Double.parseDouble(textFieldLengthB.getText().trim())));
						sides[2] = Double.parseDouble(df.format(Double.parseDouble(textFieldLengthC.getText().trim())));
						angles[0] = Double.parseDouble(df.format(Double.parseDouble(textFieldAngleA.getText().trim())));
						angles[1] = Double.parseDouble(df.format(Double.parseDouble(textFieldAngleB.getText().trim())));
						angles[2] = Double.parseDouble(df.format(Double.parseDouble(textFieldAngleC.getText().trim())));
						int sideCount = 0;
						int angleCount = 0;
						for (int i = 0; i < 3; i++) {
							if (sides[i] != 0) {
								if (i > 0 && (sides[i - 1] != 0 || sides[i - 2] != 0)) {
									side2 = sides[i];
									sideCount++;
									enteredLengths[i] = true;
								} else {
									side1 = sides[i];
									sideCount++;
									enteredLengths[i] = true;
								}
								if (i > 0 && (angles[i - 1] != 0 || angles[i - 2] != 0)) {
									angle2 = angles[i];
									angleCount++;
									enteredAngles[i] = true;
								} else {
									angle1 = angles[i];
									angleCount++;
									enteredAngles[i] = true;
								}
							}
						}
						if (sideCount >= 2 && angleCount >= 1) {
							SAS = true;
						}
					}
					if (SAS) {
						SASTriangles SASSolver = new SASTriangles();
						double[] missingValues = SASSolver.sasSolver(side1, angle1, side2);
						missingValues[0] = Double.parseDouble(df.format(missingValues[0]));
						missingValues[1] = Double.parseDouble(df.format(missingValues[1]));
						missingValues[2] = Double.parseDouble(df.format(missingValues[2]));
						if (enteredLengths[0] == false) { // The missing side is in field A
							if (textFieldLengthA.getText().trim().equals("") == false) {
								double enteredAnswer = Double.parseDouble(textFieldLengthA.getText());
								enteredAnswer = Double.parseDouble(df.format(enteredAnswer));
								if (enteredAnswer == missingValues[0]) {
									answerCorrect();
								} else {
									answerIncorrect();
								}
								lblCorrectLengthA.setText("Side a = " + missingValues[0]);
							} else {
								answerIncorrect();
							}
						} else if (enteredLengths[1] == false) { // The missing side is in field B
							if (textFieldLengthB.getText().trim().equals("") == false) {
								double answer = Double.parseDouble(textFieldLengthB.getText());
								answer = Double.parseDouble(df.format(answer));
								if (answer == missingValues[0]) {
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectLengthB.setText("Side b = " + missingValues[0]);
						} else { // The missing side is in field C
							if (textFieldLengthC.getText().trim().equals("") == false) {
								double answer = Double.parseDouble(textFieldLengthC.getText());
								answer = Double.parseDouble(df.format(answer));
								if (answer == missingValues[0]) {
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectLengthC.setText("Side c = " + missingValues[0]);
						}
						if (enteredAngles[0]) { // The missing angles are in field B and C
							if (textFieldAngleB.getText().trim().equals("") == false && textFieldAngleC.getText().trim().equals("") == false) {
								double answer1 = Double.parseDouble(textFieldAngleB.getText());
								double answer2 = Double.parseDouble(textFieldAngleC.getText());
								answer1 = Double.parseDouble(df.format(answer1));
								answer2 = Double.parseDouble(df.format(answer2));
								if ((answer1 == missingValues[1] && answer2 == missingValues[2]) || (answer2 == missingValues[1] && answer1 == missingValues[2])) { 
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectAngleB.setText("Angle B = " + missingValues[1] + "°");
							lblCorrectAngleC.setText("Angle C = " + missingValues[2] + "°");
						} else if (enteredAngles[1]) { // The missing angles are in field A and C
							if (textFieldAngleA.getText().trim().equals("") == false && textFieldAngleC.getText().trim().equals("") == false) {
								double answer1 = Double.parseDouble(textFieldAngleA.getText());
								double answer2 = Double.parseDouble(textFieldAngleC.getText());
								answer1 = Double.parseDouble(df.format(answer1));
								answer2 = Double.parseDouble(df.format(answer2));
								if ((answer1 == missingValues[1] && answer2 == missingValues[2]) || (answer2 == missingValues[1] && answer1 == missingValues[2])) { 
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectAngleA.setText("Angle A = " + missingValues[1] + "°");
							lblCorrectAngleC.setText("Angle C = " + missingValues[2] + "°");
						} else { // The missing angles are in field A and B
							if (textFieldAngleA.getText().trim().equals("") == false && textFieldAngleB.getText().trim().equals("") == false) {
								double answer1 = Double.parseDouble(textFieldAngleA.getText());
								double answer2 = Double.parseDouble(textFieldAngleB.getText());
								answer1 = Double.parseDouble(df.format(answer1));
								answer2 = Double.parseDouble(df.format(answer2));
								if ((answer1 == missingValues[1] && answer2 == missingValues[2]) || (answer2 == missingValues[1] && answer1 == missingValues[2])) { 
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectAngleA.setText("Angle A = " + missingValues[1] + "°");
							lblCorrectAngleB.setText("Angle B = " + missingValues[2] + "°");
						}
					} else { // The triangle is AAS
						AASTriangles AASSolver = new AASTriangles();
						double[] missingValues = null;
						if (enteredLengths[0]) { // The known side is length A
							missingValues = AASSolver.aasSolver(angle1, angle2, side1, 'a');
						} else if (enteredLengths[1]) { // The known side is length B
							missingValues = AASSolver.aasSolver(angle1, angle2, side1, 'b');
						} else { // The known side is length C
							missingValues = AASSolver.aasSolver(angle1, angle2, side1, 'c');
						}
						missingValues[0] = Double.parseDouble(df.format(missingValues[0]));
						missingValues[1] = Double.parseDouble(df.format(missingValues[1]));
						missingValues[2] = Double.parseDouble(df.format(missingValues[2]));
						if (enteredAngles[0] == false) { // The missing angle is in field A
							if (textFieldAngleA.getText().trim().equals("") == false) {
								double answer = Double.parseDouble(textFieldAngleA.getText());
								answer = Double.parseDouble(df.format(answer));
								if (answer == missingValues[0]) {
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectAngleA.setText("Angle A = " + missingValues[0] + "°");
						} else if (enteredAngles[1] == false) { // The missing angle is in field B
							if (textFieldAngleB.getText().trim().equals("") == false) {
								double answer = Double.parseDouble(textFieldAngleB.getText());
								answer = Double.parseDouble(df.format(answer));
								if (answer == missingValues[0]) {
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectAngleB.setText("Angle B = " + missingValues[0] + "°");
						} else { // The missing angle is in field C
							if (textFieldAngleC.getText().trim().equals("") == false) {
								double answer = Double.parseDouble(textFieldAngleC.getText());
								answer = Double.parseDouble(df.format(answer));
								if (answer == missingValues[0]) {
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectAngleC.setText("Angle C = " + missingValues[0] + "°");
						}
						if (enteredLengths[0]) { // The missing lengths are in field B and C
							if (textFieldLengthB.getText().trim().equals("") == false && textFieldLengthC.getText().trim().equals("") == false) {
								double answer1 = Double.parseDouble(textFieldLengthB.getText());
								double answer2 = Double.parseDouble(textFieldLengthC.getText());
								answer1 = Double.parseDouble(df.format(answer1));
								answer2 = Double.parseDouble(df.format(answer2));
								if ((answer1 == missingValues[1] && answer2 == missingValues[2]) || (answer2 == missingValues[1] && answer1 == missingValues[2])) { 
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectLengthB.setText("Side b = " + missingValues[1]);
							lblCorrectLengthC.setText("Side c = " + missingValues[2]);
						} else if (enteredLengths[1]) { // The missing lengths are in field A and C
							if (textFieldLengthA.getText().trim().equals("") == false && textFieldLengthC.getText().trim().equals("") == false) {
								double answer1 = Double.parseDouble(textFieldLengthA.getText());
								double answer2 = Double.parseDouble(textFieldLengthC.getText());
								answer1 = Double.parseDouble(df.format(answer1));
								answer2 = Double.parseDouble(df.format(answer2));
								if ((answer1 == missingValues[1] && answer2 == missingValues[2]) || (answer2 == missingValues[1] && answer1 == missingValues[2])) { 
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectLengthA.setText("Side a = " + missingValues[1]);
							lblCorrectLengthC.setText("Side c = " + missingValues[2]);
						} else { // The missing lengths are in field A and B
							if (textFieldLengthA.getText().trim().equals("") == false && textFieldLengthB.getText().trim().equals("") == false) {
								double answer1 = Double.parseDouble(textFieldLengthA.getText());
								double answer2 = Double.parseDouble(textFieldLengthB.getText());
								answer1 = Double.parseDouble(df.format(answer1));
								answer2 = Double.parseDouble(df.format(answer2));
								if ((answer1 == missingValues[1] && answer2 == missingValues[2]) || (answer2 == missingValues[1] && answer1 == missingValues[2])) { 
									answerCorrect();
								} else {
									answerIncorrect();
								}
							} else {
								answerIncorrect();
							}
							lblCorrectLengthA.setText("Side a = " + missingValues[1]);
							lblCorrectLengthB.setText("Side b = " + missingValues[2]);
						}
					}
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

		JButton btnGenerateTriangle = new JButton("Generate Triangle");
		btnGenerateTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblCorrectLengthA.setText(""); // Clears the fields
					lblCorrectLengthB.setText("");
					lblCorrectLengthC.setText("");
					lblCorrectAngleA.setText("");
					lblCorrectAngleB.setText("");
					lblCorrectAngleC.setText("");
					textFieldLengthA.setText("");
					textFieldLengthB.setText("");
					textFieldLengthC.setText("");
					textFieldAngleA.setText("");
					textFieldAngleB.setText("");
					textFieldAngleC.setText("");
					textFieldLengthA.setEditable(true);
					textFieldLengthB.setEditable(true);
					textFieldLengthC.setEditable(true);
					textFieldAngleA.setEditable(true);
					textFieldAngleB.setEditable(true);
					textFieldAngleC.setEditable(true);
					side1 = 0; // Resets the stored sides and angles
					side2 = 0;
					angle1 = 0;
					angle2 = 0;
					enteredLengths = new boolean[3];
					enteredAngles = new boolean[3];
					lblCorrect.setVisible(false);
					lblIncorrect.setVisible(false);
					isCorrect = true;
					Triangle triangle = new Triangle();
					int lengths = 0; // Tracks the number of generated lengths
					int angles = 0; // Tracks the number of generated sides
					if (triangle.get("sideA") != 0) {
						textFieldLengthA.setText("" + triangle.get("sideA")); // Inserts the length into the textField
						textFieldLengthA.setEditable(false);
						side1 = triangle.get("sideA");
						enteredLengths[0] = true;
						lengths += 1;
					}
					if (triangle.get("sideB") != 0) {
						textFieldLengthB.setText("" + triangle.get("sideB"));
						textFieldLengthB.setEditable(false);
						if (side1 == 0) { // Side1 has not already been set
							side1 = triangle.get("sideB");
						} else {
							side2 = triangle.get("sideB");
						}
						enteredLengths[1] = true;
						lengths += 1;
					}
					if (triangle.get("sideC") != 0) {
						textFieldLengthC.setText("" + triangle.get("sideC"));
						textFieldLengthC.setEditable(false);
						if (side1 == 0) {
							side1 = triangle.get("sideC");
						} else {
							side2 = triangle.get("sideC");
						}
						enteredLengths[2] = true;
						lengths += 1;
					}
					if (triangle.get("angleA") != 0) {
						textFieldAngleA.setText("" + triangle.get("angleA"));
						textFieldAngleA.setEditable(false);
						angle1 = triangle.get("angleA");
						enteredAngles[0] = true;
						angles += 1;
					}
					if (triangle.get("angleB") != 0) {
						textFieldAngleB.setText("" + triangle.get("angleB"));
						textFieldAngleB.setEditable(false);
						if (angle1 == 0) {
							angle1 = triangle.get("angleB");
						} else {
							angle2 = triangle.get("angleB");
						}
						enteredAngles[1] = true;
						angles += 1;
					}
					if (triangle.get("angleC") != 0) {
						textFieldAngleC.setText("" + triangle.get("angleC"));
						textFieldAngleC.setEditable(false);
						if (angle1 == 0) {
							angle1 = triangle.get("angleC");
						} else {
							angle2 = triangle.get("angleC");
						}
						enteredAngles[2] = true;
						angles += 1;
					}
					if (lengths == 2 && angles == 1) {
						SAS = true; // The triangle is SAS
					} else if (lengths == 1 && angles == 2) {
						SAS = false; // The triangle is AAS
					} else { // An error occurred
/****************************************************
 * There is some kind of bug that is randomly blowing up here.
 * Takes between 5 and 100 generates to encounter, but the program
 * terminates for unknown triangle.  Checked the constructors and
 * found no issue, and whatever it is is making it past my
 * isValidTriangle method.  I've only seen it occur on AAS
 * triangles, but I can't find a pattern other than that.
 * 
 * James - 12/7/18 1:14AM
 * ********************************************
 * Bug appears to be fixed.
 * 
 * James - 12/7/18 1:42AM
 * ************************************************/
						throw new RuntimeException("Unable to identify the type of triangle generated.");
					}
					isGenerated = true;
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(1);
				}
			}
		});
		btnGenerateTriangle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGenerateTriangle.setBounds(55, 500, 155, 23);
		frmTriangleExercise.getContentPane().add(btnGenerateTriangle);

		JButton btnNewCustomTriangle = new JButton("Clear Fields");
		btnNewCustomTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblCorrectLengthA.setText(""); // Clears the fields
					lblCorrectLengthB.setText("");
					lblCorrectLengthC.setText("");
					lblCorrectAngleA.setText("");
					lblCorrectAngleB.setText("");
					lblCorrectAngleC.setText("");
					textFieldLengthA.setText("");
					textFieldLengthB.setText("");
					textFieldLengthC.setText("");
					textFieldAngleA.setText("");
					textFieldAngleB.setText("");
					textFieldAngleC.setText("");
					textFieldLengthA.setEditable(true);
					textFieldLengthB.setEditable(true);
					textFieldLengthC.setEditable(true);
					textFieldAngleA.setEditable(true);
					textFieldAngleB.setEditable(true);
					textFieldAngleC.setEditable(true);
					side1 = 0; // Resets the stored sides and angles
					side2 = 0;
					angle1 = 0;
					angle2 = 0;
					enteredLengths = new boolean[3];
					enteredAngles = new boolean[3];
					isGenerated = false;
					isCorrect = true;
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(1);
				}
			}
		});
		btnNewCustomTriangle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewCustomTriangle.setBounds(55, 550, 155, 23);
		frmTriangleExercise.getContentPane().add(btnNewCustomTriangle);

		lblCorrectAngleA = new JLabel();
		lblCorrectAngleA.setBounds(55, 200, 200, 20);
		frmTriangleExercise.getContentPane().add(lblCorrectAngleA);

		lblCorrectAngleB = new JLabel();
		lblCorrectAngleB.setBounds(55, 240, 200, 20);
		frmTriangleExercise.getContentPane().add(lblCorrectAngleB);

		lblCorrectAngleC = new JLabel();
		lblCorrectAngleC.setBounds(55, 280, 200, 20);
		frmTriangleExercise.getContentPane().add(lblCorrectAngleC);

		lblCorrectLengthA = new JLabel();
		lblCorrectLengthA.setBounds(55, 320, 200, 20);
		frmTriangleExercise.getContentPane().add(lblCorrectLengthA);

		lblCorrectLengthB = new JLabel();
		lblCorrectLengthB.setBounds(55, 360, 200, 20);
		frmTriangleExercise.getContentPane().add(lblCorrectLengthB);

		lblCorrectLengthC = new JLabel();
		lblCorrectLengthC.setBounds(55, 400, 200, 20);
		frmTriangleExercise.getContentPane().add(lblCorrectLengthC);

		lblCorrect = new JLabel("Correct");
		lblCorrect.setForeground(Color.GREEN);
		lblCorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorrect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorrect.setBounds(10, 430, 86, 20);
		frmTriangleExercise.getContentPane().add(lblCorrect);
		lblCorrect.setVisible(false);

		lblIncorrect = new JLabel("Incorrect");
		lblIncorrect.setForeground(Color.RED);
		lblIncorrect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIncorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrect.setBounds(126, 430, 95, 20);
		frmTriangleExercise.getContentPane().add(lblIncorrect);
		lblIncorrect.setVisible(false);
	}

	public void answerCorrect() {
		try {
			if (isCorrect) {
				lblIncorrect.setVisible(false);
				lblCorrect.setVisible(true);
			}
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
			E.printStackTrace();
			System.exit(1);
		}
	}

	public void answerIncorrect() {
		try {
			lblCorrect.setVisible(false);
			isCorrect = false;
			lblIncorrect.setVisible(true);
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
			E.printStackTrace();
			System.exit(1);
		}
	}
}