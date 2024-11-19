package data_access;

import entity.TransactionHistory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Example use case
 * TransactionHistory history = <some history>
 * LoclaDate start = <some start date>
 * LocalDate end = <some end date>
 * 
 * ChartAPI api = new ChartAPI();
 * byte[] image = api.getImage(history, start, end);
 */

public class ChartAPI {
    class ChartData {
        public String[] series;
        public double[] incomes;
        public double[] expenses;

        public ChartData(String[] series, double[] incomes, double[] expenses) {
            this.series = series;
            this.incomes = incomes;
            this.expenses = expenses;
        }
    }

    private String endpoint = "https://quickchart.io/chart/render/zm-203d31f0-9c91-4750-917b-1e888d1bea24";
    private String failImage = "https://steemitimages.com/640x0/http://backofthebook.ca/wp-content/uploads/2013/03/sad-puppy.jpg";

    public ChartAPI() { }

    public byte[] fetchImage(TransactionHistory history, LocalDate start, LocalDate end) {
        return fetchImage(historyToChartData(history, start, end));
    }

    private ChartData historyToChartData(TransactionHistory history, LocalDate start, LocalDate end) {
        var epochStart = start.toEpochDay();
        var epochEnd = end.toEpochDay();

        int numEntries = (int)(epochEnd - epochStart) + 1;

        var series = new String[numEntries];
        var incomes = new double[numEntries];
        var expenses = new double[numEntries];

        for(int epoch = (int)epochStart; epoch <= epochEnd; epoch++) {
            var date = LocalDate.ofEpochDay(epoch);
            
            series[epoch - (int)epochStart] = date.format(DateTimeFormatter.ofPattern("MMMdd"));
            incomes[epoch - (int)epochStart] = history.getIncomeBetween(start, date);
            expenses[epoch - (int)epochStart] = history.getExpensesBetween(start, date);
        }

        return new ChartData(series, incomes, expenses);
    }

    private String joinDoubles(double[] arr) {
        var strArr = new String[arr.length];
        for(int i = 0; i < arr.length; i++) {
            strArr[i] = Double.toString(arr[i]);
        }
        return String.join(",", strArr);
    }

    private URL buildURL(ChartData data) {
        try {
            String urlStr = endpoint + "?f=.png&" + 
                "data1=" + joinDoubles(data.incomes) + "&" +
                "data2=" + joinDoubles(data.expenses) + "&" +
                "labels=" + String.join(",", data.series);
            URL url = URI.create(urlStr).toURL();
            return url;
        } catch (MalformedURLException e) {
            try {
                return URI.create(failImage).toURL();
            } catch (MalformedURLException e2) {
                throw new RuntimeException("something has gone terribly wrong");
            }
        }
    }

    public byte[] fetchImage(ChartData data) {
        try {
            URL url = buildURL(data);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "image/png");
            connection.setDoOutput(true);
    
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.flush();
            out.close();

            System.err.println("downloading chart");

            return connection.getInputStream().readAllBytes();
        } catch (IOException err) {
            System.out.println("failed");
            return new byte[0];
        }
    }
}