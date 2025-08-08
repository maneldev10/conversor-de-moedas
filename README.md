# conversor-de-moedas

Projeto simples em Java que utiliza a API ExchangeRate-API para converter valores entre diferentes moedas em tempo real.

## Funcionalidades

- Converte valores entre duas moedas escolhidas pelo usuário.
- Utiliza a API ExchangeRate-API para obter taxas de câmbio atualizadas.
- Interface de linha de comando (console) para interação simples.

## Pré-requisitos

- Java JDK 8 ou superior instalado.
- Conexão com a internet para acessar a API.
- Biblioteca `org.json` adicionada ao projeto (via Maven ou manualmente).
- Chave (API Key) válida da [ExchangeRate-API](https://www.exchangerate-api.com).

## Como usar

1. Clone ou faça download deste repositório.
2. Abra no IntelliJ IDEA ou sua IDE favorita.
3. Insira sua chave da API na variável `API_KEY` no arquivo `CurrencyConverter.java`:

   ```java
   private static final String API_KEY = "SUA_API_KEY_AQUI";

   Obrigado pela visita ;) 
