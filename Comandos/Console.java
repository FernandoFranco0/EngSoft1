package Comandos;

public class Console {

    public String Ler(){
        String Input = System.console().readLine();
        return Input;
    }

    public void Exibir(String Msg){
        System.out.println(Msg);
    }

}
