import java.io.InvalidObjectException;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * @author James Wedum
 * @date 12/02/2018
 * 
 *       Creates triangle objects in standard form. The angle with the same
 *       letter as a side is the angle opposite to the side. Each triangle has 3
 *       sides and three angles. Angles and sides are rounded to two decimal
 *       places. Empty constructor creates random triangle in either AAS or SAS.
 */
public class Triangle {
	private int sideA, sideB, sideC, angleA, angleB, angleC;
	DecimalFormat df = new DecimalFormat("###.00");

	/**
	 * Creates a random triangle in angle-angle-side or side-angle-side
	 * configuration with random angles having a sum of less than 120 degrees, and
	 * sides with less than 50 units in length.
	 * 
	 */
	public Triangle() {
		double typePicker = new Random().nextGaussian();
		if (typePicker <= .5) {
			// SAS triangle
			typePicker = new Random().nextGaussian();
			if (typePicker <= .33) {
				// generate side A
				sideA = new Random().nextInt(50);
			} else if (typePicker <= .66) {
				// generate side B
				sideB = new Random().nextInt(50);
			} else {
				// generate side C
				sideC = new Random().nextInt(50);
			}
			while (true) {
				typePicker = new Random().nextGaussian();
				if (typePicker <= .33 && sideA == 0) {
					// generate side A
					sideA = new Random().nextInt(50);
					break;
				} else if (typePicker <= .66 && sideB == 0) {
					// generate side B
					sideB = new Random().nextInt(50);
					break;
				} else if (sideC == 0) {
					// generate side C
					sideC = new Random().nextInt(50);
					break;
				}
			}
			if (sideA != 0 && sideB != 0) {
				sideC = 0;
				while (true) {
					angleC = new Random().nextInt(120);
					if (angleC > 15)
						break;
				}
			} else if (sideA != 0 && sideC != 0) {
				sideB = 0;
				while (true) {
					angleB = new Random().nextInt(120);
					if (angleB > 15)
						break;
				}
			} else if (sideB != 0 && sideC != 0) {
				sideA = 0;
				while (true) {
					angleA = new Random().nextInt(120);
					if (angleA > 15)
						break;
				}
			}
			// generate angle between two generated sides
		} else {
			// AAS triangle
			typePicker = new Random().nextGaussian();
			if (typePicker <= .33) {
				while (true) {
					angleA = new Random().nextInt(120);
					angleB = new Random().nextInt(120);
					if (angleA + angleB < 160)
						break;
				}
				typePicker = new Random().nextGaussian();
				if (typePicker < .5) {
					sideA = new Random().nextInt(50);
				} else {
					sideB = new Random().nextInt(50);
				}

			} else if (typePicker <= .66) {
				while (true) {
					angleA = new Random().nextInt(120);
					angleC = new Random().nextInt(120);
					if (angleA + angleC < 160)
						break;
				}
				typePicker = new Random().nextGaussian();
				if (typePicker < .5) {
					sideA = new Random().nextInt(50);
				} else {
					sideC = new Random().nextInt(50);
				}
			} else {
				while (true) {
					angleB = new Random().nextInt(120);
					angleC = new Random().nextInt(120);
					if (angleC + angleB < 160)
						break;
				}
				typePicker = new Random().nextGaussian();
				if (typePicker < .5) {
					sideB = new Random().nextInt(50);
				} else {
					sideC = new Random().nextInt(50);
				}
			}
		}
	}

	/**
	 * Creates a triangle in either angle-angle-side or side-angle-side
	 * configuration with three filled in parameters.
	 * 
	 * @param var1
	 *            for AAS -> angle, for SAS -> side
	 * @param var2
	 *            angle
	 * @param var3
	 *            side
	 * @param type
	 *            0 for AAS, 1 for SAS
	 */
	public Triangle(int var1, int var2, int var3, int type) {
		try {
			if (type != 0 || type != 1) {
				return;
			}
			if (type == 0) {
				angleA = var1;
				angleB = var2;
				sideA = var3;
			} else if (type == 1) {
				sideA = var1;
				angleC = var2;
				sideB = var3;
			}
			if (!this.isValidTriangle()) {
				angleA = angleB = angleC = sideA = sideB = sideC = 0;
				throw new InvalidObjectException("Triangle invalid!");
			}
		} catch (InvalidObjectException e) {
			JOptionPane.showMessageDialog(null, "Invalid triangle!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Helper method to ensure user input triangles are valid. --WORK IN PROGRESS--
	 * 
	 * @return true if triangle is valid
	 */
	private boolean isValidTriangle() {
		return true;
	}
	//some bullshit
	/**
	 * 
	 * @param selection
	 *            Choice of side or angle. Use sideA, sideB, sideC, angleA, angleB,
	 *            or angleC. Ignores case of input. If any other input is used,
	 *            returns 0.
	 * @return value of selected angle or side.
	 */
	public int get(String selection) {
		if (selection.equalsIgnoreCase("sideA"))
			return sideA;
		if (selection.equalsIgnoreCase("sideB"))
			return sideB;
		if (selection.equalsIgnoreCase("sideC"))
			return sideC;
		if (selection.equalsIgnoreCase("angleA"))
			return angleA;
		if (selection.equalsIgnoreCase("angleB"))
			return angleB;
		if (selection.equalsIgnoreCase("angleC"))
			return angleC;
		return 0;
	}
}
