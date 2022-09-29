package com.menesdurak.creditcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import com.menesdurak.creditcard.databinding.FragmentBackCardBinding

class BackCardFragment : Fragment() {

    private var _binding: FragmentBackCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBackCardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToBack.setOnClickListener {
            parentFragmentManager.beginTransaction().setCustomAnimations(
                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace<FrontCardFragment>(R.id.flCard)
                .addToBackStack(null)
                .commit()
        }
    }

}