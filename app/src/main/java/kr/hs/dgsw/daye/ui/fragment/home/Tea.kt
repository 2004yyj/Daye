package kr.hs.dgsw.daye.ui.fragment.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.daye.ui.fragment.home.item.TeaItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tea(name: String) {
    val list = (0..10).map { it.toString() }

    Surface(
        modifier = Modifier.background(MaterialTheme.colors.onPrimary)
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(list.size) { index ->
                TeaItem()
            }
        }
    }
}

@Preview
@Composable
fun TeaPreview() {
    Tea("전체")
}