/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mensagem_factorymethod;

import fabrica.MensagemDeAvisoDialog;
import fabrica.MensagemDeErroDialog;
import fabrica.MensagemDeSucessoDialog;
import fabrica.MensagemDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author BrunoPortugal
 */
// Classe principal usando o padrão Factory Method para exibir mensagens
public class Mensagem_FactoryMethod {

    private static MensagemDialog dialog;
    private static JFrame frame;

    public static void main(String[] args) {
        criarTelaPrincipal();
    }

    // Cria a tela principal estilizada
    private static void criarTelaPrincipal() {
        frame = new JFrame("Escolher Tipo de Mensagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setUndecorated(true); // Remove barra de título

        // Painel principal com bordas arredondadas
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(239, 244, 243));
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titleLabel = new JLabel("Escolha um tipo de mensagem:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(130, 135, 134));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(239, 244, 243));
        buttonPanel.setLayout(new GridLayout(0, 3, 15, 0)); 

        // Botão Sucesso
        JButton sucessoButton = criarBotao("Sucesso", new Color(50, 205, 50));
        sucessoButton.addActionListener(e -> selecionarMensagem(new MensagemDeSucessoDialog()));

        // Botão Erro
        JButton erroButton = criarBotao("Erro", new Color(220, 20, 60));
        erroButton.addActionListener(e -> selecionarMensagem(new MensagemDeErroDialog()));

        // Botão Aviso
        JButton avisoButton = criarBotao("Aviso", new Color(255, 165, 0));
        avisoButton.addActionListener(e -> selecionarMensagem(new MensagemDeAvisoDialog()));

        buttonPanel.add(sucessoButton);
        buttonPanel.add(erroButton);
        buttonPanel.add(avisoButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Botão de fechar no rodapé
        JButton fecharButton = criarBotao("Fechar", new Color(105, 105, 105));
        fecharButton.addActionListener(e -> frame.dispose());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(240, 248, 255));
        bottomPanel.add(fecharButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Centraliza
        frame.setVisible(true);
    }

    // Método para criar botões padronizados
    private static JButton criarBotao(String texto, Color corFundo) {
        JButton button = new JButton(texto);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(corFundo);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efeito hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(corFundo.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(corFundo);
            }
        });

        return button;
    }

    // Método para selecionar e mostrar a mensagem
    private static void selecionarMensagem(MensagemDialog mensagemDialog) {
        dialog = mensagemDialog;
        frame.dispose(); // Fecha a tela principal
        run(); // Exibe a mensagem escolhida
    }

    // Executa o método para mostrar a mensagem
    static void run() {
        dialog.showMessage();
    }
}
