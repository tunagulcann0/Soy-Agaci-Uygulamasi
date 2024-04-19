import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;

public class SoyAgaciSwing extends javax.swing.JFrame {

    static JFrame jf = new JFrame("Soy Ağacı");

    public static void genelArayuz() {
        
        jf.setSize(1920, 1080);
        jf.setLocation(0, 0);
        jf.getContentPane().setBackground(Color.GRAY);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.getContentPane().setLayout(null);
        int bosluk = 0, son = 0, kontrol = 0, kontrol2 = 0, sat = 0;
        ArrayList<JButton> buttons = new ArrayList<>();
        ArrayList<JButton> esbuttons = new ArrayList<>();
        if (AgacYapisi.root.getCinsiyet().equals("Kadın")) {
            buttons.add(new JButton());
            buttons.get(0).setText(AgacYapisi.root.getIsim() + " " + AgacYapisi.root.getSoyIsim());
            buttons.get(0).setSize(110, 50);
            buttons.get(0).setLocation(1920 / 2 - 400, 30);
            buttons.get(0).setBackground(Color.PINK);
            buttons.get(0).setForeground(Color.WHITE);
            buttons.get(0).setOpaque(true);
            buttons.get(0).setBorderPainted(false);
            buttons.get(0).setEnabled(false);
            buttons.add(new JButton());
            buttons.get(1).setText(AgacYapisi.root.getEs());
            buttons.get(1).setSize(110, 50);
            buttons.get(1).setLocation(1920 / 2 - 100, 30);
            buttons.get(1).setBackground(Color.BLUE);
            buttons.get(1).setForeground(Color.WHITE);
            buttons.get(1).setOpaque(true);
            buttons.get(1).setBorderPainted(false);
            buttons.get(1).setEnabled(false);
            jf.getContentPane().add(buttons.get(0));
            jf.getContentPane().add(buttons.get(1));
        }
        if (AgacYapisi.root.getCinsiyet().equals("Erkek")) {
            buttons.add(new JButton());
            buttons.get(0).setText(AgacYapisi.root.getIsim() + " " + AgacYapisi.root.getSoyIsim());
            buttons.get(0).setSize(110, 50);
            buttons.get(0).setLocation(1920 / 2 - 400, 30);
            buttons.get(0).setBackground(Color.BLUE);
            buttons.get(0).setForeground(Color.WHITE);
            buttons.get(0).setOpaque(true);
            buttons.get(0).setBorderPainted(false);
            buttons.get(0).setEnabled(false);
            buttons.add(new JButton());
            buttons.get(1).setText(AgacYapisi.root.getEs());
            buttons.get(1).setSize(110, 50);
            buttons.get(1).setLocation(1920 / 2 - 100, 30);
            buttons.get(1).setBackground(Color.PINK);
            buttons.get(1).setForeground(Color.WHITE);
            buttons.get(1).setOpaque(true);
            buttons.get(1).setBorderPainted(false);
            buttons.get(1).setEnabled(false);
            jf.getContentPane().add(buttons.get(0));
            jf.getContentPane().add(buttons.get(1));
        }
        int c = 0, d = 0;
        buttons.clear();
        esbuttons.clear();
        int y = 150;
        Queue<KisiDugum> queue = new ArrayDeque<>();
        queue.addAll(AgacYapisi.root.cocuklar);
        KisiDugum sonEklenen = AgacYapisi.root.cocuklar.get(0);
        int kisisay = AgacYapisi.root.cocuklar.size();
        ArrayList<KisiDugum> gorunecek = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int j = 0; j < kisisay; j++) {
                sonEklenen = queue.remove();
                gorunecek.add(sonEklenen);
                queue.addAll(sonEklenen.cocuklar);
            }
            kontrol = 0;
            kontrol2 = 0;
            sat++;
            for (KisiDugum i : gorunecek) {
                if (gorunecek.size() == 1) {
                    bosluk = 1920 / 2 - 50;
                    if (i.getCinsiyet().equals("Kadın")) {
                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk - 130, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + 130, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    } else if (i.getCinsiyet().equals("Erkek")) {

                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk - 130, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + 130, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    }
                    buttons.get(c).setEnabled(false);
                    jf.getContentPane().add(buttons.get(c));
                    c++;
                    d++;
                } else if (gorunecek.size() % 2 == 0) {
                    if (sat <= 2)
                        bosluk = 1920 / 2 - (155 * gorunecek.size());
                    else
                        bosluk = 1920 / 2 - (450 * gorunecek.size());

                    if (i.getCinsiyet().equals("Kadın")) {
                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + (d * 280) + 20, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + (d * 280) + 150, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + (d * 250) + 20, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    }

                    else if (i.getCinsiyet().equals("Erkek")) {

                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + (d * 280) + 20, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + (d * 280) + 150, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            if (kontrol2 == 0)
                                buttons.get(c).setLocation(bosluk + (d * 250) + 130, y);
                            else if (kontrol2 == 1)
                                buttons.get(c).setLocation(bosluk + (d * 250) - 90, y);
                            else if (kontrol2 == 2)
                                buttons.get(c).setLocation(bosluk + (d * 250) - 55, y);
                            if (kontrol2 == 0 && sat > 2)
                                buttons.get(c).setLocation(bosluk + (d * 250) + 110, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            kontrol2++;
                        }
                    }
                    buttons.get(c).setEnabled(false);
                    jf.getContentPane().add(buttons.get(c));
                    c++;
                    d++;

                }

                else if (gorunecek.size() % 2 == 1) {
                    if (kontrol == 0)
                        bosluk = 1920 / 2 - 260 - ((gorunecek.size() - 1) * 260);
                    else if (kontrol == 1)
                        bosluk = 1920 / 2 + 10 - ((gorunecek.size() - 1) * 260);
                    else
                        bosluk = 1920 / 2 + 200 - ((gorunecek.size() - 1) * 260);
                    kontrol++;
                    System.out.println("boyut:" + bosluk);
                    if (i.getCinsiyet().equals("Kadın")) {
                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d, y);
                            System.out.println(buttons.get(c).getLocation());
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation( bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            System.out.println(esbuttons.get(esbuttons.size() - 1).getLocation());
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    } else if (i.getCinsiyet().equals("Erkek")) {

                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);

                        }
                    }
                    buttons.get(c).setEnabled(false);
                    jf.getContentPane().add(buttons.get(c));
                    c++;
                    d++;

                }

            }
            y += 100;
            kisisay = queue.size();
            gorunecek.clear();
            buttons.clear();
            esbuttons.clear();
            c = 0;
            d = 0;
        }

    }


    public static void ister(KisiDugum kisi) {
        jf.setSize(1920, 1080);
        jf.setLocation(0, 0);
        jf.getContentPane().setBackground(Color.GRAY);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.getContentPane().setLayout(null);
        int bosluk = 0, son = 0, kontrol = 0, kontrol2 = 0, sat = 0;
        ArrayList<JButton> buttons = new ArrayList<>();
        ArrayList<JButton> esbuttons = new ArrayList<>();
        AgacYapisi.root = kisi;
        if (AgacYapisi.root.getCinsiyet().equals("Kadın")) {
            buttons.add(new JButton());
            buttons.get(0).setText(AgacYapisi.root.getIsim() + " " + AgacYapisi.root.getSoyIsim());
            buttons.get(0).setSize(110, 50);
            buttons.get(0).setLocation(1920 / 2 - 400, 30);
            buttons.get(0).setBackground(Color.PINK);
            buttons.get(0).setForeground(Color.WHITE);
            buttons.get(0).setOpaque(true);
            buttons.get(0).setBorderPainted(false);
            buttons.get(0).setEnabled(false);
            buttons.add(new JButton());
            buttons.get(1).setText(AgacYapisi.root.getEs());
            buttons.get(1).setSize(110, 50);
            buttons.get(1).setLocation(1920 / 2 - 100, 30);
            buttons.get(1).setBackground(Color.BLUE);
            buttons.get(1).setForeground(Color.WHITE);
            buttons.get(1).setOpaque(true);
            buttons.get(1).setBorderPainted(false);
            buttons.get(1).setEnabled(false);
            jf.getContentPane().add(buttons.get(0));
            jf.getContentPane().add(buttons.get(1));
        }
        if (AgacYapisi.root.getCinsiyet().equals("Erkek")) {
            buttons.add(new JButton());
            buttons.get(0).setText(AgacYapisi.root.getIsim() + " " + AgacYapisi.root.getSoyIsim());
            buttons.get(0).setSize(110, 50);
            buttons.get(0).setLocation(1920 / 2 - 400, 30);
            buttons.get(0).setBackground(Color.BLUE);
            buttons.get(0).setForeground(Color.WHITE);
            buttons.get(0).setOpaque(true);
            buttons.get(0).setBorderPainted(false);
            buttons.get(0).setEnabled(false);
            buttons.add(new JButton());
            buttons.get(1).setText(AgacYapisi.root.getEs());
            buttons.get(1).setSize(110, 50);
            buttons.get(1).setLocation(1920 / 2 - 100, 30);
            buttons.get(1).setBackground(Color.PINK);
            buttons.get(1).setForeground(Color.WHITE);
            buttons.get(1).setOpaque(true);
            buttons.get(1).setBorderPainted(false);
            buttons.get(1).setEnabled(false);
            jf.getContentPane().add(buttons.get(0));
            jf.getContentPane().add(buttons.get(1));
        }
        int c = 0, d = 0;
        buttons.clear();
        esbuttons.clear();
        int y = 150;
        Queue<KisiDugum> queue = new ArrayDeque<>();
        queue.addAll(AgacYapisi.root.cocuklar);
        KisiDugum sonEklenen = AgacYapisi.root.cocuklar.get(0);
        int kisisay = AgacYapisi.root.cocuklar.size();
        ArrayList<KisiDugum> gorunecek = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int j = 0; j < kisisay; j++) {
                sonEklenen = queue.remove();
                gorunecek.add(sonEklenen);
                queue.addAll(sonEklenen.cocuklar);
            }
            kontrol = 0;
            kontrol2 = 0;
            sat++;
            for (KisiDugum i : gorunecek) {
                System.out.println("isim: " + i.getIsim());
                if (gorunecek.size() == 1) {
                    bosluk = 1920 / 2 - 50;
                    if (i.getCinsiyet().equals("Kadın")) {
                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk - 130, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + 130, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    } else if (i.getCinsiyet().equals("Erkek")) {

                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk - 130, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + 130, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    }
                    buttons.get(c).setEnabled(false);
                    jf.getContentPane().add(buttons.get(c));
                    c++;
                    d++;
                } else if (gorunecek.size() % 2 == 0) {
                    if (sat <= 2)
                        bosluk = 1920 / 2 - (155 * gorunecek.size());
                    else
                        bosluk = 1920 / 2 - (450 * gorunecek.size());

                    if (i.getCinsiyet().equals("Kadın")) {
                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + (d * 280) + 20, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + (d * 280) + 150, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            if (kontrol2 == 0)
                                buttons.get(c).setLocation(bosluk + (d * 250) + 130, y);
                            else if (kontrol2 == 1)
                                buttons.get(c).setLocation(bosluk + (d * 250) - 90, y);
                            else if (kontrol2 == 2)
                                buttons.get(c).setLocation(bosluk + (d * 250) - 55, y);
                            if (kontrol2 == 0 && sat > 2)
                                buttons.get(c).setLocation(bosluk + (d * 250) + 110, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    }

                    else if (i.getCinsiyet().equals("Erkek")) {

                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + (d * 280) + 20, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation(bosluk + (d * 280) + 150, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            if (kontrol2 == 0)
                                buttons.get(c).setLocation(bosluk + (d * 250) + 130, y);
                            else if (kontrol2 == 1)
                                buttons.get(c).setLocation(bosluk + (d * 250) - 90, y);
                            else if (kontrol2 == 2)
                                buttons.get(c).setLocation(bosluk + (d * 250) - 55, y);
                            if (kontrol2 == 0 && sat > 2)
                                buttons.get(c).setLocation(bosluk + (d * 250) + 110, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            kontrol2++;
                        }
                    }
                    buttons.get(c).setEnabled(false);
                    jf.getContentPane().add(buttons.get(c));
                    c++;
                    d++;

                }

                else if (gorunecek.size() % 2 == 1) {
                    if (kontrol == 0)
                        bosluk = 1920 / 2 - 260 - ((gorunecek.size() - 1) * 260);
                    else if (kontrol == 1)
                        bosluk = 1920 / 2 + 10 - ((gorunecek.size() - 1) * 260);
                    else
                        bosluk = 1920 / 2 + 200 - ((gorunecek.size() - 1) * 260);
                    kontrol++;
                    if (i.getCinsiyet().equals("Kadın")) {
                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d, y);
                            System.out.println(buttons.get(c).getLocation());
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation( bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                        }
                    } else if (i.getCinsiyet().equals("Erkek")) {

                        if (i.getEs().length() != 0) {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d, y);
                            buttons.get(c).setBackground(Color.BLUE);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);
                            esbuttons.add(new JButton());
                            esbuttons.get(esbuttons.size() - 1).setText(i.getEs());
                            esbuttons.get(esbuttons.size() - 1).setSize(110, 50);
                            esbuttons.get(esbuttons.size() - 1).setLocation( bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            esbuttons.get(esbuttons.size() - 1).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            esbuttons.get(esbuttons.size() - 1).setOpaque(true);
                            esbuttons.get(esbuttons.size() - 1).setBorderPainted(false);
                            esbuttons.get(esbuttons.size() - 1).setEnabled(false);
                            jf.getContentPane().add(esbuttons.get(esbuttons.size() - 1));
                        } else {
                            buttons.add(new JButton());
                            buttons.get(c).setText(i.getIsim() + " " + i.getSoyIsim());
                            buttons.get(c).setSize(110, 50);
                            buttons.get(c).setLocation(bosluk + ((gorunecek.size() - 1) * 130) * d + 130, y);
                            buttons.get(c).setBackground(Color.PINK);
                            buttons.get(c).setForeground(Color.WHITE);
                            buttons.get(c).setOpaque(true);
                            buttons.get(c).setBorderPainted(false);

                        }
                    }
                    buttons.get(c).setEnabled(false);
                    jf.getContentPane().add(buttons.get(c));
                    c++;
                    d++;

                }

            }
            y += 100;
            kisisay = queue.size();
            gorunecek.clear();
            buttons.clear();
            esbuttons.clear();
            c = 0;
            d = 0;
        }
    }
}