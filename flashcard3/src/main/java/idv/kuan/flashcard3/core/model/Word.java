package idv.kuan.flashcard3.core.model;

import java.sql.Timestamp;

public class Word {
	private Integer id;
	private String term;
	private String phoneticSymbol;
	private String translation;
	private Timestamp createdAt;
	private Timestamp updatedAt;

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

	public String getPhoneticSymbol() {
		return phoneticSymbol;
	}

	public void setPhoneticSymbol(String phoneticSymbol) {
		this.phoneticSymbol = phoneticSymbol;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", term=" + term + ", phoneticSymbol="
				+ phoneticSymbol + ", translation=" + translation
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
