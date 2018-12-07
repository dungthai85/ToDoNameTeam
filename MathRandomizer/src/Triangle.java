import java.io.InvalidObjectException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
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
		while (!this.isValidTriangle()) {
			angleA = angleB = angleC = sideA = sideB = sideC = 0;
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
		double angleA = this.angleA, angleB = this.angleB, angleC = this.angleC;
		double sideA = this.sideA, sideB = this.sideB, sideC = this.sideC;
		if ((angleA != 0 && angleB != 0) || (angleA != 0 && angleC != 0) || (angleB != 0 && angleC != 0)) {
			// AAS
			if ((angleA != 0 && angleB != 0)) {
				angleC = 180 - (angleA + angleB);
				if (sideA != 0) {
					sideB = (sideA / Math.sin(angleA)) * Math.sin(angleB);
					sideC = (sideA / Math.sin(angleA)) * Math.sin(angleC);
				} else {
					sideA = (sideB / Math.sin(angleB)) * Math.sin(angleA);
					sideC = (sideB / Math.sin(angleB)) * Math.sin(angleC);
				}
			} else if (angleA != 0 && angleC != 0) {
				angleB = 180 - (angleA + angleC);
				if (sideA != 0) {
					sideB = (sideA / Math.sin(angleA)) * Math.sin(angleB);
					sideC = (sideA / Math.sin(angleA)) * Math.sin(angleC);
				} else {
					sideB = (sideC / Math.sin(angleC)) * Math.sin(angleB);
					sideA = (sideC / Math.sin(angleC)) * Math.sin(angleA);
				}
			} else {
				angleA = 180 - (angleB + angleC);
				if (sideB != 0) {
					sideA = (sideB / Math.sin(angleB)) * Math.sin(angleA);
					sideC = (sideB / Math.sin(angleB)) * Math.sin(angleC);
				} else {
					sideB = (sideC / Math.sin(angleC)) * Math.sin(angleB);
					sideA = (sideC / Math.sin(angleC)) * Math.sin(angleA);
				}
			}

		} else if ((sideA != 0 && sideB != 0) || (sideA != 0 && sideC != 0) || (sideB != 0 && sideC != 0)) {
			// SAS
			if (sideA != 0 && sideB != 0) {
				sideC = Math.sqrt(((sideA * sideA) + (sideB * sideB)) - (2 * sideA * sideB * Math.cos(angleC)));
				if (angleA != 0) {
					angleC = Math.asin(Math.sin(sideA) / (sideA * sideC));
					angleB = 180-(angleC+angleA);
				} else {
					angleC = Math.asin(Math.sin(sideB) / (sideB * sideC));
					angleA = 180-(angleC+angleB);
				}
			} else if (sideA != 0 && sideC != 0) {
				sideB = Math.sqrt(((sideA * sideA) + (sideC * sideC)) - (2 * sideA * sideC * Math.cos(angleB)));
				if (angleA != 0) {
					angleC = Math.asin(Math.sin(sideA) / (sideA * sideC));
					angleB = 180-(angleA+angleC);
				} else {
					angleA = Math.asin(Math.sin(sideC) / (sideC * sideA));
					angleB = 180-(angleA+angleC);
				}
			} else {
				sideA = Math.sqrt(((sideC * sideC) + (sideB * sideB)) - (2 * sideC * sideB * Math.cos(angleA)));
				if (sideB != 0) {
					angleC = Math.asin(Math.sin(sideB) / (sideB * sideC));
					angleA = 180-(angleB+angleC);
				} else {
					angleA = Math.asin(Math.sin(sideC) / (sideC * sideA));
					angleB =180-(angleA+angleC);
				}
			}
		} else
			return false; // neither AAS nor SAS
		if (angleA + angleB + angleC != 180)
			return false;
		if (angleA < 0 || angleB < 0 || angleC < 0)
			return false;
		if (sideA < 0 || sideB < 0 || sideC < 0)
			return false;

		return true;
	}

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

	public int getSide(char side) {
		if (side == 'a')
			return this.sideA;
		if (side == 'b')
			return this.sideB;
		if (side == 'c')
			return this.sideC;
		return 0;
	}

	public void setSide(char side, int val) {
		if (side == 'a') {
			this.sideA = val;
			return;
		}
		if (side == 'b') {
			this.sideB = val;
			return;
		}
		if (side == 'c') {
			this.sideC = val;
			return;
		}
		return;
	}
}
