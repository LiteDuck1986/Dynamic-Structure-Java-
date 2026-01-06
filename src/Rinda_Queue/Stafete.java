package Rinda_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;
import saraksts.Biblioteka;

public class Stafete {
	static Queue<Integer> izveidot(int Sk, char burts) {
		Random rand = new Random();
		Queue<Integer> komanda = new LinkedList<>();
		for(int i=0; i<Sk; i++) {
			komanda.add(rand.nextInt(100)+1);
		}
		
		JOptionPane.showMessageDialog(null,
				"Komanda "+burts+ " Izveidota!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		
		return komanda;
	}
	
	static void aplukot (Queue<Integer> komanda, char burts) {
		String virkne = "";
		
		for(Integer dalibnieks : komanda) {
			virkne += dalibnieks + " | ";
		}
		JOptionPane.showMessageDialog(null, virkne,
				"Komanda "+burts, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String izvelne;
		Queue<Integer> komandaA = new LinkedList<>();
		Queue<Integer> komandaB = new LinkedList<>();
		String[] darbibas = {"Izveidot komandas", "Aplūkot komandu A", "Aplūkot komandu B", "Sākt sacensības", "Apturēt"};
		int dalibniekuSk = 0, iteracija = 0;
		boolean beigas = false;
		
		do {
			izvelne = (String)JOptionPane.showInputDialog(null,
					"Izvēleies darbību", "Izvēlne",
					JOptionPane.QUESTION_MESSAGE, null,
					darbibas, darbibas[0]);
			
			if(izvelne == null)
				izvelne = "Apturēt";
			
			switch(izvelne) {
			case "Izveidot komandas":
				dalibniekuSk = Biblioteka.skaitlaParbaude("Cik katrā komandā ir dalībnieki?", 4);
				iteracija = 1;
				
				komandaA = izveidot(dalibniekuSk, 'A');
				komandaB = izveidot(dalibniekuSk, 'B');
				beigas = false;
				break;
				
			case "Aplūkot komandu A":
				if(!komandaA.isEmpty())
					aplukot(komandaA, 'A');
				
				else
					JOptionPane.showMessageDialog(null,
							"Komanda A nemaz nav izveidota!", "Brīdinājums",
							JOptionPane.WARNING_MESSAGE);
				break;
				
			case "Aplūkot komandu B":
				if(!komandaA.isEmpty())
					aplukot(komandaB, 'B');
				
				else
					JOptionPane.showMessageDialog(null,
							"Komanda B nemaz nav izveidota!", "Brīdinājums",
							JOptionPane.WARNING_MESSAGE);
				break;
				
			case "Sākt sacensības":
				if(!komandaA.isEmpty() && !komandaB.isEmpty()) {
					// Sacensības
					JOptionPane.showMessageDialog(null,
							komandaA.peek()+" vs "+komandaB.peek(), "Sacensības",
							JOptionPane.INFORMATION_MESSAGE);
					int A = komandaA.peek();
					int B = komandaB.peek();
					
					if(A > B) {
						
					}else if(A < B) {
						
					}else
						JOptionPane.showMessageDialog(null,
								"Neizšķirts abas puses zaudēju "+iteracija+".", "Sacensības",
								JOptionPane.INFORMATION_MESSAGE);
//					break;
				
				}else
					JOptionPane.showMessageDialog(null,
							"Komandas nemaz nav izveidotas!", "Brīdinājums",
							JOptionPane.WARNING_MESSAGE);
				break;
			}
			
		} while(!izvelne.equals("Apturēt"));
	}

}
