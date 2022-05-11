package kr.hs.dgsw.daye.ui.fragment.home.item.tea.tea_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.daye.R
import kr.hs.dgsw.daye.ui.resources.Drawable
import kr.hs.dgsw.daye.ui.theme.LineColor
import kr.hs.dgsw.daye.ui.theme.MainColor
import kr.hs.dgsw.daye.ui.theme.Typography
import kr.hs.dgsw.daye.ui.theme.UnselectedColor

@Composable
fun BigTeaItem() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp, 150.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(
                    width = 0.5.dp,
                    color = LineColor,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentScale = ContentScale.Crop,
        )

        Text(
            text = "아마드티 얼그레이 100티백",
            modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
                .width(150.dp),
            style = Typography.subtitle2,
            fontWeight = FontWeight.Bold,
        )

        Row {
            Text(
                text = "22%",
                color = MainColor,
                style = Typography.subtitle1,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "26,400원",
                style = Typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp)
            )

            Text(
                text = "34,000",
                color = UnselectedColor,
                style = Typography.caption,
                textDecoration = TextDecoration.LineThrough
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(14.dp),
                painter = painterResource(id = Drawable.IcStar.resourceRes),
                contentDescription = null,
                tint = MainColor
            )

            Text(
                text = "4.8",
                modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 0.dp),
                style = Typography.body2,
            )

            Text(
                text = "(18)",
                modifier = Modifier.padding(3.dp, 0.dp, 0.dp, 0.dp),
                style = Typography.body2,
                color = UnselectedColor
            )
        }
    }
}

@Preview
@Composable
fun BigTeaItemPreview() {
    Surface(
        modifier = Modifier.background(Color.White)
    ) {
        BigTeaItem()
    }
}