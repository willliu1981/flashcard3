package idv.kuan.flashcard3.view.navigate;

import java.awt.CardLayout;

import javax.swing.JPanel;

import idv.kuan.flashcard3.view.fc3component.FCComponent;

public class CardPanelNavigate extends Navigate {

	private String[] arg;

	public CardPanelNavigate(String... arg) {
		this.arg = arg;
	}

	@Override
	public void jump() {
		JPanel contentPane = FCComponent.findJPanel(FCComponent.CONTENTPANE);

		((CardLayout) contentPane.getLayout()).show(contentPane, arg[0]);
	}

}
