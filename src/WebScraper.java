import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        String script = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] newscript = script.split("\\s+");
        System.out.println((newscript.length));
        String lookfor = "the";
        String lookfor1 = lookfor.toLowerCase();
        String lookfor2 = lookfor.toUpperCase();
        int howMany = 0;
        for (int counter = 0; counter < newscript.length; counter++) {
            if (newscript[counter].startsWith(lookfor) || newscript[counter].startsWith(lookfor1) || newscript[counter].startsWith(lookfor2)) {
                howMany += 1;
            }
        }
        System.out.println(howMany);
    }

}
