package fw;

import java.awt.Color;
import java.awt.Graphics;

public class FObstaculo {

    private final VetorInt tamanho;

    private final Color StickColor;

    private VetorInt posicaoAtual;
    private final VetorInt posicaoInicial;
    private final VetorInt posicaoDestino;

    private final double frequencia;

    public FObstaculo(VetorInt posicaoInicial, VetorInt posicaoDestino,VetorInt tamanho,Color StickColor,double frequencia) {
        this.tamanho = tamanho;

        this.StickColor = StickColor;
        
        posicaoAtual = posicaoInicial;
        this.posicaoInicial = posicaoInicial;
        this.posicaoDestino = posicaoDestino;

        this.frequencia = frequencia;
    }

    public void desenhar() {
        Fpong.instancia.getMeuGraphics().setColor(StickColor);
        Fpong.instancia.getMeuGraphics().fillRect(posicaoAtual.x-(tamanho.x/2), posicaoAtual.y-(tamanho.y/2), tamanho.x, tamanho.y);
    }

    public void Mover() {
        posicaoAtual = VetorInt.InterpolacaoLinear(posicaoInicial,posicaoDestino,(Math.cos(frequencia*Math.PI*2*System.currentTimeMillis()/1000)+1)/2);
        // (X + 1)/2 serve para alterar o intervalo do coseno de (-1 a 1) para (0 a 1)
        // /1000 serve pra transformar de milisegundos pra segundos, 2pi serve para transformar vezes/segundo em ciclos/segundo
    }
    
    public VetorInt getPosicao() {
        return posicaoAtual;
    }
    
    public VetorInt getTamanho() {
        return tamanho;
    }
}
