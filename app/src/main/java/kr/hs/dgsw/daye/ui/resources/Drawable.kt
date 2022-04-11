package kr.hs.dgsw.daye.ui.resources

import kr.hs.dgsw.daye.R

sealed class Drawable(val resourceRes: Int) {
    object IcLogo: Drawable(R.drawable.ic_logo)
    object IcCart: Drawable(R.drawable.ic_cart)
    object IcSearch: Drawable(R.drawable.ic_search)
}