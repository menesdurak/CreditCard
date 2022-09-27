package com.menesdurak.creditcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.menesdurak.creditcard.databinding.FragmentFrontCardBinding
import com.menesdurak.creditcard.databinding.FragmentMainFrameBinding

class MainFrameFragment : Fragment() {

    private var _binding: FragmentMainFrameBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainFrameBinding.inflate(inflater, container, false)

        val fragmentTop = FrontCardFragment()
        val fragmentBottom = UserInfoFragment()
        childFragmentManager.beginTransaction().add(binding.flCard.id, fragmentTop).commit()
        childFragmentManager.beginTransaction().add(binding.flUserInfo.id, fragmentBottom).commit()
        val view = binding.root
        return view
    }

}