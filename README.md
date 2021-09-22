# Password Validator

## Solução

Foi implementado um servidor Web que roda na porta **8080**, na linguagem *Java*, utilizando o framework *Spring Boot*.

## Definição da API
<br>

> **POST** /api/v1/password

Corpo:
```json
{
   "password" : "AbTp9!fok"
}
```

Resposta:
```json
{
    "valid": true
}
```

## Projeto

Para a implementação, foi utilizada uma variação do padrão *Chain of Responsibility*. Cada validador contempla uma regra a ser verificada e pode se linkar com um outro validador, o que gera uma cadeia de regras a serem validadas. Caso alguma delas falhe, o processamento da cadeia é interrompido e retorna **false** para o método *validate()*. Caso contrário, retorna **true**. 

Toda regra de validação da senha deve herdar da classe abstrata **ChainableRuleValidator** se quiser pertencer a uma cadeia de regras. Porém, o uso da interface **RuleValidator** mantém a solução extensível para outras abordagens. Uma classe abstrata **RegExValidator** permite a verificação de expressões regulares contra o *input*, e a classe **AtLeastOneOfValidator** verifica a existência de ao menos um caractere dentre um conjunto.

Além disso, foi utilizado o padrão *Builder* para tornar a criação de uma cadeia de validadores mais legível e padronizada.

<br>

## Diagrama de Classes

![Rule Validator Class Diagram](/doc/validator-class-diagram.png "Rule Validator Class Diagram")

<br>

## Testes

Foram implementados testes de integração com a API (`PasswordValidationApiIntegrationTests.java`) e testes unitários, tanto do serviço (`PasswordValidationServiceTests.java`) como dos validadores (`RuleValidatorTests.java`).

<br>

## Como executar

Versões necessárias:
- JDK 11
- Apache Maven 3.8.2

Lançamento da aplicação:
```bash
mvn clean spring-boot:run
```

Lançamento dos testes:
```bash
mvn clean test
```

<br> <br> <br>

# Enunciado proposto

## Descrição 

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.

### Problema

Construa uma aplicação que exponha uma api web que valide se uma senha é válida.

Input: Uma senha (string).  
Output: Um boolean indicando se a senha é válida.

Embora nossas aplicações sejam escritas em Kotlin e C# (.net core), você não precisa escrever sua solução usando elas. Use a linguagem de programação que considera ter mais conhecimento.