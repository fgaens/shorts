package be.codesolutions.airhacks.default_browser;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class OpenInBrowser {

    public static void main(String[] args) throws IOException {
        URI uri = URI.create("https://www.codesolutions.be");
        Desktop.getDesktop().browse(uri);
    }
}
