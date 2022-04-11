package kr.hs.dgsw.daye.ui.navigation

import kr.hs.dgsw.daye.ui.resources.Drawable

sealed class Destinations(
    val label: String,
    val route: String,
    val drawable: Drawable
) {
    object Home: Destinations("홈", "home",Drawable.IcHome)
    object Store: Destinations("판매점", "store", Drawable.IcPot)
    object MyPage: Destinations("내 정보","myPage", Drawable.IcUser)
}