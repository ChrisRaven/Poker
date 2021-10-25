
package com.company;

// moduły zaproponowane przez IntelliJ
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    // Źródło: https://www.baeldung.com/java-http-request
    public static void main(String[] args) throws IOException {
        // nowy obiekt URL
        URL url = new URL("http://google.com");
        // połączenie ze wskazanym adresem URL
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // konwersja bajtów na znaki tekstowe - tej części nie do końca rozumiem, ale ważne, że działa ;)
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        // zapisywanie strumienia do stringu (IntelliJ proponuje użycie StringBuildera, ale poniższa forma jest IMHO czytelniejsza)
        String inputLine, content = null;
        while ((inputLine = in.readLine()) != null) {
            content += inputLine;
        }

        // wydruk na ekran - wydrukuje kod źródłowy strony google.com (dostępny w przeglądarce pod skrótem Ctrl + U)
        System.out.println(content);

        // zamknięcie buforu i połączenia
        in.close();
        con.disconnect();
    }
}
