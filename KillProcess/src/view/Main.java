package view;

import controller.*;
import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args)
    {
        KillController kill = new KillController();
        int opc = 0, pid;
        String nome = null;
        do {
            opc = menu();
            if (opc == 0)
                kill.listaProcessos();
            else if (opc == 1) {
                nome = lerNumero();
                if (nome == null)
                    continue;
                pid = Integer.parseInt(nome);                                
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

    public static String lerNumero()
    {
        String num = null;
        while (true)
        {
            try {
                num = JOptionPane.showInputDialog("Informe o número do pid");
                if (num == null)
                    return null;
                Integer.parseInt(num);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido, tente novamente");
                continue;
            }
        }
        return num;
    }
}