/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import menssagem.Mensagem;
import menssagem.MensagemDeAviso;

/**
 *
 * @author BrunoPortugal
 */

public class MensagemDeAvisoDialog extends MensagemDialog {

    @Override
    public Mensagem createMessage() {
        return new MensagemDeAviso();
    }
}
