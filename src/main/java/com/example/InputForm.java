package com.example;


/**
 * インプット画面からの情報を取得するフォーム.
 * @author takahiro.araki
 *
 */
public class InputForm {
	
	/**自宅の最寄り駅 */
	private String nearestStation;
	/**会社の最寄り駅 */
	private String jobStation;
	/**テレビタイトル */
	private String tvTitle;
	/**テレビ開始時間 */
	private String tvStartTime;
	
	
	public String getNearestStation() {
		return nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public String getJobStation() {
		return jobStation;
	}
	public void setJobStation(String jobStation) {
		this.jobStation = jobStation;
	}
	public String getTvTitle() {
		return tvTitle;
	}
	public void setTvTitle(String tvTitle) {
		this.tvTitle = tvTitle;
	}
	public String getTvStartTime() {
		return tvStartTime;
	}
	public void setTvStartTime(String tvStartTime) {
		this.tvStartTime = tvStartTime;
	}
	@Override
	public String toString() {
		return "InputForm [nearestStation=" + nearestStation + ", jobStation=" + jobStation + ", tvTitle=" + tvTitle
				+ ", tvStartTime=" + tvStartTime + "]";
	}
	
	
	
	
	
	

}
