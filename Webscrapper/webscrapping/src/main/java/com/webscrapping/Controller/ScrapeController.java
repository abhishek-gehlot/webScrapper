package com.webscrapping.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import com.webscrapping.Service.ScraperService;
import com.webscrapping.Model.ScrapeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class ScrapeController {
    
    @Autowired
    private ScraperService scraperService;
    

    @GetMapping("/api/scrape")
    public ScrapeResponse scrape(@RequestParam String url)  throws IOException{
        return scraperService.webScrape(url);
    }

}
