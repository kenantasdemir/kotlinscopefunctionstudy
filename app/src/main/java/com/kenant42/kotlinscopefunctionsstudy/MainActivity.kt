package com.kenant42.kotlinscopefunctionsstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
               Scope fonksiyonlar bir nesnenin bağlam içerisinde bir kod bloğunu çalıştırmasını sağlayan fonksiyonlardır.
               Bağlam nesnesi: Bir kapsam fonksiyonunun üzerinde çalıştığı nesnedir.
               Bağlam nesnesi, kapsam fonksiyonunun dönüş değerini belirleyemez, yalnızca blok içerisinde kullanılabilir.
               Scope fonksiyonlar sayesinde nesneye adı olmadan erişebilir, nesneyi değiştirebilir veya lambda sonucunu döndürebiliriz.
               Scope fonksiyonlar sayesinde kodlarımız daha kısa, okunaklı ve modüler bir yapıya kavuşur.

               Scope fonksiyonlar 2 farklı değer döndürüyor.
               Ya context objesi ya da lambda sonucu.

               Context Objesi : Apply ve Also direk olarak nesneyi döndürüyorlar. Yani context objesi.
               Lambda Sonucu : Direk olarak ilgili nesne içerisinde işlem yapma ya da yeni nesneyi döndürme görevini görür.

               With extension fonksiyon değilken, diğer scope fonksiyonları extensio fonksiyondur.
               apply ve also fonksiyonları context objesi dönerken diğer scope fonksiyonlar lambda fonksiyon döner
         */


        val notlar = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
        notlar.filter {
            it > 50

        }.let {
            Log.e("50 DEN YUKSEK ILK DEGER ", it.min().toString())
            //let fonksiyonunu genellikle null güvenliği sağlamak için kullanırız.
            //bağlam nesnesine it ile başvurur.
        }

        val lastElementOfNotlar = notlar.last().let { lastElement ->
            Log.e("LAST ELEMENT ", lastElement.toString())/*
            Burada, notlar listesinin son elemanını alır,
            bu elemanı bir lambda ifadesi içinde (let fonksiyonuyla) lastElement adlı değişkene atar,
             */
        }

        with(notlar) {
            Log.e("FIRST and LAST ", " ${min()} \t  ${max()}")
            println("ARRAY ELEMENT SIZE : ${this.size}")

            /*
            with fonksiyonu, lambda sonucunu döndürür ve bağlam nesnesine ‘this’ ile başvurur.
            Bu fonksiyonu, bir nesne üzerinde değişiklik yapmayacağınız,
            sadece belirli işlemler yapacağımız durumlarda kullanırız.
             */
        }

        Personel("Ahmet", "IT", 25000).run {
            ad.toUpperCase()
            maas += 2500
            println("$ad isimli personelin yeni maaşı $maas")
            //nesneyi başlatmak değiştirmek ve fonksiyon tanımlamak için kullanılır.
            //bağlam nesnesine this ile başvurur.
        }

        var updatedPersonel = Personel("Ahmetttt", "IT", 25000).apply {
            maas += 2500/*
            Bu fonksiyonu, bir nesneyi başlatmak, oluşturmak veya bir
            değişkene atayarak üzerinde değişiklikler yapmak için kullanabiliriz.
            bağlam nesnesine this ile başvurur.
             */
        }
        println("UPDATED PERSONEL NAME AND SALARY : ${updatedPersonel.ad}  ${updatedPersonel.maas}")

        println(notlar.also {
            println(it.max())
            //aynı anda iki işlemi gerçekleştirmek için kullanılır.
            //bağlam nesnesine it ile başvurur
        }.sum())
    }
}