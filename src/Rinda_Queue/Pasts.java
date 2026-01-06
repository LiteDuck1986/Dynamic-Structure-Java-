package Rinda_Queue;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;
import saraksts.Biblioteka;

public class Pasts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String izvelne, cilveks = null;
		int kartasNr;
		Queue<String> rinda = new LinkedList<>();
		
		String[] darbibas = {"Nostāties rindā", "Apskatīt pirmo rindā stāvošo", "Noteikt rindas garumu", "Cik pirms manis?",
			"Aplūkot visus rindā stāvošos", "Apkalpot pirmo", "Apturēt"};
		
		do {
			izvelne = (String)JOptionPane.showInputDialog(null,
					"Darbības izvēle", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvelne == null)
				izvelne = "Apturēt";
			
			switch(izvelne) {
			case "Nostāties rindā":
				cilveks = Biblioteka.virknesParbaude("Kā sauc cilvēku?", "Jānis");
				
				if(cilveks == null)
					break;
				
				rinda.add(cilveks);
				JOptionPane.showMessageDialog(null, "Cilvēks nostājās rindā!", "Paziņojums",
						JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "Apskatīt pirmo rindā stāvošo":
				if(!rinda.isEmpty())
					JOptionPane.showMessageDialog(null,
							"Pirmais rindā ir " + rinda.peek(), "Informacija", JOptionPane.INFORMATION_MESSAGE);
					
				else
					JOptionPane.showMessageDialog(null,
							"Rindā neviens nestāv!", "Tukša rinda", JOptionPane.WARNING_MESSAGE);
			}
			
		} while(!izvelne.equals("Apturēt"));
	}

}
