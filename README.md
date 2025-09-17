# 📦 API de Produtos e Usuários

Projeto desenvolvido em **Java com Spring Boot** para praticar a criação de **APIs REST** conectadas a um banco de dados **MySQL/MariaDB**.  
O sistema implementa as operações básicas de **CRUD** (Create, Read, Update, Delete) para duas entidades: **Produto** e **Usuário**.

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL / MariaDB**
- **Maven**
- **VSCode** (com extensões para Java e Spring)

---

## 📂 Estrutura do Projeto
src/main/java/br/com/bentao/api_produtos
├── controller # Contém os endpoints da API (ProdutoController, UsuarioController)
├── model # Classes que representam as tabelas do banco (Produto, Usuario)
├── repository # Interfaces que fazem a comunicação com o banco de dados
└── ApiProdutosApplication.java # Classe principal