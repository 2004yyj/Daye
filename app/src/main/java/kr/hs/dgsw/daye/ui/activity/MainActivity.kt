package kr.hs.dgsw.daye.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import kr.hs.dgsw.daye.databinding.ActivityMainBinding
import kr.hs.dgsw.daye.ui.util.findNavController
import kr.hs.dgsw.daye.ui.util.viewBindings

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBindings(ActivityMainBinding::inflate)
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        navController = findNavController(binding.navHostFragmentMain.getFragment())
        binding.bnvMain.setupWithNavController(navController)
    }
}