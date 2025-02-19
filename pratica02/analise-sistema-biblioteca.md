<span style="font-family: 'Fira Code', monospace;;">

# Análise do código: Antes e Depois

## 1. Analisando o Sistema Original

Quando comecei a revisar o meu código, identifiquei problemas relacionados aos princípios
de design que aprendemos. Seguem minhas observações:

### 1.1 Princípio DRY (Don't Repeat Yourself)

Encontrei alguns problemas de repetição no código:

- Meu código possui duplicação de código, principalmente na interface gráfica
  - Tem alguns métodos praticamente iguais nas classes para criar telas;
  - A validação de campos também estava repetida em diferentes partes do código;
- Percebi que usei atributos duplicados entre as classes Livro e Revista por exemplo
- A lógica para manipular a GUI estava repetida em vários lugares e ficou meio confusa, atribuo também à minha falta de
  experiência com GUIs

### 1.2 Princípios SOLID

#### Single Responsibility Principle (SRP)

Encontrei esses problemas que acabam indo contra o SRP:

- A classe ControleBibliotecaGUI estava sobrecarregada com muitas responsabilidades:
  - Cuidava da interface gráfica
  - Implementava lógica de apresentação
  - Fazia validação de dados
- As outras classes não tinham responsabilidades bem definidas

#### Open/Closed Principle (OCP)

Encontrei problemas como:

- O sistema de certa forma estava praticamente fechado para extensões
- Percebi que adicionar novos tipos exigia modificar várias classes existentes
- Percebi que acabei gerando um forte acoplamento no código

#### Liskov Substitution Principle (LSP)

Acredito que meu código tinha alguns pontos positivos, como por exemplo a hierarquia básica funcionava bem com
a classe Publicacao como base.
Mas também encontrei problemas como:

- As subclasses tinham comportamentos muito específicos
- Era difícil reutilizar o código existente

#### Interface Segregation Principle (ISP)

Encontrei os seguintes problemas no meu código:

- Não havia interfaces no sistema
- As classes estavam sobrecarregadas com muitas responsabilidades
- De novo um forte acoplamento entre os componentes

#### Dependency Inversion Principle (DIP)

Os problemas que encontrei no código foram:

- Havia dependências diretas de implementações concretas
- Faltavam abstrações mais adequadas
- Mais uma vez, existia um forte acoplamento entre as camadas do sistema

## 2. Minhas Modificações no Sistema

Depois de identificar esses problemas, reformulei meu código com as seguintes melhorias:

### 2.1 Aplicando o Princípio DRY

Implementei as seguintes melhorias:

- Criei a classe abstrata ItemBibliografico para:
  - Centralizar os atributos comuns
  - Unificar o comportamento base
- Desenvolvi a classe FormularioBase para:
  - Eliminar a duplicação de código nos formulários
  - Centralizar a lógica comum de GUI
- Criei interfaces reutilizáveis (Autoravel, Duravel) para:
  - Extrair comportamentos comuns em interfaces
- Centralizei a validação com:
  - Um método validarCamposBasicos na classe base
- Padronizei a formatação com:
  - Um método getInfo padronizado

### 2.2 Aplicando os Princípios SOLID

#### Single Responsibility Principle (SRP)

Implementei as seguintes melhorias:

- Separei claramente as responsabilidades:
  - ItemBibliografico como modelo de dados base
  - Interfaces específicas para diferentes comportamentos
  - FormularioBase para a lógica comum de GUI
  - Formulários específicos apenas com sua lógica específica
  - BibliotecaGUI apenas para gerenciar a interface principal

#### Open/Closed Principle (OCP)

Tornei o sistema extensível:

- Agora novos tipos podem ser adicionados sem modificar o código existente
- As interfaces permitem estender comportamentos facilmente
- Os formulários base permitem extensão controlada

#### Liskov Substitution Principle (LSP)

Criei uma hierarquia mais coesa:

- ItemBibliografico é agora uma base sólida
- As subclasses seguem o contrato base de forma consistente
- As interfaces garantem comportamentos específicos bem definidos
- A substituição é mais segura e previsível

