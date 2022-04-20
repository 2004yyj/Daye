package kr.hs.dgsw.daye.ui.fragment.home.item.recommend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.daye.ui.fragment.home.item.TeaItem
import kr.hs.dgsw.daye.ui.theme.DayeTheme
import kr.hs.dgsw.daye.ui.theme.Typography
import kotlin.math.max

@Composable
fun TeaList() {
    val list = (0..10).toList()
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.onPrimary)
    ) {
        Text(
            text = "아이템 1",
            modifier = Modifier.padding(10.dp, 10.dp, 0.dp, 0.dp),
            style = Typography.subtitle1,
            fontWeight = FontWeight.Bold,
        )
        LazyRow(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(list.size) { index ->
                Box(modifier = Modifier.height(500.dp)) {
                    TeaItem()
                }
            }
        }
    }
}

@Preview
@Composable
fun TeaListPreview() {
    TeaList()
}