package solucoes3; 

final class Square implements Shape {
    private final int side;

    public Square(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Lado deve ser positivo");
        }
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }

    public int getSide() { return side; }
}