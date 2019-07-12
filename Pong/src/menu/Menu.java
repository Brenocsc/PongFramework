package menu;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import futebol.Futebol;
import tenis.Tenis;
import paredao.Paredao;
import fw.FObstaculo;
import fw.Fpong;

public class Menu extends JFrame{
	
	private JPanel painelpong;
	private JLabel labelpong;
	private int jogo;
	private int modo;
	private int nivel;
	private int numOpcao;
	private Fpong pong;
	private ArrayList<JButton> botoes = new ArrayList<JButton>();

    public Menu() {
    	
    	iniciaPanelpong();
    	pack();
        setTitle("Pong");
        setSize(300, 300 + 40);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciaPanelpong() {
    	painelpong = new JPanel();
    	painelpong.setSize(300, 300);
    	painelpong.setLayout(null);
    	
    	labelpong = new JLabel();
    	labelpong.setSize(200, 100);
    	labelpong.setFont (labelpong.getFont ().deriveFont (40.0f));
    	labelpong.setLocation(85, 30);
    	labelpong.setText("PONG");
    	painelpong.add(labelpong);
    	criaBotoes();
    	this.add(painelpong);
    }
    
    public void criaBotoes() {
    	botoes.add(new JButton());
    	botoes.add(new JButton());
    	botoes.add(new JButton());
    	
    	numOpcao = 1;
    	
    	painelpong.add(botoes.get(0));
    	botoes.get(0).setSize(100,30);
    	botoes.get(0).setLocation(93,150);
    	botoes.get(0).setText("Paredão");
    	botoes.get(0).addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(numOpcao == 1) {
    				jogo = 1;
    				selecionarNivel();
    			} else if (numOpcao == 2){
    				modo = 1;
    				selecionarNivel();
    			} else {
    				nivel = 1;
    				iniciarPong();
    			}
    		}
    	});
    	
    	painelpong.add(botoes.get(1));
    	botoes.get(1).setSize(100,30);
    	botoes.get(1).setLocation(93,190);
    	botoes.get(1).setText("Tenis");
    	botoes.get(1).addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(numOpcao == 1) {
    				jogo = 2;
    				selecionarModo();
    			} else if (numOpcao == 2){
    				modo = 2;
    				selecionarNivel();
    			} else {
    				nivel = 2;
    				iniciarPong();
    			}
    		}
    	});
    	
    	painelpong.add(botoes.get(2));
    	botoes.get(2).setSize(100,30);
    	botoes.get(2).setLocation(93,230);
    	botoes.get(2).setText("Futebol");
    	botoes.get(2).addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(numOpcao == 1) {
    				jogo = 3;
    				selecionarModo();
    			} else if (numOpcao == 2){
    				modo = 3;
    				selecionarNivel();
    			} else {
    				nivel = 3;
    				iniciarPong();
    			}
    		}
    	});
    }
    
    public void selecionarModo() {
    	numOpcao = 2;
    	botoes.get(0).setText("Treino");
    	botoes.get(1).setText("Jogo");
    	botoes.get(2).setText("Multiplayer");
   
    }
    
    public void selecionarNivel() {
    	numOpcao = 3;
    	botoes.get(0).setText("Fácil");
    	botoes.get(1).setText("Médio");
    	botoes.get(2).setText("Difícil");
    }
    
    public void iniciarPong() {

    	if(jogo == 1) {
    		pong = new Paredao(nivel);
    	}else if(jogo == 2) {
    		pong = new Tenis(modo,nivel);
    	}else {
    		pong = new Futebol(modo,nivel);
    	}
    	pong.criar();
    	pong.iniciar();
    }
    
}
