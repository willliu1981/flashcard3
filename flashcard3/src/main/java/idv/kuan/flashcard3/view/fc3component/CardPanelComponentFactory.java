package idv.kuan.flashcard3.view.fc3component;

import javax.swing.JPanel;

public class CardPanelComponentFactory {
	public static final String PANEL_START = "panel_start";
	public static final String PANEL_MAIN = "panel_main";
	public static final String PANEL_ADD_WORD = "panel_add_word";
	public static final String PANEL_WORD_STOCK_SEARCH = "panel_word_stock_search";

	private JPanel compPanel;
	private String name;

	public CardPanelComponentFactory(JPanel comp, String name) {
		this.compPanel = comp;
		this.name = name;
	}

	public JPanel getPanel() {
		return compPanel;
	}

	public String getName() {
		return name;
	}

	public void create() {
		FCComponent.addComponent(this.compPanel, name);
	}

}
