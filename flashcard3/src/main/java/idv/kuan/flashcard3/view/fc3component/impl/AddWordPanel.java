package idv.kuan.flashcard3.view.fc3component.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import idv.kuan.flashcard3.control.AppController;
import idv.kuan.flashcard3.dao.Dao;
import idv.kuan.flashcard3.dao.WordDao;
import idv.kuan.flashcard3.model.Word;
import idv.kuan.flashcard3.view.fc3component.FCComponent;
import idv.kuan.flashcard3.view.fc3component.FCPanel;
import idv.kuan.flashcard3.view.navigate.CardPanelNavigate;

public class AddWordPanel extends FCPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea txtr_term;
	private JTextArea txtr_phoneticSymbol;
	private JTextArea txtr_translation;

	public AddWordPanel() {
		this.setLayout(new BorderLayout(0, 0));

		JPanel panel_addWord_inner01 = new JPanel();
		this.add(panel_addWord_inner01, BorderLayout.CENTER);
		panel_addWord_inner01.setLayout(new BorderLayout(0, 0));

		JButton btn_addWord_return = new JButton("返回");
		btn_addWord_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardPanelNavigate(AppController.getNavPoint()).jump();

			}
		});
		btn_addWord_return.setBorder(new SoftBevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btn_addWord_return.setFocusable(false);
		btn_addWord_return.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btn_addWord_return.setBackground(SystemColor.menu);
		panel_addWord_inner01.add(btn_addWord_return, BorderLayout.NORTH);

		JPanel panel_addWord_inner01w01 = new JPanel();
		panel_addWord_inner01.add(panel_addWord_inner01w01, BorderLayout.WEST);
		panel_addWord_inner01w01.setLayout(
				new BoxLayout(panel_addWord_inner01w01, BoxLayout.Y_AXIS));

		txtr_term = new JTextArea();
		FCComponent.addComponent(txtr_term, FCComponent.TXTR_TERM);
		txtr_term.setBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_term.setPreferredSize(new Dimension(200, 25));
		txtr_term.setLineWrap(true);
		txtr_term.setText("confirm\r\n");
		txtr_term.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panel_addWord_inner01w01.add(txtr_term);

		txtr_phoneticSymbol = new JTextArea();
		FCComponent.addComponent(txtr_phoneticSymbol,
				FCComponent.TXTR_PHONETICSYMBOL);
		txtr_phoneticSymbol.setBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_phoneticSymbol.setPreferredSize(new Dimension(200, 25));
		txtr_phoneticSymbol.setLineWrap(true);
		txtr_phoneticSymbol.setText("KK[kənˋfɝm]DJ[kənˋfə:m]");
		txtr_phoneticSymbol.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panel_addWord_inner01w01.add(txtr_phoneticSymbol);

		txtr_translation = new JTextArea();
		FCComponent.addComponent(txtr_translation,
				FCComponent.TXTR_TRANSLATION);
		txtr_translation.setBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_translation.setLineWrap(true);
		txtr_translation.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtr_translation.setText(
				"1.證實；確定[+（that）][+wh-]\r\nHis letter confirmed everything. 他的信證實了一切。\r\n2.堅定；加強\r\nThe latest developments confirmed me in my belief. 最新的發展使我堅信我的信仰。\r\n3.批准，確認\r\nThe queen confirmed the treaty. 女王批准了此項條約。\r\n4.【宗】給……施堅信禮");

		panel_addWord_inner01.add(txtr_translation);

		JPanel panel_addWord_otherOpt = new JPanel();
		panel_addWord_otherOpt.setBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_addWord_otherOpt.setPreferredSize(new Dimension(100, 10));
		panel_addWord_inner01.add(panel_addWord_otherOpt, BorderLayout.EAST);

		JButton btn_addWord_confirm = new JButton("新增單字");
		btn_addWord_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao<Word> dao = new WordDao();
				Word word = new Word();
				word.setTerm(txtr_term.getText());
				word.setPhoneticSymbol(txtr_phoneticSymbol.getText());
				word.setTranslation(txtr_translation.getText());
				dao.add(word);

				new CardPanelNavigate(AppController.getNavPoint()).jump();

			}
		});
		btn_addWord_confirm.setBorder(new SoftBevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btn_addWord_confirm.setFocusable(false);
		btn_addWord_confirm.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btn_addWord_confirm.setBackground(SystemColor.menu);
		panel_addWord_inner01.add(btn_addWord_confirm, BorderLayout.SOUTH);
	}

}
