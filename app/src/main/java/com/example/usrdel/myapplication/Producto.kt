package com.example.usrdel.myapplication

import android.os.Parcel
import android.os.Parcelable

class Producto(val numeroProducto:String, val nombrePro:String, val descripcionPro:String, val precioPro:String, val fechaLanzamiento:String,  val aniosGarantia:String, val idTienda:Int?):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(numeroProducto)
        parcel.writeString(nombrePro)
        parcel.writeString(descripcionPro)
        parcel.writeString(precioPro)
        parcel.writeString(fechaLanzamiento)
        parcel.writeString(aniosGarantia)
        parcel.writeValue(idTienda)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }
}