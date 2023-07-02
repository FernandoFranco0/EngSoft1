package Fabricas;

import Estado.ExemplarDisponivel;
import Estado.ExemplarEmprestado;

public class FabricaEstado {
    static public ExemplarEmprestado NovoExemplarEmprestado(){
        return new ExemplarEmprestado();
    }

    static public ExemplarDisponivel NovoExemplarDisponivel(){
        return new ExemplarDisponivel();
    }
}
