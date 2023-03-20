import java.util.Scanner;

public class Komand {
    
    static Scanner scanner = new Scanner(System.in);
    static String VvodDannix="";

    public static void komandOK(){
        System.out.println("-ok-");
    }
    public static void obrabotkaKonsol(String komandKonsol, String DannieK) {
        String SOobshenieK = "";

        if(komandKonsol.equals("")){}
        else if (komandKonsol.equals("сохранить")){
            SOobshenieK="-производиться запись-";

            FileHandler.seve(ObrabotDannix.SpisokPunktov);
            /*FileHandler.seve(ObrabotDannix.SpisokPunktov);*/

        }
        else if(komandKonsol.equals("считать из файла")){
            ObrabotDannix.SpisokPunktov.clear();
            FileHandler.read();
            /*ObrabotDannix.SpisokPunktov = FileHandler.read();*/
        }
        else if(komandKonsol.equals("пуск")){
            ObrabotDannix.SpisokPunktov.clear();
            FileHandler.read();
            /*ObrabotDannix.SpisokPunktov = FileHandler.read();*/
        }
        else if(komandKonsol.equals("добавить")){
            SOobshenieK="-введите данные для добавления через разделительный символ <</>>-";
            System.out.println(SOobshenieK);
            VvodDannix = scanner.nextLine();
            ShitivVodDannix(VvodDannix);
        }
        else if(komandKonsol.equals("удалить строку")){
            SOobshenieK="-введите номер строки для удаления-";
            System.out.println(SOobshenieK);
            int IndexUdall = Integer.parseInt(scanner.nextLine());
            ObrabotDannix.Udalenie(ObrabotDannix.SpisokPunktov, IndexUdall);
        }
        else if(komandKonsol.equals("редактировать шанс выпадения")){
            SOobshenieK="-введите номер строки и шанс выпадения через разделительный символ <</>>-";
            System.out.println(SOobshenieK);
            String RedaktDannixx = scanner.nextLine();
            if((RedaktDannixx.split("/")).length==2){
                String[] RedaktDannie = RedaktDannixx.split("/");
                ObrabotDannix.RedactirShansaVipad(ObrabotDannix.SpisokPunktov, Integer.parseInt(RedaktDannie[0]), RedaktDannie[1]);
            }
            else{
                SOobshenieK="---------------------\n| не верная команда |\n| поробуйте еще раз |\n---------------------";
                System.out.println(SOobshenieK);
            }
        }
        else if(komandKonsol.equals("получить приз")){
            ObrabotDannix.VidachaPrizov(ObrabotDannix.SpisokPunktov);
        }
        else{
            SOobshenieK="---------------------\n| не верная команда |\n| поробуйте еще раз |\n---------------------";
        }
        Viver.VievKonsol(null,SOobshenieK);

    }
    public static Integer komandExid(String komandKonsol) {
        int varPerem = 0;
        if(komandKonsol.equals("выход")){
            varPerem=1;
        }
        return varPerem;
    }
    public static void ShitivVodDannix(String komandKonsolK){
        if((komandKonsolK.split("/")).length==4){
            String[] VvedenDannie = komandKonsolK.split("/");
            int IDS = Integer.parseInt(VvedenDannie[0]);
            String NaemS = VvedenDannie[1];
            String KollS = VvedenDannie[2];
            String ChastotiVipadS = VvedenDannie[3];
            ObrabotDannix.DanniePriz(IDS,NaemS,KollS,ChastotiVipadS);
        }
        else{
            String SOobshenieK="---------------------\n| не верная команда |\n| поробуйте еще раз |\n---------------------";
            System.out.println(SOobshenieK);
        }
        

    }
}
