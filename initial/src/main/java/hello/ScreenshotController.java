package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ScreenshotController {
    
    @RequestMapping("/screenshots")
    public String index(@RequestParam("url") String url) {
        WebsiteCrawler websiteCrawl = new WebsiteCrawler();
        websiteCrawl.crawl(url);
        return url;
    }
    
}
