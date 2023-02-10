package idv.kuan.flashcard3.view.navigate;

import java.awt.CardLayout;

import javax.swing.JPanel;

import idv.kuan.flashcard3.view.fc3component.FCComponent;

public class CardPanelNavigate extends Navigate {
	public  static final String PANEL_START = "panel_start";
	public static final String PANEL_MAIN = "panel_main";
	public static final String PANEL_ADD_WORD = "panel_add_word";
	public static final String PANEL_SEARCH_WORD = "panel_search_word";
	
	@Override
	public void jump(String... arg) {
		JPanel contentPane = FCComponent.findJPanel(FCComponent.CONTENTPANE);

		((CardLayout) contentPane.getLayout()).show(contentPane, arg[0]);
	}

}
