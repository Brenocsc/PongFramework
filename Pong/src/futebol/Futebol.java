package futebol;

import fw.FObstaculo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import fw.Fbola;
import fw.Fpong;
import fw.Fjogador;
import fw.FPontuacao;
import fw.FTeclado;
import fw.Vetor;
import fw.VetorInt;
import tenis.Jogador;
import tenis.Teclado;

public class Futebol extends Fpong{
	
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
	private int modo;
	private int nivel;
    private ArrayList<FObstaculo> obstaculo = new ArrayList<FObstaculo>();
	
	public Futebol(int modo,int nivel) {
		super(700, 500,"Futebol!");
		this.LAR = 700;
		this.ALT = 500;
		this.modo= modo;
		this.nivel = nivel;
	}
	
    @Override
	public void criar() {
		img = createImage(LAR, ALT);
		camp = img.getGraphics();
        placar1 = new Pontuacao(new VetorInt(20,50),0,2000,60,Color.white);
        placar2 = new Pontuacao(new VetorInt(LAR-90,50),0,2000,60,Color.white);
		jogador1 = new Jogador(new VetorInt(20,ALT/2),new VetorInt(14,(4-nivel)*20 + 30), Color.white,1);
		//jogador2 = new Jogador(new VetorInt(LAR-40,ALT/2),new VetorInt(14,80), Color.white,2);
		//teclado = new Teclado(jogador1,jogador2);
		if(modo == 1) {
			jogador2 = new Jogador(new VetorInt(LAR-40,ALT/2),new VetorInt(14,80), Color.white,2);
			teclado = new Teclado(jogador1,jogador2,true);
		}else {
			jogador2 = new Jogador(new VetorInt(LAR-40,ALT/2),new VetorInt(14,(4-nivel)*20 + 30), Color.white,2);
			teclado = new Teclado(jogador1,jogador2,false);
		}
        teclado.SetListener();
        for(int i = 1; i <= 3; i++ )
        	for(int j = 0; j <= 1; j++ )
    			obstaculo.add(new FObstaculo(new VetorInt(j*300 + 200, i*100 ),new VetorInt(j*300 + 200,i*100 + 100),new VetorInt(14,30),Color.white,0.3));
        bola = new Bola(new VetorInt(LAR/2,ALT/2), new Vetor(2,0), Color.white,6, 10,1000,placar1,placar2,obstaculo);
        //obstaculo[1] = new FObstaculo(new VetorInt(LAR - 200,ALT/2 - 100),new VetorInt(LAR - 200,ALT/2 + 100),new VetorInt(14,40),Color.white,0.1);
        //obstaculo[2] = new FObstaculo(new VetorInt(LAR - 200,ALT/2 - 100),new VetorInt(LAR - 200,ALT/2 + 100),new VetorInt(14,40),Color.white,0.1);
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
        for(FObstaculo o: obstaculo)
        	o.Mover();
    }
    
    public void colisaoTudo() {
    	bola.colisaoJogador(jogador1);
    	bola.colisaoJogador(jogador2);
        bola.colisaoCampo();
    }
    
    public void desenharTudo() {
    	desenharCampo();
        bola.desenhar();
        jogador1.desenhar();
        jogador2.desenhar();
        for(FObstaculo o: obstaculo)
        	o.desenhar();
    }
    public void placarAtual() {
    	placar1.Atualizar();
    	placar2.Atualizar();
    }
    public Graphics getMeuGraphics() {
        return camp;
    }
    
    public void AtualizarTeclados() {
        teclado.Atualizar();
    }
}