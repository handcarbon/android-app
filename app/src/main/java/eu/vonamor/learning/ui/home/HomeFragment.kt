package eu.vonamor.learning.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import eu.vonamor.learning.MainActivity2
import eu.vonamor.learning.R
import eu.vonamor.learning.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.button.setOnClickListener { view ->
                Navigation.findNavController(view).navigate(R.id.navigateToList)
        }

        binding.button3.setOnClickListener { view ->
            val msg = binding.editTextTextPersonName.text.toString()
            val intent = Intent(activity, MainActivity2::class.java)
            intent.putExtra("msg", msg)
            startActivity(intent)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}