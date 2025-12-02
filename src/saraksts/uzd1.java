package saraksts;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class uzd1 {
	static boolean jauEksiste(LinkedList<String> saraksts, String elements) {
		for(int i=0; i<saraksts.size(); i++) {
			if(saraksts.get(i).equalsIgnoreCase(elements)) {
				JOptionPane.showMessageDialog(null, "Product found in the list!", "Information", JOptionPane.WARNING_MESSAGE);
				return true;
				}
			}
		return false;
	}
			
	public static void main(String[] args) {
	
	String izvele, koPievienot, koAtrast, koNonemt, arKoAizstat;
	int kurPievienot, kurNonemt, kuruMainit;
	
	LinkedList<String> saraksts = new LinkedList<>();
	
	do {
		do {
			izvele = JOptionPane.showInputDialog("1 -Add product\n"
					+ "2 -Product quantity\n"
					+ "3 -Show product\n"
					+ "4 -Find product\n"
					+ "5 -Add to a specific position\n"
					+ "6 -Remove product\n"
					+ "7 -Remove from index"
					+ "8 -Remove first\n"
					+ "9 -Remove last\n"
					+ "10 -Change product\n"
					+ "11 -Sort alphabetically\n"
					+ "12 -Delete from list\n"
					+ "0 -Exit program");
			
			if(izvele == null)
				izvele = "0";
		} while(!izvele.matches("\\d+"));
		
		switch(izvele) {
		case "1":
			do {
				koPievienot = JOptionPane.showInputDialog("What product to add?");
			}while((jauEksiste(saraksts, koPievienot) == true) || !koPievienot.matches("^[\\p{L} ]+$"));
			
			saraksts.add(koPievienot.toLowerCase());
			JOptionPane.showMessageDialog(null, "Product added to the list!", "Information",
					JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "2":
			JOptionPane.showMessageDialog(null, "Product amount: "+saraksts.size(),
					"Information", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "3":
			if(saraksts.size() == 0)
				JOptionPane.showMessageDialog(null, "There are no products listed", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			
			else {
				Iterator<String> izvade = saraksts.iterator();
				String str = "";
				while(izvade.hasNext()) {
					str += izvade.next()+"\n";
				}
				JOptionPane.showMessageDialog(null, str, "Product list", JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		case "4":
			do {	
			koAtrast = JOptionPane.showInputDialog(null, "What product to look for in the list?", "Question",
					JOptionPane.INFORMATION_MESSAGE);
		} while(!koAtrast.matches("^[\\p{L} ]+$"));
		
		JOptionPane.showMessageDialog(null, ((saraksts.indexOf(koAtrast))>-1)?"Product found "+saraksts.indexOf(koAtrast)+". position"
				: "Product not found in the list!", "Information",
				JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "5":
			do {
				koPievienot =
						JOptionPane.showInputDialog("What product to add?");
				kurPievienot = Integer.parseInt(
								JOptionPane.showInputDialog("In which position to add?"));
				
				
				// Nodrošināt to, ka nevar pievienot pa tālu vai pa tuvu
			} while((jauEksiste(saraksts, koPievienot) == true) || 
					!koPievienot.matches("^[\\p{L} ]+$") ||
					kurPievienot > saraksts.size() ||
					kurPievienot < 0);
			saraksts.add(kurPievienot-1, koPievienot);
			JOptionPane.showMessageDialog(null, "Product added to the list!", "Information",
					JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "6":
			do {
				koNonemt = 
						JOptionPane.showInputDialog("What product to remove?");
			} while(!koNonemt.matches("^[\\p{L} ]+$")
					|| !jauEksiste(saraksts, koNonemt));
			
			if(saraksts.remove(koNonemt.toLowerCase()))
				JOptionPane.showMessageDialog(null,
				"Product removed!", "Information",
				JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "7":
			// Papildini ar pārbaudi, lai indekss nav pa lielu/mazu
			do {
			kurNonemt = Integer.parseInt(
					JOptionPane.showInputDialog("What position to remove?"));
			}while(kurNonemt < 0 || kurNonemt >= saraksts.size());
//					if(saraksts.remove(kurNonemt).equals(saraksts))
					JOptionPane.showMessageDialog(null,
							"Product removed!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case "8":
			saraksts.removeFirst();
			break;
			
		case "9":
			saraksts.removeLast();
			break;
			
		case "10":
			// Pielikt pārbaudes indeksam
			do {
				kuruMainit = Integer.parseInt(JOptionPane.showInputDialog("Which index to change?"));
				arKoAizstat = JOptionPane.showInputDialog("What will be the new product?");
			} while(!arKoAizstat.matches("^[\\p{L} ]+$"));
			saraksts.set(kuruMainit, arKoAizstat);
			break;
			
		case "11":
			// Papildināt ar iespēju augoši / dilstoši
			Collections.sort(saraksts);
			break;
			
		case "12":
			// Papildus paziņojums vai tiešām vēlies visu dzēst
			saraksts.clear();
			JOptionPane.showMessageDialog(null, "The whole list is cleared!", "Information",
					JOptionPane.WARNING_MESSAGE);
			break;
			
		case "0":
			JOptionPane.showMessageDialog(null, "Program terminated!", "Information",
					JOptionPane.WARNING_MESSAGE);
			break;
			
			default:
				JOptionPane.showMessageDialog(null,
						"Šāda darbība nepastāv!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		
		}while(!izvele.equals("0"));
	}
}
