package com.acme.doktoric.provider;

import com.google.inject.ImplementedBy;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.06.09.
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */
@ImplementedBy(RowProviderImp.class)
public interface RowProvider {
    String getRow(String row);

}
