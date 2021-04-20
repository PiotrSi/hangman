package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Kafelki {

    JTextField wpisywanie = new JTextField();
    char[] str;
    JTextField[] tekstf;
    JTextArea bylo;
    JLabel etykieta;
    String ciag="";
    int licznik = 0;
    int licznikD = 0;
    JLabel labelImg;
    Kafelki(ArrayList<String> list, int y, JPanel panel1, SpringLayout splayout, JFrame okno){
        String tab;
        tab = list.get(y).toString();
        JTextField textField = new JTextField();
        Font newTextFieldFont=new Font(textField.getFont().getName(),textField.getFont().getStyle(),32);

        str = new char[tab.length()];
        tekstf = new JTextField[tab.length()];

        for(int x = 0;  x < tab.length() ; x++) {
            str[x] = tab.charAt(x);


            tekstf[x] = new JTextField(1) ;
            //tekstf[x].setPreferredSize(new Dimension(20, 20));
            tekstf[x].setFont(newTextFieldFont);
            //tekstf[x].setText(String.valueOf(str[x]));
            tekstf[x].setEditable(false);
            panel1.add(tekstf[x]);
            splayout.putConstraint(SpringLayout.WEST, tekstf[x], 35 * (x+1), SpringLayout.WEST, okno);
            splayout.putConstraint(SpringLayout.NORTH, tekstf[x], 50, SpringLayout.NORTH, okno);
        }




        bylo = new JTextArea();
        bylo.setPreferredSize(new Dimension(100, 100));
        bylo.setLineWrap(true);
        bylo.setEditable(false);
        splayout.putConstraint(SpringLayout.WEST, bylo, 181, SpringLayout.EAST, okno);
        splayout.putConstraint(SpringLayout.NORTH, bylo, 50, SpringLayout.SOUTH, tekstf[0] );
        panel1.add(bylo);

        etykieta = new JLabel("Tutaj wpisuj");
        etykieta.setBackground(Color.GREEN);
        splayout.putConstraint(SpringLayout.WEST, wpisywanie, 50, SpringLayout.WEST, okno);
        splayout.putConstraint(SpringLayout.NORTH, wpisywanie, 220, SpringLayout.SOUTH, tekstf[0]);
        panel1.add(etykieta);

        etykieta = new JLabel("Tutaj wpisuj");
        etykieta.setBackground(Color.GREEN);
        splayout.putConstraint(SpringLayout.WEST, etykieta, 40, SpringLayout.WEST, okno);
        splayout.putConstraint(SpringLayout.NORTH, etykieta, 220, SpringLayout.SOUTH, tekstf[0]);
        panel1.add(etykieta);

        wpisywanie.setPreferredSize(new Dimension(50, 50));
        splayout.putConstraint(SpringLayout.WEST, wpisywanie, 50, SpringLayout.WEST, okno);
        splayout.putConstraint(SpringLayout.NORTH, wpisywanie, 250, SpringLayout.SOUTH, tekstf[0]);
        wpisywanie.setFont(newTextFieldFont);
        panel1.add(wpisywanie);

        ImageIcon img =new ImageIcon("imgWisielec/wisielec0.PNG");
        labelImg = new JLabel("", img , JLabel.CENTER);
        splayout.putConstraint(SpringLayout.WEST, labelImg, 35, SpringLayout.WEST, okno);
        splayout.putConstraint(SpringLayout.NORTH, labelImg, 145, SpringLayout.NORTH, okno );
        panel1.add(labelImg);


        //tekstf.setText(tab[0]);


/*
        for (int x = 0;  x < tab[y].length() ; x++) {

            System.out.println(str[x]);
        }
  */
    }
    void sprawdx(String letter) {
        char szukana = Character.toLowerCase(letter.charAt(0));  ;
        boolean jest = false;
        if(licznik != 11 ) {
            {
                System.out.println(str.length);
            for (int x = 0; x < str.length; x++) {
                if (szukana == str[x]) {
                    System.out.println("znaleziono : " + str[x]);
                    tekstf[x].setText(String.valueOf(str[x]));
                    licznikD++;
                    jest = true;
                    System.out.println("znaleziono liczba : " + licznikD);
                }
            }if(licznikD == str.length){ labelImg.setIcon(new ImageIcon("imgWisielec/wisielecWin.PNG"));}
            if (jest == false && wysLitera(ciag,szukana)) {
                licznik++;
                ciag = ciag.concat(letter + " , ");
                bylo.setText(ciag);
                labelImg.setIcon(new ImageIcon("imgWisielec/wisielec" + licznik + ".PNG"));

            }
                labelImg.setIcon(new ImageIcon("imgWisielec/wisielec" + licznik + ".PNG"));
            }
        }
    }
    public boolean wysLitera(String napis, char litera)
    {
        boolean jest=true;
        // liczbę zliczonych znaków
        char znak_z_napisu; // zmienna do pobierania kolejnych liter z napisu
        for (int i = 0 ; i < napis.length() ; i+=2) // przejście po napisie
        {
            znak_z_napisu = napis.charAt(i); // pobieramy pojedynczy znak z napisu
            if(znak_z_napisu == litera) // porównanie ze znakiem
            {
                jest=false;
                break;
            }
        }
        return jest;
    }

}
