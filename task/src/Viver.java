public class Viver {
    static String strokaDannix = "";
    static int countPovtor=0;
    static String strokaDannixZag ="";
    static String IDVid = "ID";
    static String TipIgrushkiVid = "Тип игрушки";
    static String KollichestVid = "Количество";
    static String ChastotaVipadVid = "% частоты выпадения";

    public static void VievKonsol(String dannie, String SOobshenie) {
        String strokaDannix = "";
        String strokaDannixZag = "| "+IDVid+" | "+TipIgrushkiVid+" | "+KollichestVid+" | "+ChastotaVipadVid+" |"; 
        int countPovtor=0;
        
        for(int i=0; i<strokaDannixZag.length(); i++){
            countPovtor++;
        }

        strokaDannix = "-".repeat(countPovtor);
        System.out.println(strokaDannix);
        System.out.println(strokaDannixZag);
        strokaDannix = "-".repeat(countPovtor);
        System.out.println(strokaDannix);
        if(ObrabotDannix.SpisokPunktov.size() !=0){
            for(int i=0; i<ObrabotDannix.SpisokPunktov.size(); i++){
                VievKonsolDannie(i, ObrabotDannix.SpisokPunktov.get(i).get("Тип игрушки") , ObrabotDannix.SpisokPunktov.get(i).get("Количество"), ObrabotDannix.SpisokPunktov.get(i).get("% частоты выпадения"));
                System.out.println("-".repeat(countPovtor));
            }
        }
        else{
            PrintNull(countPovtor);
        }
    }

    public static void VievKonsolDannie(int IDSpiskaV, String NaemV, String KollV, String VipadenieV){
        String StokaDannixV = "| "+IDSpiskaV+" ".repeat(OtstupStr(IDVid)-OtstupStr(Integer.toString(IDSpiskaV)))+" | "+NaemV+" ".repeat(OtstupStr(TipIgrushkiVid)-OtstupStr(NaemV))+" | "+KollV+" ".repeat(OtstupStr(KollichestVid)-OtstupStr(KollV))+" | "+VipadenieV+" ".repeat(OtstupStr(ChastotaVipadVid)-OtstupStr(VipadenieV))+" |";
        System.out.println(StokaDannixV);
        
    }

    public static void PrintNull(int countPovtor){
        System.out.println("|"+" ".repeat(countPovtor-2)+"|");
        System.out.println("-".repeat(countPovtor));
    }

    public static int OtstupStr (String PeremenStrDannix){
        int Otstup=0;
        for(int i=0; i<PeremenStrDannix.length(); i++){
            Otstup++;
        }
        return Otstup;
    }
}
