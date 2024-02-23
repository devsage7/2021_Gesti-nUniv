package Ejecución;

import Objetos.*;
import Estructuras.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class JavaGUI {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListaEnlazada lista = new ListaEnlazada();
                new MainJFrame().setVisible(true);
            }
        }
        );
    }

}
