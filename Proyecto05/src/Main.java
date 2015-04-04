import java.awt.Dimension;
import java.awt.Toolkit;

import proyecto05.gui.VentanaPrincipal;


public class Main {

	public static void main(String[] args) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();// Obtener el tamaño de la pantalla
		//Iniciar aplicacion
		VentanaPrincipal vp = new VentanaPrincipal(d);
	}

}
