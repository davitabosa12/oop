package br.ufc.oop;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Random;

public class Main {

	

	public static void main(String[] args){
		List<Contribuinte> contribuintes = new ArrayList<>();
		DoubleSummaryStatistics somador = new DoubleSummaryStatistics();
		DoubleSummaryStatistics somadorPF = new DoubleSummaryStatistics();
		DoubleSummaryStatistics somadorPJ = new DoubleSummaryStatistics();
		Random random = new Random();
		//popular contribuintes
		for(int i = 0; i < 100; i++){
			if(random.nextBoolean()){
				contribuintes.add(new PFisica("Fisica " + i, random.nextDouble() * 4000, ""));
			} else {
				contribuintes.add(new PJuridica("Juridica " + i, random.nextDouble() * 12000, ""));
			}
		}
		
		for(Contribuinte c : contribuintes){
			double imposto = c.calcularImposto(); 
			somador.accept(imposto);
			
			if(c instanceof PJuridica){
				somadorPJ.accept(imposto);
			} else {
				somadorPF.accept(imposto);
			}
		}
		System.out.println("Imposto total: " + somador.getSum());
		System.out.println("Imposto PF: " + somadorPF.getSum());
		System.out.println("Imposto PJ: " + somadorPJ.getSum());
		System.out.println("Pessoas fisicas: " + somadorPF.getCount());
		System.out.println("Pessoas Juridicas: " + somadorPJ.getCount());
		System.out.println("Media PF: " + somadorPF.getAverage());
		System.out.println("Media PJ: " + somadorPJ.getAverage());
	}

}
