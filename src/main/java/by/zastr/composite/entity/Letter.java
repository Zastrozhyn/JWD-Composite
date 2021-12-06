package by.zastr.composite.entity;

import java.util.List;

public class Letter implements TextComponent{
	private char letter;

	
	public Letter(char letter) {
		super();
		this.letter = letter;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + letter;
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
		Letter other = (Letter) obj;
		if (letter != other.letter)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(letter);
	}
	

}
