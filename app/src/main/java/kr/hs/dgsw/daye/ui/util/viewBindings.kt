package kr.hs.dgsw.daye.ui.util

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

inline fun <reified VB: ViewBinding> Activity.viewBindings(
    crossinline inflate: (LayoutInflater) -> VB
): Lazy<VB> {
    return lazy(LazyThreadSafetyMode.NONE) {
        inflate(layoutInflater)
    }
} 