package saraksts;

import java.util.Iterator;
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
	
	static int meklet(LinkedList<Gramata> saraksts, String nosaukums) {
		for(int i=0; i<saraksts.size(); i++) {
			if(saraksts.get(i).getNosaukums().equalsIgnoreCase(nosaukums))
				return i;
		}
		
		return -1;
	}
	
	static boolean jauEksiste(LinkedList<Gramata> saraksts, String elements) {
		for(int i=0; i<saraksts.size(); i++) {
			if(saraksts.get(i).getNosaukums().equalsIgnoreCase(elements)) {
				JOptionPane.showMessageDialog(null, "Tāda grāmata jau ir bibliotēkā!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				return true;
				}
			}
		return false;
	}

	public static void main(String[] args) {
		String nosaukums, autors, izdevnieciba, izvelne;
		int id = 1, skaits, lppSk, indekss;
		double cena;
		LinkedList<Gramata> plaukts = new LinkedList<>();
		String[] darbibas = {"Pievienot grāmatu",
				"Noņemt grāmatu", "Apskatīt grāmatu",
				"Iznomāt grāmatu", "Atdot grāmatu", "Apturēt"};
		
		LinkedList<Gramata> panemtaGramata = new LinkedList<>();
		
		
		do {
			izvelne = (String)JOptionPane.showInputDialog(null,
					"Izvēlies darbību", "Darbību saraksts",
					JOptionPane.INFORMATION_MESSAGE, null,
					darbibas, darbibas[0]);
			
			if(izvelne == null)
				izvelne = "Apturēt";
			
			switch(izvelne) {
			case "Pievienot grāmatu":
				do {
				nosaukums = virknesParbaude("Ieraksti grāmatas nosaukumu", "Zaļā pasaka");
				
				if(nosaukums == null)
					break;
				// Pārbaudīt vai tāda grāmata jau nav ielikta plauktā
			}while((jauEksiste(plaukts, nosaukums) == true) || !nosaukums.matches("^[\\p{L} ]+$"));
				
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
				
			case "Noņemt grāmatu":
				if(plaukts.isEmpty())
					JOptionPane.showMessageDialog(null,
							"Nav plauktā neviena grāmata!", "Brīdinājums",
							JOptionPane.WARNING_MESSAGE);
				
				else {
					nosaukums = virknesParbaude("Kā sauc grāmatu, kuru vēlies noņemt", "Baltā grāmata");
				if(nosaukums == null)
					break;
				
				indekss = meklet(plaukts, nosaukums);
				if(indekss == -1)
					JOptionPane.showMessageDialog(null,
							"Meklētā grāmata nemaz plauktā neatrodas!",
							"Brīdinājums", JOptionPane.WARNING_MESSAGE);
				
				else {
					plaukts.remove(indekss);
					JOptionPane.showMessageDialog(null,
							"Grāmata dzēsta!", "Paziņojums",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				}
				break;
				
			case "Apskatīt grāmatu":
				if(plaukts.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Nav plauktā neviena grāmata!",
							"Brīdinājums", JOptionPane.WARNING_MESSAGE);
				}

				else {
				nosaukums = virknesParbaude(
						"Kuru grāmatu aplūkot?", "Zaļā pasaka");
				if(nosaukums == null)
					break;
				
				indekss = meklet(plaukts, nosaukums);
				if(indekss == -1)
					JOptionPane.showMessageDialog(null,
							"Meklētā grāmata nemaz plauktā neatrodas!",
							"Brīdinājums", JOptionPane.WARNING_MESSAGE);
				
				else 
					plaukts.get(indekss).info();
					
				}
				break;
				
			case "Iznomāt grāmatu":
				if(plaukts.isEmpty())
					JOptionPane.showMessageDialog(null,
							"Nav plauktā neviena grāmata!", "Brīdinājums",
							JOptionPane.WARNING_MESSAGE);
				
				else {
					nosaukums = virknesParbaude(
							"Kuru grāmatu iznomāt?", "Zaļā pasaka");
					if(nosaukums == null)
						break;
					
					indekss = meklet(plaukts, nosaukums);
					if(indekss == -1)
						JOptionPane.showMessageDialog(null,
								"Meklētā grāmata nemaz plauktā neatrodas!",
								"Brīdinājums", JOptionPane.WARNING_MESSAGE);
					
					else {
						plaukts.get(indekss).panemtGramatu();
						panemtaGramata.add(plaukts.get(indekss));
					// Uzglabāt paņemto grāmatu linkedList
					}
				}
				break;
				// Ieviest jaunu iespēju, izvēlēties, no paņemtām grāmatām, kuru tu vēlies atgriezt.
			case "Atdot grāmatu":
				if(panemtaGramata.size() == 0)
					JOptionPane.showMessageDialog(null, "Jums nav iznomāta grāmata", "Paziņojums",
							JOptionPane.INFORMATION_MESSAGE);
				
				else {
					Iterator<Gramata> izvade = panemtaGramata.iterator();
					String str = "";
					while(izvade.hasNext()) {
						str += izvade.next()+"\n";
					}
					JOptionPane.showMessageDialog(null, str, "Paņemtās grāmatas saraksts", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "Apturēt":
				JOptionPane.showMessageDialog(null,
						"Programma tika apturēta!", "Paziņojums",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
			
		} while(!izvelne.equals("Apturēt"));

	}

}
