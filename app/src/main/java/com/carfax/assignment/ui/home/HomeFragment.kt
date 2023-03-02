package com.carfax.assignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.carfax.assignment.R
import com.carfax.assignment.core.utils.Constants
import com.carfax.assignment.data.model.CarRemoteModel
import com.carfax.assignment.data.model.WrappedHomeRemoteModel
import com.carfax.assignment.databinding.FragmentListingBinding
import com.carfax.assignment.ui.home.adapter.HomeAdapter
import com.carfax.assignment.ui.home.adapter.InteractionListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), InteractionListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var mainAdapter: HomeAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentListingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }


    private fun initObservers() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner, ::handleLoading)
        viewModel.successCarListings.observe(viewLifecycleOwner, ::handleSuccess)
        viewModel.successCar.observe(viewLifecycleOwner, ::handleCarSuccess)
        viewModel.errorCarListings.observe(viewLifecycleOwner, ::handleError)
    }

    private fun handleLoading(loading: Boolean) {
        binding.progressBar.isVisible = loading
    }

    private fun handleSuccess(list: List<CarRemoteModel>) {
        setHomeAdapter(list)
    }

    private fun handleCarSuccess(list: WrappedHomeRemoteModel) {
        setHomeAdapter(list.listings)
    }

    private fun handleError(exception: Exception) {
        Toast.makeText(
            activity,
            "Error in getting data ${exception.localizedMessage}",
            Toast.LENGTH_LONG
        ).show()

    }

    private fun setHomeAdapter(list: List<CarRemoteModel>) {
        recyclerView = binding.recyclerView
        mainAdapter = HomeAdapter(this, list)
        recyclerView.adapter = mainAdapter
    }

    override fun onClick(item: CarRemoteModel) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.CAR_MODEL_PARAM, item )

        findNavController().navigate(
            R.id.detailsFragment,
            bundle,
        )
    }
}
