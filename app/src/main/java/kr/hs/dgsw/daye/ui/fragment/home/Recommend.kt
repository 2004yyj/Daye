package kr.hs.dgsw.daye.ui.fragment.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kr.hs.dgsw.daye.ui.fragment.home.item.recommend.BannerList
import kr.hs.dgsw.daye.ui.fragment.home.item.recommend.TeaList
import kr.hs.dgsw.daye.ui.ui_model.HomeUiModel

@Composable
fun Recommend() {
    val list = arrayListOf(
        "Banner",
        "SmallHorizontalTeaList",
        "BigHorizontalTeaList"
    ).map {
        when(it) {
            "Banner" -> HomeUiModel.BannerUiModel(it)
            "SmallHorizontalTeaList" -> HomeUiModel.SmallHorizontalTeaListUiModel(it)
            "BigHorizontalTeaList" -> HomeUiModel.BigHorizontalTeaListUiModel(it)
            else -> HomeUiModel.BannerUiModel(it)
        }
    }

    LazyColumn {
        items(list.size) { index ->
            when(list[index]) {
                is HomeUiModel.BannerUiModel -> BannerList()
                is HomeUiModel.SmallHorizontalTeaListUiModel -> TeaList()
                is HomeUiModel.BigHorizontalTeaListUiModel -> {}
            }
        }
    }
}

@Preview
@Composable
fun RecommendPreview() {
    Recommend()
}