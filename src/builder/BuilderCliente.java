// Classe abstrata para organizar a familia dos Veiculos
abstract class Veiculo {
    
    private String modelo;
    private String tipo;
    
    public Veiculo(String modelo, String tipo) {
        this.modelo = modelo;
        this.tipo = tipo;
    }

    protected String getModelo() {
        return modelo;
    }

    protected String getTipo() {
        return tipo;
    }
}

// Classe exemplo de veiculo do modelo Ferrari
class Ferrari extends Veiculo {
    
    private String nome;

    public Ferrari(String modelo) {
        super(modelo, "Esportivo");
        this.nome = "Ferrari";
    }

    public String toString() {
        return "Carro: " + this.nome + " " + getModelo() + " " + getTipo();
    }
}

// Classe exemplo de veiculo do modelo Jeep
class Jeep extends Veiculo {
    
    private String nome;

    public Jeep(String modelo) {
        super(modelo, "Utilitario");
        this.nome = "Jeep";
    }

    public String toString() {
        return "Carro: " + this.nome + " " + getModelo() + " " + getTipo();
    }
}

// Interface com a estrutura para a montadora
interface MontadoraBuilder {
    void montar(char tipo, String modelo);
    Veiculo getVeiculo();
}

// Classe da montadora para o veiculo
class MontadoraVeiculoBuilder implements MontadoraBuilder {
    
    private Veiculo veiculo;

    public void montar(char tipo, String modelo) {
        switch (tipo) {
            case 'F': veiculo = new Ferrari(modelo); break;
            case 'J': veiculo = new Jeep(modelo); break;
        }
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
}

// Classe que ordena a construcao do veiculo
class Montadora {
    
    private MontadoraBuilder builder = new MontadoraVeiculoBuilder();

    public Veiculo montar(char tipo, String modelo) {
        builder.montar(tipo, modelo);
        return builder.getVeiculo();
    }
}

// Classe com um exempo de uso pelo cliente
class BuilderCliente {
    
    public static void main(String[] args) {
        new BuilderCliente().executar();
    }

    public void executar() {
        Montadora montadora = new Montadora();

        Veiculo carro1 = montadora.montar('F', "Testarossa");
        Veiculo carro2 = montadora.montar('J', "Renegade");

        System.out.println(carro1);
        System.out.println(carro2);
    }
}