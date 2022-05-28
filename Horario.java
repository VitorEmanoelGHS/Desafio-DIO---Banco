package dio.desafio.sistemaBancario;

import java.text.SimpleDateFormat;

public class Horario {
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
	
	public Horario() {}
	
	public String getHorario() {
		return timeStamp;
	}
}
