# ToolsChallenge

API de pagamento que realiza processamento de solicitaçoes de compra e estorno da mesma.
A API permite consultar os dados do pagamento enviados e estorno

## Tecnologias Utilizadas

O projeto foi criado com Spring Boot na linguagem de programação Java, Spring Data JPA e realizado testes unitários com JUnit.

## Arquitetura
O projeto está divido nas seguintes camadas:

*main:*
1. Config
2. Controller
3. Convert
4. DTO
5. Exception
6. Model
7. Repository
8. Service

*test:*
1. Servico.impl

## Como executar
1. Clonar o projeto
2. Executar o projeto em uma IDEA``
3. Acessar no navegador http://localhost:8080/swagger-ui.html#/

## Como testar
O sistema possui dois endpoint:
1. **``POST /pagamentos``**: Requisita o processamento do pagamento:
```javascript
{
  "transacao": {
    "cartao": "44441231231231234",
    "descricao": {
      "dataHora": "2022-12-20",
      "estabelecimento": "Teste",
      "valor": 500.50
    },
    "formaPagamento": {
      "parcelas": 1,
      "tipo": "AVISTA"
    },
  }
}
```

*Exemplo do corpo da resposta do pagamento:*
```javascript
{
    "transacaoRespostaDTO": {
        "id": 1,
            "cartao": "*************1234",
            "descricao": {
            "valor": 500.5,
                "dataHora": "2022-12-20",
                "estabelecimento": "Teste",
                "nsu": 1234,
                "condigoAutorizacao": 1111111,
                "status": "AUTORIZADO"
        },
        "formaPagamento": {
            "tipo": "AVISTA",
                "parcelas": 1
        }
    }
}
```


1. **``PUT /estorno``**: *Para fazer o estorno basta passar o idPagamento:*
   *Exemplo do corpo da resposta do estorno:*
```javascript
{
  "transacaoRespostaDTO": {
    "id": 1,
    "cartao": "*************1234",
    "descricao": {
      "valor": 500.5,
      "dataHora": "2022-12-20",
      "estabelecimento": "Teste",
      "nsu": 1234,
      "condigoAutorizacao": 1111111,
      "status": "CANCELADO"
    },
    "formaPagamento": {
      "tipo": "AVISTA",
      "parcelas": 1
    }
  }
}
```

3**``GET /consultaPagamentoId``**: Requisita os dados do pagamento do id
4**``GET /consultaPagamento``**: Requisita os dados de todos os pagamentos 
