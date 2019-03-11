package dao;

public class RecordData {
	private String[] fieldNames;
	private String[][] records;
	private String mapTemplateName;

	public String[] getFieldNames() {
		return fieldNames;
	}
	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}
	public String[][] getRecords() {
		return records;
	}
	public void setRecords(String[][] records) {
		this.records = records;
	}
	public String getMapTemplateName() {
		return mapTemplateName;
	}
	public void setMapTemplateName(String mapTemplateName) {
		this.mapTemplateName = mapTemplateName;
	}
}
