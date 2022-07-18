package com.mqds.filmesflix.model

import android.os.Parcelable


data class Movie(
    val id: Int,
    val title: String,
    val description: String?,
    val image: String,
    val lauchDate: String?
)
//: Parcelable

/*
package com.br.natanfc.filmesflix.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName


@Parcelize
data class Movie(
    val id: Int,
    val titulo: String,
    val imagem: String,
    val descricao: String?,
    @SerializedName("data_lancamento")
    val dataLancamento: String?
): Parcelable*/