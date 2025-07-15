# Resolução 02 - API para Mensagens SMS


## Entrada e saída de dados
- Json de entrada, SmsMessageInDTO.

```jason
{
    "phoneNumber": "1132321",
    "status": "ENVIADO"
}
```
- Json de saída, SmsMessageOutDTO.

```jason
{
    "id": 4,
    "phoneNumber": "1132321",
    "status": "ENVIADO",
    "sentAt": "2025-07-14T13:31:33.3740107"
}
```

## Endpoints da aplicação 


| Método | URL | Descrição
|---|---|---|
| `POST` | localhost:8080/message | realiza a criação de uma mensagem, recebendo em seu body de requisição um SmsMessageInDTO. Em caso de sucesso, a requisição retorna um status code 200 e um body de SmsMessageOutDTO, em caso de erros, a requisição retorna um status code de 400 ou 500.
| `GET` | localhost:8080/message/{status} | realiza a busca de mensagens geradas nas últimas 24 horas com base no status de envio [ENVIADO, RECEBIDO, ERRO_DE_ENVIO] passado via url. Em caso de sucesso, a requisição retorna em seu body um status code de 200 e uma lista vazia se nenhuma mensagem possuir o status informado ou uma lista de SmsMessageOutDTO com todas as mensagens que possuem o status informado via url. Em caso de erros, a requisição retorna um 400 ou 500.
| `PUT` | localhost:8080/message/update | realiza a alteração do status de envio de uma mensagem através do id da mensagem passada via parâmetro e um body de SmsMessageInDTO. Em caso de sucesso, a requisição retorna um body de SmsMessageOutDTO atualizado, em caso de erros, a requisição retorna um 404,400 ou 500.
