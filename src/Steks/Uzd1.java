package Steks;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Uzd1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String izvele, vards = "";
		Stack<String> mansSteks = new Stack<>();
		
		String[] darbibas = {"Ievadīt vārdu", "Noteikt vārda garumu", "Apskatīt pēdējo burtu", "Apgriezt vārdu",
				"Apturēt"};
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null,
					"Izvlēlies darbību", "Darbību saraksts",
					JOptionPane.QUESTION_MESSAGE, null,
					darbibas, darbibas[0]);
			
		switch(izvele) {
		case "Ievadīt vārdu":
			
			break;
			
		case "Noteikt vārda garumu":
			
			break;
			
		case "Apskatīt pēdējo burtu":
	
			break;
	
		case "Apgriezt vārdu":
	
			break;
	
		case "Apturēt":
	
			break;
		}
		} while(!izvele.equals("Apturēt"));
	} 

}
