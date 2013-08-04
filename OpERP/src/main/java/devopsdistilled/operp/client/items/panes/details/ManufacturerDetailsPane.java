package devopsdistilled.operp.client.items.panes.details;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.items.controllers.ManufacturerController;
import devopsdistilled.operp.server.data.entity.items.Manufacturer;

public class ManufacturerDetailsPane extends
		AbstractEntityDetailsPane<Manufacturer> {

	@Inject
	private ManufacturerController manufacturerController;

	private Manufacturer manufacturer;

	private final JPanel pane;
	private final JTextField manufacturerIdField;
	private final JTextField manufacturerNameField;

	public ManufacturerDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		JLabel lblManufacturerId = new JLabel("Manufacturer ID");
		pane.add(lblManufacturerId, "cell 0 0,alignx trailing");

		manufacturerIdField = new JTextField();
		pane.add(manufacturerIdField, "cell 1 0,growx");
		manufacturerIdField.setColumns(10);

		JLabel lblManufacturerName = new JLabel("Manufacturer Name");
		pane.add(lblManufacturerName, "cell 0 1,alignx trailing");

		manufacturerNameField = new JTextField();
		pane.add(manufacturerNameField, "cell 1 1,growx");
		manufacturerNameField.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
				if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
						getPane(),
						"Delete Manufactuer: "
								+ manufacturer.getManufacturerName() + " ?",
						"Delete Manufacturer", JOptionPane.YES_NO_OPTION)) {

					getDialog().dispose();
					manufacturerController.delete(manufacturer);
				}
			}
		});
		pane.add(btnDelete, "flowx,cell 1 3");

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		pane.add(btnEdit, "cell 1 3");

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnOk, "cell 1 3");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	@Override
	public void show(Manufacturer manufacturer) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle() {
		return "Manufacturer Details";
	}

}
