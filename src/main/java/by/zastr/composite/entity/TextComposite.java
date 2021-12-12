package by.zastr.composite.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
	private List<TextComponent> componentList;
	private ComponentType componentType;
	
	public TextComposite(ComponentType componentType) {
		super();
		this.componentType = componentType;
		componentList= new ArrayList<TextComponent>();
	}
	
	@Override
	public ComponentType getComponentType() {
		return componentType;
	}

	@Override
	public boolean add(TextComponent component) {
		return componentList.add(component);
	}

	@Override
	public boolean remove(TextComponent component) {
		return componentList.remove(component);
	}

	@Override
	public TextComponent getComponent(int index) {
		return componentList.get(index);
	}

	@Override
	public List<TextComponent> getAllComponent() {
		return componentList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentList == null) ? 0 : componentList.hashCode());
		result = prime * result + ((componentType == null) ? 0 : componentType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextComposite other = (TextComposite) obj;
		if (componentList == null) {
			if (other.componentList != null)
				return false;
		} else if (!componentList.equals(other.componentList))
			return false;
		if (componentType != other.componentType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (TextComponent component : componentList) {
			if (component.getComponentType().equals(ComponentType.PARAGRAPH)) {
				stringBuilder.append("    ");
			}
			
			stringBuilder.append(component.toString());
			
			if (component.getComponentType().equals(ComponentType.LEXEME)) {
				stringBuilder.append(" ");
			}
			if (component.getComponentType().equals(ComponentType.PARAGRAPH)) {
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();	
	}
}
