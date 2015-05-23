package delincuentes.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextArea;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import delincuentes.controller.ControladorPrincipal;
import delincuentes.model.Delincuente;

public class PanelAntecedentes extends JPanel{
	
	private JTextArea textArea;
	private JButton btnSalvar;
	
	public PanelAntecedentes() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);
		setName("antecedentes");
		
		colocaComponentes();
		
	}
	
	private void colocaComponentes() {
		
		Insets insets = new Insets(10, 10, 10, 10);
		
		JLabel lblAntecedentes = new JLabel("Antecedentes");
		GridBagConstraints gbc_lblAntecedentes = new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
		add(lblAntecedentes, gbc_lblAntecedentes);
		
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_textArea = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(scroll, gbc_textArea);
		
		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
		add(btnSalvar, gbc_btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorPrincipal.getInstance().actualizarDelincuente(ControladorPrincipal.getInstance().getvPrincipal().getPanelDelincuentes().getListaDelincuentes().getSelectedIndex());
			}
		});
	}
	
	public void datosDelincuente(Delincuente d) {
		textArea.setText(d.getAntecedentes());
	}

	public JTextArea getTextArea() {
		return textArea;
	}

}
