import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String POST_URL = "http://localhost:9090/SpringMVCExample/home";
    private static final String POST_PARAMS = "userName=Pankaj";

    public static void main(String[] args) {
        sendGET();
    }

    private static void sendGET() {
        try {
            URL obj = new URL("http://www.httpbin.org/");

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();

            System.out.println("GET Response Code :: " + responseCode);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
