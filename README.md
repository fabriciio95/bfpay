# Bfpay
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/fabriciio95/bfpay/blob/master/LICENSE) 

# Sobre o projeto

Bfpay é um web service construído para fins de **aprendizado** que faz uma simulação de pagamentos online utilizado no projeto [Bluefood](https://github.com/fabriciio95/bluefood).

# Tecnologias utilizadas
- Java
- Spring Boot
- Jakarta Bean Validation
- Gradle

# Arquitetura
- REST

# Implantação em produção
- Heroku

# Como executar o projeto
Pré-requisitos: Java 11, Gradle 6.8.3

```bash
# clonar repositório
git clone https://github.com/fabriciio95/bfpay

# Entre na pasta raiz do projeto:
cd bfpay

# E para rodar o projeto, você pode executar:
gradle bootRun
```

# Manual das requisições do Web Service
Pré-requisitos: Postman

**Por ser apenas uma simulação de pagamento, as regras para aceitar o pagamento são bem fictícias. Para que o pagamento seja dado como autorizado é necessário apenas que o cartão tenha 16 digitos e começe com os números:** 
- 0000
- 1111
- 2222
- 3333

## Efetuando um pagamento
Para efetuar um pagamento, você deve enviar uma requisição utilizando o método **POST** do protocolo HTTP com a URL:

```url
http://localhost:8081/bfpay/pay
```
Você também **obrigatoriamente** deverá enviar na requisição um cabeçalho **Token** com o valor **r2d2**.

![URL - Header](https://github.com/fabriciio95/arquivos-read-me/blob/master/arquivos-rep-bfpay/url-header.png)

E no corpo da requisição, você deverá enviar um objeto JSON com o campo:

```json
{
  "numCartao" : ""
}
```

![Body](https://github.com/fabriciio95/arquivos-read-me/blob/master/arquivos-rep-bfpay/body.png)

### E então será retornado o status do pagamento:
- Autorizado: Quando o pagamento foi bem sucedido.
- NaoAutorizado: Quando o cartão não inicia com **0000, 1111, 2222 ou 3333**.
- CartaoInvalido: Quando o cartão não tem 16 digitos.
- Token inválido: Quando o token informado no cabeçalho da requisição é diferente de **r2d2**.

![Response](https://github.com/fabriciio95/arquivos-read-me/blob/master/arquivos-rep-bfpay/response.png)

## Testando o web service implantado no Heroku
**Para testar o web service implantado no heroku, você precisa apenas fazer a seguinte alteração na url do exemplo acima:**
```url
http://localhost:8081
```
**Para:**
```url
  https://bfpay.herokuapp.com
```
**Lembrando que caso o servidor não esteja ativo no Heroku as primeiras requisições podem não funcionar, então apenas faça uma requisição e aguarde alguns instantes para o servidor seja inicializado no Heroku.**

# Autor

Fabricio Siqueira Macedo

https://linkedin.com/in/fabricio-siqueira-macedo

