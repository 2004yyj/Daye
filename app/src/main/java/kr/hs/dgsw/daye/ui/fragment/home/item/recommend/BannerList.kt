package kr.hs.dgsw.daye.ui.fragment.home.item.recommend

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import kr.hs.dgsw.daye.ui.fragment.home.item.recommend.banner_list.BannerItem

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerList() {
    val list = (0..10).toList()
    HorizontalPager(list.size) { index ->
        BannerItem()
    }
}

@Preview
@Composable
fun BannerListPreview() {
    BannerList()
}