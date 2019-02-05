package com.example.usrdel.myapplication

import android.os.Parcel
import android.os.Parcelable

class Tienda(var nombre:String, var direccion:String, var fechaApertura:String, var ruc:String, var matriz:String?):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(direccion)
        parcel.writeString(fechaApertura)
        parcel.writeString(ruc)
        parcel.writeString(matriz)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tienda> {
        override fun createFromParcel(parcel: Parcel): Tienda {
            return Tienda(parcel)
        }

        override fun newArray(size: Int): Array<Tienda?> {
            return arrayOfNulls(size)
        }
    }

}