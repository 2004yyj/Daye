package kr.hs.dgsw.daye.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import kr.hs.dgsw.daye.R
import kr.hs.dgsw.daye.databinding.FragmentHomeBinding
import kr.hs.dgsw.daye.ui.adapter.ViewPagerAdapter
import kr.hs.dgsw.daye.ui.fragment.tea.*
import kr.hs.dgsw.daye.ui.util.viewBindings

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by viewBindings(FragmentHomeBinding::inflate)
    private lateinit var tabLayoutMediator: TabLayoutMediator
    private lateinit var tabArray: Array<String>
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabArray = resources.getStringArray(R.array.tabArray)
        viewPagerAdapter = ViewPagerAdapter(this,
            arrayListOf(
                RecommendFragment(),
                GreenTeaFragment(),
                WhiteTeaFragment(),
                YellowTeaFragment(),
                OolongTeaFragment(),
                BlackTeaFragment(),
                DarkTeaFragment()
            )
        )
        with(binding.viewPagerHome) {
            adapter = viewPagerAdapter
            isSaveEnabled = false
        }

        tabLayoutMediator = TabLayoutMediator(
            binding.tabLayoutHome,
            binding.viewPagerHome,
        ) { tab, position ->
            tab.text = tabArray[position]
        }
        tabLayoutMediator.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        tabLayoutMediator.detach()
    }
}