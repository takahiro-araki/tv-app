package com.example;

/**
 * アウトプット画面表示のドメイン
 * @author tajkahiro.araki
 *
 */
public class OutputDomain {
	/**道順 */
	private String root;
	/**リンク */
	private String url;
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "OutputDomain [root=" + root + ", url=" + url + "]";
	}
	
	

}
