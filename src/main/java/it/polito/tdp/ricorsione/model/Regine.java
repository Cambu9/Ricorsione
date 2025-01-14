package it.polito.tdp.ricorsione.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {
	
	List<List<Integer>> tutte;
	
	public List<List<Integer>> cercaRegine (int N) { //serve per avviare la ricorsione (prima interazione)
		this.tutte = new ArrayList<List<Integer>>();
		List<Integer> parziale = new ArrayList<Integer>();
		regine_ricorsiva(parziale, 0, N);
		return this.tutte;
	}
	
	private void regine_ricorsiva(List<Integer> parziale, int livello, int N) {
		if(livello==N) { //caso terminale
 //           System.out.println(parziale);
			this.tutte.add(new ArrayList<Integer> (parziale));
		} else {
			//ho già parziale[0] fino a parziale[livello-1] già decise 
			//devo decidere parziale[livello] tra tutti i valori possibili
			// da 0 a N-1 (colonne), purchè compatibili
			for (int col=0; col<N; col++) {
				if(compatibile(livello, col, parziale)) { //col compatibile con parziale
					parziale.add(col);
					regine_ricorsiva(parziale, livello+1, N);
					parziale.remove(parziale.size()-1); // backtracking (ritornare sui propri passi, per poter fare ulteriori tentativi)
				}
			}
		}
	}
	
	private boolean compatibile(int livello, Integer col, List<Integer> parziale){
		if(parziale.indexOf(new Integer(col)) != -1) //controllo sulle righe
			return false;
		for(int riga = 0; riga < parziale.size(); riga++) {
			// regina alle coordinate (R,C)=(riga, parziale.get(riga))
			// confrontare con (r,c)=(livello, col)
			if(riga+parziale.get(riga) == livello+col)
				return false;
			if(riga-parziale.get(riga) == livello-col)
				return false;
		}
		return true;
	}

}
