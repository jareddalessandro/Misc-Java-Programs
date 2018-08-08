package Networking_HighLevelAPI;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Making a url by combining URIs
public class URItoURL {

    public static void main(String[] args) {
        try {
            // URI uri = new URI("https://username:password@myserver.com:5000/catalog/phones?os=android#samsung");
            URI baseURi = new URI("https://username:password@myserver.com:5000");
            URI uri1 = new URI("/catalog/phones?os=android#samsung");
            URI uri2 = new URI("/catalog/tv?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedURi1 = baseURi.resolve(uri1);
            URI resolvedURi2 = baseURi.resolve(uri2);
            URI resolvedURi3 = baseURi.resolve(uri3);

            URL url1 = resolvedURi1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedURi2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedURi3.toURL();
            System.out.println("URL 3 = " + url3);

//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific-part" + uri.getSchemeSpecificPart());
//            System.out.println("Authority " + uri.getAuthority());
//            System.out.println("User Info " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());

        } catch (URISyntaxException e) {
            System.out.println("URI is Bad: " + e.getMessage());
        } catch(MalformedURLException e) {
            System.out.println("Bad URL: " + e.getMessage());
        }
    }
}
