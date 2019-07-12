package paredao;

import fw.FPontuacao;
import fw.Fbola;
import fw.Fjogador;
import fw.Fpong;
import fw.Vetor;
import fw.VetorInt;

import java.awt.Color;

public class Bola extends Fbola {
    
        private FPontuacao placar;
	
	public Bola(VetorInt posicao, Vetor velocidade,double velocidadeTerminal, Color BallColor, int raio,long tempoParado,FPontuacao placar) {
		super(posicao, velocidade,velocidadeTerminal, BallColor, raio,tempoParado);
                
                this.placar = placar;
	}
	
    @Override
	public int colisaoCampo() {
		
		if (velocidade.x > 0) {
            if (posicao.x + raio > Fpong.instancia.getLargura() - 20) {
                velocidade.x = -velocidade.x;
                return 0;
            }
        } else if (velocidade.x < 0) {
            if (posicao.x - raio < 0) {
                velocidade.x = -velocidade.x;
                return 0;
            }
        } 
		
		if (velocidade.y < 0) {
			if (posicao.y < 0) {
				velocidade.y = -velocidade.y;
				return 0;
			}
		} else if (velocidade.y > 0) {
			if (posicao.y + raio > Fpong.instancia.getAltura()) {
                                ReiniciarBola(posicaoInicial,velocidadeInicial);
                                placar.addPontos(1);
                                placar.mostraPontos();
				return 1;
			}
		}
        
		return 0;
	}
	
    @Override
	public void colisaoJogador(Fjogador j) {
        
        if ((posicao.x + raio>= j.getPosicao().x - (j.getTam().x/2) ) && (posicao.x - raio <= j.getPosicao().x + (j.getTam().x/2))) {
            
            if (posicao.y + raio >= j.getPosicao().y - (j.getTam().y/2) ) {
                
                velocidade.y = - velocidade.y;
                velocidade.x += j.getVelocidade().x;
                /*
                if (PlayerStick.getVelocidade().y < 0) {
                    velocidade.y--;
                    
                } else if (PlayerStick.velocidade.y > 0) {
                    velocidade.y += PlayerStick.getVelocidade().y;
                    
                }
                */
            }
        }
	}
	
}
