package manoj;

public class Loanbean {

	private String username,loandate,itemtype,itemname,releasedate,loanstatus,comment,intrestrate;
	private double totalweight,loanamount,netweight,releaseamount;
	private int loanid;
	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}
	public int getLoanid() {
		return loanid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoandate() {
		return loandate;
	}
	public void setLoandate(String loandate) {
		this.loandate = loandate;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public String getLoanstatus() {
		return loanstatus;
	}
	public void setLoanstatus(String loanstatus) {
		this.loanstatus = loanstatus;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public double getTotalweight() {
		return totalweight;
	}
	public void setTotalweight(double totalweight) {
		this.totalweight = totalweight;
	}
	public double getNetweight() {
		return netweight;
	}
	public void setNetweight(double netweight) {
		this.netweight = netweight;
	}
	public double getLoanamount() {
		return loanamount;
	}
	public double getReleaseamount() {
		return releaseamount;
	}
	public void setReleaseamount(double releaseamount) {
		this.releaseamount = releaseamount;
	}
	public void setLoanamount(double loanamount) {
		this.loanamount = loanamount;
	}
	public String getIntrestrate() {
		return intrestrate;
	}
	public void setIntrestrate(String intrestrate) {
		this.intrestrate = intrestrate;
	}
	
}
