package com.example.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tasks.databinding.FragmentTasksBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TasksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TasksFragment : Fragment() {

private var _binding:FragmentTasksBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentTasksBinding.inflate(inflater,container,false)
        val view=binding.root

        val application= requireNotNull(this.activity).application
        val dao=TaskDatabase.getInstance(application).taskDao
        val viewModelFactory=TasksViewModelFactory(dao)
        val viewModel=ViewModelProvider(
            this,viewModelFactory).get(TasksViewModel::class.java)
        binding.viewModel=viewModel

        binding.lifecycleOwner=viewLifecycleOwner

        // Inflate the layout for this fragment
        return view
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}