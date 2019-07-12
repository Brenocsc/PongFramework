package tenis;

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

public class Tenis extends Fpong{
	
	private Image img;
	private Graphics camp;
	private final int LAR;
	private final int ALT;
	private Fbola bola;
	private Fjogador jogador1;
	private Fjogador jogador2;
    private FPontuacao placar1;
    private FPontuacao placar2;
	private FTeclado teclado;
    private FObstaculo obstaculo;
    private int modo;
    private int nivel;
	
	public Tenis(int modo,int nivel) {
		super(700, 500,"Tenis!");
		this.LAR = 700;
		this.ALT = 500;
		this.modo = modo;
		this.nivel = nivel;
	}
	
    @Override
	public void criar() {
		img = createImage(LAR, ALT);
		camp = img.getGraphics();
        placar1 = new Pontuacao(new VetorInt(20,50),0,2000,60,Color.white);
        placar2 = new Pontuacao(new VetorInt(LAR-90,50),0,2000,60,Color.white);
		bola = new Bola(new VetorInt(LAR/2,ALT/2), new Vetor(2,0),6, Color.white, 10,1000,placar1,placar2);
		jogador1 = new Jogador(new VetorInt(20,ALT/2),new VetorInt(14,(4-nivel)*20 + 30), Color.white,1);
		if(modo == 1) {
			jogador2 = new Jogador(new VetorInt(LAR-40,ALT/2),new VetorInt(14,80), Color.white,2);
			teclado = new Teclado(jogador1,jogador2,true);
		}else {
			jogador2 = new Jogador(new VetorInt(LAR-40,ALT/2),new VetorInt(14,(4-nivel)*20 + 30), Color.white,2);
			teclado = new Teclado(jogador1,jogador2,false);
		}
		teclado.SetListener();
    }
	
    @Override
	public void paint(Graphics g) {
        g.drawImage(img, 0, 0, LAR, ALT, this);
    }
	
    @Override
	public void moverTudo() {
    	bola.mover();
        jogador1.mover();
        if(modo == 1)
        	jogador2.moverAutomatico('y', bola.getPosicao().y);
        else 
        	jogador2.mover();
    }
    @Override
    public void colisaoTudo() {
    	bola.colisaoJogador(jogador1);
    	bola.colisaoJogador(jogador2);
        bola.colisaoCampo();
    }
    @Override
    public void desenharTudo() {
    	desenharCampo();
        bola.desenhar();
        jogador1.desenhar();
        jogador2.desenhar();
    }
    @Override
    public void placarAtual() {
    	placar1.Atualizar();
    	placar2.Atualizar();
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