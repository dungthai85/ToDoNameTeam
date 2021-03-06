
public class AASTriangles {

	/**
	 * 
	 * @param angleA
	 *            -> this should be opposite
	 * @param angleB
	 *            -> this should be adjacent
	 * @param side
	 * @param whichSide
	 */
	public double[] aasSolver(double angleA, double angleB, double side, char whichSide) {
		double side1, side2;
		double lastAngle = 180 - angleA - angleB;
		if (whichSide == 'a') {
			side1 = (side / Math.sin(angleA)) * Math.sin(angleB);
			side2 = (side / Math.sin(angleA)) * Math.sin(lastAngle);
			double[] missingValues = { lastAngle, side1, side2 };
			// System.out.println("The missing angle is " + lastAngle + ", the two missing
			// sides are " + side1 + " and " + side2 + ".");
			return missingValues;

		} else if (whichSide == 'b') {
			side1 = (side / Math.sin(angleB)) * Math.sin(angleA);
			side2 = (side / Math.sin(angleB)) * Math.sin(lastAngle);
			double[] missingValues = { lastAngle, side1, side2 };
			// System.out.println("The missing angle is " + lastAngle + ", the two missing
			// sides are " + side1 + " and " + side2 + ".");
			return missingValues;

		} else if (whichSide == 'c') {
			side1 = (side / Math.sin(lastAngle)) * Math.sin(angleA);
			side2 = (side / Math.sin(lastAngle)) * Math.sin(angleB);
			double[] missingValues = { lastAngle, side1, side2 };
			// System.out.println("The missing angle is " + lastAngle + ", the two missing
			// sides are " + side1 + " and " + side2 + ".");
			return missingValues;
		} else {
			System.out.println(
					"Please indicate which side is known for the triangle using a lowercase character from a to c.");
			return null;
		}
	}

}