# Projeto de demonstração: Maven + JUnit 5 + PIT

Projeto pronto para abrir no Apache NetBeans 21 ou superior. Inclui uma classe `Calculadora`, testes JUnit 5 e o plugin PIT para testes de mutação.

## Requisitos

- JDK 25 instalado e selecionado no NetBeans (o `pom.xml` está configurado para Java 25).
- NetBeans 21 ou superior com suporte a projetos Maven.
- Acesso à internet na primeira execução para o Maven baixar as dependências.

> Se você tiver apenas JDK 17, abra `pom.xml` e altere `<maven.compiler.release>25</maven.compiler.release>` para `17`. A classe de exemplo é compatível com Java 17.

## Abrir no NetBeans

1. Extraia o arquivo ZIP para uma pasta fácil de encontrar.
2. No NetBeans, selecione **File > Open Project**.
3. Escolha a pasta `Projeto_PIT_NetBeans` extraída e abra o projeto Maven.
4. Aguarde o NetBeans resolver/baixar as dependências. A primeira vez pode demorar.

## 1. Executar os testes JUnit

- Clique com o botão direito no projeto e escolha **Test** (ou a opção equivalente para executar os testes).
- O resultado esperado é que os 6 testes passem.

## 2. Executar o PIT sem usar o terminal

1. Clique com o botão direito no projeto.
2. Procure **Run Maven > Goals...**, **Execute Maven Goal** ou uma opção equivalente (o nome varia conforme a versão/configuração do NetBeans).
3. No campo Goals, cole:

   `test-compile org.pitest:pitest-maven:mutationCoverage`

4. Execute e aguarde o Maven terminar.

Se o NetBeans não mostrar uma opção para objetivos Maven, confira **Tools > Options > Java > Maven** ou use a janela de saída Maven para executar o objetivo.

## 3. Abrir o relatório

Depois que o PIT terminar com sucesso, abra o arquivo:

`target/pit-reports/index.html`

O relatório também é gerado em XML em `target/pit-reports/mutations.xml`.

## Entender os resultados

- **Killed**: um teste falhou ao executar o código mutado; os testes detectaram a alteração.
- **Survived**: os testes não perceberam a alteração; vale revisar ou acrescentar testes.
- **No coverage**: nenhum teste cobriu o código mutado.
- **Mutation coverage**: proporção dos mutantes detectados em relação aos mutantes relevantes gerados.

## Se aparecer erro

- `mvn: command not found`: não use o comando `mvn` no terminal neste momento; execute os objetivos pela integração Maven do NetBeans.
- Erro de JDK/`release version 25 not supported`: confirme que o NetBeans está usando um JDK 25. Alternativamente, altere a propriedade `maven.compiler.release` para a versão do JDK instalado (por exemplo, 17).
- Dependências não baixam: confira a conexão com a internet e tente recarregar o projeto Maven.
- PIT não encontra classes: confira se os pacotes `com.mycompany.pit` das classes de produção e teste foram mantidos.

## Estrutura

```text
Projeto_PIT_NetBeans/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/mycompany/pit/Calculadora.java
    └── test/java/com/mycompany/pit/CalculadoraTest.java
```
