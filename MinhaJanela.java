import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MinhaJanela extends JFrame {
    private List<String> selecoes = new ArrayList<>();
    private JLabel todasSelecoesLabel;
    private JLabel selectionLabel;

    public MinhaJanela() {
        setTitle("Sistema de Cantina");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuEditar = new JMenu("Editar");
        menuArquivo.add(new JMenuItem("Novo"));
        menuArquivo.add(new JMenuItem("Abrir"));
        menuArquivo.add(new JMenuItem("Salvar"));
        menuArquivo.addSeparator();
        menuArquivo.add(new JMenuItem("Sair"));
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        setJMenuBar(menuBar);

        todasSelecoesLabel = new JLabel("Você selecionou: ", JLabel.CENTER);
        selectionLabel = new JLabel("Selecione uma comida.", JLabel.CENTER);
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        addButton(buttonPanel, "Sanduíche");
        addButton(buttonPanel, "Pizza");
        addButton(buttonPanel, "Salgado");
        addButton(buttonPanel, "Salada");
        addButton(buttonPanel, "Suco");
        addButton(buttonPanel, "Sobremesa");

        JButton finalizarPedidoButton = new JButton("Finalizar Pedido");
        finalizarPedidoButton.addActionListener(e -> {
            selectionLabel.setText("Pedido finalizado! Obrigado.");
            todasSelecoesLabel.setText("Pedido feito!");
        });

        JPanel finalizarPanel = new JPanel(new BorderLayout());
        finalizarPanel.add(todasSelecoesLabel, BorderLayout.NORTH);
        finalizarPanel.add(finalizarPedidoButton, BorderLayout.SOUTH);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Bem-vindo à Cantina! Escolha sua comida abaixo.", JLabel.CENTER), BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(selectionLabel, BorderLayout.SOUTH);
        panel.add(finalizarPanel, BorderLayout.PAGE_END);

        add(panel);
    }

    private void addButton(JPanel panel, String text) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            selecoes.add(text);
            selectionLabel.setText("Você escolheu: " + text);
            todasSelecoesLabel.setText("Você selecionou: " + String.join(", ", selecoes));
        });
        panel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MinhaJanela janela = new MinhaJanela();
            janela.setVisible(true);
        });
    }
}
