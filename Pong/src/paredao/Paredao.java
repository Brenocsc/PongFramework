package paredao;

import fw.FObstaculo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import fw.Fbola;
import fw.Fpong;
import fw.Fjogador;
import fw.FPontuacao;
import fw.FTeclado;
import fw.Vetor;
import fw.VetorInt;

public class Paredao extends Fpong{
	
	private Image img;
	private Graphics camp;
	private final int LAR;
	private final int ALT;
	private Fbola bola;
	private Fjogador jogador;
    private FPontuacao placar;
	private FTeclado teclado;
    private FObstaculo obstaculo;
    private int nivel;
	
	public Paredao(int nivel) {
		super(500, 500,"Paredao!");
		this.LAR = 500;
		this.ALT = 500;
		this.nivel = nivel;
	}
	
        @Override
	public void criar() {
		img = createImage(LAR, ALT);
		camp = img.getGraphics();
        placar = new Pontuacao(new VetorInt(50,50),0,2000,60,Color.white);
		bola = new Bola(new VetorInt(LAR/2,ALT/2), new Vetor(0,2),6, Color.white, 10,1000,placar);
		jogador = new Jogador(new VetorInt(LAR/2,ALT-20),new VetorInt((4-nivel)*20 + 30,14), Color.white);
		teclado = new Teclado(jogador);
        teclado.SetListener();
        obstaculo = new FObstaculo(new VetorInt(LAR/2- 100,ALT-200),new VetorInt(LAR/2 + 100,ALT-200),new VetorInt(80,14),Color.white,0.1);
        }
	
        @Override
            public void paint(Graphics g) {
            g.drawImage(img, 0, 0, LAR, ALT, this);
        }
	
        @Override
	public void moverTudo() {
            bola.mover();
            jogador.mover();
            obstaculo.Mover();
        }
    
        @Override
        public void colisaoTudo() {
            bola.colisaoJogador(jogador);
            bola.colisaoCampo();
        }
    
        @Override
        public void desenharTudo() {
            desenharCampo();
            bola.desenhar();
            jogador.desenhar();

            //repaint();
            //obstaculo.desenhar();
        }
        @Override
        public void placarAtual() {
            placar.Atualizar();
        }
        
        @Override
        public void AtualizarTeclados() {
            teclado.Atualizar();
        }
    
        @Override
        public Graphics getMeuGraphics() {
            return camp;
        }
}