package com.example.client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class ClientController {
    
    private CountingsRepository countingsRepository;
    private RestClient restClient;
    private FileOutputStream fos;

    public ClientController (CountingsRepository countingsRepository) {
        this.countingsRepository = countingsRepository;
        restClient = RestClient.create();
        try {
            fos = new FileOutputStream("/Users/tcollings/Documents/virtual.txt", true);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @GetMapping("/count")
    public void doCountWork() {

        doTheCounting();
    }

    @GetMapping("/countVirtual")
    public void doCountWorkVirtual () {
        Thread thread  = Thread.startVirtualThread(() ->
        {
            doTheCounting();
        });
    }

    private void doTheCounting () {
        try {
                long start = Calendar.getInstance().getTimeInMillis();
                int count = restClient.get().uri(new URI("http://localhost:8081/count")).retrieve().body(Integer.class);
                CountEntity ce = new CountEntity(count, "comment");
                countingsRepository.save(ce);
                long end = Calendar.getInstance().getTimeInMillis();
                fos.write(("timing = " + (end - start) + System.lineSeparator()).getBytes());
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

}
