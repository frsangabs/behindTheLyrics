# 🎵 Behind the Lyrics (BTL)

**Behind the Lyrics (BTL)** é uma aplicação web voltada para amantes da música que desejam explorar informações sobre **bandas, álbuns e músicas**, indo além dos títulos e descobrindo os significados e histórias por trás das letras.  

O projeto foi desenvolvido como parte de um estudo sobre **arquitetura MVC**, onde foi feito um CRUD com integração ao banco de dados via **JDBC** e uso de **Spring Boot** com **Thymeleaf** para renderização dinâmica no front-end.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **JDBC (Java Database Connectivity)**
- **PostgreSQL**
- **Thymeleaf**
- **HTML5 / CSS3**
- **Bootstrap**

---

## 🧠 Conceito do Projeto

A proposta do **BTL** é unir o amor pela música à curiosidade sobre suas origens.  
O usuário pode navegar entre bandas, visualizar detalhes sobre seus álbuns e músicas, e ler trechos que contam o **contexto, inspiração e mensagem** de cada composição.

Cada página foi construída pensando na **experiência de descoberta**, oferecendo uma interface simples e organizada para explorar o conteúdo musical.

---

## 🗂️ Estrutura do Sistema

O sistema segue o padrão **MVC (Model-View-Controller)**:

- **Model:** Classes que representam as entidades principais (`Banda`, `Album`, `Musica`), conectadas ao banco via JDBC.
- **DAO:** Camada responsável pela comunicação direta com o banco de dados PostgreSQL.
- **Service:** Responsável por aplicar regras de negócio e repassar dados entre DAO e Controller.
- **Controller:** Controla as requisições e direciona as páginas renderizadas com Thymeleaf.
- **View (Thymeleaf):** Renderiza as informações dinâmicas em HTML, exibindo listas e detalhes.

---

## 🖥️ Funcionalidades Principais

✅ Listagem de **bandas** cadastradas  
✅ Exibição dos **álbuns** relacionados a cada banda  
✅ Visualização de **músicas** com lore/descrição  
✅ Sistema de **navegação entre entidades** (banda → álbum → música)  
✅ Interface dinâmica utilizando **Thymeleaf**  

---

## 📸 Interface

As páginas foram criadas com **Thymeleaf** e **Bootstrap**, oferecendo:
- Cards para exibição de bandas e álbuns;
- Páginas de detalhes com as músicas e suas descrições;
- Um layout coerente e fácil de navegar.

Home:
<img width="1898" height="914" alt="image" src="https://github.com/user-attachments/assets/949f9534-05e0-4ec0-99ef-042ac33adcff" />

Músicas:
<img width="1918" height="688" alt="image" src="https://github.com/user-attachments/assets/4cfcc5c5-2a45-4417-997d-2156808a2fa0" />

Bandas:
<img width="1918" height="715" alt="image" src="https://github.com/user-attachments/assets/209628fe-235a-47d6-acd4-3b552a9c619a" />

Albuns:
<img width="1918" height="672" alt="image" src="https://github.com/user-attachments/assets/40ba30bc-58e7-4136-b5ea-7c6d27442633" />




