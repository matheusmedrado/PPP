# 🎮 Princípios e Padrões de Projeto - Trabalho Final

Este repositório contém o trabalho final da disciplina **Princípios e Padrões de Projeto**, implementando um framework de jogos 2D em Java com dois jogos demonstrativos que aplicam diversos padrões de design.

## 🏗️ Arquitetura do Projeto

O projeto é estruturado em três módulos principais:

```
📦 Trabalho Final
├── 🔧 Framework/          # Framework base para jogos 2D
├── 👾 FreezeMonster/      # Jogo implementado usando o framework
├── 🚀 SpaceInvaders/      # Segundo jogo implementado usando o framework
└── 📋 buildSrc/           # Configurações de build compartilhadas
```

## 🎯 Framework de Jogos

O **Framework** é o coração do projeto, fornecendo uma base reutilizável para desenvolvimento de jogos 2D. Ele implementa vários padrões de design fundamentais:

### Padrões Implementados

- **🏭 Abstract Factory**: Sistema de fábricas para criação de diferentes tipos de sprites
- **👁️ Visitor**: Gerenciamento de colisões e interações entre objetos do jogo
- **🎨 Template Method**: Estrutura base para criação de jogos através da classe `MainFrame`
- **🔧 Strategy**: Diferentes comportamentos para sprites e entidades do jogo

### Componentes Principais

- `MainFrame`: Classe abstrata que define a estrutura básica de um jogo
- `AbstractBoard`: Board abstrato que gerencia o loop principal do jogo
- `PlayerFabrica`: Interface para fábrica de criação de players
- `CollisionVistor`: Visitor para tratamento de colisões

## 🎮 Jogos Implementados

### 👾 FreezeMonster

Um jogo de ação onde o jogador controla um personagem que deve derrotar monstros usando projéteis especiais.

**Características:**
- Sistema de sprites animados
- Diferentes tipos de monstros
- Sistema de projéteis
- Detecção de colisões

**Assets inclusos:**
- Sprites de monstros (9 variações)
- Sprite do player
- Efeitos visuais (gosma, raios)

### 🚀 SpaceInvaders

Uma implementação clássica do famoso jogo Space Invaders.

**Características:**
- Invasores espaciais
- Sistema de pontuação
- Mecânicas clássicas do jogo original

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal
- **Swing**: Interface gráfica
- **Gradle**: Sistema de build
- **Kotlin DSL**: Configuração de build

## 🚀 Como Executar

### Pré-requisitos

- Java 11 ou superior
- Gradle (incluído via wrapper)

### Executando os Jogos

1. **Clone o repositório:**
   ```bash
   git clone <url-do-repositorio>
   cd ppp/Trabalho\ Final
   ```

2. **Execute o FreezeMonster:**
   ```bash
   ./gradlew :FreezeMonster:run
   ```

3. **Execute o SpaceInvaders:**
   ```bash
   ./gradlew :SpaceInvaders:run
   ```

### Build do Projeto

Para compilar todos os módulos:
```bash
./gradlew build
```

## 📚 Estrutura dos Padrões

### Abstract Factory
```java
public interface PlayerFabrica {
    Player novoPlayer();
}
```

### Visitor Pattern
```java
public interface CollisionVistor {
    // Implementação do padrão Visitor para colisões
}
```

### Template Method
```java
public abstract class MainFrame extends JFrame {
    protected abstract AbstractBoard createBoard(); // Hotspot
}
```

## 👥 Contribuições

Este projeto foi desenvolvido como trabalho acadêmico para a disciplina de Princípios e Padrões de Projeto.

## 📄 Licença

Projeto acadêmico - uso educacional.

---


