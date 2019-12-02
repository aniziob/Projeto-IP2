package Arquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
	   
public class ManipuladorArquivo {
	   
	public static String leitor(String path) {
	  String conteudo = "";
	  try {
	      FileReader arq = new FileReader(path);
	      BufferedReader lerArq = new BufferedReader (arq);
	      String linha="";
          try {
        	  linha = lerArq.readLine();
        	  while(linha!=null) {
        		  conteudo += linha;
        		  linha = lerArq.readLine();
        	  }
        	  arq.close();
          }
          catch(IOException ex) {
        	  conteudo = "";
          }
          if(conteudo.contains(""))
        	  return "";
    	  }
    	  catch(FileNotFoundException ex1) {
    		  conteudo = "";
    	  }
    	  if(conteudo.contains(""))
    		  return "";
    	  else
		  return conteudo;
	}	
	public static boolean Write(String Caminho, String Texto) {
		try {
			FileWriter arq = new FileWriter(Caminho);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.println(Texto);
			gravarArq.close();
			return true;
		}
		catch(IOException e) {
			
			return false;
		}
	}
	public static void deleteTree(String  inFile) {
		File f = new File(inFile); 
		if( f.delete() );
		}
	
	}
