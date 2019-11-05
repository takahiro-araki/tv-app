package com.example;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * HTML情報を取得するクラス.
 * 
 * @author takahiro.araki
 *
 */
public class ExecuteSearch {
	public static void main(String[] args) {
		
	}
	
	

	/**
	 * 入力情報からテレビ番組の情報を取得する.
	 * @return テレビ番組の開始時間の文字列情報
	 */
	public static String getHtml(InputForm form) {
		
		try {
			//テレビ番組の情報を取得するためのget文を作成
			StringBuilder str=new StringBuilder();
			str.append("https://tv.yahoo.co.jp/search/?q=");
			str.append(form.getTvTitle());
			//ドキュメントクラスの変数を作成し、HTMLを取得
			Document document = Jsoup.connect(str.toString()).get();
			//指定のタグ要素の情報を検索する
			Elements elements=document.select("div");
			
			System.out.println(elements);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return "aut";
	}
	
	
	public static String searchTrain(InputForm form) {
		StringBuilder str=new StringBuilder();
		//ジョルダンのリンク長すぎ問題
		str.append("https://www.jorudan.co.jp/norikae/cgi/nori.cgi?eki1=");
		str.append(form.getJobStation());
		str.append("&eki2=");
		str.append(form.getNearestStation());
		//テレビの放送年月をアペンドする
		str.append("&Dym=");
		str.append("");
		//テレビの放送日をアペンドする
		str.append("&Ddd=");
		str.append("");
		//テレビの放送時間（時）をアペンドする
		str.append("&Dhh=");
		str.append("");
		//テレビの放送時間（分）をアペンドする
		str.append("&Dmn1=");
		str.append("");
		//到着にセットして検索
		str.append("&Cway=1&S=検索");
		
		
		
		
		

		
		
		return "outputForm";
		
	}
	


}
