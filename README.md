# Sistema de Reservas de Hotel

## Requisitos
- Java 17+
- Ambiente para visualização e teste do código (VSCode, Intellij, Eclipse, Vim)

## Funcionalidades do Sistema

- Cadastro de Quartos:
    - Cadastro de quartos com informações como número do quarto, tipo (simples, duplo, suíte), capacidade e status (disponível, ocupado).

- Registro de Hóspedes:
    - Cadastro de hóspedes com informações como nome, documento de identidade, e detalhes de contato.

- Reservas:
    - Criação, atualização e cancelamento de reservas.
      Associação de reservas a hóspedes e quartos.

- Check-in e Check-out:
    - Realização de check-in e check-out dos hóspedes.
      Atualização do status dos quartos.

- Geração de Relatórios:
    - Relatórios de ocupação de quartos.
      Relatórios de reservas por período.


## Estrutura da Aplicação

- Classe Quarto:

~~~java 
public class Quarto {
    private int numero;
    private String tipo;
    private double preco;

    // Construtor, getters e setters
}
~~~
- Classe Hospede:

~~~java 
public class Hospede {
    private String nome;
    private String telefone;
    private String email;

    // Construtor, getters e setters
}
~~~

- Classe Reserva:

~~~java 
public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    // Construtor, getters e setters
}
~~~

- Classe Sistema:

~~~java 
public class Sistema {
    private List<Hospede> hospedes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;
    private Map<String, List<Reserva>> reservasPorHospede;

    // Métodos para cadastro de quartos, hóspedes, reservas, check-in, check-out, geração de relatórios, etc.
}
~~~

## Banco de Dados
### Será persistido em arquivo .dat gerado pelo Serializable, interface do Java

## Metodologia de Desenvolvimento

    Análise e Definição dos Requisitos:
        Entendimento das necessidades do hotel.
        Definição das funcionalidades principais e secundárias.

    Modelagem do Sistema:
        Definição das estruturas de dados e do banco de dados.

    Desenvolvimento:
        Implementação das classes principais (Quarto, Hospede, Reserva, Sistema).
        Desenvolvimento dos métodos para manipulação de dados.
        
    Documentação:
        Detalhamento e manual de como utilizar a aplicação
        Inclusão de prints das telas do sistema e explicações detalhadas.

## Execução
    Para utilizar a aplicação é necessário cadastrar o Quarto e em seguida o Hospede
    assim então fazer CheckIn ou Reserva.

    Cadastro de Quartos:
        formulário para cadastrar novos quartos.

    Registro de Hóspedes:
        Formulário para cadastrar novos hóspedes.
        Listagem de hóspedes existentes e quartos ocupados pelos mesmos.

    Gerenciamento de Reservas:
        Formulário para criar, atualizar e cancelar reservas.
        Listagem de reservas com possibilidade de alteração de status.

    Check-in e Check-out:
        Funcionalidade para realizar check-in e check-out.
        Atualização do status dos quartos e reservas.


## Estruturas de Dados Utilizadas

    Lista (List):
        Para armazenar quartos, hóspedes e reservas.
        Exemplo: List<Quarto> quartos, List<Hospede> hospedes, List<Reserva> reservas.

    Objeto (Object):
        Classes como Quarto, Hospede, Reserva e Hotel representam os diferentes componentes do sistema, encapsulando os dados e comportamentos relacionados.
