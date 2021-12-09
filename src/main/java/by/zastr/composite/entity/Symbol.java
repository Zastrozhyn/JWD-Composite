package by.zastr.composite.entity;

import java.util.List;

public class Symbol implements TextComponent {
	
	private char symbol;
	private ComponentType componentType;

	public Symbol(char symbol) {
		super();
		this.symbol = symbol;
		componentType = ComponentType.SYMBOL;
	}

	@Override
	public boolean add(TextComponent component) {
		return false;
	}

	@Override
	public boolean remove(TextComponent component) {
		return false;
	}

	@Override
	public TextComponent getComponent(int index) {
		throw new UnsupportedOperationException("Not available operation to component:"+this.getClass());
	}

	@Override
	public List<TextComponent> getAllComponent() {
		throw new UnsupportedOperationException("Not available operation component"+this.getClass());
	}
	
	@Override
	public ComponentType getComponentType() {
		return componentType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + symbol;
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
		Symbol other = (Symbol) obj;
		if (symbol != other.symbol)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(symbol);
	}
}
