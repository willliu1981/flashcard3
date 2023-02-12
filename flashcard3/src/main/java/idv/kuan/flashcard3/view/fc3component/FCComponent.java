package idv.kuan.flashcard3.view.fc3component;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class FCComponent {
	public static final String CONTENTPANE="contentPane";
	
	public static final String TXTR_TERM="txtr_term";
	public static final String TXTR_PHONETICSYMBOL="txtr_phoneticSymbol";
	public static final String TXTR_TRANSLATION="txtr_translation";
	
	public static final String WORD_STOCK_SEARCH="word_stock_search";
	public static final String WORD_STOCK_CONTENT="word_stock_content";
	
	private static Map<String, JComponent> components = new HashMap<>();

	public static <T extends JComponent> void addComponent(T comp,
			String name) {
		components.put(name, comp);
	}

	public static <T extends JComponent> T findComponent(String name,
			Class<T> type) {

		JComponent jComponent = components.get(name);

		return (T) jComponent;
	}

	public static JPanel findJPanel(String name) {

		return findComponent(name, JPanel.class);
	}
}
