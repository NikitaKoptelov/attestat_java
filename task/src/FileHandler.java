import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class FileHandler {
    public static void seve(ArrayList<Map<String,String>> SpisokPunktov) {
        System.out.println("производится сохранение записей в файл");
        try(FileWriter writer = new FileWriter("Save_Data.txt", false))
        {
            for(int i=0; i<SpisokPunktov.size(); i++){
                String TextDannix = i+"/"+ObrabotDannix.SpisokPunktov.get(i).get("Тип игрушки")+"/"+ObrabotDannix.SpisokPunktov.get(i).get("Количество")+"/"+ObrabotDannix.SpisokPunktov.get(i).get("% частоты выпадения");
                writer.write(TextDannix);
                writer.append("\n");
            }
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
        System.out.println("-OK-");

    }

    public static ArrayList<Map<String,String>> read(){
        ArrayList<Map<String,String>> SpisokPunktov = new ArrayList<>();
        System.out.println("чтение из файла");

        File file = new File("Save_Data.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                Komand.ShitivVodDannix(line);
                /*System.out.println(line);*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-OK-"); 
        return SpisokPunktov;
    }

    public static void ZapisPoluchenPrizov (Map<String,String> PunktPriza){
        System.out.println("производится сохранение записей в файл");
        try(FileWriter writer = new FileWriter("Spisok_vidachi_prizov.txt", true))
        {
            String TextDannix = PunktPriza.get("Тип игрушки")+"/ осталось-"+PunktPriza.get("Количество")+"шт. / процент выпадения - "+PunktPriza.get("% частоты выпадения");
            writer.append(TextDannix);
            writer.append("\n");
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
        System.out.println("-OK-");
    }

}
