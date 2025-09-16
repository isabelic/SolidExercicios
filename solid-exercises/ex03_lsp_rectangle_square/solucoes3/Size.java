package solucoes3;

public class Size {
    protected int largura, altura;

    public Size(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setLargura(int side) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setLargura'");
    }
}
