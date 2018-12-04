package dev.top;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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
        	this.collegueRepo.save(new Collegue("Stephane", 300,"https://wallpapercave.com/wp/wp1811952.jpg"));
        	this.collegueRepo.save(new Collegue("Alexis",300,"https://images2.alphacoders.com/485/485496.jpg"));
        	this.collegueRepo.save(new Collegue("Florian", 300,"https://www.wallpapersbrowse.com/images/ne/nekogag.jpg"));
        	this.collegueRepo.save(new Collegue("Matthieu",200,"https://static.ladepeche.fr/content/media/image/zoom/2014/09/11/1637638-sipa-rex43064278-000001.jpg"));
        }

    }
}
