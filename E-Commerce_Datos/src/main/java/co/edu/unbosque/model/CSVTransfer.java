package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class CSVTransfer {
	private List<Data> csvList;

    public CSVTransfer() {}

    public void setCsvList(List<Data> csvList) {
        this.csvList = csvList;
    }

    public List<Data> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<Data>();
    }
}