#### Interface Segregation Principle (ISP)

Desenvolvi interfaces específicas:

- Autoravel para itens que precisam de autor
- Duravel para itens com duração
- Os clientes agora dependem apenas das interfaces que realmente precisam
- Consegui uma separação clara de responsabilidades

#### Dependency Inversion Principle (DIP)

Implementei dependência de abstrações:

- O sistema agora trabalha com a abstração ItemBibliografico
- Passei a usar interfaces para comportamentos específicos
- Os formulários dependem de contratos, não de implementações concretas

## 3. Principais Mudanças Estruturais que Implementei

1. Criei um Novo Sistema de Tipos:

   - ItemBibliografico como base abstrata
   - Interfaces para comportamentos específicos
   - Uma hierarquia mais flexível e extensível

2. Desenvolvi um Sistema de Formulários melhorado:

   - FormularioBase como template
   - Formulários específicos mais enxutos
   - Reutilização efetiva de código

3. Reorganizei o Código:

   - Pacotes/classes mais coesos
   - Responsabilidades bem definidas
   - Reduzi significativamente o acoplamento

4. Melhorei a Interface Gráfica:
   - Implementei um sistema de abas mais organizado
   - Eliminei código duplicado
   - Tornei a manutenção mais simples

## 4. Benefícios da Minha Nova Implementação

1. Melhorei a Manutenibilidade:

   - O código está mais organizado
   - Reduzi drasticamente a duplicação
   - As responsabilidades estão mais claras

2. Aumentei a Extensibilidade:

   - Agora é muito mais fácil adicionar novos tipos
   - É simples adicionar novos comportamentos
   - As mudanças têm baixo impacto no sistema existente

3. Melhorei a Reusabilidade:

   - Criei componentes mais genéricos
   - As interfaces são reutilizáveis
   - O código base é compartilhado de forma eficiente

4. Aumentei a Testabilidade:
   - Os componentes estão mais isolados
   - As dependências estão claramente definidas
   - As interfaces são bem definidas

## 5. Minha Conclusão

Através da aplicação consistente dos princípios DRY e SOLID, consegui transformar um sistema problemático em uma
arquitetura mais robusta e bem estruturada.

Minhas principais melhorias foram:

- Eliminar praticamente todo o código duplicado
- Organizar melhor as responsabilidades
- Criar um sistema mais flexível e extensível
- Tornar a manutenção mais simples
- Produzir um código mais limpo e compreensível

Acredito que estas melhorias tornaram o sistema mais robusto, fácil de manter e bem mais preparado para
futuras expansões. Gostei da forma como as interfaces Autoravel e Duravel permitiram uma composição mais flexível
de comportamentos, o que era quase que impossível no código original.

## 6. Código Atualizado em Sua Totalidade

- Interfaces

```java
public interface Duravel {
    int getDuracao();
}
```

```java
public interface Autoravel {
    String getAutor();
}
```

- Classes Formularios

```java
import javax.swing.*;
import java.util.function.Consumer;
import java.awt.*;


public abstract class FormularioBase extends JPanel {
    protected JTextField txtTitulo;
    protected JTextField txtAno;
    protected ControleBiblioteca controle;
    protected Consumer<Void> onItemAdded;

    public FormularioBase(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        this.controle = controle;
        this.onItemAdded = onItemAdded;
        setLayout(new GridLayout(0, 2, 5, 5));
        criarCamposBasicos();
    }

    protected void criarCamposBasicos() {
        txtTitulo = new JTextField();
        txtAno = new JTextField();

        add(new JLabel("Título:"));
        add(txtTitulo);
        add(new JLabel("Ano:"));
        add(txtAno);
    }

    protected boolean validarCamposBasicos() {
        return !txtTitulo.getText().trim().isEmpty() &&
                !txtAno.getText().trim().isEmpty();
    }

    protected abstract void limparCampos();
    protected abstract ItemBibliografico criarItem();
}

```

