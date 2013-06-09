package com.acme.doktoric.provider;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.09.
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */

public class RowProviderImp implements RowProvider {

    @Override
    public String getRow(String row) {
        row = row.replaceAll(String.valueOf((char) 160), " ");
        row=row.replaceAll("( )+"," ");
        row=row.replaceAll("Egész nap","");
        if(row.equals(" ")){
            row="";
        }
        return row;
    }

    public static RowProvider rowProvider() {
        return new RowProviderImp();
    }
}
