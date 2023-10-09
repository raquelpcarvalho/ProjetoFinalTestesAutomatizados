# ProjetoFinalProgramacao-Web2 - API Rest Farmácia

**Projeto do Módulo de Programação Web II do Curso de Formação Back-End Java | #btgfaztech.**

**Objetivo da API:** Simular o sistema de uma Farmácia, contendo: Usuário (User), Funcionário (Employee), Pedido (Order), Produto (Product) e tipo do produto (TypeProduct).

**-Implementado:**
- Endpoint de cadastro, leitura, atualização e deleção lógica de funcionário;
- Endpoint de login;
- Consulta por CPF do usuário (Para inclusão de CPF válido no sistema, foi utilizador gerador de CPF disponível na internet para testes de software);
- Consulta por salário e filtro por valor mínimo;
- Cálculo do valor total da Order, sem precisar que o usuário passe o valor.


## INFORMAÇÕES SOBRE O PROJETO
O projeto foi orientado pela Professora Cinthia Queiroz, implementado em aula, para conclusão pela turma.

Foi solicitado uma API REST utilizando Spring Boot. O projeto era de tema livre, mas, devia conter alguns requisitos:
**Requisitos:**
Um endpoint de cadastro, leitura, atualização e deleção (lógica ou física) de usuário que será usado no login da aplicação
Endpoints de buscas que recebem filtros opcionais e realizam consultas na camada de dados (de acordo com o tema do projeto).

**Requisitos Não Funcionais:**
Deve ser uma aplicação Spring Boot
Utilização do banco de dados H2
Linguagem Java 11 - 17
Deve ser inicializado a base de dados para utilização dos endpoints.
Deve conter autenticação básica utilizando Spring Security


## A ser implementado posteriormente:**
- Classe Cliente;