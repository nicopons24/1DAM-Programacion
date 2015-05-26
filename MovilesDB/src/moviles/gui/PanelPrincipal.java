package moviles.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {
	
	private JLabel label;
	private ImageIcon icon;
	
	public PanelPrincipal() {
	
		setName("principal");
		setLayout(new GridBagLayout());
		
		colocaComponentes();
		
	}
	
	private void colocaComponentes() {
		
		icon = new ImageIcon(getClass().getResource("/moviles/image/logo.png"));
		
		Insets insets = new Insets(10, 10, 10, 10);
		
		label = new JLabel(icon);
		GridBagConstraints gbc_label = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
		add(label, gbc_label);
		
	}

}
