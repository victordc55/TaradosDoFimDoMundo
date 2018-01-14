package TUI;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import calculadorauniversal.ICalculadoraUniversal;

public class Utils {
	
	
	/* esta class contem as variaveis necessario */
	
	
	private PrintStream out = System.out;
	private Scanner in = new Scanner(System.in);
	private String completeNumericalPattern = "[d-M-yyyy ][H:mm:ss ][VV ][O ][G]";
	private String extendedPattern = "[EEEE d MMMM yyyy ][H:mm:ss ][VV ][OOOO ]['Era' G ]['Trimestre' Q]";
	private DateTimeFormatter printFormat = DateTimeFormatter.ofPattern(completeNumericalPattern);
	private ICalculadoraUniversal calculadoraUniversal;
	private ITextualUI currentUI ;
	private Relogio relogio;
	
	
	public PrintStream getOut() {
		return out;
	}
	public void setOut(PrintStream out) {
		this.out = out;
	}
	public Scanner getIn() {
		return in;
	}
	public void setIn(Scanner in) {
		this.in = in;
	}
	public String getCompleteNumericalPattern() {
		return completeNumericalPattern;
	}
	public void setCompleteNumericalPattern(String completeNumericalPattern) {
		this.completeNumericalPattern = completeNumericalPattern;
	}
	public String getExtendedPattern() {
		return extendedPattern;
	}
	public void setExtendedPattern(String extendedPattern) {
		this.extendedPattern = extendedPattern;
	}
	public DateTimeFormatter getPrintFormat() {
		return printFormat;
	}
	public void setPrintFormat(DateTimeFormatter printFormat) {
		this.printFormat = printFormat;
	}
	public ICalculadoraUniversal getCalculadoraUniversal() {
		return calculadoraUniversal;
	}
	public void setCalculadoraUniversal(ICalculadoraUniversal calculadoraUniversal) {
		this.calculadoraUniversal = calculadoraUniversal;
	}
	public ITextualUI getCurrentUI() {
		return currentUI;
	}
	public void setCurrentUI(ITextualUI currentUI) {
		this.currentUI = currentUI;
	}
	public Relogio getRelogio() {
		return relogio;
	}
	public void setRelogio(Relogio relogio) {
		this.relogio = relogio;
	}
	
	
	
	

}
