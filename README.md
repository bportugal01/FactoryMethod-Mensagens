#  Factory Method - Sistema de Mensagens

Este projeto demonstra o uso do padrão de projeto **Factory Method** em um sistema de exibição de mensagens. 


##  Sobre o Projeto

Utilizando o padrão **Factory Method**, este sistema permite criar diferentes tipos de mensagens (sucesso, erro, aviso, etc.) sem acoplar o código às classes concretas. Isso facilita a manutenção e a extensão do sistema no futuro. A aplicação simula uma tela onde, ao selecionar um tipo de mensagem, o sistema utiliza a fábrica correspondente para exibir a mensagem adequada com estilo visual próprio.


##  Imagens da Aplicação

### Tela Inicial  
<img src="https://github.com/bportugal01/FactoryMethod-Mensagens/blob/main/img/home.png" width="400"/>

###  Mensagem de Sucesso  
<img src="https://github.com/bportugal01/FactoryMethod-Mensagens/blob/main/img/sucesso.png" width="400"/>

###  Mensagem de Aviso  
<img src="https://github.com/bportugal01/FactoryMethod-Mensagens/blob/main/img/aviso.png" width="400"/>

###  Mensagem de Erro  
<img src="https://github.com/bportugal01/FactoryMethod-Mensagens/blob/main/img/erro.png" width="400"/>

---

##  Conceito de Factory Method

O padrão **Factory Method** define uma interface para criar um objeto, mas permite que as subclasses decidam qual classe instanciar. Neste projeto, cada tipo de mensagem possui sua própria fábrica que é responsável por instanciar a mensagem adequada.

Esse padrão promove:
- Desacoplamento entre a criação e o uso dos objetos.
- Facilidade de extensão (novos tipos de mensagens podem ser adicionados facilmente).
- Organização clara e orientada a boas práticas de programação.
