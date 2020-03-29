package com.sele2.elements;

import org.openqa.selenium.By;

public class Table extends BaseElement {

	public Table(String locator) {
		super(locator);
	}

	public int getRowsCount() {
		int noOfRows = this.getDriver().findElements(By.tagName("tr")).size();
		return noOfRows;
	}

	public int getColumnCount(){
		int noOfCols = this.getDriver().findElements(By.xpath("//tr[2]/td")).size();
		return noOfCols;
	}

	// verify presence of the text/data
	public boolean presenceOfData(String data){
		int dataSize = this.getDriver().findElements(By.xpath("//td/a[normalize-space(text())='"+data+"']")).size();
		boolean presence = false;
		if(dataSize > 0){
			presence = true;
		}
		return presence;
	}
	
	public String getTableCellValue(int rowNumber, int columnNumber){
		String cellData = this.getDriver().findElement(By.xpath("//tr["+rowNumber+"]/td["+columnNumber+"]/a")).getText();
		return cellData;
	}

	public void clickTableCell(int rowNumber, int columnNumber){
		this.getDriver().findElement(By.xpath("//tr["+rowNumber+"]/td["+columnNumber+"]/a")).click();
	}
}
