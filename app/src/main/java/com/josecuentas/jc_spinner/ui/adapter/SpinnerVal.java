package com.josecuentas.jc_spinner.ui.adapter;

public class SpinnerVal {

	private String id;
	private String value;
	private String _code;
	
	

	public SpinnerVal(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public SpinnerVal(String _code, String id, String value) {
		this._code = _code;
		this.id = id;
		this.value = value;
	}

	public SpinnerVal() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String get_code() {
		return _code;
	}

	public void set_code(String _code) {
		this._code = _code;
	}

	@Override
	public String toString() {
		return "SpinnerVal{" +
				"_code='" + _code + '\'' +
				", id='" + id + '\'' +
				", value='" + value + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SpinnerVal that = (SpinnerVal) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (value != null ? !value.equals(that.value) : that.value != null) return false;
		return _code != null ? _code.equals(that._code) : that._code == null;

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (value != null ? value.hashCode() : 0);
		result = 31 * result + (_code != null ? _code.hashCode() : 0);
		return result;
	}
}
