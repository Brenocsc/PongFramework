package paredao;

import java.awt.Color;

import fw.Fjogador;
import fw.VetorInt;

public class Jogador extends Fjogador{
	
	public Jogador(VetorInt posicao,VetorInt tamanho,Color StickColor) {
		super(posicao, tamanho, StickColor);
	}
	
	public int numJogador() {
		return 1;
	}
}
