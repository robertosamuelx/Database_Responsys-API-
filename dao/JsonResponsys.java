package dao;

public class JsonResponsys {
	private RecordData recordData;
	private MergeRule mergeRule;
    
    public JsonResponsys(MergeRule mergeRule, RecordData recordData) {
    	setMergeRule(mergeRule);
    	setRecordData(recordData);
    }
    
    public void setRecordData(RecordData recordData) {
    	this.recordData = recordData;
    }
    
	public RecordData getRecordData() {
		return recordData;
	}

	public MergeRule getMergeRule() {
		return mergeRule;
	}

	public void setMergeRule(MergeRule mergeRule) {
		this.mergeRule = mergeRule;
	}
}