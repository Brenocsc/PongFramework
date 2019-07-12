package tenis;

import fw.FPontuacao;
import fw.VetorInt;
import java.awt.Color;
import java.awt.Graphics;

public class Pontuacao extends FPontuacao {
    public Pontuacao(VetorInt posicao, int score,long tempoMostrandoPlacar,int tamanhoDaFonte, Color corDaFonte) {
        super(posicao,score,tempoMostrandoPlacar,tamanhoDaFonte,corDaFonte);
    }
}
