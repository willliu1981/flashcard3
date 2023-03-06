package idv.kuan.flashcard3.view.fc3component.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import idv.kuan.flashcard3.controller.AppController;
import idv.kuan.flashcard3.view.fc3component.CardPanelComponentFactory;
import idv.kuan.flashcard3.view.fc3component.FCComponent;
import idv.kuan.flashcard3.view.navigate.CardPanelNavigate;

public class MainPanelAddWordActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		FCComponent.findComponent(FCComponent.TXTR_TERM, JTextArea.class)
				.setText("");
		FCComponent
				.findComponent(FCComponent.TXTR_PHONETICSYMBOL, JTextArea.class)
				.setText("");
		FCComponent.findComponent(FCComponent.TXTR_TRANSLATION, JTextArea.class)
				.setText("");

		AppController.setNavPoint(CardPanelComponentFactory.PANEL_MAIN);
		new CardPanelNavigate(CardPanelComponentFactory.PANEL_ADD_WORD).jump();
	}

}
