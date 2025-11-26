package saraksts;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class uzd1 {
	static boolean jauEksiste(LinkedList<String> saraksts, String elements) {
		for(int i=0; i<saraksts.size(); i++) {
			if(saraksts.get(i).equalsIgnoreCase(elements)) {
				JOptionPane.showMessageDialog(null, "This product is already added in the list!", "Error", JOptionPane.WARNING_MESSAGE);
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
			}
		
		}while(!izvele.equals("0"));
	}
}
