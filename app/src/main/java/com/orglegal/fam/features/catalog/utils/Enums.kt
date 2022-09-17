package com.orglegal.fam.features.catalog.utils

import androidx.annotation.DrawableRes
import com.orglegal.fam.R

enum class Socials(val value: String?, @DrawableRes val resId: Int?) {
    INSTAGRAM("instagram", R.drawable.ic_instagram),
    WHATSAPP("whatsapp", R.drawable.ic_whatsapp),
    TIKTOK("tiktok", R.drawable.ic_tiktok),
    NULL(null, null)
}