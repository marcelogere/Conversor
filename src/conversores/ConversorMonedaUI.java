package conversores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorMonedaUI {
    private static JFrame frame;
    private static JComboBox<String> comboBox;
    private static JTextField textField;
    private static JLabel resultadoLabel;

    /**
     * @wbp.parser.entryPoint
     */
    public static void mostrarVentana() {
        // Crear la ventana del conversor de moneda
    	frame = new JFrame("Conversor de Moneda");
    	frame.getContentPane().setBackground(new Color(128, 128, 255));
        //frame.setLocationRelativeTo(null);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setVisible(true);

        // Crear el JComboBox para seleccionar la conversión
        String[] conversiones = {
                "Peso Argentino a Dólar",
                "Peso Argentino a Euros",
                "Peso Argentino a Libras Esterlinas",
                "Peso Argentino a Yen Japonés",
                "Peso Argentino a Won sul-coreano",
                "Dólar a Peso Argentino",
                "Euros a Peso Argentino",
                "Libras Esterlinas a Peso Argentino",
                "Yen Japonés a Peso Argentino",
                "Won sul-coreano a Peso Argentino"
        };
        
        // Utilizar GridBagLayout para centrar los componentes
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 36, 0, 0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
        gridBagLayout.columnWidths = new int[]{0, 10, 0};
        frame.getContentPane().setLayout(gridBagLayout);
        comboBox = new JComboBox<>(conversiones);
        
        GridBagConstraints gbcCombo = new GridBagConstraints();
        gbcCombo.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        
        // Colocar el JComboBox en el centro vertical y horizontalmente
        gbcCombo.gridx = 1;
        gbcCombo.gridy = 1;
        gbcCombo.fill = GridBagConstraints.HORIZONTAL;
        frame.getContentPane().add(comboBox, gbcCombo);
        
        // Manejar el evento de seleccion de opcion del comboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the resultadoLabel when a new option is selected
                resultadoLabel.setText("");
            }
        });
        
        // Crear el JTextField para ingresar la cantidad a convertir
        textField = new JTextField(10);
        textField.setFont(new Font("Tahoma", Font.BOLD, 14));
        
                
        GridBagConstraints gbctxtField = new GridBagConstraints();
        gbctxtField.gridx = 1;
        gbctxtField.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        // Colocar el valor a convertir en el centro vertical y horizontalmente
        gbctxtField.gridy = 2;
        frame.getContentPane().add(textField, gbctxtField);
        
        // Crear el botón para realizar la conversión
        JButton button = new JButton("Convertir");
        
        
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 1;
        gbcButton.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        // Colocar el botón en el centro vertical y horizontalmente
        gbcButton.gridy = 3;
        frame.getContentPane().add(button, gbcButton);
        
        // Manejar el evento de clic del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirMoneda();
            }
        });
        
	    // Crear el JLabel para mostrar el resultado
	    resultadoLabel = new JLabel();
	    resultadoLabel.setForeground(new Color(255, 255, 255));
	    resultadoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        
         
		 GridBagConstraints gbcResult = new GridBagConstraints();
		 gbcResult.gridx = 1;
		 gbcResult.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
		 // Colocar el resultado en el centro vertical y horizontalmente
		 gbcResult.gridy = 4;
		 frame.getContentPane().add(resultadoLabel, gbcResult);
                                                
        // Crear el botón para volver a la ventana principal
        JButton volverButton = new JButton("Volver");
        
        // Utilizar GridBagConstraints para posicionar el botón de volver
        GridBagConstraints gbcVolverButton = new GridBagConstraints();
        gbcVolverButton.anchor = GridBagConstraints.WEST;
        gbcVolverButton.gridx = 1;
        gbcVolverButton.insets = new Insets(5, 5, 0, 5); // Agregar espaciado
        gbcVolverButton.gridy = 6;
        frame.getContentPane().add(volverButton, gbcVolverButton);
        
        // Manejar el evento de clic del botón "Volver"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.main(conversiones);
            }
        });

        // Mostrar la ventana del conversor de moneda
        frame.setVisible(true);
    }

    /**
     * @wbp.parser.entryPoint
     */
    private static void convertirMoneda() {
        String seleccion = (String) comboBox.getSelectedItem();
        double cantidad = Double.parseDouble(textField.getText());

        // Realizar la conversión de acuerdo a la selección
        String resultado = "";

        if (seleccion.equals("Peso Argentino a Dólar")) {
            resultado = "U$S " + ConversorMoneda.convertirPesoADolar(cantidad);
        } else if (seleccion.equals("Peso Argentino a Euros")) {
            resultado = "€ " + ConversorMoneda.convertirPesoAEuros(cantidad);
        } else if (seleccion.equals("Peso Argentino a Libras Esterlinas")) {
            resultado = "£ " + ConversorMoneda.convertirPesoALibras(cantidad);
        } else if (seleccion.equals("Peso Argentino a Yen Japonés")) {
            resultado = "¥ " + ConversorMoneda.convertirPesoAYen(cantidad);
        } else if (seleccion.equals("Peso Argentino a Won sul-coreano")) {
            resultado = "₩ " + ConversorMoneda.convertirPesoAWon(cantidad);
        } else if (seleccion.equals("Dólar a Peso Argentino")) {
            resultado = "$ " + ConversorMoneda.convertirDolarAPeso(cantidad);
        } else if (seleccion.equals("Euros a Peso Argentino")) {
            resultado = "$ " + ConversorMoneda.convertirEuroAPeso(cantidad);
        } else if (seleccion.equals("Libras Esterlinas a Peso Argentino")) {
            resultado = "$ " + ConversorMoneda.convertirLibraAPeso(cantidad);
        } else if (seleccion.equals("Yen Japonés a Peso Argentino")) {
            resultado = "$ " + ConversorMoneda.convertirYenAPeso(cantidad);
        } else if (seleccion.equals("Won sul-coreano a Peso Argentino")) {
            resultado = "$ " + ConversorMoneda.convertirWonAPeso(cantidad);
        }

        resultadoLabel.setText("Resultado: " + resultado);
    }
}