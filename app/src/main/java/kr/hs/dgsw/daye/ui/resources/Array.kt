package kr.hs.dgsw.daye.ui.resources

import kr.hs.dgsw.daye.R

sealed class Array(val arrayRes: Int) {
    object HomeTabArray: Array(R.array.tabArray)
}