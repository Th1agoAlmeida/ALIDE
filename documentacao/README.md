
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


## Annotation
Anotações para "injeção" de rotinas nas classes:

### Annotation para Controller

- **@Controller** : Define que uma classe assume o papel de Controller na aplicação com pradrão MVC;

- **@RequestMapping(value="", method=RequestMethod.)** : Define quais endereços de URL fazem chamada Requisição
    - **value=""** ou **value={"/", "/a", "/b"}** : Valor de chamada da requisição, dado especifico ou vetor de dados
    - **method=RequestMethod.GET** ou **.POST** : Tipo de Requisição que ele trata

### Annotation para Model


## Classes de Implementação

- **ModelAndView**: Faz uma ponte entre as instancias do Model e a renderização da View por meio das classes com a *Annotation @Controller*:

    ```java
    @RequestMapping(value="/requisicao", method=RequestMethod.GET) //RequestMethod.GET / RequestMethod.POST
    public ModelAndController metodoGet_Post() {
        ModelAndController modelAndController = new ModelAndController("/pagina_de_redirecionamento.html");
        
        // Implementação
        
        return modelAndController;
    }
    ```

## Thymeleaf

**Thymeleaf** é um engine template html, ele tem **atributos** especiais em sua composição e **layouts** também

### Exemplo de exportação

<html xmlns:th="http://thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">

</html>