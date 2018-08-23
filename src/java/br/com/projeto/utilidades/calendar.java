/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luis.silva
 */
public class calendar {

    public static void main(String[] args) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat f = DateFormat.getDateInstance();

        Date data2 = f.parse("12/01/1995");
        System.out.println("Conversão String para data:  " + data2
        );

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data formatada: " + sdf.format(data));

        //Converte Objetos
        System.out.println("Data covertida: " + sdf.parse("02/08/1970"));
    }
}
