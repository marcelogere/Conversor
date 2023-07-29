package conversores;

public class ConversorMoneda {
    public static double convertirPesoADolar(double cantidad) {
        return cantidad * 0.017;
    }

    public static double convertirDolarAPeso(double cantidad) {
        return cantidad * 58.5;
    }

    public static double convertirPesoAEuros(double cantidad) {
        return cantidad * 0.015;
    }

    public static double convertirEuroAPeso(double cantidad) {
        return cantidad * 65.2;
    }

    public static double convertirPesoALibras(double cantidad) {
        return cantidad * 0.013;
    }

    public static double convertirLibraAPeso(double cantidad) {
        return cantidad * 75.8;
    }

    public static double convertirPesoAYen(double cantidad) {
        return cantidad * 1.84;
    }

    public static double convertirYenAPeso(double cantidad) {
        return cantidad * 0.54;
    }

    public static double convertirPesoAWon(double cantidad) {
        return cantidad * 19.3;
    }

    public static double convertirWonAPeso(double cantidad) {
        return cantidad * 0.051;
    }
}