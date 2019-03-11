package dao;

public class MergeRule {
	private String htmlValue;
    private String optinValue;
    private String textValue;
    private boolean insertOnNoMatch;
    private String updateOnMatch;
    private String matchColumnName1;
    private String matchColumnName2;
    private String matchOperator;
    private String optoutValue;
    private String rejectRecordIfChannelEmpty;
    private String defaultPermissionStatus;
    
	public String getHtmlValue() {
		return htmlValue;
	}
	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}
	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	public String getOptinValue() {
		return optinValue;
	}
	public void setOptinValue(String optinValue) {
		this.optinValue = optinValue;
	}
	public boolean getInsertOnNoMatch() {
		return insertOnNoMatch;
	}
	public void setInsertOnNoMatch(boolean insertOnNoMatch) {
		this.insertOnNoMatch = insertOnNoMatch;
	}
	public String getUpdateOnMatch() {
		return updateOnMatch;
	}
	public void setUpdateOnMatch(String updateOnMatch) {
		this.updateOnMatch = updateOnMatch;
	}
	public String getMatchColumnName1() {
		return matchColumnName1;
	}
	public void setMatchColumnName1(String matchColumnName1) {
		this.matchColumnName1 = matchColumnName1;
	}
	public String getMatchOperator() {
		return matchOperator;
	}
	public void setMatchOperator(String matchOperator) {
		this.matchOperator = matchOperator;
	}
	public String getMatchColumnName2() {
		return matchColumnName2;
	}
	public void setMatchColumnName2(String matchColumnName2) {
		this.matchColumnName2 = matchColumnName2;
	}
	public String getOptoutValue() {
		return optoutValue;
	}
	public void setOptoutValue(String optoutValue) {
		this.optoutValue = optoutValue;
	}
	public String getRejectRecordIfChannelEmpty() {
		return rejectRecordIfChannelEmpty;
	}
	public void setRejectRecordIfChannelEmpty(String rejectRecordIfChannelEmpty) {
		this.rejectRecordIfChannelEmpty = rejectRecordIfChannelEmpty;
	}
	public String getDefaultPermissionStatus() {
		return defaultPermissionStatus;
	}
	public void setDefaultPermissionStatus(String defaultPermissionStatus) {
		this.defaultPermissionStatus = defaultPermissionStatus;
	}
}
