package fw;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Fpong extends JPanel implements Runnable{
    
        public static Fpong instancia = null;
    
	private int LAR;
	private int ALT;
	protected JFrame frame;
	private String name;
	private Thread thread;
	private int NUM_QUADRO;
	
	public Fpong(int LAR, int ALT, String name) {
            
        if(instancia == null) {
            instancia = this;
        } else {
            System.gc();
            System.runFinalization();
        }
            
		this.LAR = LAR;
		this.ALT = ALT;
		this.name = name;
		this.NUM_QUADRO = 60;
		
		setSize(LAR, ALT);
		frame = new JFrame();
                iniciarFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void iniciarFrame() {
		frame.add(this);
        frame.pack();
        frame.setTitle(name);
        frame.setSize(LAR, ALT + 40);
        frame.setVisible(true);
	}
	
	public void iniciar() {
		thread = new Thread(this);
        thread.start();
	}
	
	public void desenharCampo(){
		getMeuGraphics().setColor(Color.black);
        getMeuGraphics().fillRect(0, 0, LAR, ALT);
	}
	
	public abstract void criar();
	public abstract void moverTudo();
	public abstract void colisaoTudo();
	public abstract void desenharTudo();
	public abstract void placarAtual();
        public abstract void AtualizarTeclados();
	
	public void run() {
		try {
            while (true) {
                AtualizarTeclados();
            	moverTudo();
            	colisaoTudo();
            	desenharTudo();
            	placarAtual();
                repaint();
                Thread.sleep(1000/NUM_QUADRO);
            }
        } 
            catch (InterruptedException ie) { 
            System.err.print("Interrupted!\n" + ie);
        }
	}
        
        public int getLargura() {
            return LAR;
        }
        
        public int getAltura() {
            return ALT;
        }
        
        public JFrame getFrame() {
            return frame;
        }
        
        public abstract Graphics getMeuGraphics();
}
