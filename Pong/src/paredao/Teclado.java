package paredao;

import fw.FTeclado;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import fw.Fjogador;
import fw.Fpong;
import fw.Vetor;
import java.awt.TextArea;

public class Teclado extends FTeclado{

	private Fjogador jogador;
	private float velocidade = 2;
        private boolean PressionandoEsq = false;
        private boolean PressionandoDir = false;
	
	private int LEFT =  KeyEvent.VK_LEFT;
	private int RIGHT = KeyEvent.VK_RIGHT;
	private int A = KeyEvent.VK_A;
	private int D = KeyEvent.VK_D;
	
	public Teclado(Fjogador j) {
		jogador = j;
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		int Keycode = key.getKeyCode();
		if(Keycode == LEFT || Keycode == A) {
			PressionandoEsq = true;
		} else if(Keycode == RIGHT || Keycode == D) {
			PressionandoDir = true;
		}	}

	@Override
	public void keyReleased(KeyEvent key) {
            int Keycode = key.getKeyCode();
            if(Keycode == LEFT || Keycode == A) {
                    PressionandoEsq = false;
            } else if(Keycode == RIGHT || Keycode == D) {
                    PressionandoDir = false;
            }
        }

	@Override
	public void keyTyped(KeyEvent key) {}
        
        @Override
        public void Atualizar() {
            float velocidadeDestino;

            if(PressionandoEsq && PressionandoDir){
                velocidadeDestino = 0;
            } else if (PressionandoEsq) {
                velocidadeDestino = -velocidade;
            } else if (PressionandoDir) {
                velocidadeDestino = velocidade;
            } else {
                velocidadeDestino = 0;
            }

            jogador.setVelocidade(new Vetor(velocidadeDestino,jogador.getVelocidade().y));

        }
	
}
