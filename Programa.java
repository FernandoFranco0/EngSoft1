
public class Programa {
    public static void main(String[] args) {
        new PosGradOk();
    }
}

/*
 * O sistema de biblioteca consiste no gerenciamento e manutenção de livros disponíveis em uma biblioteca acadêmica. Ele permite que três tipos de usuários (alunos de graduação, alunos de pósgraduação e professores) realizem o empréstimo, devolução e reserva de livros disponíveis. Um livro específico pode dispor na biblioteca de mais de um exemplar. Assim, é possível encontrar na biblioteca dois ou mais exemplares de um mesmo livro. Cada livro deve possuir um código que o identifique e um título. Além do código e do título, os livros devem manter as seguintes informações adicionais: editora, autores, edição e ano da publicação. Cada usuário deve ter um código de identificação e nome. Cada um dos três tipos de usuários possui regras específicas para poder pegar livro emprestado. Essas regras são detalhadas na descrição da funcionalidade de empréstimo, na Seção 3 deste documento. Além disso, a cada tipo de usuário é permitido um determinado intervalo de tempo, em dias, durante o qual ele pode ficar com o livro emprestado, conforme a Tabela 1. Sempre que o empréstimo de um livro é solicitado na biblioteca, é feito o registro daquela operação no sistema e é fixada uma data de devolução baseada no tempo de empréstimo do tipo de usuário. Usuários têm também o direito de realizar reservas de livros. A reserva de um livro garante a prioridade no seu empréstimo apenas entre os alunos, como ficará mais claro nas regras de empréstimo, detalhadas na Seção 3. A reserva também tem que ser registrada no sistema.

 */



 /*
  Classe Sistema, a main, que registra emprestimos
    * devolução livro -> "dev UserId BookId" -> Ao final, o sistema deve emitir uma mensagem de sucesso ou insucesso da devolução, que mencione o nome do usuário e o título do livro. A mensagem de insucesso deve dizer o motivo. Nesse caso, o insucesso só ocorre se não houver empréstimo em aberto daquele livro para aquele usuário.

    * reserva livro -> "res UserId BookId" -> Será permitida a reserva de apenas 3 livros por usuário. Ao final, o sistema deve emitir uma mensagem de sucesso ou insucesso da reserva, que mencione o nome do usuário e o título do livro. A mensagem de insucesso deve dizer o motivo.

    * Professor observador -> "obs UserId BookId" -> observar toda vez que determinado livro tiver mais de duas reservas simultâneas. Toda vez que o livro tiver mais de duas reservas simultâneas, o livro deve “avisar” aos “observadores”. O observador deve simplesmente registrar internamente quantas vezes ele foi notificado. Fazer de maneira que possa adicionar novos tipos de observadores como cordenadores etc. Não há necessidade de checar se o código do usuário se refere realmente a um professor.

    Consultas do Sistema
        * Consultar Livro -> "liv BookId" -> Exibe (i) título, (ii) quantidade de reservas para aquele livro, e, se diferente de zero, devem ser também apresentados o nome dos usuários que realizaram cada reserva, (iii) para cada exemplar, deve ser apresentado seu código, seu status (disponível ou emprestado), e em caso do exemplar estar emprestado deverá ser exibido o nome do usuário que realizou o empréstimo, a data de empréstimo e a data prevista para devolução. 

        * Consultar Usuario -> "usr UserId" -> o sistema deverá apresentar a lista de todos os seus empréstimos correntes e passados, assim como de suas reservas. A listagem de cada empréstimo deverá apresentar o título do livro, a data do empréstimo, o status atual daquele empréstimo (em curso ou finalizado) e a data da devolução já realizada ou prevista. A listagem das reservas deverá apresentar o título do livro reservado e a data da solicitação da reserva. 

        * Consultar Professor -> "ntf UserId" -> o sistema deve retornar a quantidade de vezes que ele foi notificado sobre mais de duas reservas simultâneas em livros observados por ele. Não há necessidade de checar se o código se refere realmente a um professor.

    * Sair Sistema -> "sai"


     Exigências de Projeto
        1. O sistema NÃO deve se preocupar com a persistência de dados, ou seja, NÃO deve usar banco de dados. Os objetos relativos aos dados de teste (Seção 7) deverão ser instanciados na memória no momento da inicialização do sistema.
        2. O sistema NÃO deve ter uma interface com o usuário gráfica. Todos os comandos deverão ser fornecidos via linha de comando, e suas respostas devem ser mostradas no console.
        3. O projeto deve ter uma classe responsável por ler os comandos e mostrar as respostas no console. Essa classe deve se comunicar com a fachada do sistema por meio de um esquema de comandos, projetados de acordo com o padrão de projeto “Command”.
        4. A comunicação entre os comandos e as classes de negócio deverão ser feitos por meio de uma classe fachada que também deverá ser um Singleton.
        5. Evite o uso de “if “ou “switch” para saber o tipo de usuário que está lidando e, em particular, use algum padrão de projeto para implementar as diferentes regras para realização de empréstimo e evitar o uso de ifs para selecionar entre as possíveis regras.




  Provavelmente interface "user" que tem emprestimo, devolução, reserva de livros, algum tipo de ReturnUserManager() com informaçoes de tempo de devolção / regras de emprestismo  / etc (elas podem mudar e podem surgir novos tipos de usuarios -> prova anterior) , <--(implementa)-- alunos de graduação, alunos de pósgraduação e professores <-- tem que ter id, nome <-- alunos podem reservar , professores ignoram a reserva
  Provavelmente classe "livro" tem id, título, quantidade de exemplares, editora, autores, edição, ano de publicação
*/