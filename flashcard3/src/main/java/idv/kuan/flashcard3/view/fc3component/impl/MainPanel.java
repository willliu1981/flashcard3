package idv.kuan.flashcard3.view.fc3component.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import idv.kuan.flashcard3.view.fc3component.FCPanel;
import idv.kuan.flashcard3.view.navigate.CardPanelNavigate;

public class MainPanel extends FCPanel {

	public MainPanel() {
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel_main_inner01 = new JPanel();
		this.add(panel_main_inner01);
		GridBagLayout gbl_panel_main_inner01 = new GridBagLayout();
		gbl_panel_main_inner01.columnWidths = new int[] { 69, 0 };
		gbl_panel_main_inner01.rowHeights = new int[] { 31, 0, 0, 0 };
		gbl_panel_main_inner01.columnWeights = new double[] { 1.0,
				Double.MIN_VALUE };
		gbl_panel_main_inner01.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_main_inner01.setLayout(gbl_panel_main_inner01);

		JButton btn_addWord = new JButton("新增單字");
		btn_addWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtr_term.setText("");
				//txtr_phoneticSymbol.setText("");
				//txtr_translation.setText("");

				//navPoint = CardPanelNavigate.PANEL_MAIN;

				new CardPanelNavigate().jump(CardPanelNavigate.PANEL_ADD_WORD);
			}
		});
		btn_addWord.setFont(new Font("新細明體", Font.PLAIN, 18));
		btn_addWord.setFocusable(false);
		btn_addWord.setBackground(SystemColor.menu);
		btn_addWord.setAlignmentX(0.5f);
		GridBagConstraints gbc_btn_addWord = new GridBagConstraints();
		gbc_btn_addWord.insets = new Insets(0, 0, 5, 0);
		gbc_btn_addWord.gridx = 0;
		gbc_btn_addWord.gridy = 0;
		panel_main_inner01.add(btn_addWord, gbc_btn_addWord);

		JButton btn_searchWord = new JButton("查詢字庫");
		btn_searchWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardPanelNavigate()
						.jump(CardPanelNavigate.PANEL_SEARCH_WORD);
			}
		});
		btn_searchWord.setFont(new Font("新細明體", Font.PLAIN, 18));
		btn_searchWord.setFocusable(false);
		btn_searchWord.setBackground(SystemColor.menu);
		btn_searchWord.setAlignmentX(0.5f);
		GridBagConstraints gbc_btn_searchWord = new GridBagConstraints();
		gbc_btn_searchWord.insets = new Insets(0, 0, 5, 0);
		gbc_btn_searchWord.gridx = 0;
		gbc_btn_searchWord.gridy = 1;
		panel_main_inner01.add(btn_searchWord, gbc_btn_searchWord);

		JButton btn_appInfo = new JButton("版本說明");
		btn_appInfo.setFont(new Font("新細明體", Font.PLAIN, 18));
		btn_appInfo.setFocusable(false);
		btn_appInfo.setBackground(SystemColor.menu);
		btn_appInfo.setAlignmentX(0.5f);
		GridBagConstraints gbc_btn_appInfo = new GridBagConstraints();
		gbc_btn_appInfo.gridx = 0;
		gbc_btn_appInfo.gridy = 2;
		panel_main_inner01.add(btn_appInfo, gbc_btn_appInfo);

		JPanel panel_main_inner02 = new JPanel();
		panel_main_inner02.setPreferredSize(new Dimension(10, 100));
		this.add(panel_main_inner02, BorderLayout.NORTH);
	}
}
