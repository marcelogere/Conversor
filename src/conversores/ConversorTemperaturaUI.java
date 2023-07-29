package conversores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorTemperaturaUI {
    private static JFrame frame;
    private static JComboBox<String> comboBox;
    private static JTextField textField;
    private static JLabel resultadoLabel;

    /**
     * @wbp.parser.entryPoint
     */
    public static void mostrarVentana() {
        // Crear la ventana del conversor de temperaturas
        frame = new JFrame("Conversor de Temperatura");
        frame.getContentPane().setBackground(new Color(128, 128, 255));
        //frame.setLocationRelativeTo(null);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setVisible(true);

        // Crear el JComboBox para seleccionar la conversión
        String[] conversiones = {
                "Celsius a Fahrenheit",
                "Celsius a Kelvin",
                "Fahrenheit a Celsius",
                "Fahrenheit a Kelvin",
                "Kelvin a Celsius",
                "Kelvin a Fahrenheit"
        };

        // Utilizar GridBagLayout para centrar los componentes
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 36, 0, 0, 0};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        frame.getContentPane().setLayout(gridBagLayout);
        comboBox = new JComboBox<>(conversiones);
        
        GridBagConstraints gbcCombo = new GridBagConstraints();
        gbcCombo.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        
        // Colocar el JComboBox en el centro vertical y horizontalmente
        gbcCombo.gridx = 1;
        gbcCombo.gridy = 0;
        gbcCombo.fill = GridBagConstraints.HORIZONTAL;
        frame.getContentPane().add(comboBox, gbcCombo);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset the resultadoLabel when a new option is selected
                resultadoLabel.setText("");
            }
        });

        // Crear el JTextField para ingresar la temperatura a convertir
        textField = new JTextField(10);
        textField.setFont(new Font("Tahoma", Font.BOLD, 14));
        
                
        GridBagConstraints gbcField = new GridBagConstraints();
        gbcField.gridx = 1;
        gbcField.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        // Colocar el valor a convertir en el centro vertical y horizontalmente
        gbcField.gridy = 1;
        frame.getContentPane().add(textField, gbcField);

        // Crear el botón para realizar la conversión
        JButton button = new JButton("Convertir");
        
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 1;
        gbcButton.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        // Colocar el botón en el centro vertical y horizontalmente
        gbcButton.gridy = 2;
        frame.getContentPane().add(button, gbcButton);
        
        // Manejar el evento de clic del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirTemperatura();
            }
        });
        
        // Crear el JLabel para mostrar el resultado
        resultadoLabel = new JLabel();
        resultadoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        resultadoLabel.setForeground(new Color(255, 255, 255));
        
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 1;
        gbcLabel.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        // Colocar el resultado en el centro vertical y horizontalmente
        gbcLabel.gridy = 3;
        frame.getContentPane().add(resultadoLabel, gbcLabel);
        
        // Crear el botón para volver a la ventana principal
        JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        // Utilizar GridBagConstraints para posicionar el botón de volver
        GridBagConstraints gbcVolverButton = new GridBagConstraints();
        gbcVolverButton.anchor = GridBagConstraints.WEST;
        gbcVolverButton.gridx = 1;
        gbcVolverButton.insets = new Insets(5, 5, 5, 5); // Agregar espaciado
        gbcVolverButton.gridy = 6;
        frame.getContentPane().add(volverButton, gbcVolverButton);
        
        // Manejar el evento de clic del botón "Volver"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.main(conversiones);
            }
        });

        // Mostrar la ventana del conversor de temperaturas
        frame.setVisible(true);
    }

    /**
     * @wbp.parser.entryPoint
     */
    private static void convertirTemperatura() {
        String seleccion = (String) comboBox.getSelectedItem();
        double temperatura = Double.parseDouble(textField.getText());

        // Realizar la conversión de acuerdo a la selección
        String resultado = "";

        if (seleccion.equals("Celsius a Fahrenheit")) {
            resultado = "°F " + ConversorTemperatura.convertirCelsiusAFahrenheit(temperatura);
        } else if (seleccion.equals("Celsius a Kelvin")) {
            resultado = "°K " + ConversorTemperatura.convertirCelsiusAKelvin(temperatura);
        } else if (seleccion.equals("Fahrenheit a Celsius")) {
            resultado = "°C " + ConversorTemperatura.convertirFahrenheitACelsius(temperatura);
        } else if (seleccion.equals("Fahrenheit a Kelvin")) {
            resultado = "°C " + ConversorTemperatura.convertirFahrenheitAKelvin(temperatura);
        } else if (seleccion.equals("Kelvin a Celsius")) {
            resultado = "°C " + ConversorTemperatura.convertirKelvinACelsius(temperatura);
        } else if (seleccion.equals("Kelvin a Fahrenheit")) {
            resultado = "°C " + ConversorTemperatura.convertirKelvinAFahrenheit(temperatura);
        }

        resultadoLabel.setText("Resultado: " + resultado);
    }
}
