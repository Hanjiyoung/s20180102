package oracle.java.s20180102.model;

public class TourCardDto {
	private String rn;
	private String imgSrc;
	private String gImg;
	private String nickName;
	private String gServTitle;
	private String gServSub;
	private String gServLeadTime;
	private String gServPrice;
	
	private int likeIt;
	private int remainSize;
	private int gServNo;
		
	
	
	public String getgServPrice() {
		return gServPrice;
	}
	public void setgServPrice(String gServPrice) {
		this.gServPrice = gServPrice;
	}
	public int getgServNo() {
		return gServNo;
	}
	public void setgServNo(int gServNo) {
		this.gServNo = gServNo;
	}
	public int getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}
	public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getgImg() {
		return gImg;
	}
	public void setgImg(String gImg) {
		this.gImg = gImg;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getgServTitle() {
		return gServTitle;
	}
	public void setgServTitle(String gServTitle) {
		this.gServTitle = gServTitle;
	}
	public String getgServSub() {
		return gServSub;
	}
	public void setgServSub(String gServSub) {
		this.gServSub = gServSub;
	}
	
	public String getgServLeadTime() {
		return gServLeadTime;
	}
	public void setgServLeadTime(String gServLeadTime) {
		this.gServLeadTime = gServLeadTime;
	}

	public int getRemainSize() {
		return remainSize;
	}
	public void setRemainSize(int remainSize) {
		this.remainSize = remainSize;
	}
	

	
}
