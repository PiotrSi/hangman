package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GUI extends JFrame implements ActionListener {
    FileReader fr = null;
    String linia = "";
    ArrayList<String> mylist = new ArrayList<String>();
    //String[] tab = new String[3];
    Kafelki pola;

    public GUI() {
        JFrame okno = new JFrame();

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.black);
        okno.add(panel1);






        SpringLayout splayout = new SpringLayout();
        panel1.setLayout(splayout);





        try {
            wczytaj(mylist);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(mylist.size());
        //int los = 1;
        int min =0;
        int max = mylist.size();
                                            //Losuj
        int los = (int) ((Math.random() * (max - min)) + min);


                                            //stwórz okienka na literki
        Kafelki pola = new Kafelki(mylist,los,panel1,splayout,okno);
                                            //okienko na złeliterki







        //wpisz literki
        //pola.wpisywanie.addActionListener(this);
        pola.wpisywanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String value1 = pola.wpisywanie.getText();

        if(value1.length()>0 && value1.length()<2)
        {
            System.out.println("wpisano : "+value1);
            pola.sprawdx(value1);
        }
                pola.wpisywanie.setText("");
            }
        });


        //




        //JTextField tekstf = new JTextField(1);
        //tekstf.setPreferredSize(new Dimension(20, 20));
        //tekstf.setEditable(false);
        //panel1.add(tekstf);
        //tekstf.setText(tab[0]);
/*
        JPasswordField passwordField = new JPasswordField(1);
        passwordField.setPreferredSize(new Dimension(20, 20));
        passwordField.setEditable(false);
        panel1.add(passwordField);
*/
        /*
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.red);
        okno.add(panel2);
*/
        okno.setVisible(true);
        okno.setLocation(650, 400);
        okno.setSize(450, 450);
        okno.setTitle("okno");
        okno.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //String
    void wczytaj(ArrayList<String> tab) throws FileNotFoundException {

        int i=0;
        // OTWIERANIE PLIKU:
        try {
            //fr = new FileReader("C:/Users/edpio/IdeaProjects/wisielec/out/production/wisielec/com/company/plik.txt");
            fr = new FileReader("plik.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);
        // ODCZYT KOLEJNYCH LINII Z PLIKU:
        try {
            while((linia = bfr.readLine()) != null){
                System.out.println(linia);
                mylist.add(linia);
                //tab[i]=linia;

                i++;
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        // ZAMYKANIE PLIKU
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
