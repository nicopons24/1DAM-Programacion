package delincuentes.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import delincuentes.controller.ControladorPrincipal;
import delincuentes.model.Delincuente;

public class PanelDelincuentes extends JPanel{
	
	private JTextField nombre, edad, sexo, nacionalidad, direccion, poblacion;
	private JList<Delincuente> listaDelincuentes;
	private DefaultListModel<Delincuente> modeloLista;
	private JPanel datosDelincuente;
	private JButton btnAntecedentes;

	public PanelDelincuentes() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		setName("delincuentes");
		
		colocaComponentes();
		
	}
	
	private void colocaComponentes() {
		Insets insets = new Insets(10, 10, 10, 10);
		
		listaDelincuentes = new JList<Delincuente>();
		modeloLista = new DefaultListModel<Delincuente>();
		listaDelincuentes.setModel(modeloLista);
		JScrollPane scroll = new JScrollPane(listaDelincuentes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_listaDelincuentes = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(scroll, gbc_listaDelincuentes);
		listaDelincuentes.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (listaDelincuentes.getSelectedIndex() != -1) {
					ControladorPrincipal.getInstance().muestraDatosDelincuente(listaDelincuentes.getSelectedValue());
				}
			}
		});
		
		datosDelincuente = new JPanel();
		GridBagConstraints gbc_datosDelincuente = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(datosDelincuente, gbc_datosDelincuente);
		GridBagLayout gbl_datosDelincuente = new GridBagLayout();
		datosDelincuente.setLayout(gbl_datosDelincuente);
		datosDelincuente.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints(0, 0, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(lblNombre, gbc_lblNombre);
		
		nombre = new JTextField();
		GridBagConstraints gbc_nombre = new GridBagConstraints(0, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(nombre, gbc_nombre);
		
		JLabel lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(lblEdad, gbc_lblEdad);
		
		edad = new JTextField();
		GridBagConstraints gbc_edad = new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(edad, gbc_edad);
		
		JLabel lblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(lblSexo, gbc_lblSexo);
		
		sexo = new JTextField();
		GridBagConstraints gbc_sexo = new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(sexo, gbc_sexo);
		
		JLabel lblNacionalida = new JLabel("Nacionalida");
		GridBagConstraints gbc_lblNacionalida = new GridBagConstraints(0, 4, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(lblNacionalida, gbc_lblNacionalida);
		
		nacionalidad = new JTextField();
		GridBagConstraints gbc_nacionalidad = new GridBagConstraints(0, 5, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(nacionalidad, gbc_nacionalidad);
		
		JLabel lblDireccion = new JLabel("Direccion");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints(0, 6, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(lblDireccion, gbc_lblDireccion);
		
		direccion = new JTextField();
		GridBagConstraints gbc_direccion = new GridBagConstraints(0, 7, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(direccion, gbc_direccion);
		
		JLabel lblPoblacion = new JLabel("Poblacion");
		GridBagConstraints gbc_lblPoblacion = new GridBagConstraints(0, 8, 2, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(lblPoblacion, gbc_lblPoblacion);
		
		poblacion = new JTextField();
		GridBagConstraints gbc_poblacion = new GridBagConstraints(0, 9, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		datosDelincuente.add(poblacion, gbc_poblacion);
		
		btnAntecedentes = new JButton("Antecedentes");
		GridBagConstraints gbc_btnAntecedentes = new GridBagConstraints(0, 10, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, insets, 0, 0);
		datosDelincuente.add(btnAntecedentes, gbc_btnAntecedentes);
		btnAntecedentes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().mostrarAntecedentes();				
			}
		});
	}

	public void cargaDelincuentes(ArrayList<Delincuente> delincuentes) {
		for (int i = 0; i < delincuentes.size(); i++) {
			modeloLista.addElement(delincuentes.get(i));
		}
	}
	
	public void datosDelincuente(Delincuente d) {
		nombre.setText(d.getNombre());
		edad.setText(""+d.getEdad());
		sexo.setText(d.getSexo());
		nacionalidad.setText(d.getNacionalidad());
		direccion.setText(d.getDireccion());
		poblacion.setText(d.getPoblacion());
		datosDelincuente.setVisible(true);
	}

	public JList<Delincuente> getListaDelincuentes() {
		return listaDelincuentes;
	}

	public DefaultListModel<Delincuente> getModeloLista() {
		return modeloLista;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getEdad() {
		return edad;
	}

	public JTextField getSexo() {
		return sexo;
	}

	public JTextField getNacionalidad() {
		return nacionalidad;
	}

	public JTextField getDireccion() {
		return direccion;
	}

	public JTextField getPoblacion() {
		return poblacion;
	}
}
