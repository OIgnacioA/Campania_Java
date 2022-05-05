
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;




public class Main {
    
    public static void main(String[] args) throws IOException {

       File f =  new File("C:\\Users\\oscar.avendano\\Desktop\\imgs\\foto.png");

       encoder ENcoder = new encoder();
       String encodstring = ENcoder.encodeFileToBase64Binary(f);
       System.out.println(encodstring);

     }
        
 private static String code; 
 
}
 
class encoder { 
     
     
     
     
    public String encodeFileToBase64Binary(File file) throws IOException{
         String encodedfile = null;
        try {
            
           
            
            FileInputStream fIS = new FileInputStream(file);

            byte[] bytes = new byte[(int)file.length()];
            
            fIS.read(bytes);
            
            encodedfile = Base64.getEncoder().encodeToString(bytes); //encodeBase64(bytes).toString();
             
             
            
            
          /*byte src[] = Files.readAllBytes(Paths.get("C:\\Users\\oscar.avendano\\Desktop\\foto.png"));
          byte dst[] = Base64.getEncoder().encode(src);*/
         //Base64.Encoder enc = Base64.getEncoder();        
         
         
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
            Escritor(encodedfile);
         return encodedfile;
     }

    
    
    
       public void Escritor (String codigo) {
           
            FileWriter swResultados = null; 
            BufferedWriter br = null; 
            try{
                
                swResultados = new FileWriter("C:\\Users\\oscar.avendano\\Desktop\\escritor.txt",true); 
                    br = new BufferedWriter(swResultados);
                    br.write(codigo);
                   // br.newLine();
            } catch (Exception e){}
           
       }
       
       
       
       
       
       
}