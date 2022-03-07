package kr.hs.dgsw.daye.ui.util

import android.app.Activity
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

fun Activity.findNavController(navHostFragment: NavHostFragment): NavController {
    return navHostFragment.navController
}