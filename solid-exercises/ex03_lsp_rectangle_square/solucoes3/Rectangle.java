package solucoes3;

public class Rectangle {
    private Size size;

    public Rectangle(int altura, int largura) {
        this.size = new Size(altura, largura);
    }

    public void setLargura(int largura) {
        this.size.largura = largura;
    }

    public void setAltura(int altura) {
        this.size.altura = altura;
    }

    public int area() {
        return size.getLargura() * size.getAltura();
    }
}
