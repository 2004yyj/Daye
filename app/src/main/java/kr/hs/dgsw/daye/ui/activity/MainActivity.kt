package kr.hs.dgsw.daye.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.daye.ui.fragment.Home
import kr.hs.dgsw.daye.ui.fragment.MyPage
import kr.hs.dgsw.daye.ui.fragment.Store
import kr.hs.dgsw.daye.ui.navigation.Destinations
import kr.hs.dgsw.daye.ui.resources.Drawable
import kr.hs.dgsw.daye.ui.theme.DayeTheme
import kr.hs.dgsw.daye.ui.theme.MainColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DayeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    val items = listOf(
        Destinations.Home,
        Destinations.Store,
        Destinations.MyPage
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MainTopAppBar() },
        bottomBar = { MainBottomNavigation(items, navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Destinations.Home.route
        ) {
            composable(Destinations.Home.route) { Home(navController) }
            composable(Destinations.Store.route) { Store(navController) }
            composable(Destinations.MyPage.route) { MyPage(navController) }
        }
    }
}

@Composable
fun MainTopAppBar() {
    TopAppBar(
        title = {},
        modifier = Modifier,
        backgroundColor = Color.White,
        navigationIcon = {
            Icon(
                tint = MainColor,
                contentDescription = null,
                painter = painterResource(id = Drawable.IcLogo.resourceRes),
            )
        },
        actions = {
            IconButton(
                onClick = {  },
                modifier = Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp)
            ) {
                Icon(
                    tint = MainColor,
                    contentDescription = null,
                    painter = painterResource(id = Drawable.IcSearch.resourceRes),
                )
            }
            IconButton(onClick = {  }) {
                Icon(
                    tint = MainColor,
                    painter = painterResource(id = Drawable.IcCart.resourceRes),
                    contentDescription = null
                )
            }
        },
    )
}

@Composable
fun MainBottomNavigation(items: List<Destinations>, navController: NavHostController) {
    BottomNavigation(backgroundColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { destination ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = destination.drawable.resourceRes),
                        contentDescription = null
                    )
                },
                selectedContentColor = MainColor,
                unselectedContentColor = MainColor.copy(alpha = ContentAlpha.disabled),
                selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                onClick = {
                    navController.navigate(destination.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DayeTheme {
        Main()
    }
}