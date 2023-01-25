package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Locadora {
	private String modelo;
	private Date retirada;
	private Date retorno;
	private Double precoH;
	private Double precoD;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Locadora() {

	}

	public Locadora(String modelo, Date retirada, Date retorno, Double precoH, Double precoD) {
		super();
		this.modelo = modelo;
		this.retirada = retirada;
		this.retorno = retorno;
		this.precoH = precoH;
		this.precoD = precoD;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getRetirada() {
		return retirada;
	}

	public void setRetirada(Date retirada) {
		this.retirada = retirada;
	}

	public Date getRetorno() {
		return retorno;
	}

	public void setRetorno(Date retorno) {
		this.retorno = retorno;
	}

	public Double getPrecoH() {
		return precoH;
	}

	public void setPrecoH(Double precoH) {
		this.precoH = precoH;
	}

	public Double getPrecoD() {
		return precoD;
	}

	public void setPrecoD(Double precoD) {
		this.precoD = precoD;
	}

	public double tempoD() {
		long diff = retorno.getTime() - retirada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public double tempoH() {
		long diff = retorno.getTime() - retirada.getTime();
		return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public double pBasico() {
		double pbasico = 0;
		if (tempoH() < 12) {
			pbasico = tempoH() * precoH;
		} else {
			pbasico = tempoD() * precoD;
		}
		return pbasico;
	}

	public double imposto() {
		double imposto = 0;
		if (pBasico() < 100) {
			imposto = pBasico() * 0.2;
		} else {
			imposto = pBasico() * 0.15;
		}
		return imposto;
	}

	public double pTotal() {
		return pBasico() + imposto();
	}
}
