package id.co.gesangmultimedia.sergap;

public class SargapActivity extends KoneksiActivity {
    String URL = " https://gesangmultimedia.co.id/sar-operator/server.php";
    String url = "";
    String response = "";

    public String tampilSargap(){
        try {
            url = URL + "?operasi=view";
            System.out.println("URL Tampil Sargap :" + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }

    public String tampilPolsek(){
        try {
            url = URL + "?operasi=viewpolsek";
            System.out.println("URL Tampil Polsek :" + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }

    public String insertSargap(String latitude, String longitude, String notelp){
        try{
            url = URL + "?operasi=insert";
            System.out.println("URL Insert Sargap :" + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
}
