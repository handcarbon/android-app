package eu.vonamor.learning.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import eu.vonamor.learning.databinding.FragmentEventDetailsBinding
import eu.vonamor.learning.databinding.FragmentHomeBinding

class EventDetailsFragment : Fragment() {

    private var _binding: FragmentEventDetailsBinding? = null

    val args: EventDetailsFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentEventDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val myNumber = args.detailsId
        binding.textView2.setText(myNumber.toString())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}