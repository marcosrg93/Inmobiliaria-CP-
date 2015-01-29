package es.marcos.inmobiliariacp;

import android.os.Parcel;
import android.os.Parcelable;


public class Inmueble implements Parcelable,Comparable<Inmueble> {
    private int id;
    private String direccion;
    private String tipo;
    private double precio;
    private  boolean subido= false;
    public static final Creator<Inmueble> CREATOR = new Creator<Inmueble>() {
        @Override
        public Inmueble createFromParcel(Parcel p) {
            String direccion = p.readString();
            String tipo = p.readString();
            Double precio = p.readDouble();
            int id=p.readInt();
            return new Inmueble(id, direccion, tipo, precio);
        }
        @Override
        public Inmueble[] newArray(int i) {
            return new Inmueble[i];
        }
    };
    public Inmueble(int id, String direccion, String tipo, double precio) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.precio = precio;
    }
    public Inmueble( String direccion, String tipo, double precio) {
        this.direccion = direccion;
        this.tipo = tipo;
        this.precio = precio;
    }
    @Override
    public int hashCode() {
         return (int) (id ^ (id >>> 32));
    }
    public Inmueble() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setSubido() {
        this.subido = true;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        Inmueble i=(Inmueble)o;
        if (this.id==i.getId()) {
            return true;
        }
        return false;
    }
    @Override
    public int compareTo(Inmueble another) {
        if (this.direccion.compareToIgnoreCase(another.direccion) >0 ) {
            return 1;
        } else if (this.direccion.compareToIgnoreCase(another.direccion) <0 ) {
            return -1;
        }
        return 0;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(direccion);
        dest.writeString(tipo);
        dest.writeDouble(precio);
    }
}
