package futebol;

import java.awt.Color;

import fw.Fjogador;
import fw.VetorInt;

public class Jogador extends Fjogador{
	
	private int numeroJogador; 
	
	public Jogador(VetorInt posicao,VetorInt tamanho,Color StickColor, int numeroJogador) {
		super(posicao, tamanho, StickColor);
		this.numeroJogador = numeroJogador;
	}
	
	public int numJogador() {
		return numeroJogador;
	}
}
