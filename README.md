
# Microserviço de Proposta:

### **Funcionalidades**

* Receber e validar propostas de crédito via API REST.
* Enviar as propostas para uma fila de mensageria para processamento.
* Receber o resultado final da análise de crédito (aprovado ou negado).
* Sistema de resiliência utilizando a anotação Scheduler, para propostas que ainda não foram enviadas a fila.
* Atualizar o status da proposta no banco de dados.

### **🛠️ Tecnologias Utilizadas**

* **Linguagem:** Java 21
* **Framework:** Spring Boot
* **Mensageria:** RabbitMQ
* **Banco de Dados:** PostgreSQL
* **Contêineres:** Docker

### **Arquitetura de Comunicação**

O Serviço de Propostas recebe uma requisição, a salva no banco e a envia para uma fila, que é consumida pelo Serviço de Análise de Crédito. Depois age como consumer e recebe as propostas completas do outro serivço, depois atualiza o objeto no banco de dados.
