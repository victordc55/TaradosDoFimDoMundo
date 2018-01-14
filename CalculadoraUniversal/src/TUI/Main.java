package TUI;

public class Main {


	public static void main(String[] args) {
		
		IPrinter printer = Printer.getPrinter();
                UserInterface control = UserInterface.getUserInterface();
                control.setPrinter(printer);
                control.init();
	}

}
