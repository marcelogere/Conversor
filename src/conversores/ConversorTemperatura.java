package conversores;

public class ConversorTemperatura {
    // Método para convertir Celsius a Fahrenheit
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Método para convertir Celsius a Kelvin
    public static double convertirCelsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Método para convertir Fahrenheit a Celsius
    public static double convertirFahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Método para convertir Fahrenheit a Kelvin
    public static double convertirFahrenheitAKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9;
    }

    // Método para convertir Kelvin a Celsius
    public static double convertirKelvinACelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Método para convertir Kelvin a Fahrenheit
    public static double convertirKelvinAFahrenheit(double kelvin) {
        return (kelvin * 9 / 5) - 459.67;
    }
}
