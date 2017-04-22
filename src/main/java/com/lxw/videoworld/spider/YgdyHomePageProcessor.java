package com.lxw.videoworld.spider;

import us.codecraft.webmagic.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zion on 2017/4/18.
 */
public class YgdyHomePageProcessor extends BaseProcessor {
    @Override
    public void process(Page page) {
        super.process(page);
        List<String> urlList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        List<String> urlList1 = page.getHtml().css("div.co_content2").links().all();
        List<String> titleList1 = page.getHtml().css("div.co_content2").css("a").regex(">(.*?)</a>").all();
        List<String> urlList2 = page.getHtml().css("div.co_content4").links().all();
        List<String> titleList2 = page.getHtml().css("div.co_content4").css("a").regex(">(.*?)</a>").all();
        if (urlList1 != null && urlList1.size() > 0) {
            urlList.addAll(urlList1);
        }
        if (urlList2 != null && urlList2.size() > 0) {
            urlList.addAll(urlList2);
        }
        if (titleList1 != null && titleList1.size() > 0) {
            titleList.addAll(titleList1);
        }
        if (titleList2 != null && titleList2.size() > 0) {
            titleList.addAll(titleList2);
        }
        page.putField("urlList", urlList);
        page.putField("titleList", titleList);
    }
}
