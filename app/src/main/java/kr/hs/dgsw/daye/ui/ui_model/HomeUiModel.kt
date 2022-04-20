package kr.hs.dgsw.daye.ui.ui_model

sealed class HomeUiModel(item: String) {
    class BannerUiModel(item: String) : HomeUiModel(item)
    class SmallHorizontalTeaListUiModel(item: String) : HomeUiModel(item)
    class BigHorizontalTeaListUiModel(item: String) : HomeUiModel(item)
}