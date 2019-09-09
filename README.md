# buildit-spring
FIAP - Projeto de AM (Oracle - 2019)

Configurando o projeto localmente (Oracle):

1.  Clone o repositório
2. Baixe o **ojdbc7.jar** da Oracle - https://www.oracle.com/technetwork/database/features/jdbc/jdbc-drivers-12c-download-1958347.html
3. Execute o seguinte comando para adicionar o ojdbc.jar localmente
```
mvn install:install-file -Dfile=<path-to-file>/ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.1.0 -Dpackaging=jar
```
4. Mude o acesso ao BD da aplicação no arquivo **application.properties**
5. Execute um Build e depois execute o programa

Acessando banco de dados em memória (H2 database):
1.  Clone o repositório
2. Execute o projeto
3. Acesse a url (localhost:3030/h2) e logue com o usuário e senha definido no arquivo application.properties

Ps* Caso você seja redirecionado para a página de login da aplicação logue com as seguintes credenciais
E-mail: buildit@fiap.com.br / senha: nimda



