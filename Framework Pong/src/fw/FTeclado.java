package fw;

import java.awt.event.KeyListener;
import javax.swing.JLabel;


public abstract class FTeclado implements KeyListener {
    
    private JLabel label = new JLabel();
    
    public void SetListener(){
        
        label.addKeyListener(this);
        Fpong.instancia.getFrame().add(label);
        label.requestFocus();
    }

    public abstract void Atualizar();
}
