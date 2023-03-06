package idv.kuan.flashcard3.view.fc3component.impl;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import idv.kuan.flashcard3.core.dao.WordDao;
import idv.kuan.flashcard3.core.model.Word;
import idv.kuan.flashcard3.view.fc3component.CardPanelComponentFactory;
import idv.kuan.flashcard3.view.fc3component.FCComponent;
import idv.kuan.flashcard3.view.fc3component.FCPanel;
import idv.kuan.flashcard3.view.navigate.CardPanelNavigate;

public class WordStockSearchPanel extends FCPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WordStockSearchPanel() {
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel_word_stock_inner01 = new JPanel();
		this.add(panel_word_stock_inner01, BorderLayout.CENTER);
		panel_word_stock_inner01.setLayout(new BorderLayout(0, 0));

		JButton btn_word_stock_return = new JButton("返回");
		btn_word_stock_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardPanelNavigate(CardPanelComponentFactory.PANEL_MAIN)
						.jump();
			}
		});
		btn_word_stock_return.setFocusable(false);
		btn_word_stock_return.setBackground(SystemColor.control);
		btn_word_stock_return.setFont(new Font("新細明體", Font.PLAIN, 18));
		panel_word_stock_inner01.add(btn_word_stock_return, BorderLayout.SOUTH);

		JPanel panel_word_stock_inner01n01 = new JPanel();
		panel_word_stock_inner01.add(panel_word_stock_inner01n01,
				BorderLayout.NORTH);
		panel_word_stock_inner01n01.setLayout(new BorderLayout(0, 0));

		JTextField txtf_word_stock_search = new JTextField();
		txtf_word_stock_search.setFont(new Font("新細明體", Font.PLAIN, 22));
		panel_word_stock_inner01n01.add(txtf_word_stock_search,
				BorderLayout.CENTER);
		txtf_word_stock_search.setColumns(10);
		FCComponent.addComponent(txtf_word_stock_search,
				FCComponent.WORD_STOCK_SEARCH);

		JPanel panel_word_stock_inner01n01w01 = new JPanel();
		panel_word_stock_inner01n01w01.setPreferredSize(new Dimension(250, 10));
		panel_word_stock_inner01n01.add(panel_word_stock_inner01n01w01,
				BorderLayout.WEST);

		JPanel panel_word_stock_inner01n01e01 = new JPanel();
		panel_word_stock_inner01n01e01.setPreferredSize(new Dimension(250, 50));
		panel_word_stock_inner01n01.add(panel_word_stock_inner01n01e01,
				BorderLayout.EAST);
		GridBagLayout gbl_panel_word_stock_inner01n01e01 = new GridBagLayout();
		gbl_panel_word_stock_inner01n01e01.columnWidths = new int[] { 40, 40,
				40 };
		gbl_panel_word_stock_inner01n01e01.rowHeights = new int[] { 40, 40,
				35 };
		gbl_panel_word_stock_inner01n01e01.columnWeights = new double[] { 0.0,
				0.0, 0.0 };
		gbl_panel_word_stock_inner01n01e01.rowWeights = new double[] { 0.0,
				0.0 };
		panel_word_stock_inner01n01e01
				.setLayout(gbl_panel_word_stock_inner01n01e01);

		JButton btn_word_stock_search = new JButton("查詢");
		btn_word_stock_search.setFocusable(false);
		btn_word_stock_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WordDao dao = new WordDao();
				Word result = dao.getByTerm(
						FCComponent.findComponent(FCComponent.WORD_STOCK_SEARCH,
								JTextField.class).getText());
				JTextArea content = FCComponent.findComponent(
						FCComponent.WORD_STOCK_CONTENT, JTextArea.class);
				StringBuilder sb = new StringBuilder();
				sb.append(result.getTerm()).append("\r\n").append("\r\n")
						.append(result.getPhoneticSymbol()).append("\r\n")
						.append("\r\n").append(result.getTranslation());
				content.setText(sb.toString());
			}
		});
		btn_word_stock_search.setBackground(SystemColor.control);
		GridBagConstraints gbc_btn_word_stock_search = new GridBagConstraints();
		gbc_btn_word_stock_search.insets = new Insets(0, 0, 5, 5);
		gbc_btn_word_stock_search.gridx = 1;
		gbc_btn_word_stock_search.gridy = 1;
		panel_word_stock_inner01n01e01.add(btn_word_stock_search,
				gbc_btn_word_stock_search);
		btn_word_stock_search.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_word_stock_search.setFont(new Font("新細明體", Font.PLAIN, 18));

		JPanel panel_word_stock_inner01n01n01 = new JPanel();
		panel_word_stock_inner01n01.add(panel_word_stock_inner01n01n01,
				BorderLayout.NORTH);

		JPanel panel_word_stock_inner01n01s01 = new JPanel();
		panel_word_stock_inner01n01.add(panel_word_stock_inner01n01s01,
				BorderLayout.SOUTH);

		JPanel panel_word_stock_inner01n01c01 = new JPanel();
		panel_word_stock_inner01.add(panel_word_stock_inner01n01c01,
				BorderLayout.CENTER);
		panel_word_stock_inner01n01c01.setLayout(new BorderLayout(0, 0));

		JTextArea txtr_word_stock_content = new JTextArea();
		txtr_word_stock_content.setLineWrap(true);
		txtr_word_stock_content.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtr_word_stock_content.setEditable(false);
		panel_word_stock_inner01n01c01.add(txtr_word_stock_content,
				BorderLayout.CENTER);
		FCComponent.addComponent(txtr_word_stock_content,
				FCComponent.WORD_STOCK_CONTENT);
	}
}
