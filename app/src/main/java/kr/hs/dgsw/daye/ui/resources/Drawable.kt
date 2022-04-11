package kr.hs.dgsw.daye.ui.resources

import kr.hs.dgsw.daye.R

sealed class Drawable(val resourceRes: Int) {
    object IcLogo: Drawable(R.drawable.ic_logo)
    object IcCart: Drawable(R.drawable.ic_cart)
    object IcSearch: Drawable(R.drawable.ic_search)
    object IcHome: Drawable(R.drawable.ic_home_not_selected)
    object IcPot: Drawable(R.drawable.ic_pot_not_selected)
    object IcUser: Drawable(R.drawable.ic_user_not_selected)
}