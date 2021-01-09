# Sobre o projeto:

A Web API REST foi desenvolvida utilizando como ferramentas e soluções:
- Maven
- Git
- Github
- Docker
- Postgresql
- PgAdmin
- Java 11
- Spring boot
- Springfox
- Swagger
- Postman


##### Sobre A Arquitetura
Foi utilizada uma arquitetura MVC para o projeto da API, com utilização um layer de serviços para desaclopar os controllers do modelo.
A camada de serviço é responsável pela validação dos dados antes da comunicação entre a camada de persistência e a requisições dos controllers, tornando assim os controllers responsáveis apenas para receber as requisições http mapeadas pelas endpoints e devolver as representações de visualização do modelo.


##### Uteis e Exceptions
Foram criadas classes mappers para cada entidade do modelo para a transformação entrem as representações DTO e View do modelo, tais classes estão no package *br.com.navita.patrimonioempresa.utils.mapper*.  
Também foram criadas exceptions que extendem a classe RuntimeException tanto para aumentar a semantica de exceptions como para a utilização na classe ApiResourceAdvice que serve como advice para os controllers devolvendo mensagens de erros nas respostas da requisições http para a API.

##### ORM
A comunicação com o DB é toda realizada para interfaces repository que são implementadas pelo framework Spring Data que utilizadas por já possuírem out-of-box métodos CRUD e paginação.


##### Segurança
A segurança é realizada pelo Spring Security com a geração de token que é necessário para autorização em todos os endpoints, com exceção do Endpoint api/user

# Sobre sua utilização: 

A aplicação Patrimônio empresa tem documentação uma página swagger-ui que pode ser acessada no endereço http://host/swagger-ui.html
![swagger-1](http://felipemandu.com.br/swagger-1.png)

Todos os endpoints estão protegidos e só são somente acessados por token, com a exceção do endpoint http://host/api/user.

##### Endpoints de Marca

![swagger-1](http://felipemandu.com.br/swagger-2.png)

##### Endpoints de Patrimônio

![swagger-1](http://felipemandu.com.br/swagger-3.png)


##### Endpoint de User

O endpoint http://host/api/user deve ser utilizado para criação de um usuário da api, pois somente com um usuário será possível gerar um token.

![swagger-4](http://felipemandu.com.br/swagger-4.png)


##### Gerando Token de acesso


O Token será gerado no endpoint http://host/oauth/token por meio de uma authorization Basic Auth com o client-id e o secret-id da API, e o envio dos params grant_type=password
username=**EmaildoUsuarioCadastrado** e password=**passwordDoUsuarioCadastrado**.

![swagger-1](http://felipemandu.com.br/postman-1.png)


##### Acessando recursos com token
Com o acess_token em mãos, o consumidor da API enviará um requisição para os endpoints seguros com o header Authorization "Bearer **acess_token** " para garantir acesso das requisições.


![swagger-1](http://felipemandu.com.br/swagger-5.png) 

