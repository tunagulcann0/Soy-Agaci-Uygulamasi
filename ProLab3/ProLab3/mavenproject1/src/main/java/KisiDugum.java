import java.text.*;
import java.util.*;
import com.opencsv.bean.CsvBindByName;

public class KisiDugum {
    List<KisiDugum> cocuklar = new ArrayList<>();
    KisiDugum partner = null;
    KisiDugum mother = null;
    KisiDugum father = null;
    public void setId(String id) {
        this.id = id;
    }
    public void setKizlikSoyIsmi(String kizlikSoyIsmi) {
        this.kizlikSoyIsmi = kizlikSoyIsmi;
    }

    void yasHesapla() throws ParseException {
        if (getDogumTarihi() == null) {
            setDogumTarihi("05/05/1985");
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse(this.getDogumTarihi());
        Date simdikiZaman = new Date();
        long zamanFarki = simdikiZaman.getTime() - date.getTime();
        this.yas = (zamanFarki / (1000l * 60 * 60 * 24 * 365));
    }
    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    @CsvBindByName(column = "id", required = true)
    private String id;

    @CsvBindByName(column = "İsim", required = true)
    private String isim;

    @CsvBindByName(column = "Soyisim", required = true)
    private String soyIsim;

    @CsvBindByName(column = "Doğum Tarihi", required = true)
    private String dogumTarihi;

    @CsvBindByName(column = "Eşi")
    private String es;

    @CsvBindByName(column = "Anne Adı", required = true)
    private String anneAdi;

    @CsvBindByName(column = "Baba Adı", required = true)
    private String babaAdi;

    @CsvBindByName(column = "Kan Grubu", required = true)
    private String kanGrubu;

    @CsvBindByName(column = "Meslek")
    private String meslek;

    @CsvBindByName(column = "Medeni Hali", required = true)
    private String medeniHal;

    @CsvBindByName(column = "Kızlık Soyismi")
    private String kizlikSoyIsmi;

    @CsvBindByName(column = "Cinsiyet", required = true)
    private String cinsiyet;

    @CsvBindByName(column = "Eş İd")
    private String esId;

    public String getId() {
        return this.id;
    }

    public String getIsim() {
        return this.isim;
    }

    public String getSoyIsim() {
        return this.soyIsim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public String getDogumTarihi() {
        return this.dogumTarihi;
    }

    public String getEs() {
        return this.es;
    }

    public String getAnneAdi() {
        return this.anneAdi;
    }

    public String getBabaAdi() {
        return this.babaAdi;
    }

    public String getKanGrubu() {
        return this.kanGrubu;
    }

    public String getMeslek() {
        return this.meslek;
    }

    public String getMedeniHal() {
        return this.medeniHal;
    }

    public String getKizlikSoyIsmi() {
        return this.kizlikSoyIsmi;
    }

    public String getCinsiyet() {
        return this.cinsiyet;
    }

    public String getEsId() {
        return this.esId;
    }

    long yas;

}