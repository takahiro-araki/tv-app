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
		return "outputForm";
		
	}
	


}
