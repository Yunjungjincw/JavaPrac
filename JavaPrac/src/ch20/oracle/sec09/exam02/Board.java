package ch20.oracle.sec09.exam02;

import java.sql.Blob;
import java.util.Date;


public class Board {
	public int bno;
	public String btitle;
	public String bcontent;
	public String bwriter;
	public Date bdate;
	public String bfileName;
	public Blob bfileData;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getBfileName() {
		return bfileName;
	}
	public void setBfileName(String bfileName) {
		this.bfileName = bfileName;
	}
	public Blob getBfileData() {
		return bfileData;
	}
	public void setBfileData(Blob bfileData) {
		this.bfileData = bfileData;
	}
}
