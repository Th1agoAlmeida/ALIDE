
# Documentação Minimalista

## Disposição de pacotes (Front-End / Back-End)

Os pacotes do java da aplicação estão dispostos da seguinte maneira:

    com.upe.alide.*;

    com.
        upe.
            alide.
                Main.java;
                config;
                controller;
                model;
                repository;


---

## Annotation
Anotações para "injeção" de rotinas nas classes: [Mais Informações](https://pt.wikipedia.org/wiki/Annotation_(java))

### Controller

- **@Controller** : Define que uma classe assume o papel de Controller na aplicação com pradrão MVC:

- **@RequestMapping(value="", method=RequestMethod.)** : Define quais endereços de URL fazem chamada Requisição:

    ```java
    @Controller
    public class Controller {     

        @RequestMapping(value="nome_da_requisicao", method=RequestMethod.) // GET / POST
        public Type metodo() {

            return type;
        }

    }
    ```

    - **value=""** ou **value={"/", "/a", "/b"}** : Valor de chamada da requisição, dado especifico ou vetor de dados

    - **method=RequestMethod.GET** ou **.POST** : Tipo de Requisição que ele trata

---

### Model

* **@Entity** : Apresenta como entidade do banco de dados

* **@ID** : Aponta atributo que servirá como Id (Chave Primária da Tabela)

* **@GeneratedValue(strategy = GenerationType.AUTO)** : Configura forma como a chave será gerada no banco

```java
@Entity
public class ClasseEntidade implements Serializable {
    
	/**
	 * 
	 * Interface Serializable Gera o private static final long serialVersionUID = 1L;
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO - IDENTITY - SEQUENCE - TABLE
    private long id;

    private String nome;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
```

---

### Configuration

* **@Configuration** : Faz a classe ser visualizada como uma classe de configuração:
```java
@Configuration
public class ClasseConfig {

}
```
* **@Bean** : Faz uma Classe ou Metodo funcionar como uma dependencia para outras classes:
```java
@Configuration
public class ClassConfig {

    @Bean
    public Type metodoConfig() {

        return type;
    }
}
```

---

## Classes (Objetos)

- **ModelAndView**: Faz uma ponte entre as instancias do Model e a renderização da View por meio das classes com a *Annotation @Controller*:

    ```java
    @RequestMapping(value="/requisicao", method=RequestMethod.GET) //RequestMethod.GET / RequestMethod.POST
    public ModelAndController metodoGet_Post() {
        ModelAndController modelAndController = new ModelAndController("/pagina_de_redirecionamento.html");
        
        // Implementação
        
        return modelAndController;
    }
    ```

---

## Thymeleaf

**Thymeleaf** é um engine template html, ele tem **atributos** especiais em sua composição e **layouts** também

### Exemplo de exportação

```html
<html xmlns:th="http://thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

</html>
```