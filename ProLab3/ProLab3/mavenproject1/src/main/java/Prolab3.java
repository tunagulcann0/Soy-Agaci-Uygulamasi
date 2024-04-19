import com.opencsv.bean.CsvBindByName;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.JList.DropLocation;

import org.apache.commons.collections.ArrayStack;

import com.opencsv.bean.CsvToBeanBuilder;

public class Prolab3 {
    static int sayac = 0;

    public static void main(String[] args) throws ParseException {
        SoyAgaciSwing soyAgaciSwing = new SoyAgaciSwing();
        Scanner scan = new Scanner(System.in);
        try {
            List<String> idcontrol = new ArrayList<>();
            List<KisiDugum> kangrubuayni = new ArrayList<>();
            List<KisiDugum> a1 = new CsvToBeanBuilder<KisiDugum>(
                    new FileReader("/Users/tunagulcan/Desktop//Sayfa1.csv"))
                    .withType(KisiDugum.class).build().parse();
            List<KisiDugum> a2 = new CsvToBeanBuilder<KisiDugum>(
                    new FileReader("/Users/tunagulcan/Desktop/Sayfa2.csv"))
                    .withType(KisiDugum.class).build().parse();
            List<KisiDugum> a3 = new CsvToBeanBuilder<KisiDugum>(
                    new FileReader("/Users/tunagulcan/Desktop/Sayfa3.csv"))
                    .withType(KisiDugum.class).build().parse();
            List<KisiDugum> a4 = new CsvToBeanBuilder<KisiDugum>(
                    new FileReader("/Users/tunagulcan/Desktop/Sayfa4.csv"))
                    .withType(KisiDugum.class).build().parse();
            for (KisiDugum a : a1)
                AgacYapisi.kisiler.add(a);
            for (KisiDugum a : a2)
                AgacYapisi.kisiler.add(a);
            for (KisiDugum a : a3)
                AgacYapisi.kisiler.add(a);
            for (KisiDugum a : a4)
                AgacYapisi.kisiler.add(a);
            AgacYapisi.root = AgacYapisi.kisiler.get(0);
            int ssyac = 0;
            KisiDugum gecici = AgacYapisi.root;
            int saa = 100;
            int sa = 800;
            int kontrols = 0;
            for (KisiDugum node : AgacYapisi.kisiler) {
                sayac = 0;
                if (node.getMedeniHal().equals("Evli") || node.getMedeniHal().equals("Dul")) {
                    for (KisiDugum a : AgacYapisi.kisiler) {
                        if (node.getMedeniHal().equals("Evli")) {
                            if (a.getId().equals(node.getEsId())) {
                                sayac = 1;
                            }
                        }
                    }
                    if (sayac == 1) {
                        for (KisiDugum node2 : AgacYapisi.kisiler) {
                            if (node.getEsId().equals(node2.getId())) {
                                kontrols = AgacYapisi.kisiler.indexOf(node2);
                                break;
                            }
                        }
                        node.partner = AgacYapisi.kisiler.get(kontrols);
                    } else {
                        String[] esIsım = node.getEs().split(" ");
                        node.partner = new KisiDugum();
                        node.partner.setIsim(esIsım[0]);
                        if (esIsım.length > 1) {
                            node.partner.setSoyIsim(esIsım[1]);
                        }
                        if (node.getCinsiyet().equals("Erkek")) {
                            node.partner.setKizlikSoyIsmi("");
                        }
                        String yeniid = Integer.toString(sa++);
                        node.partner.setId(yeniid);
                    }
                }
            }
            sa = 0;
            for (KisiDugum kisi1 : AgacYapisi.kisiler) {
                kisi1.yasHesapla();
                int sayac = 0;
                String[] anneismi = kisi1.getEs().split(" ");
                for (KisiDugum kisi2 : AgacYapisi.kisiler) {
                    if (!idcontrol.contains(kisi2.getId())) {
                        if (kisi1.getMedeniHal().equals("Evli") && kisi2.getAnneAdi().equals(anneismi[0])
                                && kisi2.getBabaAdi().equals(kisi1.getIsim())
                                && (kisi2.getSoyIsim().equals(kisi1.getSoyIsim())
                                        || kisi2.getKizlikSoyIsmi().equals(kisi1.getSoyIsim()))) {
                            kisi1.cocuklar.add(kisi2);
                            idcontrol.add(kisi2.getId());
                            kisi2.father = kisi1;
                            kisi2.mother = kisi1.partner;
                        }
                        String[] babaismi = kisi1.getEs().split(" ");
                        if (kisi1.getMedeniHal().equals("Evli")) {
                            if (kisi2.getAnneAdi().equals(kisi1.getIsim())
                                    && kisi2.getBabaAdi().equals(babaismi[0])
                                    && (kisi2.getSoyIsim().equals(kisi1.getSoyIsim())
                                            || kisi2.getKizlikSoyIsmi().equals(kisi1.getSoyIsim()))) {
                                kisi1.cocuklar.add(kisi2);
                                idcontrol.add(kisi2.getId());
                                kisi2.mother = kisi1;
                                kisi2.father = kisi1.partner;
                            }
                        }
                    }
                }
                for (KisiDugum kisi : AgacYapisi.kisiler) {
                    kisi.yasHesapla();
                    if (!idcontrol.contains(kisi.getId())) {
                        if (kisi1.getMedeniHal().equals("Evli")
                                && kisi.getBabaAdi().equals(kisi1.getIsim())
                                && (kisi.getSoyIsim().equals(kisi1.getSoyIsim())
                                        || kisi.getKizlikSoyIsmi().equals(kisi1.getSoyIsim()))
                                && kisi.yas < kisi1.yas) {
                            kisi1.cocuklar.add(kisi);
                            idcontrol.add(kisi.getId());
                            kisi.father = kisi1;
                        }
                        if (kisi1.getMedeniHal().equals("Evli")) {
                            if (kisi.getAnneAdi().equals(kisi1.getIsim()) && kisi.yas < kisi1.yas) {
                                if (sayac == 0) {
                                    sayac++;
                                }
                                kisi1.cocuklar.add(kisi);
                                idcontrol.add(kisi.getId());
                                kisi.mother = kisi1;
                            }
                        }
                    }
                }
            }
            while (true) {
                System.out.println("\n\n1-Çocuğu olmayan kişilerin yaş sıralaması.\n" +
                        "2-Üvey kardeşlerin harf sıralaması.\n" +
                        "3-Kan grubu aynı olanların listelenmesi.\n" +
                        "4-Aynı mesleği yapan çocuklar ve torunlar.\n" +
                        "5-Aynı isme sahip kişilerin isimleri ve yaşları.\n" +
                        "6-İki kişiden büyük olanı bulma.\n" +
                        "7-İstenen kişinin soy ağacının gösterilmesi.\n" +
                        "8-Soy ağacının kaç nesilden oluştuğunun gösterilmesi.\n" +
                        "9-İstenen kişiden sonra kaç nesil olduğunun gösterilmesi.\n" +
                        "10-Soyağacı çizdirme.\n" +
                        "0-Çıkış.\n");
                System.out.print("Secim yapınız:");
                int secim = scan.nextInt();
                scan.nextLine();
                if (secim == 0)
                    break;

                switch (secim) {
                    case 1:
                        Stack<KisiDugum> yigin = new Stack<KisiDugum>();
                        List<KisiDugum> cocuguolmayanlar = new ArrayList<>();
                        yigin.push(AgacYapisi.root);
                        while (!yigin.isEmpty()) {
                            KisiDugum islemdugum = yigin.pop();
                            if (islemdugum.cocuklar.size() != 0) {
                                yigin.addAll(islemdugum.cocuklar);
                            } else {
                                cocuguolmayanlar.add(islemdugum);
                                islemdugum.yasHesapla();
                            }
                        }
                        System.out.println("\nÇocuğu olmayan kişiler\n");
                        for (KisiDugum asa : cocuguolmayanlar) {
                            System.out.println(asa.getIsim() + "==>" + asa.yas);
                        }
                        KisiDugum gecicii;
                        int adim = 1;
                        System.out.print("\nBaslangic adimi=  ");
                        for (KisiDugum k : cocuguolmayanlar) {
                            System.out.print(k.yas + "\t");
                        }
                        for (int i = 0; i < cocuguolmayanlar.size(); i++) {
                            System.out.print("\n" + (adim++) + ". adim=  ");
                            int min = i;
                            for (int j = i + 1; j < cocuguolmayanlar.size(); j++) {
                                if (cocuguolmayanlar.get(j).yas < cocuguolmayanlar.get(min).yas) {
                                    min = j;
                                }
                            }
                            gecicii = cocuguolmayanlar.get(i);
                            cocuguolmayanlar.set(i, cocuguolmayanlar.get(min));
                            cocuguolmayanlar.set(min, gecicii);
                            for (KisiDugum aas : cocuguolmayanlar) {
                                System.out.print(aas.yas + "\t");
                            }
                        }
                        break;
                    case 2:
                        Queue<KisiDugum> kuyruk = new ArrayDeque<KisiDugum>();
                        List<KisiDugum> uveykardesler = new ArrayList<>();
                        Set<String> idkontroll = new HashSet<>();
                        kuyruk.add(AgacYapisi.root);
                        while (!kuyruk.isEmpty()) {
                            KisiDugum kisi1 = kuyruk.remove();
                            for (KisiDugum kisi2 : AgacYapisi.kisiler) {
                                if (!kisi1.cocuklar.isEmpty() && !kisi2.cocuklar.isEmpty()) {
                                    if (kisi1.partner.getId().equals(kisi2.getId())) {
                                        for (KisiDugum kiisi1 : kisi1.cocuklar) {
                                            sayac = 1;
                                            for (KisiDugum kiisi2 : kisi2.cocuklar) {
                                                if (kiisi1.getId().equals(kiisi2)) {
                                                    sayac = 0;
                                                }
                                            }
                                            if (sayac == 1) {
                                          //      uveykardesler.addAll()
                                            }
                                        }
                                    }
                                }
                            }
                            if (kisi1.cocuklar.size() != 0) {
                                kuyruk.addAll(kisi1.cocuklar);
                            }
                        }
                        System.out.println("Uvey kardeşler");
                        for (KisiDugum a : uveykardesler) {
                            System.out.println(a.getIsim() + "\t" + a.getId());
                        }
                        break;
                    case 3:
                        kangrubuayni.clear();
                        System.out.print("Lütfen aramak istediğiniz kan grubunun giriniz:");
                        String kangrubu = scan.nextLine();
                        Set<String> kontrol = new HashSet<>();
                        for (KisiDugum kisi : AgacYapisi.kisiler) {
                            if ((kangrubu.compareTo(kisi.getKanGrubu())) != 0) {
                                continue;
                            } else {
                                if (!kontrol.contains(kisi.getId())) {
                                    kangrubuayni.add(kisi);
                                    kontrol.add(kisi.getId());
                                }
                            }
                        }
                        for (KisiDugum a : kangrubuayni) {
                            System.out.println(a.getIsim());
                        }
                        break;
                    case 4:
                        System.out.print("Lutfen id giriniz:");
                        String kisiidsi = scan.nextLine();
                        KisiDugum yeniroot = AgacYapisi.root;
                        int kisisayi = 0;
                        int agakisisayi = 0;
                        for (KisiDugum a : AgacYapisi.kisiler) {
                            if (a.getId().equals(kisiidsi)) {
                                yeniroot = a;
                                break;
                            }
                            kisisayi++;
                        }
                        agakisisayi = Agackisisayisi(AgacYapisi.root, agakisisayi);
                        if (kisisayi >= agakisisayi) {
                            yeniroot = AgacYapisi.kisiler.get(agakisisayi);
                        }
                        Queue<KisiDugum> kuyruks = new ArrayDeque<>();
                        Queue<KisiDugum> kuyruks2 = new ArrayDeque<>();
                        Set<String> idds = new HashSet();
                        List<KisiDugum> aynimeslek = new ArrayList<>();
                        kuyruks.add(yeniroot);
                        sayac = 0;
                        while (!kuyruks.isEmpty()) {
                            kuyruks2.add(yeniroot);
                            KisiDugum a = kuyruks.remove();
                            while (!kuyruks2.isEmpty()) {
                                KisiDugum a22 = kuyruks2.remove();
                                if (!idds.contains(a22.getId())) {
                                    if (a.getMeslek().equals(a22.getMeslek()) && a.getId() != a22.getId()
                                            && a.getMeslek().length() != 0) {
                                        if (sayac == 0) {
                                            aynimeslek.add(a);
                                            idds.add(a.getId());
                                            sayac++;
                                        }
                                        aynimeslek.add(a22);
                                        idds.add(a22.getId());
                                    }
                                }
                                if (!a22.cocuklar.isEmpty()) {
                                    kuyruks2.addAll(a22.cocuklar);
                                }
                            }
                            if (!a.cocuklar.isEmpty()) {
                                kuyruks.addAll(a.cocuklar);
                            }
                        }
                        for (KisiDugum a : aynimeslek) {
                            System.out.println(a.getIsim() + " " + a.getId() + "==>" + a.getMeslek());
                        }
                        break;
                    case 5:
                        Set<String> idkontrol2 = new HashSet<>();
                        Queue<KisiDugum> kuyruk1 = new ArrayDeque<KisiDugum>();
                        List<KisiDugum> aynisimler = new ArrayList<>();
                        kuyruk1.add(AgacYapisi.root);
                        int sayac = 0;
                        while (!kuyruk1.isEmpty()) {
                            KisiDugum a = kuyruk1.remove();
                            for (KisiDugum a22 : AgacYapisi.kisiler) {
                                if (a.getIsim().equals(a22.getIsim())) {
                                    if (a.getId() != a22.getId()) {
                                        if (sayac++ == 0) {
                                            idkontrol2.add(a.getId());
                                            aynisimler.add(a);
                                        }
                                        idkontrol2.add(a22.getId());
                                        aynisimler.add(a22);
                                    }
                                }
                            }
                        }
                        for (KisiDugum a : aynisimler) {
                            a.yasHesapla();
                            System.out.println(a.getIsim() + "\t" + a.yas + "\t" + a.getId());
                        }
                        break;
                    case 6:
                        System.out.print("Lutfen birinci kisinin idsini giriniz.");
                        String birindex = scan.nextLine();
                        System.out.print("Lutfen ikinci kisinin idsini giriniz:");
                        String ikinciindex = scan.nextLine();
                        int birindexx = 0, ikinciindexx = 0;
                        for (KisiDugum k : AgacYapisi.kisiler) {
                            if (k.getId().equals(birindex)) {
                                birindexx = AgacYapisi.kisiler.indexOf(k);
                                break;
                            }
                        }
                        for (KisiDugum k : AgacYapisi.kisiler) {
                            if (k.getId().equals(ikinciindex)) {
                                ikinciindexx = AgacYapisi.kisiler.indexOf(k);
                                break;
                            }
                        }
                        KisiDugum birincikisi = AgacYapisi.kisiler.get(birindexx);
                        KisiDugum ikincikisi = AgacYapisi.kisiler.get(ikinciindexx);
                        System.out.println(birincikisi.getIsim());
                        System.out.println(ikincikisi.getIsim());
                        System.out.println(yakinlikbul(birincikisi, ikincikisi));
                        break;
                    case 7:
                        String id;
                        System.out.print("Soy ağacını görmek istediğiniz kişinin ID'sini giriniz: ");
                        id = scan.nextLine();
                        for (KisiDugum i : AgacYapisi.kisiler) {
                            if (i.getId().equals(id)) {
                                soyAgaciSwing.ister(i);
                                break;
                            }
                        }
                        break;
                    case 8:
                        KisiDugum kisi = AgacYapisi.root;
                        int nesilsayisi = 1;
                        List<Integer> nesilsayi = new ArrayList<>();
                        nesilbulma(kisi, nesilsayisi, nesilsayi);
                        int enbuyuk = 0;
                        for (Integer s : nesilsayi) {
                            if (s > enbuyuk) {
                                enbuyuk = s;
                            }
                        }
                        System.out.println(enbuyuk);
                        break;
                    case 9:
                        System.out.print("Lutfen kişi id giriniz:");
                        String kisiid = scan.nextLine();
                        KisiDugum kisi1 = AgacYapisi.root;
                        int ids = 0;
                        for (KisiDugum k : AgacYapisi.kisiler) {
                            if (kisiid.equals(k.getId())) {
                                ids = AgacYapisi.kisiler.indexOf(k);
                                break;
                            }
                        }
                        kisi1 = AgacYapisi.kisiler.get(ids);
                        int nesilsayisi1 = 0;
                        List<Integer> nesilsayi1 = new ArrayList<>();
                        nesilbulma(kisi1, nesilsayisi1, nesilsayi1);
                        int enbuyuk1 = 0;
                        for (Integer s : nesilsayi1) {
                            if (s > enbuyuk1) {
                                enbuyuk1 = s;
                            }
                        }
                        System.out.println(enbuyuk1);
                        break;
                    case 10:
                        soyAgaciSwing.genelArayuz();
                        break;
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void nesilbulma(KisiDugum kisi, int nesilsayisi, List<Integer> nesilsayi) {
        if (!kisi.cocuklar.isEmpty()) {
            nesilsayisi++;
            for (KisiDugum a : kisi.cocuklar) {
                nesilbulma(a, nesilsayisi, nesilsayi);
            }
        }
        nesilsayi.add(nesilsayisi);
    }

    static int Agackisisayisi(KisiDugum kisi, int kisisayisi) {
        Queue<KisiDugum> kuyruk = new ArrayDeque<KisiDugum>();
        kuyruk.add(AgacYapisi.root);
        while (!kuyruk.isEmpty()) {
            kisisayisi++;
            KisiDugum islemdugum = kuyruk.remove();
            if (islemdugum.partner != null) {
                kisisayisi++;
            }
            if (islemdugum.cocuklar.size() != 0) {
                kuyruk.addAll(islemdugum.cocuklar);
            }
        }
        return kisisayisi;
    }

    static String yakinlikbul(KisiDugum kisi, KisiDugum kisi2) {
        String donus = "";
        String annesi = "Annesi ";
        String annesinin = "Annesinin ";
        String babasi = "Babası ";
        String babasinin = "Babasının ";
        if (kisi.getCinsiyet().equals("Erkek")) {
            donus = donus + babasi;
            while (true) {
                if (kisi2.mother != null) {
                    if (kisi2.mother.mother != null) {
                        if (kisi2.mother.getKizlikSoyIsmi().equals(kisi.getSoyIsim())
                                || kisi2.mother.mother.getKizlikSoyIsmi().equals(kisi.getSoyIsim())) {
                            kisi2 = kisi2.mother;
                            donus = annesinin + donus;
                        } else {
                            kisi2 = kisi2.father;
                            donus = babasinin + donus;
                        }
                        if (kisi2.father != null) {
                            if (kisi2.father.getId().equals(kisi.getId())) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                    if (kisi2.mother.getKizlikSoyIsmi().equals(kisi.getSoyIsim())) {
                        kisi2 = kisi2.mother;
                        donus = annesinin + donus;
                    } else {
                        kisi2 = kisi2.father;
                        donus = babasinin + donus;
                    }
                }
                if (kisi2.father != null) {
                    if (kisi2.father.getId().equals(kisi.getId())) {
                        break;
                    }
                }
            }
        } else {
            donus = donus + annesi;
            while (true) {
                if (kisi2.mother != null) {
                    if (kisi2.mother.mother != null) {
                        if (kisi2.mother.getKizlikSoyIsmi().equals(kisi.getSoyIsim())
                                || kisi2.mother.mother.getKizlikSoyIsmi().equals(kisi.getSoyIsim())) {
                            kisi2 = kisi2.mother;
                            donus = annesinin + donus;
                        } else {
                            kisi2 = kisi2.father;
                            donus = babasinin + donus;
                            System.out.println(donus);
                        }
                        if (kisi2.mother != null) {
                            if (kisi2.mother.getId().equals(kisi.getId())) {
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                    if (kisi2.mother.getKizlikSoyIsmi().equals(kisi.getSoyIsim())) {
                        kisi2 = kisi2.mother;
                        donus = annesinin + donus;
                    } else {
                        kisi2 = kisi2.father;
                        donus = babasinin + donus;
                    }
                }
                if (kisi2.mother != null) {
                    if (kisi2.mother.getId().equals(kisi.getId())) {
                        break;
                    }
                }
            }
        }
        return donus;
    }
}
