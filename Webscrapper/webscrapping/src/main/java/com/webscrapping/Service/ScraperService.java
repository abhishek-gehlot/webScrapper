package com.webscrapping.Service;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.webscrapping.Model.ScrapeResponse;
import com.webscrapping.Controller.ScrapeController;
import com.webscrapping.WebscrappingApplication;


@Service
public class ScraperService {

    public ScrapeResponse webScrape(String url) throws IOException{
    Document doc=Jsoup.connect(url).get();

    List<String> images=new ArrayList<>();
    List<String> videos=new ArrayList<>();
    List<String> links=new ArrayList<>();

    // Elements img=doc.select("a[href]");
    for(Element img:doc.select("img")){
        String src=img.absUrl("src");
        if(!src.isEmpty()){
            images.add(src);
        }
    }
    for(Element video:doc.select("video source")){
        String src=video.absUrl("src");
        if(!src.isEmpty()){
            videos.add(src);
        }
    }

    for(Element link:doc.select("a[href]")){
        String href=link.absUrl("href");
        if(!href.isEmpty()){
            links.add(href);
        }
    }
    ScrapeResponse response=new ScrapeResponse();
    response.setImages(images);
    response.setVideos(videos);
    response.setLinks(links);

    return response;
  }
}