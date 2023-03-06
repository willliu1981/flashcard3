package idv.kuan.flashcard3.view.fc3component.impl;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import idv.kuan.flashcard3.view.fc3component.CardPanelComponentFactory;
import idv.kuan.flashcard3.view.fc3component.FCComponent;
import idv.kuan.flashcard3.view.fc3component.FCPanel;

public class StartPanel extends FCPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StartPanel() {
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel_start_inner01 = new JPanel();
		this.add(panel_start_inner01, BorderLayout.CENTER);
		GridBagLayout gbl_panel_start_inner01 = new GridBagLayout();
		gbl_panel_start_inner01.columnWeights = new double[] { 0.0 };
		gbl_panel_start_inner01.rowWeights = new double[] { 0.0 };
		panel_start_inner01.setLayout(gbl_panel_start_inner01);
		JButton btn_start = new JButton("START");
		btn_start.setFocusable(false);
		btn_start.setBackground(SystemColor.control);
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel contentPane = FCComponent
						.findJPanel(FCComponent.CONTENTPANE);
				((CardLayout) contentPane.getLayout()).show(contentPane,
						CardPanelComponentFactory.PANEL_MAIN);
			}
		});
		btn_start.setFont(new Font("新細明體", Font.PLAIN, 18));
		btn_start.setAlignmentX(0.5f);
		GridBagConstraints gbc_btn_start = new GridBagConstraints();
		gbc_btn_start.gridx = 0;
		gbc_btn_start.gridy = 0;
		panel_start_inner01.add(btn_start, gbc_btn_start);
	}
}
