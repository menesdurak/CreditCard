package com.menesdurak.creditcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.replace
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
            parentFragmentManager.beginTransaction().setCustomAnimations(
                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace<BackCardFragment>(R.id.flCard)
                .addToBackStack(null)
                .commit()
        }
    }
}
