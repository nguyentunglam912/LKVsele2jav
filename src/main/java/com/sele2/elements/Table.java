package com.sele2.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table extends BaseElement {

	public Table(String locator) {
		super(locator);
	}

	public WebElement table() {
		return this.findElement();
	}

	public int getRowsCount() {
		int noOfRows = this.table().findElements(By.tagName("tr")).size();
		return noOfRows;
	}

	public int getColumnCount(){
		int noOfCols = this.table().findElements(By.xpath("//tr[2]/td")).size();
		return noOfCols;
	}

	// verify presence of the text/data
	public boolean presenceOfData(String data){
		int dataSize = this.table().findElements(By.xpath("//td[normalize-space(.)='"+data+"']")).size();
		boolean presence = false;
		if(dataSize > 0){
			presence = true;
		}
		return presence;
	}
	
	public String getTableCellValue(int rowNumber, int columnNumber){
		String cellData = this.table().findElement(By.xpath("//tr["+rowNumber+"]/td["+columnNumber+"]")).getText().trim();
		return cellData;
	}

	public void clickTableCell(int rowNumber, int columnNumber){
		this.table().findElement(By.xpath("//tr["+rowNumber+"]/td["+columnNumber+"]")).click();
	}
}
