package Rinda_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;

public class Loterija {
	
	static ArrayList<Integer> cipari = new ArrayList<Integer>();
	static Queue<Integer> bilete = new LinkedList<>();
	static Queue<Integer> laimigie = new LinkedList<>();
	
	static boolean saktaIzloze = false;
	
	public static void saktIzlozi() {
		Random rand = new Random();
		String str = "";
		
		for(int i=1; i<=24; i++) {
			cipari.add(i);
		}
		
		Collections.shuffle(cipari);
		
		str += "Izlozē piedalās šādi skaitļi:\n"+cipari+"\n";
		
		// Laimīgie skaitļi
		int skIndekss;
		for(int i=0; i<6; i++) {
			do {
				skIndekss = rand.nextInt(cipari.size());
			} while(laimigie.contains(cipari.get(skIndekss)) == true);
			laimigie.add(cipari.get(skIndekss));
		}
		str += "\nLaimīgie izlozes skaitļi:\n"+laimigie+"\n";
		
		// Biļetes skaitļi
		for(int i=0; i<laimigie.size(); i++) {
			skIndekss = rand.nextInt(laimigie.size());
			bilete.add(cipari.get(skIndekss));
			cipari.remove(skIndekss);
		}
		
		str += "\nTavā izlozes biļetē ir skaitļi:\n"+bilete+"\n";
		JOptionPane.showMessageDialog(null, str, "Izloze galā",
				JOptionPane.INFORMATION_MESSAGE);
		saktaIzloze = true;
	}
	
	public static void salidzinat() {
		Queue<Integer> sakrit = new LinkedList<Integer>();
		int kurs;
		
		for(int i=0; i<bilete.size(); i++) {
			kurs = laimigie.peek();
			if(bilete.contains(laimigie.remove()))
				sakrit.add(kurs);
		}
		
		JOptionPane.showMessageDialog(null, "Tavā biļetē ir "+
		sakrit+" laimējušie skaitļi:\n"+sakrit,
		"Salīdzinājums", JOptionPane.INFORMATION_MESSAGE);
		
		cipari.clear();
		bilete.clear();
		laimigie.clear();
		sakrit.clear();
		saktaIzloze = false;
	}

	public static void main(String[] args) {
		
		String izvelne;
		
		do {
			izvelne = JOptionPane.showInputDialog(null,
					"1 -Veikt izlozi\n2 -Salīdzināt skaitļus\n "
					+ "3 -Apturēt", "Izvēlne", JOptionPane.QUESTION_MESSAGE);
			
			if(izvelne == null)
				izvelne = "3";
			
			switch(izvelne) {
			case "1":
				if(!saktaIzloze)
					saktIzlozi();
				
				else
					JOptionPane.showMessageDialog(null,
							"Izloze jau ir noslēgusies!", "Brīdinājums",
							JOptionPane.WARNING_MESSAGE);
				break;
				
			case "2":
				if(saktaIzloze)
					salidzinat();
				
				else
					JOptionPane.showMessageDialog(null,
							"Izloze vēl nav notikusi!", "Brīdinājums",
							JOptionPane.WARNING_MESSAGE);
				break;
				
			case "3":
				JOptionPane.showMessageDialog(null,
						"Programma apturēta!", "Brīdinājums",
						JOptionPane.WARNING_MESSAGE);
				break;
				
			default:
			}
			
		} while(!izvelne.equals("3"));

	}

}
