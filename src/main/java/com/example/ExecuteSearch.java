package com.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * HTML情報を取得するクラス.
 * 
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/search")
public class ExecuteSearch {

	
	@RequestMapping("")
	public String showInputForm() {
		return "inputForm";
		
	}
		
		

	/**
	 * 入力情報からテレビ番組の情報を取得する.
	 * 
	 * @return テレビ番組の開始時間の文字列情報
	 */
	@RequestMapping("/html")
	public static String getHtml(InputForm form,Model model) {

		try {
			// テレビ番組の情報を取得するためのget文を作成
			StringBuilder str = new StringBuilder();
			str.append("https://tv.yahoo.co.jp/search/?q=");
			str.append(form.getTvTitle());
			// ドキュメントクラスの変数を作成し、HTMLを取得
			Document document = Jsoup.connect(str.toString()).get();
			// 指定のタグ要素の情報を検索する
			Elements timeElements = document.select(".leftarea p em");
			Elements titleElements = document.select(".yjLS.pb5p a");
			// 検索結果の先頭が見たい番組という前提（本来ならば、検証しないといけない）
			String startTime = timeElements.get(1).ownText().toString().substring(0, timeElements.get(1).ownText().toString().indexOf("～"));
			String tvTitle=titleElements.get(0).ownText().toString();
			form.setTvStartTime(startTime);
			form.setTvTitle(tvTitle);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return searchTrain(form,model);
	}
	/**
	 * @param form
	 * @return
	 */
	public static String searchTrain(InputForm form,Model model) {
		//時間を時分で分離
		String hour=form.getTvStartTime().substring(0,form.getTvStartTime().indexOf(":"));

		String minuts1=form.getTvStartTime().substring(form.getTvStartTime().indexOf(":")+1,form.getTvStartTime().length()-1);
		String minuts2=form.getTvStartTime().substring((form.getTvStartTime().indexOf(":")+2),form.getTvStartTime().length());

		//現在の日付を取得
		Date date =new Date();
		SimpleDateFormat yearDateFormat=new SimpleDateFormat("yyyyMM");
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
		str.append(minuts1);
		str.append("&Dmn2=");
		str.append(minuts2);
		// 到着にセットして検索
		str.append("&Cway=1&S=検索");
		
		// ドキュメントクラスの変数を作成し、HTMLを取得
		OutputDomain outputDomain=null;
		List<OutputDomain> outputDomainList=new ArrayList<>();
		try {
			Document document = Jsoup.connect(str.toString()).get();
			Elements rootElements=document.select(".bk_result h3");
			Elements urlElements=document.select(".bk_result .print");
			for(int i=0;i<rootElements.size();i++) {
				outputDomain=new OutputDomain();
				outputDomain.setRoot(rootElements.get(i).ownText().toString());
				outputDomain.setUrl(urlElements.get(i).absUrl("href").toString());
				outputDomainList.add(outputDomain);
			}
			model.addAttribute("outputDomainList",outputDomainList);
			model.addAttribute("title",form.getTvTitle());
			model.addAttribute("time",form.getTvStartTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "outputForm";
	}
}
