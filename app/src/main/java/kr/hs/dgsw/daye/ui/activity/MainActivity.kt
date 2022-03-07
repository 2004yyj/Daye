package kr.hs.dgsw.daye.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import kr.hs.dgsw.daye.databinding.ActivityMainBinding
import kr.hs.dgsw.daye.ui.util.findNavController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        navController = findNavController(binding.navHostFragmentMain.getFragment())
        binding.bnvMain.setupWithNavController(navController)
    }
}