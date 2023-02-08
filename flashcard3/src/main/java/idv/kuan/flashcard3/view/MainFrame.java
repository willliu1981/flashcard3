package idv.kuan.flashcard3.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import idv.kuan.flashcard3.dao.Dao;
import idv.kuan.flashcard3.dao.WordDao;
import idv.kuan.flashcard3.model.Word;
import javax.swing.BoxLayout;

public class MainFrame extends JFrame {
	private static final String PANEL_START = "panel_start";
	private static final String PANEL_MAIN = "panel_main";
	private static final String PANEL_ADD_WORD = "panel_add_word";

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

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel_start = new JPanel();
		contentPane.add(panel_start, PANEL_START);
		panel_start.setLayout(new BorderLayout(0, 0));

		JPanel panel_start_inner01 = new JPanel();
		panel_start.add(panel_start_inner01, BorderLayout.CENTER);
		GridBagLayout gbl_panel_start_inner01 = new GridBagLayout();
		gbl_panel_start_inner01.columnWeights = new double[] { 0.0 };
		gbl_panel_start_inner01.rowWeights = new double[] { 0.0 };
		panel_start_inner01.setLayout(gbl_panel_start_inner01);

		JButton btn_start = new JButton("START");
		btn_start.setFocusable(false);
		btn_start.setBackground(SystemColor.control);
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, PANEL_MAIN);
			}
		});
		btn_start.setFont(new Font("新細明體", Font.PLAIN, 18));
		btn_start.setAlignmentX(0.5f);
		GridBagConstraints gbc_btn_start = new GridBagConstraints();
		gbc_btn_start.gridx = 0;
		gbc_btn_start.gridy = 0;
		panel_start_inner01.add(btn_start, gbc_btn_start);

		JPanel main_panel = new JPanel();
		contentPane.add(main_panel, PANEL_MAIN);
		main_panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_main_inner01 = new JPanel();
		main_panel.add(panel_main_inner01);
		GridBagLayout gbl_panel_main_inner01 = new GridBagLayout();
		gbl_panel_main_inner01.columnWidths = new int[] { 69, 0 };
		gbl_panel_main_inner01.rowHeights = new int[] { 31, 0, 0, 0 };
		gbl_panel_main_inner01.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_main_inner01.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_main_inner01.setLayout(gbl_panel_main_inner01);

		JButton btn_addWord = new JButton("新增單字");
		btn_addWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, PANEL_ADD_WORD);

				txtr_term.setText("");
				txtr_phoneticSymbol.setText("");
				txtr_translation.setText("");

				navPoint = PANEL_MAIN;
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
		main_panel.add(panel_main_inner02, BorderLayout.NORTH);

		JPanel panel_addWord = new JPanel();
		contentPane.add(panel_addWord, PANEL_ADD_WORD);
		panel_addWord.setLayout(new BorderLayout(0, 0));

		JPanel panel_addWord_inner01 = new JPanel();
		panel_addWord.add(panel_addWord_inner01, BorderLayout.CENTER);
		panel_addWord_inner01.setLayout(new BorderLayout(0, 0));

		JButton btn_addWord_return = new JButton("返回");
		btn_addWord_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((CardLayout) contentPane.getLayout()).show(contentPane, navPoint);
			}
		});
		btn_addWord_return.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_addWord_return.setFocusable(false);
		btn_addWord_return.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btn_addWord_return.setBackground(SystemColor.menu);
		panel_addWord_inner01.add(btn_addWord_return, BorderLayout.NORTH);

		JPanel panel_addWord_inner01w01 = new JPanel();
		panel_addWord_inner01.add(panel_addWord_inner01w01, BorderLayout.WEST);
		panel_addWord_inner01w01.setLayout(new BoxLayout(panel_addWord_inner01w01, BoxLayout.Y_AXIS));

		txtr_term = new JTextArea();
		txtr_term.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_term.setPreferredSize(new Dimension(200, 25));
		txtr_term.setLineWrap(true);
		txtr_term.setText("confirm\r\n");
		txtr_term.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panel_addWord_inner01w01.add(txtr_term);

		txtr_phoneticSymbol = new JTextArea();
		txtr_phoneticSymbol.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_phoneticSymbol.setPreferredSize(new Dimension(200, 25));
		txtr_phoneticSymbol.setLineWrap(true);
		txtr_phoneticSymbol.setText("KK[kənˋfɝm]DJ[kənˋfə:m]");
		txtr_phoneticSymbol.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panel_addWord_inner01w01.add(txtr_phoneticSymbol);

		txtr_translation = new JTextArea();
		txtr_translation.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtr_translation.setLineWrap(true);
		txtr_translation.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtr_translation.setText(
				"1.證實；確定[+（that）][+wh-]\r\nHis letter confirmed everything. 他的信證實了一切。\r\n2.堅定；加強\r\nThe latest developments confirmed me in my belief. 最新的發展使我堅信我的信仰。\r\n3.批准，確認\r\nThe queen confirmed the treaty. 女王批准了此項條約。\r\n4.【宗】給……施堅信禮");
		panel_addWord_inner01.add(txtr_translation);

		JPanel panel_addWord_otherOpt = new JPanel();
		panel_addWord_otherOpt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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

				((CardLayout) contentPane.getLayout()).show(contentPane, navPoint);
			}
		});
		btn_addWord_confirm.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn_addWord_confirm.setFocusable(false);
		btn_addWord_confirm.setFont(new Font("Monospaced", Font.PLAIN, 18));
		btn_addWord_confirm.setBackground(SystemColor.menu);
		panel_addWord_inner01.add(btn_addWord_confirm, BorderLayout.SOUTH);

	}

}
