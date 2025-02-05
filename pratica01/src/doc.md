# 📚 Sistema de Controle de Biblioteca

Um sistema simples e intuitivo para gerenciar o cadastro de livros e revistas em uma biblioteca, desenvolvido em Java com interface gráfica Swing.

## 📝 Sobre o Projeto

Este sistema foi desenvolvido para facilitar o controle de uma biblioteca básica, oferecendo uma interface amigável onde qualquer pessoa pode cadastrar e gerenciar livros e revistas de forma eficiente.

### 🏗️ Arquitetura do Sistema

O projeto foi estruturado seguindo boas práticas de programação orientada a objetos, com uma clara separação de responsabilidades:

#### 📦 Estrutura base

A classe `Publicacao` serve como base para o sistema:

#### 📖 Gerenciamento de Livros

A classe `Livro` herda de `Publicacao`:

#### 📰 Gerenciamento de Revistas

A classe `Revista` também herda de `Publicacao`:

### 🖥️ Telas do Sistema

[Aqui você coloca suas screenshots]

### 🏗️ Como organizei o código

Decidi separar o sistema em algumas classes principais:

#### 📦 Estrutura base

#### 📖 Para os livros

#### 📰 Para as revistas

### 🎯 Funcionalidades

- ✅ Cadastro de livros com título, autor e ano
- ✅ Cadastro de revistas com organizador, volume e número
- ✅ Listagem completa do acervo
- ✅ Interface gráfica intuitiva
- ✅ Validação de campos obrigatórios

### 💭 O que poderia melhorar

Se tivesse mais tempo, gostaria de implementar:
- 💾 Salvamento permanente dos dados
- 🔍 Sistema de busca
- ✏️ Edição de publicações já cadastradas
- 📋 Sistema de empréstimos

### 🤔 Principais Desafios

A parte mais trabalhosa foi fazer a interface gráfica funcionar como esperado. Os principais pontos de atenção foram:
- Garantir que todos os campos fossem preenchidos
- Deixar as telas organizadas e intuitivas
- Atualização automática da listagem

### 🔧 Como rodar o projeto

1. Clone o repositório
2. Abra o projeto em sua IDE favorita
3. Execute a classe `Main.java`

### 📋 Requisitos do Sistema

- Java 8 ou superior
- IDE com suporte a GUI (Swing)

### 🎨 Interface do Sistema

O sistema possui três telas principais:
1. Cadastro de Livros
2. Cadastro de Revistas
3. Listagem do Acervo

[Aqui você coloca mais screenshots específicas de cada tela]

### 📝 Conclusão

O sistema atende bem à proposta inicial de um controle de biblioteca básico. É fácil de usar e mantém o código organizado para futuras melhorias ou manutenções.

### 💭 Melhorias Futuras

Funcionalidades planejadas para próximas versões:

- 💾 Persistência de dados em banco
- 🔍 Sistema de busca avançada
- ✏️ Edição e exclusão de registros
- 📋 Controle de empréstimos
- 📊 Relatórios estatísticos
- 🔐 Sistema de login
- 📱 Interface responsiva para diferentes resoluções

---
Desenvolvido por Matheus Medrado Ferreira.
