package ru.startandroid.obhodprototype.Model;

import org.parceler.Parcel;

/**
 * Created by edu02 on 10.03.2016.
 */

@Parcel
public class Point {
    public int Id;
    public String Title;
    public Item[] Items;
    public boolean CanBeFilledWithDefault;

    public void Point(){}
}
