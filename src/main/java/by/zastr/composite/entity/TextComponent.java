package by.zastr.composite.entity;

import java.util.List;

public interface TextComponent {
	boolean add (TextComponent component);
	boolean remove (TextComponent component);
	TextComponent getComponent(int index);
	List<TextComponent> getAllComponent();
	ComponentType getComponentType();
}
