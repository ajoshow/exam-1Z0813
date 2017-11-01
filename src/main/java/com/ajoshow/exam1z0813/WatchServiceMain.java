package com.ajoshow.exam1z0813;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService ws = FileSystems.getDefault().newWatchService();

        Path dir = Paths.get("src/main/resources");
        dir.register(ws, ENTRY_CREATE,
                ENTRY_DELETE,
                ENTRY_MODIFY);

        // this loop let program keeps watch...
        for(;;){
            WatchKey key = ws.take();

            for(WatchEvent<?> event : key.pollEvents()){
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                if(ev.kind() == ENTRY_CREATE){
                    System.out.println("CREATED: " + ev.context().toString());
                }else if(ev.kind() == ENTRY_DELETE){
                    System.out.println("DELETED: " + ev.context().toString());
                }else if(ev.kind() == ENTRY_MODIFY){
                    System.out.println("MODIFY: " + ev.context().toString());
                }else{
                    // OVERFLOW
                    System.out.println("OVERFLOW");
                }
            }

            // important! use reset to change watch state from signalled to ready.
            boolean valid = key.reset();

            // is invalid when watch service is closed, canceled, or directory is inaccessible
            if(!valid){
                break; // exit if the key is no longer valid
            }
        }

    }



}
