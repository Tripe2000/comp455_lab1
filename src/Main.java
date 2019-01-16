import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while(true) {
            String inputRaw = reader.nextLine();
            String[] input = inputRaw.split("\\s+");
            if(input[0].equals("httpc")){
                if(input[1].equals("get")) { sendGET(); }
                else if(input[1].equals("post")) { sendPOST(); }
                else { System.out.println("unknown cmd"); }
            } else { System.out.println("unknown cmd"); }
        }
        reader.close();
    }

    private static void sendGET() {
        try {
            URL obj = new URL("http://www.httpbin.org/");

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);

            System.out.println("GET Response Code :: " + con.getResponseCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendPOST() {
        try {
            URL obj = new URL("http://www.httpbin.org/");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);

            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            final String POST_PARAMS = "paramName=paramValue";
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            System.out.println("POST Response Code :: " + con.getResponseCode());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
