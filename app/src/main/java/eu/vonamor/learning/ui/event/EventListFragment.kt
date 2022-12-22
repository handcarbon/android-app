package eu.vonamor.learning.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import eu.vonamor.learning.R
import eu.vonamor.learning.databinding.FragmentEventListBinding

class EventListFragment : Fragment() {

    private var _binding: FragmentEventListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEventListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button2.setOnClickListener { view ->
            val action = EventListFragmentDirections.navigateToDetails(20)
            Navigation.findNavController(view).navigate(action)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}