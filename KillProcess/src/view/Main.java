package view;

import controller.*;
import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args)
    {
        KillController kill = new KillController();
        int opc = 0, pid;
        String nome = "";
        do {
            opc = menu();
            if (opc == 0)
                kill.listaProcessos();
            else if (opc == 1) {
                pid = Integer.parseInt(JOptionPane.showInputDialog("Insira o número do Pid"));
                kill.mataPid(pid);
            } else if (opc == 2)
                nome = JOptionPane.showInputDialog("Informe o nome do processo");
                kill.mataNome(nome);
        } while (opc != 3); 
    }

    public static int menu()
    {
        String[] opcs = {"Listar Processos", "Matar por Pid", "Matar por Nome", "Sair"};
        return JOptionPane.showOptionDialog(
            null, "Selecione a opção desejada", "Processos",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
            opcs, opcs[2]);
    }
}