
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;




public class Main {
    
    public static void main(String[] args) throws IOException {

       File f =  new File("C:\\Users\\sehent\\Desktop\\sky.png");

       encoder ENcoder = new encoder();
       String encodstring = ENcoder.encodeFileToBase64Binary(f);
       System.out.println(encodstring);
       code = encodstring;
       
       ENcoder.Escritor(code);
       

     }
        
 private static String code; 
 
}
 
class encoder { 
     
     
     
     
    public String encodeFileToBase64Binary(File file) throws IOException{
         String encodedfile = null;
        try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedfile = Base64.getEncoder().encodeToString(bytes); //encodeBase64(bytes).toString();
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

         return encodedfile;
     }

       public void Escritor (String codigo) {
           
            FileWriter swResultados = null; 
            BufferedWriter br = null; 
            try{
                
                swResultados = new FileWriter("C:\\Users\\sehent\\Desktop\\escritor.txt",true); 
                    br = new BufferedWriter(swResultados);
                    br.write(codigo);
                   // br.newLine();
            } catch (Exception e){}
           
       }
       
       
       
       
       
       
}