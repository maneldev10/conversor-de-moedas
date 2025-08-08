import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    // Coloque sua chave da ExchangeRate-API aqui
    private static final String API_KEY = "cf184e6bd9949cd99d6454a9";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double fetchRate(String baseCurrency, String targetCurrency) throws Exception {
        String urlStr = BASE_URL + baseCurrency.toUpperCase();
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Erro na conexão: HTTP " + conn.getResponseCode());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        JSONObject json = new JSONObject(response.toString());

        if (!json.getString("result").equals("success")) {
            throw new RuntimeException("Erro da API: " + json);
        }

        JSONObject rates = json.getJSONObject("conversion_rates");
        return rates.getDouble(targetCurrency.toUpperCase());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Conversor de Moedas ===");
            System.out.print("Moeda de origem (ex: USD, BRL, EUR): ");
            String from = scanner.nextLine().trim();

            System.out.print("Moeda de destino (ex: USD, BRL, EUR): ");
            String to = scanner.nextLine().trim();

            System.out.print("Valor a converter: ");
            double amount = scanner.nextDouble();

            double rate = fetchRate(from, to);
            double converted = amount * rate;

            System.out.printf("%.2f %s = %.2f %s%n", amount, from.toUpperCase(), converted, to.toUpperCase());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
