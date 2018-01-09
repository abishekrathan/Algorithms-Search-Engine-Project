
package SearchEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import ComplxStruct.ComplxStruct;


public class SearchEngine {
	
	
	static ComplxStruct complxStruct;
	static String []ocList;
	static String input[];
	public static void main(String[] args) {
		ocList = new String[5];
		input = new String[5];
		ocList[0]="http://espnfc.us";
		ocList[1]="http://www.espnfc.us/scores";
		ocList[2]="http://www.espnfc.us/transfers/news";
		ocList[3]="http://www.espnfc.us/video";
		ocList[4]="http://www.espn.com/";
		
		int index = 0;
		for(String ocl : ocList){
			
		
		URL url;
		URLConnection conn;
		BufferedReader br;
		try {
			url = new URL(ocl);
			conn = url.openConnection();

	        // open the stream and put it into BufferedReader
	        br = new BufferedReader(
	                           new InputStreamReader(conn.getInputStream()));
	        String inputLine ="";
            while (br.readLine() != null) {
                    
            	inputLine = inputLine+ ""+ br.readLine();
            }
            input[index] = ""+inputLine;
            br.close();
            index++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		System.out.println("Please Wait....");
		complxStruct = new ComplxStruct(5, input);
		complxStruct.insert();
		
		
		Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the words: ");
			scanner=new Scanner(System.in);
			String input = "" + scanner.nextLine();
			scanner.close();
			
			ArrayList<String> res = complxStruct.search(input.toLowerCase());
			System.out.println("Search Results:");
			if(!res.isEmpty()){
				for(String r: res){
					System.out.println(ocList[Integer.parseInt(r)]);
				}
			}
			else
				System.out.println("Not Found!");
			
		
			
	}
}
