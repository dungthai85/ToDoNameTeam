import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Initializes a launch window with a button for the triangle exercises
 * and a button for the quadratic equation exercises.
 */
public class StartScreen {

	private JFrame frmMathRandomizer;

	public static void main(String[] args) {
		try {
			StartScreen window = new StartScreen();
			window.frmMathRandomizer.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		}
	}

	public StartScreen() {
		initialize();
	}

	private void initialize() {
		frmMathRandomizer = new JFrame();
		frmMathRandomizer.setTitle("MathRandomizer");
		frmMathRandomizer.setBounds(100, 100, 450, 300);
		frmMathRandomizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMathRandomizer.getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("MathRandomizer");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(27, 11, 378, 45);
		frmMathRandomizer.getContentPane().add(lblTitle);

		JButton btnTriangle = new JButton("Triangle Exercises");
		btnTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TriangleProblem();
					TriangleProblem.main(null); // Opens a triangle exercise window
					frmMathRandomizer.setVisible(false);
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(1);
				}
			}
		});
		btnTriangle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTriangle.setBounds(136, 83, 161, 35);
		frmMathRandomizer.getContentPane().add(btnTriangle);

		JButton btnQuadratic = new JButton("Quadratic Equations");
		btnQuadratic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new QuadraticProblem();
					QuadraticProblem.main(null); // Opens a quadratic exercise window
					frmMathRandomizer.setVisible(false);
				}
				catch (Exception E) {
					JOptionPane.showMessageDialog(null, "The program encountered an error. Terminating.", "Error", JOptionPane.ERROR_MESSAGE);
					E.printStackTrace();
					System.exit(1);
				}
			}
		});
		btnQuadratic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuadratic.setBounds(136, 152, 161, 35);
		frmMathRandomizer.getContentPane().add(btnQuadratic);
	}
}
