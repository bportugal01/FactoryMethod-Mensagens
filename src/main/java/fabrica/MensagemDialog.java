/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import menssagem.Mensagem;

/**
 *
 * @author BrunoPortugal
 */

public abstract class MensagemDialog {

    public void showMessage() {
        Mensagem mensagem = createMessage();
        mensagem.render();
    }

    public abstract Mensagem createMessage();
}
