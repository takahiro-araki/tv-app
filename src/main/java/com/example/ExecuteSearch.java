package com.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

/**
 * HTML情報を取得するクラス.
 * 
 * @author takahiro.araki
 *
 */
public class ExecuteSearch {
	public static void main(String[] args) {
		try{
			StringBuilder str = new StringBuilder();
			// ジョルダンのリンク長すぎ問題
			str.append("https://www.jorudan.co.jp/norikae/cgi/nori.cgi?eki1=");
			str.append("保谷");
			str.append("&eki2=");
			str.append("新宿");
			// テレビの放送年月をアペンドする
			str.append("&Dym=");
			str.append("201911");
			// テレビの放送日をアペンドする
			str.append("&Ddd=");
			str.append("6");
			// テレビの放送時間（時）をアペンドする
			str.append("&Dhh=");
			str.append("20");
			// テレビの放送時間（分）をアペンドする
			str.append("&Dmn1=");
			str.append("15");
			// 到着にセットして検索
			str.append("&Cway=1&S=検索");
			
			
			Document document=Jsoup.connect(str.toString()).get();
		Elements elements=document.select("#Bk_list_tbody tr td");
		for (Element element:elements) {
			System.out.println("検証　"+element);
			
			
		}
		
		
		}catch(Exception e) {
			e.printStackTrace();}
	}
		
		

	/**
	 * 入力情報からテレビ番組の情報を取得する.
	 * 
	 * @return テレビ番組の開始時間の文字列情報
	 */
	public static String getHtml(InputForm form) {

		try {
			// テレビ番組の情報を取得するためのget文を作成
			StringBuilder str = new StringBuilder();
			str.append("https://tv.yahoo.co.jp/search/?q=");
			str.append(form.getTvTitle());
			// ドキュメントクラスの変数を作成し、HTMLを取得
			Document document = Jsoup.connect(str.toString()).get();
			// 指定のタグ要素の情報を検索する
			Elements elements = document.select(".leftarea p em");
			// 検索結果の先頭が見たい番組という前提（本来ならば、検証しないといけない）
			String startTime = elements.get(1).toString().substring(0, elements.get(1).toString().indexOf("～"));
			form.setTvStartTime(startTime);
			

		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return searchTrain(form);
	}

	/**
	 * @param form
	 * @return
	 */
	public static String searchTrain(InputForm form) {
		//時間を時分で分離
		String hour=form.getTvStartTime().substring(0,form.getTvStartTime().indexOf(":"));
		String minuts=form.getTvStartTime().substring(form.getTvStartTime().indexOf(":"),form.getTvStartTime().length());
		//現在の日付を取得
		Date date =new Date();
		SimpleDateFormat yearDateFormat=new SimpleDateFormat("yyyymm");
		SimpleDateFormat mounthDateFormat=new SimpleDateFormat("dd");
		String year=yearDateFormat.format(date);
		String mounth=mounthDateFormat.format(date);
		
		StringBuilder str = new StringBuilder();
		// ジョルダンのリンク長すぎ問題
		str.append("https://www.jorudan.co.jp/norikae/cgi/nori.cgi?eki1=");
		str.append(form.getJobStation());
		str.append("&eki2=");
		str.append(form.getNearestStation());
		// テレビの放送年月をアペンドする
		str.append("&Dym=");
		str.append(year);
		// テレビの放送日をアペンドする
		str.append("&Ddd=");
		str.append(mounth);
		// テレビの放送時間（時）をアペンドする
		str.append("&Dhh=");
		str.append(hour);
		// テレビの放送時間（分）をアペンドする
		str.append("&Dmn1=");
		str.append(minuts);
		// 到着にセットして検索
		str.append("&Cway=1&S=検索");
		// ドキュメントクラスの変数を作成し、HTMLを取得
		try {
			Document document = Jsoup.connect(str.toString()).get();
			Elements elements=document.select("tr td");
			
		} catch (IOException e) {
			e.printStackTrace();

		}
		return "outputForm";

	}

}