```java

import javax.swing.*;
import java.util.function.Consumer;

public class FormularioLivro extends FormularioBase {
    private JTextField txtAutor;
    private JTextField txtEditora;

    public FormularioLivro(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        super(controle, onItemAdded);

        txtAutor = new JTextField();
        txtEditora = new JTextField();

        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Editora:"));
        add(txtEditora);

        JButton btnAdicionar = new JButton("Adicionar Livro");
        btnAdicionar.addActionListener(e -> adicionarLivro());
        add(btnAdicionar);
    }

    private void adicionarLivro() {
        if (!validarCamposBasicos() || txtAutor.getText().trim().isEmpty() ||
                txtEditora.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            ItemBibliografico livro = criarItem();
            controle.adicionarItem(livro);
            limparCampos();
            onItemAdded.accept(null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano deve ser um número!");
        }
    }

    @Override
    protected void limparCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtEditora.setText("");
        txtAno.setText("");
    }

    @Override
    protected ItemBibliografico criarItem() {
        return new Livro(
                txtTitulo.getText().trim(),
                txtEditora.getText().trim(),
                Integer.parseInt(txtAno.getText().trim()),
                txtAutor.getText().trim()
        );
    }
}

```

```java

import javax.swing.*;
import java.util.function.Consumer;

public class FormularioRevista extends FormularioBase {
private JTextField txtOrganizador;
private JTextField txtVolume;
private JTextField txtNumero;
private JTextField txtIssn;

    public FormularioRevista(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        super(controle, onItemAdded);

        txtOrganizador = new JTextField();
        txtVolume = new JTextField();
        txtNumero = new JTextField();
        txtIssn = new JTextField();

        add(new JLabel("Organizador:"));
        add(txtOrganizador);
        add(new JLabel("Volume:"));
        add(txtVolume);
        add(new JLabel("Número:"));
        add(txtNumero);
        add(new JLabel("ISSN:"));
        add(txtIssn);

        JButton btnAdicionar = new JButton("Adicionar Revista");
        btnAdicionar.addActionListener(e -> adicionarRevista());
        add(btnAdicionar);
    }

    private void adicionarRevista() {
        if (!validarCamposBasicos() || txtOrganizador.getText().trim().isEmpty() ||
                txtVolume.getText().trim().isEmpty() || txtNumero.getText().trim().isEmpty() ||
                txtIssn.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            ItemBibliografico revista = criarItem();
            controle.adicionarItem(revista);
            limparCampos();
            onItemAdded.accept(null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano, volume e número devem ser números!");
        }
    }

    @Override
    protected void limparCampos() {
        txtTitulo.setText("");
        txtOrganizador.setText("");
        txtVolume.setText("");
        txtNumero.setText("");
        txtIssn.setText("");
        txtAno.setText("");
    }

    @Override
    protected ItemBibliografico criarItem() {
        return new Revista(
                txtTitulo.getText().trim(),
                Integer.parseInt(txtAno.getText().trim()),
                txtIssn.getText().trim(),
                Integer.parseInt(txtNumero.getText().trim()),
                txtOrganizador.getText().trim(),
                Integer.parseInt(txtVolume.getText().trim())
        );
    }
}
```

```java

import javax.swing.*;
import java.util.function.Consumer;

public class FormularioVideo extends FormularioBase {
    private JTextField txtAutor;
    private JTextField txtDuracao;

    public FormularioVideo(ControleBiblioteca controle, Consumer<Void> onItemAdded) {
        super(controle, onItemAdded);

        txtAutor = new JTextField();
        txtDuracao = new JTextField();

        add(new JLabel("Autor:"));
        add(txtAutor);
        add(new JLabel("Duração (min):"));
        add(txtDuracao);

        JButton btnAdicionar = new JButton("Adicionar Vídeo");
        btnAdicionar.addActionListener(e -> adicionarVideo());
        add(btnAdicionar);
    }

    private void adicionarVideo() {
        if (!validarCamposBasicos() || txtAutor.getText().trim().isEmpty() ||
                txtDuracao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        try {
            ItemBibliografico video = criarItem();
            controle.adicionarItem(video);
            limparCampos();
            onItemAdded.accept(null);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ano e duração devem ser números!");
        }
    }

    @Override
    protected void limparCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAno.setText("");
        txtDuracao.setText("");
    }

    @Override
    protected ItemBibliografico criarItem() {
        return new Video(
                txtTitulo.getText().trim(),
                Integer.parseInt(txtAno.getText().trim()),
                txtAutor.getText().trim(),
                Integer.parseInt(txtDuracao.getText().trim())
        );
    }
}


```

