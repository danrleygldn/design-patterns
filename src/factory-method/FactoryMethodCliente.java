// Classe abstrata para organizar a familia dos veiculos
abstract class Veiculo {
    private String modelo;
    
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

// Classe exemplo de um veiculo tipo Opala
class Opala extends Veiculo {
    
    public Opala() {
        setModelo("Opala");
    }
}

// Classe exemplo de um veiculo tipo Vectra
class Vectra extends Veiculo {
    
    public Vectra() {
        setModelo("Vectra");
    }
}

// Classe abstrata para estrutura do criador dos tipos de veiculo
abstract class GMCriador {
    
    public abstract Opala factoryOpala();
    
    public abstract Vectra factoryVectra();  
}

// Classe concreta com as fabricas de criacao
class GMCriadorConcreto extends GMCriador {
    
    public Opala factoryOpala() {
        return new Opala();
    }
    
    public Vectra factoryVectra() {
        return new Vectra();
    }
}

// Classe com um exemplo de uso pelo cliente
class FactoryMethodCliente {
    
    public static void main(String[] args) {
        new FactoryMethodCliente().executar();
    }
    
    public void executar() {
        GMCriador gm = new GMCriadorConcreto();
        Veiculo opala = gm.factoryOpala();
        Veiculo vectra = gm.factoryVectra();
        
        System.out.println(opala.getModelo());
        System.out.println(vectra.getModelo());
    }
}