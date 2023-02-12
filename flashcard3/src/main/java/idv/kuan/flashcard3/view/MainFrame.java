package idv.kuan.flashcard3.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import idv.kuan.flashcard3.dao.Dao;
import idv.kuan.flashcard3.dao.WordDao;
import idv.kuan.flashcard3.model.Word;
import idv.kuan.flashcard3.view.fc3component.CardPanelComponentFactory;
import idv.kuan.flashcard3.view.fc3component.FCComponent;
import idv.kuan.flashcard3.view.fc3component.FCPanelFactory;
import idv.kuan.flashcard3.view.fc3component.impl.MainPanel;
import idv.kuan.flashcard3.view.fc3component.impl.StartPanel;
import idv.kuan.flashcard3.view.navigate.CardPanelNavigate;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea txtr_term;
	private JTextArea txtr_phoneticSymbol;
	private JTextArea txtr_translation;

	private static String navPoint = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		FCComponent.addComponent(contentPane, FCComponent.CONTENTPANE);

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		FCPanelFactory.createFCPanel(new CardPanelComponentFactory(
				new StartPanel(), CardPanelComponentFactory.PANEL_START));
		FCPanelFactory.createFCPanel(new CardPanelComponentFactory(
				new MainPanel(), CardPanelComponentFactory.PANEL_MAIN));

		JPanel panel_addWord = new JPanel();
		contentPane.add(panel_addWord, CardPanelNavigate.PANEL_ADD_WORD);
		panel_addWord.setLayout(new BorderLayout(0, 0));

		JPanel panel_addWord_inner01 = new JPanel();
		panel_addWord.add(panel_addWord_inner01, BorderLayout.CENTER);
		panel_addWord_inner01.setLayout(new BorderLayout(0, 0));

		JButton btn_addWord_return = new JButton("返回");
		btn_addWord_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardPanelNavigate().jump(navPoint);

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
		txtr_term.setBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_term.setPreferredSize(new Dimension(200, 25));
		txtr_term.setLineWrap(true);
		txtr_term.setText("confirm\r\n");
		txtr_term.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panel_addWord_inner01w01.add(txtr_term);

		txtr_phoneticSymbol = new JTextArea();
		txtr_phoneticSymbol.setBorder(
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_phoneticSymbol.setPreferredSize(new Dimension(200, 25));
		txtr_phoneticSymbol.setLineWrap(true);
		txtr_phoneticSymbol.setText("KK[kənˋfɝm]DJ[kənˋfə:m]");
		txtr_phoneticSymbol.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panel_addWord_inner01w01.add(txtr_phoneticSymbol);

		txtr_translation = new JTextArea();
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

				new CardPanelNavigate().jump(navPoint);

			}
		});
		btn_addWord_confirm.setBorder(new SoftBevelBorder(BevelBorder.RAISED,
				null, null, null, null));
		btn_addWord_confirm.setFocusable(false);
		btn_addWord_confirm.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btn_addWord_confirm.setBackground(SystemColor.menu);
		panel_addWord_inner01.add(btn_addWord_confirm, BorderLayout.SOUTH);

		JPanel panel_word_stock = new JPanel();
		contentPane.add(panel_word_stock, CardPanelNavigate.PANEL_SEARCH_WORD);
		panel_word_stock.setLayout(new BorderLayout(0, 0));

		JPanel panel_word_stock_inner01 = new JPanel();
		panel_word_stock.add(panel_word_stock_inner01, BorderLayout.CENTER);
		panel_word_stock_inner01.setLayout(new BorderLayout(0, 0));

		JButton btn_word_stock_return = new JButton("返回");
		btn_word_stock_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardPanelNavigate().jump(CardPanelNavigate.PANEL_MAIN);
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
