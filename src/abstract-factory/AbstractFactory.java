import java.util.Scanner;

// Classe abstrata para organizar a família dos Pets
abstract class Pet {
    
    private String nome;
    
    public Pet(String nome) {
        this.nome = nome;
    }
    
    public String toString() {
        return this.nome;
    }
}

// Classe abstrata para organizar a família dos Gatos
abstract class Gato extends Pet {
    
    public Gato(String nome) {
         super(nome);
    }
}

// Classe abstrata para organizar a família dos Cachorros
abstract class Cachorro extends Pet {
    
    public Cachorro(String nome) {
        super(nome);
    }
}

// Classes concretas
// Classe de exemplo para Gato de Companhia
class Persa extends Gato {
    
    public Persa() {
        super("Persa");
    }
}

// Classe de exemplo para Gato de Guarda
class RagDoll extends Gato {
    
    public RagDoll() {
        super("RagDoll");
    }
}

// Classe de exemplo para Cachorro de Companhia
class Shitzu extends Cachorro {
    
    public Shitzu() {
        super("Shitzu");
    }
}

// Classe de exemplo para Cachorro de Guarda
class Pastor extends Cachorro {
    
    public Pastor() {
        super("Pastor");
    }
}

// Interface com estrutura para as Fábricas
interface ModeloPet {

    public Cachorro getCachorro();
    public Gato getGato();
}

// Classe da Fábrica de construção dos Pets de Companhia
class FactoryCompanhia implements ModeloPet {
    public Cachorro getCachorro() {
        return new Shitzu();
    }
    
    public Gato getGato() {
        return new Persa();
    }
}

// Classe da Fábrica de construção dos Pets de Guarda
class FactoryGuarda implements ModeloPet {

    public Cachorro getCachorro() {
        return new Pastor();
    }
    
    public Gato getGato() {
        return new RagDoll();
    }
}

// Classe com um exemplo de uso pelo cliente
class AbstractFactory {
    private Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        new AbstractFactory().executar();
    }
    
    public void executar() {
        System.out.println("Informe (1) p/ Companhia ou (2) p/ Guarda");
        byte entrada = scanner.nextByte();
        
        ModeloPet modelo = null;
        switch (entrada) {
            case 1: modelo = new FactoryCompanhia(); break;
            case 2: modelo = new FactoryGuarda(); break;
        }
        
        System.out.println("Cachorro: " + modelo.getCachorro());
        System.out.println("Gato: " + modelo.getGato());
    }
}