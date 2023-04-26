import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class getresultApi {
   public String getResultApis(String from, String to, int amount) throws MalformedURLException, IOException {
    String url = String.format("https://api.apilayer.com/exchangerates_data/convert?to=%s&from=%s&amount=%d", to, from, amount);
    URL urlFormat = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) urlFormat.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("apikey", "qmNyWPI4HCvaAsAX7nBFQAZ6NFSS4ZEA");
        
    try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        String result = response.toString();
        return getResult(result);
    
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    } finally {
        connection.disconnect();
    }
}

   
   public static String getResult(String result) {
        int resultIndex = result.indexOf("\"result\":"); //buscando la posición de \"result\": en el api
        
        if (resultIndex >= 0) { // si es  el resultado es mayor igual de 0 es por q si tiene datos
         String restoDeApi = result.substring(resultIndex + 10); // guardamos el resto de los valores traidos 
         int TamañoDeResult=restoDeApi.length(); // calculamos el tamano del resultado 
         String resultado=restoDeApi.substring(0,TamañoDeResult-4);// restamos 4 por q es el valor que no queremos
         //System.out.println("result:"+resultado);
         return resultado;
        }else{
            System.out.println("Error al procesar");
        }
        return null;
        
        }
   
  


}
