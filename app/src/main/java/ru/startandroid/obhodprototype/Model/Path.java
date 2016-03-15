package ru.startandroid.obhodprototype.Model;


import org.parceler.Parcel;


@Parcel
public class Path{

    public int Id;
    public String Title;
    public String Name;
    public String Place;
    public String StartTime;
    public Point[] Points;

    public boolean Started = false;
    public boolean Expanded = false;

    public Path() {
    }


}
