package stockanalyzer.ctrl;

import yahooApi.YahooFinance;
import yahooApi.beans.QuoteResponse;
import yahooApi.beans.YahooResponse;
import yahoofinance.Stock;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Controller {
		
	public void process(String ticker) {
		System.out.println("Start process");

		//TODO implement Error handling
		//TODO implement methods for
		//1) Daten laden
		//2) Daten Analyse

		YahooFinance yahooFinance = new YahooFinance();
		List<String> tickers = Arrays.asList(ticker);
		YahooResponse response = yahooFinance.getCurrentData(tickers);
		QuoteResponse quotes = response.getQuoteResponse();
		quotes.getResult().stream().forEach(quote -> System.out.println(quote.getAsk()));



		Stock stock = null;
		try{
			stock = yahoofinance.YahooFinance.get(ticker);
			stock.getHistory().forEach(System.out::println);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	public Object getData(String searchString) {

		
		return null;
	}


	public void closeConnection() {
		
	}
}
