package br.com.sansyro.sgp.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUlil {
	
	public static String obterDataHoraAtual() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}
	
	public static String obterHoraAtual() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static String obterDataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public static String obterDataFormatada(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}
	
	public static String obterDataHoraFormatada(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
	}
	
	public static String obterHoraFormatada(Date data) {
		return new SimpleDateFormat("HH:mm:ss").format(data);
	}

}

