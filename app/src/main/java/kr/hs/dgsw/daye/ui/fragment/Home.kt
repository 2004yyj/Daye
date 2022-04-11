package kr.hs.dgsw.daye.ui.fragment

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
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
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import kr.hs.dgsw.daye.ui.activity.Main
import kr.hs.dgsw.daye.ui.resources.Array
import kr.hs.dgsw.daye.ui.theme.MainColor
import kr.hs.dgsw.daye.ui.theme.MainLightColor

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Home(navController: NavController) {
    val tabArray = stringArrayResource(id = Array.HomeTabArray.arrayRes)
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
            tabArray.forEachIndexed { index, text ->
                Tab(
                    selected = currentPage == index,
                    selectedContentColor = MainColor,
                    unselectedContentColor = MainLightColor,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = text)
                    },
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            count = tabArray.size
        ) {
            
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    Home(navController)
}