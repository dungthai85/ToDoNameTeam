//
public class AASTriangles {
	
	/**
	 * 
	 * @param angleA
	 * @param angleB
	 * @param side
	 * @param whichSide
	 */
	public void aasSolver(double angleA, double angleB, double side, char whichSide) {
    double side1, side2;
    double lastAngle = 180 - angleA - angleB;
    if (whichSide == 'a') {
        side1 = (side/Math.sin(angleA))*Math.sin(angleB);
        side2 = (side/Math.sin(angleA))*Math.sin(lastAngle);
        System.out.println("The missing angle is " + lastAngle + ", the two missing sides are " + side1 + " and " + side2 + ".");
 
    }else if(whichSide == 'b') {
        side1 = (side/Math.sin(angleB))*Math.sin(angleA);
        side2 = (side/Math.sin(angleB))*Math.sin(lastAngle);
        System.out.println("The missing angle is " + lastAngle + ", the two missing sides are " + side1 + " and " + side2 + ".");
       
    }else if(whichSide == 'c') {
        side1 = (side/Math.sin(lastAngle))*Math.sin(angleA);
        side2 = (side/Math.sin(lastAngle))*Math.sin(angleB);
        System.out.println("The missing angle is " + lastAngle + ", the two missing sides are " + side1 + " and " + side2 + ".");
}else {
    System.out.println("Please indicate which side is known for the triangle using a lowercase character from a to c.");
}
}
}