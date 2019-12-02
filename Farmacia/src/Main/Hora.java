package Main;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;



public class Hora {
  
  public String hora() {
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	String hora=dateFormat.format(date);
	return hora;	  
  }  
}