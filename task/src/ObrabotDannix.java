import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class ObrabotDannix {
    static ArrayList<Map<String,String>> SpisokPunktov = new ArrayList<>();
    static int IDSpiska = 0;
    
    public static void DanniePriz(int IDSpiska, String Naem, String Koll, String Vipadenie){
        Map<String,String> DicXarac = new HashMap<>();
        DicXarac.put("Тип игрушки", Naem);
        DicXarac.put("Количество", Koll);
        DicXarac.put("% частоты выпадения", Vipadenie);
        SpisokPunktov.add(IDSpiska,DicXarac);
    }

    public static void Udalenie(ArrayList<Map<String,String>> SpisokPunktov, int IdUdalSpiska){
        SpisokPunktov.remove(IdUdalSpiska);
    }

    public static void RedactirShansaVipad(ArrayList<Map<String,String>> SpisokPunktov, int IdUdalSpiska, String ChastotaVipad){
        SpisokPunktov.get(IdUdalSpiska).replace("% частоты выпадения", ChastotaVipad);
    }

    public static void VidachaPrizov(ArrayList<Map<String,String>> SpisokPunktov) {

        // String[] SpisokPunktov = SpisokPunktov; // Числа
        int Dlina = SpisokPunktov.size();
        int[] chance = new int[Dlina]; // Количество
        for(int i=0; i<SpisokPunktov.size(); i++){
            chance[i]= Integer.parseInt(SpisokPunktov.get(i).get("% частоты выпадения"));
        }

        int count = IntStream.of(chance).sum(); // Считаем количество элементов воображаемого массива

        // Вывод вероятностей:
        // for (int i = 0; i < chance.length; i++) {
        //     System.out.println("Вероятность числа \"" + SpisokPunktov.get(i) + "\":  \t" + (chance[i]) + "%");
        // }
        
        // Генерация случайного числа
        Random random = new Random();
        for (int randomNumsCount = 0; randomNumsCount < 1; randomNumsCount++) {
            
            int index = random.nextInt(count); // Выбираем случайный индекс из воображаемого массива

            for (int i = 0; i < chance.length; i++) { // Ищем элемент, которому принадлежит этот индекс
                index -= chance[i];
                if(index < 0) {
                    // System.out.println("Случайное число: " + SpisokPunktov.get(i));
                    int KollChislo = Integer.parseInt(SpisokPunktov.get(i).get("Количество"))-1;
                    SpisokPunktov.get(i).replace("Количество", Integer.toString(KollChislo));
                    FileHandler.ZapisPoluchenPrizov(SpisokPunktov.get(i));
                    if(KollChislo==0){
                        Udalenie(SpisokPunktov, i);
                    }
                    break;
                }
            }

        }
    }
}
