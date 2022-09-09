package com.orglegal.fam.features.catalog.utils

import androidx.annotation.DrawableRes
import com.orglegal.fam.R

enum class Socials(val value: String?, @DrawableRes resId: Int?) {
    INSTAGRAM("instagram", R.drawable.ic_instagram),
    WHATSAPP("whatsapp", R.drawable.ic_whatsapp),
    NULL(null, null)
}