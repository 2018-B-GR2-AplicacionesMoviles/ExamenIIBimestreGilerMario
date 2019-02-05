package com.example.usrdel.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import com.tapadoo.alerter.Alerter
import kotlinx.android.synthetic.main.activity_registrar.*

class RegistrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        btnAceptar.setOnClickListener { aceptar() }
        btnCancelar.setOnClickListener { cancelar() }
    }

    fun aceptar(){
        val url = "http://192.168.100.8:1337/tienda"
        val tienda = Tienda(nombre=txtNombre.text.toString(), direccion = txtDireccion.text.toString(),
                            fechaApertura = txtFechaApertura.text.toString(), ruc = txtRuc.text.toString(), matriz = null)
        val parametro = listOf("nombre" to tienda.nombre,
                                "direccion" to tienda.direccion,
                                "fechaApertura" to tienda.fechaApertura,
                                "ruc" to tienda.ruc,
                                "matriz" to "norte")
        url.httpPost(parametro).responseString { request, response, result ->
            when(result){
                is Result.Failure ->{
                    val exepcion = result.getException()
                    Toast.makeText(this, "Error:${exepcion}", Toast.LENGTH_SHORT).show()
                }
                is Result.Success ->{
                    Alerter.create(this@RegistrarActivity)
                            .setTitle("Registro")
                            .setText("Guardado con éxito")
                            .setBackgroundColorRes(R.color.colorAccent)
                            .show()
                }
            }
        }
        txtNombre.setText("")
        txtDireccion.setText("")
        txtFechaApertura.setText("")
        txtRuc.setText("")
    }

    fun cancelar(){
        txtNombre.setText("")
        txtDireccion.setText("")
        txtFechaApertura.setText("")
        txtRuc.setText("")
    }
}
