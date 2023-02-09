package idv.kuan.flashcard3.view.fc3component;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

public class FCComponent {
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
}
