
public class SASTriangles {
	public double[] sasSolver(double side1, double angle, double side2) {
		double lastSide, smallAngle, bigAngle, smallSide;
		lastSide = (Math.sqrt( (side1*side1) + (side2*side2) - (2*side1*side2*Math.cos(angle))));
		if ( side1 < side2) {
			smallSide = side1;
		} else {
			smallSide = side2;
		}
		smallAngle = Math.asin(Math.sin(angle)/smallSide*smallSide);
		bigAngle = 180 - angle - smallAngle;
		double[] missingValues = {lastSide, smallAngle, bigAngle};
		//System.out.println("The missing side is " + lastSide + ", the two missing angles are " + smallAngle + " and " + bigAngle + ".");
		return missingValues;
	}
}