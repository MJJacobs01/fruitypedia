package com.josdem.fruitypedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.josdem.fruitypedia.databinding.FragmentCategoryBinding
import com.josdem.fruitypedia.state.ApplicationState


class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ApplicationState.storeValue("categoryFragment", this)
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    fun displayResults(categories: ArrayList<String>) {
        val listView = view?.findViewById(R.id.listViewCategories) as ListView
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter<String>(view!!.context, R.layout.list_category, R.id.categoryTextView, categories)
        listView.adapter = arrayAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}