# Sistema de Reservas de Hotel

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


## Estruturas de Dados Sugeridas

- Classe Quarto:
    - Atributos: número, tipo, capacidade, disponibilidade.
~~~java 
public class Quarto {
    private int numero;
    private String tipo;
    private int capacidade;
    private boolean disponivel;

    // Construtor, getters e setters
}
~~~
- Classe Hospede:
    - Atributos: id, nome, documento, contato.
~~~java 
public class Hospede {
    private int id;
    private String nome;
    private String documento;
    private String contato;

    // Construtor, getters e setters
}
~~~

- Classe Reserva:
    - Atributos: id, quarto, hóspede, dataCheckIn, dataCheckOut, status.

~~~java 
public class Reserva {
    private int id;
    private Quarto quarto;
    private Hospede hospede;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private String status; // "reservada", "check-in", "check-out"

    // Construtor, getters e setters
}
~~~

- Classe Hotel:
    - Atributos: listas de quartos, hóspedes e reservas.

~~~java 
public class Hotel {
    private List<Quarto> quartos;
    private List<Hospede> hospedes;
    private List<Reserva> reservas;

    // Métodos para cadastro de quartos, hóspedes, reservas, check-in, check-out, geração de relatórios, etc.
}
~~~

## Banco de Dados


Estrutura do Banco de Dados
- Tabela Quarto:
    - Colunas: numero, tipo, capacidade, disponivel.
~~~sql
CREATE TABLE Quarto (
    numero INT PRIMARY KEY,
    tipo VARCHAR(50),
    capacidade INT,
    disponivel BOOLEAN
);
~~~

- Tabela Hospede:
    - Colunas: id, nome, documento, contato.

~~~sql

CREATE TABLE Hospede (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    documento VARCHAR(20),
    contato VARCHAR(50)
);
~~~

- Tabela Reserva:
    - Colunas: id, quarto_numero, hospede_id, dataCheckIn, dataCheckOut, status.

~~~sql
CREATE TABLE Reserva (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quarto_numero INT,
    hospede_id INT,
    dataCheckIn DATE,
    dataCheckOut DATE,
    status VARCHAR(20),
    FOREIGN KEY (quarto_numero) REFERENCES Quarto(numero),
    FOREIGN KEY (hospede_id) REFERENCES Hospede(id)
);
~~~

## Metodologia de Desenvolvimento

    Análise e Definição dos Requisitos:
        Entendimento das necessidades do hotel.
        Definição das funcionalidades principais e secundárias.

    Modelagem do Sistema:
        Criação de diagramas de classes.
        Definição das estruturas de dados e do banco de dados.

    Desenvolvimento:
        Implementação das classes principais (Quarto, Hospede, Reserva, Hotel).
        Desenvolvimento dos métodos para manipulação de dados.
        
    Documentação:
        Escrita do relatório final com o resumo, introdução, metodologia e execução.
        Inclusão de prints das telas do sistema e explicações detalhadas.

## Execução

    Cadastro de Quartos:
        Tela/formulário para cadastrar novos quartos.
        Listagem de quartos existentes com status de disponibilidade.

    Registro de Hóspedes:
        Tela/formulário para cadastrar novos hóspedes.
        Listagem de hóspedes existentes.

    Gerenciamento de Reservas:
        Tela/formulário para criar, atualizar e cancelar reservas.
        Listagem de reservas com possibilidade de alteração de status.

    Check-in e Check-out:
        Funcionalidade para realizar check-in e check-out.
        Atualização do status dos quartos e reservas.

    Relatórios:
        Tela para selecionar período e gerar relatórios de ocupação de quartos e reservas.

## Estruturas de Dados Utilizadas

    Lista (List):
        Para armazenar quartos, hóspedes e reservas.
        Exemplo: List<Quarto> quartos, List<Hospede> hospedes, List<Reserva> reservas.

    Objeto (Object):
        Classes como Quarto, Hospede, Reserva e Hotel representam os diferentes componentes do sistema, encapsulando os dados e comportamentos relacionados.
