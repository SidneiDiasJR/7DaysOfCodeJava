package model;

public class MarvelComic extends AbstractMarvel {

	@Override
	public String title() {
		return super.title();
	}

	@Override
	public String urlImage() {
		return super.urlImage();
	}

	@Override
	public String rating() {
		return "Vazio";
	}

	@Override
	public String toString() {
	  return super.toString();
	}
	
	@Override
	public String year() {
		return "Vazio";
	}

	@Override
	public String type() {
		return "Comics";
	}

	@Override
	public int compareTo(Content outro) {
		return this.title().compareTo(outro.title());
	}
}
