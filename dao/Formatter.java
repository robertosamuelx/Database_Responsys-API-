package dao;

public class Formatter {

	private String[] databaseFields, responsysFields;

	public String[] getResponsysFields() {
		return responsysFields;
	}

	public void setResponsysFields(String[] responsysFields) {
		this.responsysFields = responsysFields;
	}

	public String[] getDatabaseFields() {
		return databaseFields;
	}

	public void setDatabaseFields(String[] databaseFields) {
		this.databaseFields = databaseFields;
	}
}
