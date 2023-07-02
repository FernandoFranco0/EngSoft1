package Fabricas;

import Estado.ExemplarEmprestado;

public class FabricaEstado {
    static public ExemplarEmprestado NovoExemplarEmprestado(){
        return new ExemplarEmprestado();
    }
}
