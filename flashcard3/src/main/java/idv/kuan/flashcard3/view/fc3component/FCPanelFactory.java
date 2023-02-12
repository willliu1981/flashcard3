package idv.kuan.flashcard3.view.fc3component;

import javax.swing.JComponent;

public abstract class FCPanelFactory {
	public static final String CONTENTPANE = "contentPane";

	public static final String WORD_STOCK_SEARCH = "word_stock_search";
	public static final String WORD_STOCK_CONTENT = "word_stock_content";

	//default base panel
	public static void createFCPanel(CardPanelComponentFactory factory) {
		factory.create();
		createFCPanel(factory.getPanel(), factory.getName());
	}

	//default base panel
	public static void createFCPanel(JComponent comp, Object constraints) {
		createFCPanel(FCComponent.findJPanel(FCComponent.CONTENTPANE), comp,
				constraints);

	}

	public static void createFCPanel(JComponent base, JComponent comp,
			Object constraints) {
		FCComponent.addComponent(comp, comp.getClass().getCanonicalName());
		base.add(comp, constraints);

	}
}
