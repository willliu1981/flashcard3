package idv.kuan.flashcard3.view;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import idv.kuan.flashcard3.view.fc3component.CardPanelComponentFactory;
import idv.kuan.flashcard3.view.fc3component.FCComponent;
import idv.kuan.flashcard3.view.fc3component.FCPanelFactory;
import idv.kuan.flashcard3.view.fc3component.impl.AddWordPanel;
import idv.kuan.flashcard3.view.fc3component.impl.MainPanel;
import idv.kuan.flashcard3.view.fc3component.impl.MainPanelAddWordActionListener;
import idv.kuan.flashcard3.view.fc3component.impl.StartPanel;
import idv.kuan.flashcard3.view.fc3component.impl.WordStockSearchPanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
				new MainPanel(new MainPanelAddWordActionListener()),
				CardPanelComponentFactory.PANEL_MAIN));

		FCPanelFactory.createFCPanel(new CardPanelComponentFactory(
				new AddWordPanel(), CardPanelComponentFactory.PANEL_ADD_WORD));

		FCPanelFactory.createFCPanel(
				new CardPanelComponentFactory(new WordStockSearchPanel(),
						CardPanelComponentFactory.PANEL_WORD_STOCK_SEARCH));

	}

}
