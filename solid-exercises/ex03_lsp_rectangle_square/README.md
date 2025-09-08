# LSP — Retângulo vs. Quadrado

**Contexto:** módulo de layout calculando áreas e redimensionamento.

## Código legado (errado)
```java
class Rectangle {
    protected int width, height;
    void setWidth(int w) { this.width = w; }
    void setHeight(int h) { this.height = h; }
    int area() { return width * height; }
}

class Square extends Rectangle {
    @Override void setWidth(int w) { this.width = this.height = w; }
    @Override void setHeight(int h) { this.width = this.height = h; }
}
```

## Problema
Substituir `Rectangle` por `Square` quebra expectativas de clientes que dependem de setadores independentes (violação de LSP).

## Tarefa
Remover a herança problemática. Propor tipos imutáveis (`Size`, `Square`) ou composição. Se a API promete setWidth/setHeight independentes, `Square` não deve herdar de `Rectangle`.

## Critérios de aceitação
- Nenhum teste que usa `Rectangle` falha ao receber um `Square`.
- Invariantes documentadas para cada tipo.
