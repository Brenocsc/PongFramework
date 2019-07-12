package fw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public abstract class FPontuacao {
	
	private VetorInt posicao;
	private int pontos;
    private final long tempoMostrandoPlacar;
    private long tempoMostrandoPlacarAtual = 0;
    
    private Color corDaFonte;

    private long tempoDoUltimoFrame;
    
    private boolean AFonteJaFoiSetada = false;
	
	public FPontuacao(VetorInt posicao, int pontos,long tempoMostrandoPlacar,int tamanhoDaFonte, Color corDaFonte) {
		this.posicao = posicao;
		this.pontos = pontos;
        this.tempoMostrandoPlacar = tempoMostrandoPlacar;
        this.corDaFonte = corDaFonte;
        
        Fpong.instancia.getMeuGraphics().setFont(new Font("TimesRoman",Font.PLAIN,tamanhoDaFonte));
        Fpong.instancia.getMeuGraphics().drawString(String.valueOf(pontos),posicao.x,posicao.y); // isso aqui serve para inicializar os componentes relacionados com o drawstring e com a fonte,
                                                                 // para evitar um pico de latencia ao Setar ou Adicionar o score
        tempoDoUltimoFrame = System.currentTimeMillis();
	}

    public void Atualizar() {
        if (tempoMostrandoPlacarAtual > 0) {
            Fpong.instancia.getMeuGraphics().setColor(corDaFonte);
            Fpong.instancia.getMeuGraphics().drawString(String.valueOf(pontos),posicao.x,posicao.y);
            tempoMostrandoPlacarAtual -= (System.currentTimeMillis() - tempoDoUltimoFrame);
        }
        tempoDoUltimoFrame = System.currentTimeMillis();
    }
	
    public VetorInt getPosicao() {
        return posicao;
    }
    
    public void setPosicao(VetorInt posicao) {
            this.posicao = new VetorInt(posicao.x,posicao.y);
    }
    
    public int getPontos(){
        return pontos;
    }
    
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    public void addPontos(int pontos) {
        this.pontos += pontos;
    }
    
    public void mostraPontos() {
    	tempoMostrandoPlacarAtual = tempoMostrandoPlacar;
    }
}
