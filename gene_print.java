import edu.duke.*;
public class gene_print {
    private void gene_detect(String dna){
        int i_taa = 0, i_tag = 0, i_tga = 0, i_least = 0, s_index = 0;
        while(s_index != -1 || i_least != -1){
            System.out.println("Looped boi!");
            s_index = dna.indexOf("atg",i_taa);
            i_taa = dna.indexOf("taa",s_index+3);
            i_tag = dna.indexOf("tag",s_index+3);
            i_tga = dna.indexOf("tga",s_index+3);
            i_least = Math.min(i_taa,Math.min(i_tag,i_tga));
            while(i_least == -1){
                if(i_taa == -1){
                    i_least = Math.min(i_tag,i_tga);
                    i_taa = 99999999;
                }
                else if (i_tag == -1){
                    i_least = Math.min(i_taa,i_tga);
                    i_tag = 99999999;
                }
                else if (i_tga == -1){
                    i_least = Math.min(i_taa,i_tag);
                    i_tga = 99999999;
                }
                break;
            }
            i_taa = dna.indexOf("taa",s_index+3);
            i_tag = dna.indexOf("tag",s_index+3);
            i_tga = dna.indexOf("tga",s_index+3);
            if (s_index == -1 || i_least == -1){
                System.out.println(" ");
                break;
            }
            while(i_least != dna.length() && i_least != -1){
 
                if ((i_least - s_index) % 3 == 0 && s_index != -1){
                    System.out.println("The gene is: " + dna.substring(s_index,i_least+3));
                    s_index = i_least+3;
                    break;
                }
                else {
                    if(i_least == i_taa)
                    i_least = Math.min(i_tag,i_tga);
                    else if (i_least == i_tag)
                    i_least = Math.min(i_taa,i_tga);
                    else if (i_least == i_tga)
                    i_least = Math.min(i_taa,i_tag);
                    else {
                        /*i_taa = dna.indexOf("taa",i_taa+1);
                        i_tag = dna.indexOf("tag",i_tag+1);
                        i_tga = dna.indexOf("tga",i_tga+1);*/
                        break;                        
                    }
                }
            }
        }
    }
    public void main(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        System.out.println("Length of dna is:" + dna.length());
        System.out.println("DNA is:" + dna);
        gene_detect(dna);
    }
  
}
