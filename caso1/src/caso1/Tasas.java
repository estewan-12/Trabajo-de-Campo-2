package caso1;

public class Tasas {
	private static double TasaInteres = 4.5; 

    public static void actualizarTasaInteres(double nuevaTasa) {
        TasaInteres = nuevaTasa;
    }

    public static double mostrarTasaInteres() {
        return TasaInteres;
    }
}
