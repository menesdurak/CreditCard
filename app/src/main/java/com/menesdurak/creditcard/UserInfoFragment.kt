package com.menesdurak.creditcard

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.menesdurak.creditcard.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TextWatcher for creditcard number is taken from:
        //Hannu Leinonen
        //https://gist.github.com/hleinone/5b445e5475ca9f8a3bdc6a44998f4edd
        binding.etCreditCardNumber.addTextChangedListener(object: TextWatcher {
            private var current = ""

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable) {
                if (p0.toString() != current) {
                    val userInput = p0.toString().replace(UserInfoFragment.nonDigits, "")
                    if (userInput.length <= 16) {
                        current = userInput.chunked(4).joinToString(" ")
                        p0.filters = arrayOfNulls<InputFilter>(0)
                    }
                    p0.replace(0, p0.length, current, 0, current.length)
                }
            }
        })
    }
    companion object {
        private val nonDigits = Regex("[^\\d]")
    }

}