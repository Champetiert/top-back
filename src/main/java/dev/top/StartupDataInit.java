package dev.top;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;

    @Autowired 
    CollegueRepo collegueRepo;
    
    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        if(this.versionRepo.count() <= 0) {
            this.versionRepo.save(new Version("v1"));
            this.versionRepo.save(new Version("v2"));
            this.versionRepo.save(new Version("v3"));
            this.versionRepo.save(new Version("v4"));
        }
        if(this.collegueRepo.count() <= 0) {
        	List<String>a=new ArrayList<>();
        	List<String>b=new ArrayList<>();
        	List<String>c=new ArrayList<>();
        	List<String>d=new ArrayList<>();
        	List<String>master=new ArrayList<>();
        	a.add("https://wallpapercave.com/wp/wp1811952.jpg");
        	a.add("https://wallpapersite.com/images/pages/pic_w/1799.jpg");
        	a.add("http://hdqwalls.com/wallpapers/skyscraper-movie-10k-ve.jpg");
        	b.add("https://images2.alphacoders.com/485/485496.jpg");
        	b.add("https://images6.alphacoders.com/485/485500.jpg");
        	b.add("https://img.bfmtv.com/c/1000/600/04d3/41cde7346d5fa39b47363d6641b2.jpg");
        	c.add("https://www.wallpapersbrowse.com/images/ne/nekogag.jpg");
        	c.add("http://braindamaged.fr/wp-content/uploads/2017/04/the-expendables-4-arnold-schwarzenegger-quitte-aussi-la-franchise-une.jpg");
        	c.add("https://images.alphacoders.com/294/thumb-1920-294343.jpg");
        	d.add("https://static.ladepeche.fr/content/media/image/zoom/2014/09/11/1637638-sipa-rex43064278-000001.jpg");
        	d.add("http://www.nord-cinema.com/wp-content/uploads/2017/02/le-cinquieme-element.jpg");
        	d.add("https://s22295.pcdn.co/wp-content/uploads/Die-Hard1.jpg");
	
        	master.add("https://stmed.net/sites/default/files/chuck-norris-wallpapers-26561-3401916.jpg");
        	master.add("https://icdn2.digitaltrends.com/image/ex2norris-2000x864.jpg?ver=1");
        	master.add("https://vignette.wikia.nocookie.net/villains/images/d/de/Chuck_Norris_in_Way_of_the_Dragonvillainswiki.jpg/revision/latest?cb=20160212022414");
        	this.collegueRepo.save(new Collegue("Stephane", 300,a));
        	this.collegueRepo.save(new Collegue("Alexis",300,b));
        	this.collegueRepo.save(new Collegue("Florian", 300,c));
        	this.collegueRepo.save(new Collegue("Matthieu",200,d));
        	this.collegueRepo.save(new Collegue("Chuck",1000,master,"Norris","Chuck","ChuckNorris@Chuck.Norris","Chuck Norris Ranch, 77868 Navasota, United States"));
        }

    }
}
