package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class CSVTransfer {
	private List<Datos> csvList;

    public CSVTransfer() {}

    public void setCsvList(List<Datos> csvList) {
        this.csvList = csvList;
    }

    public List<Datos> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<Datos>();
    }
}
