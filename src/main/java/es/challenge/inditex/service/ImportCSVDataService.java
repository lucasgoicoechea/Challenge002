package es.challenge.inditex.service;

import java.io.FileReader;
import java.util.Collections;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class ImportCSVDataService {

	private <T> List<T> readCSVtoBean(String filePath, Class<T> clazz, String[] columnsParam) {
		try (CSVReader csvReader = new CSVReader(new FileReader(filePath), ',', '"', 0);) {
			// mapping of columns with their positions
			ColumnPositionMappingStrategy<T> mappingStrategy = new ColumnPositionMappingStrategy<>();
			// Set mappingStrategy type to clazz Type
			mappingStrategy.setType(clazz);
			// Fields in class Bean
			String[] columns = columnsParam;
			// Setting the colums for mappingStrategy
			mappingStrategy.setColumnMapping(columns);
			// create instance for CsvToBean class
			CsvToBean<T> ctb = new CsvToBean<>();
			// parsing csvReader(*.csv) with mappingStrategy
			return ctb.parse(mappingStrategy, csvReader);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return Collections.emptyList();
	}

	public <T> List<T> importCSVToObject(String pathFilesFolder, String fileCSV, Class<T> clazz,
			String[] columnsParam) {
		List<T> list = null;
		try {
			list = readCSVtoBean(pathFilesFolder + "\\" + fileCSV, clazz, columnsParam);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
