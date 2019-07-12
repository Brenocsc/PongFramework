package fw;

public class Vetor {

    public static Vetor zero = new Vetor(0,0);
    public static Vetor um = new Vetor(1,1);

    public double x;
    public double y;

    public Vetor(double x,double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vetor() {
        x = 0;
        y = 0;
    }

    public static double Distancia(Vetor a, Vetor b) {
        return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
    }

    public static Vetor Normalizar(Vetor a) {
        double magnitude = Distancia(a,zero);
        Vetor retorno = new Vetor();

        retorno.x = a.x/magnitude;
        retorno.y = a.y/magnitude;

        return retorno;
    }
    
    public static Vetor EncaixarVetor(Vetor valor,double maximo) { // garante que o tamanho do vetor não passa do máximo
        if(Distancia(valor,zero) > maximo) {
            Vetor normal = Normalizar(valor);
            
            normal.x *= maximo;
            normal.y *= maximo;
            
            return normal;
        } else {
            return valor;
        }        
    }

    public static Vetor InterpolacaoLinear(Vetor comeco, Vetor destino, double alfa) { // alfa deve ser um valor de 0 a 1
        return new Vetor(comeco.x + (destino.x - comeco.x)*alfa,comeco.y + (destino.y - comeco.y)*alfa);
    }
}
