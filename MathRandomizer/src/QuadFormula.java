
public class QuadFormula {
	double x1, x2;
	String ix1, ix2;
	boolean isImagine = false;
	
	/**
	 * The Quadratic Formula
	 * @param a of (a)x^2+bx+c
	 * @param b of ax^2+(b)x+c
	 * @param c of ax^2+bx+(c)
	 * @return
	 */
	public double[] quadForm (double a, double b, double c) {	

		double d = (b * b) - (4 * a * c);
		double twoRoots[] = new double[3];
		double oneRoot[] = new double[2];
		twoRoots[2] = d;
		oneRoot[1] = d;

		if (d > 0) {
			twoRoots[0] = ( -b + Math.sqrt(d))/(2*a);
			twoRoots[1] = (-b - Math.sqrt(d))/(2*a);
			return twoRoots;

		} else if (d == 0) {
			oneRoot[0] = (-b+Math.sqrt(d))/(2*a);
			return oneRoot;

		} else {
			twoRoots[0] = -b/(2*a);
			twoRoots[1] = (Math.sqrt(-1*d))/(2*a);
			return twoRoots;
		}

	}
	
	/**
	 * The Quadratic Solution
	 * @param a of (a)x^2+bx+c
	 * @param b of ax^2+(b)x+c
	 * @param c of ax^2+bx+(c)
	 */
	public void quadSoln (double a, double b, double c) {
		double d = (b * b) - (4 * a * c);	

		if (d > 0) {
			x1 = quadForm(a,b,c)[0];
			x2 = quadForm(a,b,c)[1];

		} else if (d == 0) {
			x1 = quadForm(a,b,c)[0];
		} else {

			double x1Temp = quadForm(a,b,c)[0];
			double x2Temp = quadForm(a,b,c)[1];
			double bTemp = b/(2*a);
			ix1 = ("" + bTemp + " + "  + x1Temp + "i");
			ix2 = ("" + bTemp + " + "  + x2Temp + "i");
			isImagine = true;
		}
	}
}