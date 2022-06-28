package it.polito.tdp.ricorsione.model;

import it.polito.tdp.ricorsione.EntryPoint;

public class TestQuadratoMagico {
	public static void main(String[] args) {
        QuadratoMagico q = new QuadratoMagico();
        
        System.out.println("lato 2");
        q.risoliQuadrato(2);
        
        System.out.println("lato 3");
        q.risoliQuadrato(3);
        
        System.out.println("lato 4");
        q.risoliQuadrato(4);
    }

}
