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



// Classe que representa uma mensagem de sucesso profissional
public class MensagemDeSucesso implements Mensagem {

    JFrame frame;

    @Override
    public void render() {
        frame = new JFrame("Sucesso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setUndecorated(true); // Remove a borda padrão para personalizar

        // Painel principal com bordas arredondadas
        JPanel mainPanel = new RoundedPanel(30);
        mainPanel.setBackground(new Color(230, 255, 230));
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Painel para o conteúdo
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(230, 255, 230));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Ícone de sucesso
        JLabel iconLabel = new JLabel(new ImageIcon("src/main/java/icon/sucesso.png")); // Coloque o caminho do seu ícone aqui
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Texto principal
        JLabel titleLabel = new JLabel("Sucesso!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(34, 139, 34));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Texto de descrição
        JLabel descriptionLabel = new JLabel("Sua operação foi concluída com êxito.");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descriptionLabel.setForeground(new Color(0, 100, 0));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adiciona componentes no painel
        contentPanel.add(iconLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        contentPanel.add(descriptionLabel);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Botão de OK
        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(50, 205, 50));
        okButton.setForeground(Color.WHITE);
        okButton.setFont(new Font("Arial", Font.BOLD, 16));
        okButton.setFocusPainted(false);
        okButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Efeito hover no botão
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                okButton.setBackground(new Color(34, 139, 34));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                okButton.setBackground(new Color(50, 205, 50));
            }
        });

        okButton.addActionListener(e -> frame.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 255, 230));
        buttonPanel.add(okButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Centraliza na tela
        frame.setVisible(true);
    }

    @Override
    public void onClick() {
        // Não utilizado pois o botão já está integrado no render.
    }
}

// Classe para painel arredondado
class RoundedPanel extends JPanel {
    private int cornerRadius;

    public RoundedPanel(int radius) {
        super();
        this.cornerRadius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Pintar fundo arredondado
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcs.width, arcs.height);
        g2.setColor(getForeground());
    }
}
