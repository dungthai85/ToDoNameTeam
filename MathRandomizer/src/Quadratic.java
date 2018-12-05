import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author James Wedum
 * @date 11/25/2018
 * 
 *	Creates quadratic objects for equations in the form of 
 * 	"A*x + B*x^2 + C = 0".  No argument creates random quadratic,
 * 	3 doubles creates quadratic in standard form.  String argument 
 *  parses string into quadratic.
 * */
public class Quadratic {
	private final int A, B, C;
	
	/**
	 *Creates a new quadratic with random doubles between 0 and 100.
	 * 
	 * */
	Quadratic(){
		int multiplier = new Random().nextInt(100);
		/* commented section is for creating quadratics w/ decimals*/
//		DecimalFormat df = new DecimalFormat("###.00");
//		double A = new Random().nextGaussian()*multiplier;
//		multiplier = new Random().nextInt(100);
//		double B = new Random().nextGaussian()*multiplier;
//		multiplier = new Random().nextInt(100);
//		double C = new Random().nextGaussian()*multiplier;
//		this.A=Double.parseDouble(df.format(A));
//		this.B=Double.parseDouble(df.format(B));
//		this.C=Double.parseDouble(df.format(C));
		if(multiplier>=50) {
			this.A=1;
			this.B=new Random().nextInt(100);
			this.C=new Random().nextInt(100);
		}
		else {
			this.A=new Random().nextInt(100);
			this.B=new Random().nextInt(100);
			this.C=new Random().nextInt(100);
		}

	}
				//To be implemented if needed.
//	/**
//	 *Puts equation into standard form and parses into quadratic.
//	 * */
//	Quadratic(String input){
//		Equation userInput = new Equation(input);
//		
//	}
	/**
	 * Constructor accepting all three coefficients in order of standard form.
	 * */
	Quadratic(int A, int B, int C){
		this.A=A;
		this.B=B;
		this.C=C;
	}
	/**
	 * Returns double with coefficient value.  Blows up if passed incorrect parameter.
	 * @param param A, B, or C. 
	 * */
	public int get(String param){
		if(param.equalsIgnoreCase("a"))
			return this.A;
		if(param.equalsIgnoreCase("b"))
			return this.B;
		if(param.equalsIgnoreCase("c"))
			return this.C;
		else return (Integer) null;
	}
	public String toString() {
		return (A+"*x + "+B+"*x^2 + "+C+" = 0\n");
	}
	
	/**
	 * Private helper class for checking if a string is a valid equation.
	 * */
	private class Equation{
		private String input;
		Equation(String input){
			input = input.trim();
		}
		
		@SuppressWarnings("unused")
		Equation() throws Exception{
			throw new Exception("Default constructor unavailable.");
		}
		
	}

}