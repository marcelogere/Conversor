package conversores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Conversores");
        frame.getContentPane().setBackground(new Color(128, 128, 255));
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el JComboBox para seleccionar el conversor
        String[] conversores = {"Elije un Conversor", "Conversor de Moneda", "Conversor de Temperatura"};

        // Utilizar GridBagLayout para centrar los componentes
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
        gridBagLayout.rowHeights = new int[]{0, 30, 0};
        frame.getContentPane().setLayout(gridBagLayout);
        
        JComboBox<String> comboBox = new JComboBox<>(conversores);
        GridBagConstraints gbcCombo = new GridBagConstraints();
        gbcCombo.insets = new Insets(5, 5, 5, 0); // Agregar espaciado
        
        // Colocar el JComboBox en el centro vertical y horizontalmente
        gbcCombo.gridx = 1;
        gbcCombo.gridy = 0;
        gbcCombo.fill = GridBagConstraints.HORIZONTAL;
        frame.getContentPane().add(comboBox, gbcCombo);
                                                                                                        
        // Crear el botón para confirmar la selección
        JButton button = new JButton("Seleccionar");
        
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 1;
        gbcButton.insets = new Insets(5, 5, 0, 0); // Agregar espaciado
        // Colocar el botón en el centro vertical y horizontalmente
        gbcButton.gridy = 2;
        frame.getContentPane().add(button, gbcButton);

        // Manejar el evento de selección del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) comboBox.getSelectedItem();
                if (seleccion.equals("Conversor de Moneda")) {
                    ConversorMonedaUI.mostrarVentana();
                } else if (seleccion.equals("Conversor de Temperatura")) {
                    ConversorTemperaturaUI.mostrarVentana();
                }
                frame.dispose();
            }
        });

        // Mostrar la ventana principal
        frame.setVisible(true);
    }
}
