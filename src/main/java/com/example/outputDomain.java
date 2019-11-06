package com.example;


/**
 * アウトプット情報を出力するためのドメイン
 * @author takahiro.araki
 *
 */
public class outputDomain {

	/**テレビタイトル */
	private String tvTitle;
	/**テレビ内容*/
	private String tvDescription;
	/**テレビ開始時間 */
	private String tvStartTime;
	/**電車の発車時間 */
	private String trainDepartureTime;
	/**電車の到着時間 */
	private String trainArrivalTime;
	public String getTvTitle() {
		return tvTitle;
	}
	public void setTvTitle(String tvTitle) {
		this.tvTitle = tvTitle;
	}
	public String getTvDescription() {
		return tvDescription;
	}
	public void setTvDescription(String tvDescription) {
		this.tvDescription = tvDescription;
	}
	public String getTvStartTime() {
		return tvStartTime;
	}
	public void setTvStartTime(String tvStartTime) {
		this.tvStartTime = tvStartTime;
	}
	public String getTrainDepartureTime() {
		return trainDepartureTime;
	}
	public void setTrainDepartureTime(String trainDepartureTime) {
		this.trainDepartureTime = trainDepartureTime;
	}
	public String getTrainArrivalTime() {
		return trainArrivalTime;
	}
	public void setTrainArrivalTime(String trainArrivalTime) {
		this.trainArrivalTime = trainArrivalTime;
	}
	@Override
	public String toString() {
		return "outputDomain [tvTitle=" + tvTitle + ", tvDescription=" + tvDescription + ", tvStartTime=" + tvStartTime
				+ ", trainDepartureTime=" + trainDepartureTime + ", trainArrivalTime=" + trainArrivalTime + "]";
	}
	
	
	
	
	
	
	
}
