package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController
{
    public KillController()
    {
        super();
    }

    private String os()
    {
        return System.getProperty("os.name");
    }

    public void listaProcessos()
    {
        String proc;
        if (os().contains("Windows"))
            proc = "TASKLIST /FO TABLE";
        else
            proc = "ps -ef";
        try {
            String[] procArr = proc.split(" ");
            Process p = Runtime.getRuntime().exec(procArr);
            InputStreamReader procOut = new InputStreamReader(p.getInputStream());
            BufferedReader buffer = new BufferedReader(procOut);
            String line = buffer.readLine();
            while (line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void mataPid(int pid)
    {
        String proc;
        if (os().contains("Windows"))
            // Usando /F pois o Windos não tava matando alguns processos sem essa flag
            proc = "TASKKILL /F /PID " + String.valueOf(pid);
        else
            proc = "kill -9 " + String.valueOf(pid);
        try {
            String[] procArr = proc.split(" ");
            Runtime.getRuntime().exec(procArr);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}