package Comandos;

import java.util.HashMap;

import Fabricas.FabricaComando;

public class Console {
    private HashMap<String, CComando> HashComando;

    public Console(){
        HashComando = new HashMap<String,CComando>();
        HashComando.put("liv",FabricaComando.NovoComandoConsultarLivro());
        HashComando.put("ntf",FabricaComando.NovoComandoConsultarProfessor());
        HashComando.put("usu",FabricaComando.NovoComandoConsultarUsuario());        
        HashComando.put("emp",FabricaComando.NovoComandoEmprestimo());
        HashComando.put("dev",FabricaComando.NovoComandoDevolver());
        HashComando.put("obs",FabricaComando.NovoComandoObservar());
        HashComando.put("res",FabricaComando.NovoComandoReservar());
        HashComando.put("sai",FabricaComando.NovoComandoSair());
    }

    public void LerExecutar(){
        System.out.println("Digite um comando: liv IdLivro, ntf IdProfessor, usu IdUsuario, emp IdUsu IdLiv, dev IdUsu IdLiv, obs IdProf IdLiv, res IdUsu IdLiv, sai");
        String Input = System.console().readLine();
        String[] Params = ParseInput(Input);

        String FeedBack = HashComando.get(Params[0]).Executar(Params[1], Params[2]);
        
        Exibir(FeedBack);
    }

    public void Exibir(String Msg){
        System.out.println(Msg);
    }

    public String[] ParseInput(String Input){
        String[] ReturnParams = {null, null, null};

        String[] Split = Input.split(" ", 3);
        
        for(int i = 0 ; i < Split.length ; i++){
            ReturnParams[i] = Split[i];
        }

        return ReturnParams;

    }



}
