package fw;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Fjogador {
	
    private VetorInt posicao;
    private VetorInt tamanho;
    private Vetor velocidade;
    private Color StickColor;
    private long tempo;
    
    public Fjogador(VetorInt posicao,VetorInt tamanho,Color StickColor) {
    	tempo = System.currentTimeMillis();
        this.posicao = posicao;
        this.tamanho = tamanho;
		velocidade = Vetor.zero;
        this.StickColor=StickColor;
    }

    public void mover(){
		long deltaTempo = System.currentTimeMillis() - tempo;
        posicao.x = Encaixar((int) (posicao.x + velocidade.x*deltaTempo/10),tamanho.x/2,Fpong.instancia.getLargura() - tamanho.x/2);
	    posicao.y = Encaixar((int) (posicao.y + velocidade.y*deltaTempo/10),tamanho.y/2,Fpong.instancia.getAltura() - tamanho.y/2);
	    tempo = System.currentTimeMillis();
    }
    
    public void desenhar() {
        Fpong.instancia.getMeuGraphics().setColor(StickColor);
        Fpong.instancia.getMeuGraphics().fillRect(posicao.x-(tamanho.x/2), posicao.y-(tamanho.y/2), tamanho.x, tamanho.y);
    }
    
    public int Encaixar(int valor,int minimo,int maximo) { // garante que o valor esta dentro do per√≠odo em questao
        if(valor < minimo) {
            valor = minimo;
        } else {
            if(valor > maximo) {
                valor = maximo;
            }
        }
        return valor;
    }
    
    public void moverAutomatico(char direcao, int posicao) {
    	if(direcao == 'y') {
    		if(this.posicao.y < posicao) {//ir pra baixo
    			setVelocidade(new Vetor(0,3));
    		} else if(this.posicao.y > posicao) {
    			setVelocidade(new Vetor(0,-3));
    		} else {
    			setVelocidade(new Vetor(0,0));
    		}
    		
    	}else if(direcao == 'x') {
    		//n„o usamos
    	}
    	mover();
    }
    
    public abstract int numJogador();
    
    public VetorInt getPosicao() {
		return posicao;
	}
	public void setPosicao(VetorInt posicao) {
		this.posicao = new VetorInt(posicao.x, posicao.y);
	}
	public VetorInt getTam() {
		return tamanho;
	}
	public void setTam(VetorInt tamanho) {
		this.tamanho = new VetorInt(tamanho.x, tamanho.y);
	}
	public Vetor getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Vetor velocidade) {
		this.velocidade = new Vetor(velocidade.x, velocidade.y);
	}
}
