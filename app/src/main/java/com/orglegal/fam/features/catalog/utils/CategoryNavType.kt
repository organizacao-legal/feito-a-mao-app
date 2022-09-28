package com.orglegal.fam.features.catalog.utils

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.orglegal.fam.features.catalog.domain.model.Category

class CategoryNavType : NavType<Category>(isNullableAllowed = false) {
    @Suppress("DEPRECATION")
    override fun get(bundle: Bundle, key: String): Category? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Category {
        return Gson().fromJson(value, Category::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Category) {
        bundle.putParcelable(key, value)
    }
}