	                           Oficina Java – JPA – Hibernate – CRUD Básico
	
1- Configuração do ambiente de desenvolvimento Java.
1.1 – SDK - Kit de desenvolvimento Java -   http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html 
 
1.2 – NetBeans IDE 8.0.2 (já vem com o GlassFish e Tomcat).    https://netbeans.org/downloads/ 

1.3 – Banco de dados, Postgresql - https://www.postgresql.org/download/
                                   Mysql - https://www.mysql.com/downloads/

1.4 – Conta no GitHub - https://github.com/    

1.5 - Git - https://git-scm.com/downloads (Git é um sistema de controle de versões distribuído, usado principalmente no desenvolvimento de software, mas pode ser usado para registrar o histórico de edições de qualquer tipo de arquivo).

2- Iniciando projeto.
2.1 – tipo de projeto. (WEB)
2.2 – Servidor de aplicação (Glassfish)
2.3 – Java EE – (O Java EE (Java Enterprise Edition) consiste de uma série de especificações bem detalhadas, dando uma receita de como deve ser implementado um software que faz cada um desses serviços de infraestrutura).
2.4.1 – Configuração da Conexão com banco de dados (camada de Persistência).
2.4.2–JPA - API Java Persistence API e Hibernate. 
2.4.3 – Conexão com o Banco Mysql 
2.4.4 – Conexão como o Banco PostgreSql.
2.4.5 - Conexão com o Banco Oracle

2.5 – Estruturas de pastas do projeto
2.5.1 - WEB_INF
2.5.1.1 – Arquivo web.xml
2.5.2 - Pacote de código fonte
2.5.3 - Bibliotecas
2.5.4 - Arquivos de configuração	
- Hibernate.cfg.xml
             - Persistence.xml

3 – Importando as bibliotecas.
         	3.1.1 – Manual 
 Fonte - http://www.java2s.com/Code/Jar/
3.1.2 – Automático - Usando Maven.
 https://mvnrepository.com/

4- Classes e anotações JPA e Hibernate.
4.1- Pacote Modelo
4.1.1 – Classe Usuario. java
          @Entity 
Anotação que indica para o Hibernate que a classe é um modelo de banco de dados, é está notação que marcar a classe como uma entidade de persistência.
@Table(name = "usuario") obs. Cuidado para não usar palavra chave dos bancos
Esta anotação indica para o Hibernate que a classe é uma tabela de banco de dados, neste caso  estamos usando só a propriedade nome, ou seja, o Hibernate vai criar uma tabela com o nome “user” e vai ignorar o nome Usuário que é o nome da classe. Caso não tivesse especificado nada, ou seja, somete escrito @Table sem a propriedade nome, o Hibernate criaria uma tabela com o nome da classe no banco, que neste caso é usuário.
4.1.2- declaração das Variáveis ou objetos.
 - Declaração - Modificadores de acesso, tipo, nome do objeto.
 @Id - Identificador da chave primaria
 @GeneratedValue(strategy = GenerationType.AUTO) 
 AUTO - Indica que o provedor de persistência deve escolher uma estratégia      apropriada para o banco de dados específico. A estratégia de geração AUTO pode esperar que exista um recurso de banco de dados ou pode tentar criar um. Um fornecedor pode fornecer documentação sobre como criar esses recursos caso não ofereça suporte à geração de esquema ou não possa criar o recurso de esquema no tempo de execução.

IDENTITY - Indica que o provedor de persistência deve atribuir chaves primárias para a entidade usando uma coluna de identidade do banco de dados.

SEQUENCE - Indica que o provedor de persistência deve atribuir chaves primárias para a entidade usando uma seqüência de banco de dados.

TABLE - Indica que o provedor de persistência deve atribuir chaves primárias para a entidade usando uma tabela de banco de dados subjacente para garantir a exclusividade.

@Column (nullable = false, length = 100, unique = true)
Propriedades da coluna, not null, quantidade de caracteres, valor único, outros.
@Temporal(TemporalType.DATE)
Determina para o banco parâmetro com propriedade de date time, neste caso, está anotado como só data, porém, pode ser configurado ainda só TIME e TIMESTAMP.

4.1.3 – declaração do método construtor
	- Construtor padrão e com argumento.
4.1.4 – declaração dos métodos Getter e Setter.
	- Métodos que dão acesso às variáveis de privadas. (nome, senha, email, dataNascimento).
4.1.5- declaração do método hashCode.
	- Método que garante identificador único na tabela, neste caso o ID, mas poderia ser o nome, CPF, ou qualquer outro parâmetro que julgue necessário. 
4.1.6 - declaração do método toString.
- Este método formata a saída de como padrão, deixa a saída legível no console.

4.2 - Pacote Utilidades
4.2.1 – Classe CriarTabelas.java
Método main:
public static void main(String[] args) {
          Persistence.createEntityManagerFactory("bancoMysql");
    } 
Obs.  Orientação a objetos no Java - Para que o método possa ser sobrescrito ele tem que ser herdado em primeiro lugar. Métodos estáticos não são herdados, tal como os construtores também não são. Métodos estáticos são dá Classe, e não de uma instância específica (objeto).
         
4.2.2- Classe de conexão com o banco (EntityManager).
	- Interfaces EntityManager e EntityManagerFactory.
	- A fabrica de conexão com o banco.

4.3 – Pacotes DAO (Data Access Object)

4.3.1 – Classe usuarioDAO 
- EntityManager manager = conexao.getEntityManager();
          - EntityTransaction conexao = managerMysql.getTransaction();
	Métodos do CRUD.

