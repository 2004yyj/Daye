package kr.hs.dgsw.daye.ui.fragment

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.hs.dgsw.daye.ui.theme.MainColor
import kr.hs.dgsw.daye.ui.theme.MainLightColor

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(navController: NavController) {
    val tabArray = HomeTab.values()
    val pagerState = rememberPagerState(initialPage = 0)
    val currentPage = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = currentPage,
            backgroundColor = Color.White,
            edgePadding = 0.dp,
            indicator = { tabPositions ->
                Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[currentPage]),
                    color = MainColor
                )
            }
        ) {
            tabArray.forEachIndexed { index, homeTab ->
                Tab(
                    selected = currentPage == index,
                    selectedContentColor = MainColor,
                    unselectedContentColor = MainLightColor,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = homeTab.title)
                    },
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            count = tabArray.size,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val tab = tabArray[page]
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.onPrimary)
                    .fillMaxSize()
            ) {
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    Home(navController)
}