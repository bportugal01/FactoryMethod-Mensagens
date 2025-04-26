/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menssagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author BrunoPortugal
 */



// Classe que representa uma mensagem de erro estilizada
public class MensagemDeErro implements Mensagem {

    JFrame frame;

    @Override
    public void render() {
        // Configurações iniciais da janela
        frame = new JFrame("Erro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setUndecorated(true); // Remove a barra padrão da janela

        // Painel principal com bordas arredondadas
        JPanel mainPanel = new RoundedPanel(30);
        mainPanel.setBackground(new Color(255, 220, 220));
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Painel interno que organiza o conteúdo em coluna
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255, 220, 220));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Ícone de erro
        JLabel iconLabel = new JLabel(new ImageIcon("src/main/java/icon/erro.png"));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título da mensagem
        JLabel titleLabel = new JLabel("Erro!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(178, 34, 34));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Descrição do erro
        JLabel descriptionLabel = new JLabel("Ocorreu um problema durante a operação.");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setForeground(new Color(139, 0, 0));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando componentes ao painel de conteúdo
        contentPanel.add(iconLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(descriptionLabel);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Botão de fechar
        JButton dismissButton = new JButton("Fechar");
        dismissButton.setBackground(new Color(220, 20, 60));
        dismissButton.setForeground(Color.WHITE);
        dismissButton.setFont(new Font("Arial", Font.BOLD, 16));
        dismissButton.setFocusPainted(false);
        dismissButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Efeito hover no botão
        dismissButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                dismissButton.setBackground(new Color(178, 34, 34));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                dismissButton.setBackground(new Color(220, 20, 60));
            }
        });

        // Ação do botão: fechar a janela
        dismissButton.addActionListener(e -> frame.dispose());

        // Painel do botão
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 220, 220));
        buttonPanel.add(dismissButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adicionando painel principal à janela
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true);
    }

    @Override
    public void onClick() {
        // A ação do clique já está configurada no botão
    }
}
