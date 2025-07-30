package be.codesolutions.airhacks.desktop;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class Browser {

    public static void main(String[] args) throws IOException {
        URI uri = URI.create("https://www.codesolutions.be");
        Desktop.getDesktop().browse(uri);
    }
}
