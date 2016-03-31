package de.herrlock.manga.util;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.herrlock.javafx.handler.Exec;
import de.herrlock.manga.downloader.DialogDownloader;
import de.herrlock.manga.downloader.PlainDownloader;
import de.herrlock.manga.host.PrintAllHoster;
import de.herrlock.manga.html.ViewPageMain;
import de.herrlock.manga.http.StartWithDesktop;
import de.herrlock.manga.jd.JDExport;

public enum Execs implements Exec {
    DIALOG_DOWNLOADER() {
        @Override
        public void execute() {
            DialogDownloader.execute();
        }
    },
    PLAIN_DOWNLOADER() {
        @Override
        public void execute() {
            PlainDownloader.execute();
        }
    },
    START_SERVER() {
        private final Logger logger = LogManager.getLogger();

        @Override
        public void execute() {
            try {
                StartWithDesktop.main();
            } catch ( ServletException | LifecycleException | IOException | URISyntaxException ex ) {
                this.logger.fatal( ex );
            }
        }
    },
    ADD_TO_JD_W_FILE() {
        @Override
        public void execute() {
            JDExport.executeGetFileProperties();
        }
    },
    VIEW_PAGE_MAIN() {
        @Override
        public void execute() {
            ViewPageMain.execute();
        }
    },
    PRINT_ALL_HOSTER() {
        @Override
        public void execute() {
            PrintAllHoster.execute();
        }
    },
    DO_NOTHING() {
        @Override
        public void execute() {
            // do nothing :)
        }
    };

}
