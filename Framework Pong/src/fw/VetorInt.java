package fw;

public class VetorInt {

    public static VetorInt zero = new VetorInt(0,0);
    public static VetorInt um = new VetorInt(1,1);

    public int x;
    public int y;

    public VetorInt(int x,int y) {
        this.x = x;
        this.y = y;
    }
    
    public VetorInt() {
        x = 0;
        y = 0;
    }

    public static double Distancia(VetorInt a, VetorInt b) {
        return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y,2));
    }

    public static VetorInt InterpolacaoLinear(VetorInt inicio, VetorInt destino, double alfa) { // alfa deve ser um valor de 0 a 1
        double inicioX = (double) inicio.x;
        double inicioY = (double) inicio.y;
        double destinoX = (double) destino.x;
        double destinoY = (double) destino.y;

        return new VetorInt((int)(inicioX + (destinoX - inicioX)*alfa),(int)(inicioY + (destinoY - inicioY)*alfa));
    }
}
