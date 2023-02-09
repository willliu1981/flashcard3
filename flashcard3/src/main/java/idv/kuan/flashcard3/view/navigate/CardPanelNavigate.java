package idv.kuan.flashcard3.view.navigate;

import java.awt.CardLayout;

import javax.swing.JPanel;

import idv.kuan.flashcard3.view.fc3component.FCComponent;

public class CardPanelNavigate extends Navigate {

	@Override
	public void jump(String... arg) {
		JPanel contentPane = FCComponent.findComponent("contentPane",
				JPanel.class);

		((CardLayout) contentPane.getLayout()).show(contentPane, arg[0]);
	}

}
