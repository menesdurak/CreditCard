package com.menesdurak.creditcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.menesdurak.creditcard.databinding.FragmentFrontCardBinding

class FrontCardFragment : Fragment() {

    private var _binding: FragmentFrontCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFrontCardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToBack.setOnClickListener {
            val backFragment = BackCardFragment()
            childFragmentManager.beginTransaction().replace(R.id.frmFront, backFragment).commit()
        }
    }
}
