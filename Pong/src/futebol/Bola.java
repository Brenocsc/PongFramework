package futebol;

import fw.FObstaculo;
import fw.FPontuacao;
import fw.Fbola;
import fw.Fjogador;
import fw.Fpong;
import fw.Vetor;
import fw.VetorInt;

import java.awt.Color;
import java.util.ArrayList;

public class Bola extends Fbola {
    
    private FPontuacao placar1;
    private FPontuacao placar2;
    private ArrayList<FObstaculo> obstaculos;
    
	public Bola(VetorInt posicao, Vetor velocidade, Color BallColor,double velocidadeTerminal, int raio,long tempoParado,FPontuacao placar1, FPontuacao placar2,ArrayList<FObstaculo> obstaculos ) {
		super(posicao, velocidade,velocidadeTerminal, BallColor, raio,tempoParado);
        this.placar1 = placar1;
        this.placar2 = placar2;
        this.obstaculos = obstaculos;
	}
	
    @Override
	public int colisaoCampo() {
		
		if (velocidade.y > 0) {
            if (posicao.y + raio > Fpong.instancia.getAltura()) {
                velocidade.y = -velocidade.y;
                return 0;
            }
        } else if (velocidade.y < 0) {
            if (posicao.y - raio < 0) {
                velocidade.y = -velocidade.y;
                return 0;
            }
        } 
                for(int i=0;i < obstaculos.size();i++) {
                    VetorInt obsPos = obstaculos.get(i).getPosicao();
                    VetorInt obsTam = obstaculos.get(i).getTamanho();
                    if(velocidade.y > 0) {
                        if(posicao.x + raio >= obsPos.x - obsTam.x/2 && posicao.x - raio <= obsPos.x + obsTam.x/2){
                            if(posicao.y + raio >= obsPos.y - obsTam.y/2 && posicao.y + raio <= obsPos.y + obsTam.y/2) {
                                velocidade.y *= -1;
                                return 0;
                            }
                        }
                    } else {
                        if(posicao.x + raio >= obsPos.x - obsTam.x/2 && posicao.x - raio <= obsPos.x + obsTam.x/2){
                            if(posicao.y - raio >= obsPos.y - obsTam.y/2 && posicao.y - raio <= obsPos.y + obsTam.y/2) {
                                velocidade.y *= -1;
                                return 0;
                            }
                        }
                    }

                    if(velocidade.x > 0) {
                        if(posicao.y + raio >= obsPos.y - obsTam.y/2 && posicao.y - raio <= obsPos.y + obsTam.y/2){
                            if(posicao.x + raio >= obsPos.x - obsTam.x/2 && posicao.x + raio <= obsPos.x + obsTam.x/2) {
                                velocidade.x *= -1;
                                return 0;
                            }
                        }
                    } else {
                        if(posicao.y + raio >= obsPos.y - obsTam.y/2 && posicao.y - raio <= obsPos.y + obsTam.y/2){
                            if(posicao.x - raio >= obsPos.x - obsTam.x/2 && posicao.x - raio <= obsPos.x + obsTam.x/2) {
                                velocidade.x *= -1;
                                return 0;
                            }
                        }
                    }
                }
                
                
		
		if (velocidade.x < 0) {
			if (posicao.x < 0) {
				ReiniciarBola(posicaoInicial,velocidadeInicial);
                placar1.addPontos(1);
                placar1.mostraPontos();
                placar2.mostraPontos();
                return 1;
			}
		} else if (velocidade.x > 0) {
			if (posicao.x + raio > Fpong.instancia.getLargura() - 20) {
				ReiniciarBola(posicaoInicial,velocidadeInicial);
                placar2.addPontos(1);
                placar1.mostraPontos();
                placar2.mostraPontos();
                return 1;
			}
		}
        
		return 0;
	}
	
    @Override
	public void colisaoJogador(Fjogador j) {
        
        if ((posicao.y >= j.getPosicao().y - (j.getTam().y/2) ) && (posicao.y <= j.getPosicao().y + (j.getTam().y/2))) {
        	if(j.numJogador() == 1) {
	            if (posicao.x - raio <= j.getPosicao().x + (j.getTam().x/2) && velocidade.x < 0) {
	                velocidade.x *= -1;
	                velocidade.y += j.getVelocidade().y;
	            }
        	} else {
        		if (posicao.x + raio >= j.getPosicao().x - (j.getTam().x/2) && velocidade.x > 0) {
	                velocidade.x *= -1;
	                velocidade.y += j.getVelocidade().y;
	            }
        	}
        }
	}
	
}
