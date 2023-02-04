package idv.kuan.flashcard3.model;

public class Word {
	private Integer id;
	private String term;
	private String translation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", term=" + term + ", translation="
				+ translation + "]";
	}

}
