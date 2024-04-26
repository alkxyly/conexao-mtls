﻿# Conceituando o MTLS

 O MTLS (Mutual Transport Layer Security) é uma extensão do protocolo TLS (Transport Layer Security) que fornece autenticação mútua entre o cliente e o servidor em uma conexão segura. No TLS tradicional, apenas o servidor é autenticado pelo cliente, enquanto o cliente permanece anônimo. Com o MTLS, ambos, cliente e servidor, são autenticados um pelo outro. A autenticação MTLS é realizada durante o processo de handshake TLS, no qual as duas partes (cliente e servidor) trocam informações de certificado digital para confirmar suas identidades. 

 O processo de autenticação do MTLS (Mutual Transport Layer Security) envolve várias etapas, durante as quais tanto o cliente quanto o servidor se autenticam mutuamente usando certificados digitais.

```mermaid
sequenceDiagram
    participant Client
    participant Server

    Note over Client, Server: Início do Handshake TLS

    Client->>Server: Cliente envia mensagem indicando os protocolos TLS suportados, conjuntos de criptografia e outras informações relevantes

    Note over Client, Server: Envio do Certificado pelo Cliente

    Client->>Server: Certificado Chave pública e outras informações, incluindo sua identidade

    Note over Server: Validação do certificado do cliente

    Server-->>Client: Verificar certificado do cliente certificação da assinatura por uma autoridade de certificação confiável (CA) e o período de validade

    Note over Server, Client: Envio do Certificado pelo Servidor

    Server->>Client: Certificado Chave pública e outras informações, incluindo sua identidade

    Note over Client: Validação do Certificado do Servidor

    Client-->>Server: Verificar certificado do servidor Verificação da assinatura por uma CA confiável e o período de validade

    Note over Client, Server: Conclusão do Handshake com autenticação MTLS bem-sucedida comunicação protegida pela criptografia TLS

```
