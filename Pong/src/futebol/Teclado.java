package futebol;

import fw.FTeclado;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import fw.Fjogador;
import fw.Vetor;
import java.awt.TextArea;

public class Teclado extends FTeclado{

	private Fjogador jogador1;
	private Fjogador jogador2;
    protected JFrame frame;
	private float velocidade = 2;
    private boolean PressCima1 = false;
    private boolean PressCima2 = false;
    private boolean PressBaixo1 = false;
    private boolean PressBaixo2 = false;
    private boolean umJogador;
	
	private int W =  KeyEvent.VK_W;
	private int S = KeyEvent.VK_S;
	private int UP = KeyEvent.VK_UP;
	private int DOWN = KeyEvent.VK_DOWN;
	
	public Teclado(Fjogador j1,Fjogador j2, boolean umJogador) {
        super();
		jogador1 = j1;
		jogador2 = j2;
		this.umJogador = umJogador;
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		int Keycode = key.getKeyCode();
		if(Keycode == W) {
			PressCima1 = true;
		} else if(Keycode == S) {
			PressBaixo1 = true;
		} else if(Keycode == UP) {
			PressCima2 = true;
		} else if(Keycode == DOWN) {
			PressBaixo2 = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
        int Keycode = key.getKeyCode();
        if(Keycode == W) {
			PressCima1 = false;
		} else if(Keycode == S) {
			PressBaixo1 = false;
		} else if(Keycode == UP) {
			PressCima2 = false;
		} else if(Keycode == DOWN) {
			PressBaixo2 = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent key) {}
        
        @Override
        public void Atualizar() {
            float velocidadeDestino;

            if(PressCima1 && PressBaixo1){
                velocidadeDestino = 0;
            } else if (PressCima1) {
                velocidadeDestino = -velocidade;
            } else if (PressBaixo1) {
                velocidadeDestino = velocidade;
            } else {
                velocidadeDestino = 0;
            }
            jogador1.setVelocidade(new Vetor(jogador1.getVelocidade().x,velocidadeDestino));

            if(!umJogador) {
	            if(PressCima2 && PressBaixo2){
	                velocidadeDestino = 0;
	            } else if (PressCima2) {
	                velocidadeDestino = -velocidade;
	            } else if (PressBaixo2) {
	                velocidadeDestino = velocidade;
	            } else {
	                velocidadeDestino = 0;
	            }
	            jogador2.setVelocidade(new Vetor(jogador2.getVelocidade().x,velocidadeDestino));
            }
        }
	
}
