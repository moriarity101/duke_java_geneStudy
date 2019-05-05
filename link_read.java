import java.io.*; 
public class link_read{
    public static void main(String[] args)throws Exception 
  { 
  
  File file = new File("H:\\text.txt"); 
  
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  String st; 
  while ((st = br.readLine()) != null) {
      int s_index = st.indexOf("youtube.com");
      if (s_index != -1 || s_index != 0){
          s_index = st.indexOf("\"https");
          int e_index = st.indexOf("\"", s_index+1);
          System.out.println(st.substring(s_index+1,e_index));
        }              
    }
  }
} 