- Classes Bases

```java
public abstract class ItemBibliografico {
    protected String titulo;
    protected int ano;

    public ItemBibliografico(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public abstract String getInfo();
    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
}
```

```java

public class Livro extends ItemBibliografico implements Autoravel {
    private String autor;
    private String editora;

    public Livro(String titulo, String editora, int ano, String autor) {
        super(titulo, ano);
        this.editora = editora;
        this.autor = autor;
    }

    @Override
    public String getInfo() {
        return String.format("Livro: %s\nAutor: %s\nEditora: %s\nAno: %d",
                titulo, autor, editora, ano);
    }

    @Override
    public String getAutor() {
        return autor;
    }
}

```

```java

public class Revista extends ItemBibliografico {
    private String issn;
    private int numero;
    private String organizador;
    private int volume;

    public Revista(String titulo, int ano, String issn, int numero,
                   String organizador, int volume) {
        super(titulo, ano);
        this.issn = issn;
        this.numero = numero;
        this.organizador = organizador;
        this.volume = volume;
    }

    @Override
    public String getInfo() {
        return String.format("Revista: %s\nOrg.: %s\nVol.: %d\nNro.: %d\nAno: %d",
                titulo, organizador, volume, numero, ano);
    }

    public String getOrganizador() { return organizador; }
    public int getVolume() { return volume; }
    public int getNumero() { return numero; }
}

```

```java

public class Video extends ItemBibliografico implements Autoravel, Duravel {
    private String autor;
    private int duracao; // em minutos

    public Video(String titulo, int ano, String autor, int duracao) {
        super(titulo, ano);
        this.autor = autor;
        this.duracao = duracao;
    }

    @Override
    public String getInfo() {
        return String.format("Vídeo: %s\nAutor: %s\nDuração: %d min\nAno: %d",
                titulo, autor, duracao, ano);
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public int getDuracao() {
        return duracao;
    }
}

```

- Classe ControleBiblioteca

```java

import java.util.ArrayList;
import java.util.List;

public class ControleBiblioteca {
    private List<ItemBibliografico> itens;

    public ControleBiblioteca() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemBibliografico item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public List<ItemBibliografico> listarItens() {
        return new ArrayList<>(itens);
    }
}

```

- Classe responsavel pela GUI

```java

import javax.swing.*;
import java.awt.*;

public class BibliotecaGUI {
    private ControleBiblioteca controle;
    private JFrame frameMain;
    private JTextArea areaListagem;

    public BibliotecaGUI() {
        controle = new ControleBiblioteca();
        criarInterfacePrincipal();
    }

    private void criarInterfacePrincipal() {
        frameMain = new JFrame("Biblioteca");
        frameMain.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Livros", new FormularioLivro(controle, v -> atualizarListagem()));
        tabbedPane.addTab("Revistas", new FormularioRevista(controle, v -> atualizarListagem()));
        tabbedPane.addTab("Vídeos", new FormularioVideo(controle, v -> atualizarListagem()));

        frameMain.add(tabbedPane, BorderLayout.WEST);

        areaListagem = new JTextArea(20, 40);
        areaListagem.setEditable(false);
        frameMain.add(new JScrollPane(areaListagem), BorderLayout.CENTER);

        frameMain.pack();
        frameMain.setLocationRelativeTo(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setVisible(true);

        atualizarListagem();
    }

    private void atualizarListagem() {
        StringBuilder sb = new StringBuilder("=== ITENS BIBLIOGRÁFICOS ===\n\n");

        for (ItemBibliografico item : controle.listarItens()) {
            sb.append(item.getInfo()).append("\n\n");
        }

        areaListagem.setText(sb.toString());
    }

    public static void main(String[] args) {
        new BibliotecaGUI();
    }
}
```

</span>
