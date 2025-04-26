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
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author BrunoPortugal
 */



// Classe que representa uma mensagem de aviso estilizada
public class MensagemDeAviso implements Mensagem {

    JFrame frame;

    @Override
    public void render() {
        // Configurações iniciais da janela
        frame = new JFrame("Aviso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setUndecorated(true); // Remove a barra padrão da janela

        // Painel principal com bordas arredondadas
        JPanel mainPanel = new RoundedPanel(30);
        mainPanel.setBackground(new Color(255, 250, 205));
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Painel interno que organiza o conteúdo em coluna
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255, 250, 205));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Ícone de aviso
        JLabel iconLabel = new JLabel(new ImageIcon("src/main/java/icon/aviso.png"));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título da mensagem
        JLabel titleLabel = new JLabel("Aviso!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(255, 165, 0));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Descrição do aviso
        JLabel descriptionLabel = new JLabel("Verifique suas informações antes de continuar.");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setForeground(new Color(184, 134, 11));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando componentes ao painel de conteúdo
        contentPanel.add(iconLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(descriptionLabel);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Botão de confirmação
        JButton gotItButton = new JButton("Entendi");
        gotItButton.setBackground(new Color(255, 140, 0));
        gotItButton.setForeground(Color.WHITE);
        gotItButton.setFont(new Font("Arial", Font.BOLD, 16));
        gotItButton.setFocusPainted(false);
        gotItButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Efeito hover no botão
        gotItButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                gotItButton.setBackground(new Color(255, 165, 0));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                gotItButton.setBackground(new Color(255, 140, 0));
            }
        });

        // Ação do botão: fechar a janela
        gotItButton.addActionListener(e -> frame.dispose());

        // Painel do botão
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 250, 205));
        buttonPanel.add(gotItButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adicionando painel principal à janela
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setVisible(true);
    }

    @Override
    public void onClick() {
        // A ação do clique já está configurada no botão
    }
}
