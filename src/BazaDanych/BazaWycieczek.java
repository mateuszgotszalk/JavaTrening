package BazaDanych;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import static BazaDanych.DBconnection.*;

public class BazaWycieczek {

    public static void main(String[] args) {

        LinkedList lista = new LinkedList();
        LinkedList lista1 = new LinkedList();
        LinkedList lista2 = new LinkedList();
        LinkedList lista3 = new LinkedList();
        LinkedList lista4 = new LinkedList();
        LinkedList lista5 = new LinkedList();

        DBconnection dBconnection = new DBconnection();
        dBconnection.connect();

        try{
            wycieczkiOsoby(980211);
            lista = showMiejsca();
            lista1 = showOsoba();
            lista2 = showStatusy();
            lista3 = showPrzewodnicy();
            lista4 = showOferty();
            lista5 = showWycieczki();
            System.out.println("```````````````````````");
            zrealizowane();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Iterator<Miejsce> iterator = lista.listIterator();

        System.out.println("Miejsca");

        System.out.println("id \tkraj\t misato\t hotel");
        System.out.println("-----------------------------");
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }
        Iterator<Osoba> iter = lista1.listIterator();

        System.out.println("Osoby");
        System.out.println("**************************");
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        Iterator<Status> iter1 = lista2.listIterator();

        System.out.println("Statusy");
        System.out.println("**************************");
        while(iter1.hasNext()){
            System.out.println(iter1.next());
        }
        Iterator<Przewodnik> iter2 = lista3.listIterator();

        System.out.println("Przwodnicy");
        System.out.println("**************************");
        while(iter2.hasNext()){
            System.out.println(iter2.next());
        }
        Iterator<Oferta> iter3 = lista4.listIterator();

        System.out.println("Oferty");
        System.out.println("**************************");
        while(iter3.hasNext()){
            System.out.println(iter3.next());
        }

        Iterator<Oferta> iter4 = lista5.listIterator();

        System.out.println("Wycieczki");
        System.out.println("**************************");
        while(iter4.hasNext()){
            System.out.println(iter4.next());
        }

        dBconnection.disconnect();

    }
}
