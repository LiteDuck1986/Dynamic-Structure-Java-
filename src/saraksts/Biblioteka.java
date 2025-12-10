package saraksts;

import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Biblioteka {
	static String virknesParbaude(String zinojums, String nokl) {
		String ievade;
		
		do {
			ievade = JOptionPane.showInputDialog(null, zinojums, nokl);
			
			if(ievade == null)
				return null;
			
			ievade = ievade.trim();
		} while(!Pattern.matches("^[\\p{L} ]+$", ievade));
		
		return ievade;
	}
	
	static int skaitlaParbaude(String zinojums, int tips) {
		String ievade;
		int skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums,
					"Skaitļa ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(ievade == null)
			return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < 1) {
					JOptionPane.showMessageDialog(null,
							"Ievadīts negatīvs skaitlis!", "Nekorekti dati",
							JOptionPane.WARNING_MESSAGE);
				}
				return skaitlis;
				
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Ievadīts nekorekts datu tips!", "kļūda",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	static double skaitlaParbaude(String zinojums, double tips) {
		String ievade;
		double skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums,
					"Skaitļa ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(ievade == null)
			return -1.0;
			
			try {
				skaitlis = Double.parseDouble(ievade);
				if(skaitlis < 0.1) {
					JOptionPane.showMessageDialog(null,
							"Ievadīts negatīvs skaitlis!", "Nekorekti dati",
							JOptionPane.WARNING_MESSAGE);
				}
				return skaitlis;
				
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Ievadīts nekorekts datu tips!", "kļūda",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

	public static void main(String[] args) {
		String nosaukums, autors, izdevnieciba, izvelne;
		int id = 1, skaits, lppSk, indekss;
		double cena;
		LinkedList<Gramata> plaukts = new LinkedList<>();
		String[] darbibas = {"Pievienot grāmatu",
				"Noņemt grāmatu", "Apskatīt grāmatu",
				"Iznomāt grāmatu", "Apturēt"};
		
		do {
			izvelne = (String)JOptionPane.showInputDialog(null,
					"Izvēlies darbību", "Darbību saraksts",
					JOptionPane.INFORMATION_MESSAGE, null,
					darbibas, darbibas[0]);
			
			if(izvelne == null)
				izvelne = "Apturēt";
			
			switch(izvelne) {
			case "Pievienot grāmatu":
				nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu", "Zaļā pasaka");
				
				if(nosaukums == null)
					break;
				
				autors = virknesParbaude("Ieraksti grāmatas autoru", "Henrijs Zaļais");
				
				if(autors == null)
					break;
				
				izdevnieciba = virknesParbaude("Norādi grāmatas izdevniecību", "Jumava");
				
				if(izdevnieciba == null)
					break;
				
				skaits = skaitlaParbaude("Norādi eksemplāru skaitu", 1);
				if(skaits == -1)
					break;
				
				cena = skaitlaParbaude("Norādi grāmatas cenu", 0.1);
				if(cena == -1.0)
					break;
				
				lppSk = skaitlaParbaude("Norādi lappušu skaitu", 1);
				if(lppSk == -1)
					break;
				
				plaukts.add(new Gramata(id, skaits, lppSk, nosaukums, autors, izdevnieciba,
						cena));
				break;
				
				
			}
			
		} while(!izvelne.equals("Apturēt"));

	}

}
