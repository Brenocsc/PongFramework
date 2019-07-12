package fw;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Fbola{
	
	protected VetorInt posicao;  
        protected VetorInt posicaoInicial;                                  // - coordinate of the ball
	protected Vetor velocidade;
        protected Vetor velocidadeInicial;
        protected double velocidadeTerminal;// - velocity
	protected int raio;		 		 // - radius of the ball
	protected long tempo;
        protected long tempoParado;
        protected long tempoParadoAtual = 0;
	protected Color BallColor;
	
	public Fbola(VetorInt posicao,Vetor velocidade,double velocidadeTerminal, Color BallColor, int radius,long tempoParado) {
		this.posicao = posicao;
        posicaoInicial = new VetorInt(posicao.x,posicao.y);
		this.velocidade = velocidade;
        velocidadeInicial = new Vetor(velocidade.x,velocidade.y);
                this.velocidadeTerminal = velocidadeTerminal;
		this.BallColor = BallColor;
		this.raio = radius;
		this.tempoParado = tempoParado; 
		tempo = System.currentTimeMillis();
        tempoParadoAtual = tempoParado;

	}

	public void mover(){
		long deltaTempo = System.currentTimeMillis() - tempo;

		if(tempoParadoAtual <= 0) {
                    
                    velocidade = Vetor.EncaixarVetor(velocidade, velocidadeTerminal);
                    posicao.x += velocidade.x * deltaTempo/10;
                    posicao.y += velocidade.y * deltaTempo/10;
                } else {
                    tempoParadoAtual -= deltaTempo;
                }  

		tempo = System.currentTimeMillis();
	}
        
        public int Encaixar(int valor,int minimo,int maximo) { // garante que o valor esta dentro do período em questao
            if(valor < minimo) {
                valor = minimo;
            } else {
                if(valor > maximo) {
                    valor = maximo;
                }
            }
            return valor;
        }
        
        public void ReiniciarBola(VetorInt pos,Vetor vel) {
            velocidade.x = vel.x;
            velocidade.y = vel.y;

            posicao.x = pos.x;
            posicao.y = pos.y;

            tempoParadoAtual = tempoParado;
        }

            public void desenhar() {
            Fpong.instancia.getMeuGraphics().setColor(BallColor);
            Fpong.instancia.getMeuGraphics().fillRect(posicao.x - raio, posicao.y - raio, raio*2, raio*2);
        }
	
	public abstract int colisaoCampo();
	
	public abstract void colisaoJogador(Fjogador j);
	
	public VetorInt getPosicao() {
		return posicao;
	}
	public void setPosicao(VetorInt posicao) {
		this.posicao = new VetorInt(posicao.x,posicao.y);
	}
	public Vetor getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Vetor velocidade) {
		this.velocidade = new Vetor(velocidade.x,velocidade.y);
	}
	public int getRaio() {
		return raio;
	}
	public void setRaio(int raio) {
		this.raio = raio;
	}

	}// *<--end of the Class -->* //
