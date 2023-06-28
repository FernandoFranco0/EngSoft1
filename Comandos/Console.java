package Comandos;

import java.util.HashMap;

public class Console {
    private HashMap<String, CComando> HashComando;

    public Console(){
        HashComando = new HashMap<String,CComando>();
        HashComando.put("liv",new CConsultarLivro());
        HashComando.put("ntf",new CConsultarProfessor());
        HashComando.put("usu",new CConsultarUsuario());        
        HashComando.put("emp",new CEmprestimo());
        HashComando.put("dev",new CDevolver());
        HashComando.put("obs",new CObservar());
        HashComando.put("res",new CReservar());
        HashComando.put("sai",new CSair());
    }

    public void LerExecutar(){
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
