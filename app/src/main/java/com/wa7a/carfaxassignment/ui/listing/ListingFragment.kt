package com.wa7a.carfaxassignment.ui.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.carfaxassignment.R
import com.wa7a.carfaxassignment.data.model.ListingsRemoteModel
import com.wa7a.carfaxassignment.databinding.FragmentListingBinding
import com.wa7a.carfaxassignment.ui.listing.adapters.CarListingsAdapter
import com.wa7a.carfaxassignment.ui.listing.adapters.InteractionListener
import com.wa7a.carfaxassignment.ui.main.MainViewModel
import com.wa7a.carfaxassignment.utils.Constants.CAR_MODEL


class ListingFragment : Fragment(), InteractionListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var mainAdapter: CarListingsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentListingBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListingBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerView
        mainAdapter = CarListingsAdapter(this)
        recyclerView.adapter = mainAdapter

        viewModel.carListingsSuccess.observe(viewLifecycleOwner) {
            if (it.body()?.listings != null) {
                mainAdapter.setContentList(it.body()?.listings!!)
            }
        }

        viewModel.carListingsError.observe(viewLifecycleOwner) {
            Toast.makeText(
                activity,
                "Error in getting data ${it.localizedMessage}",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    override fun onClick(item: ListingsRemoteModel) {
        findNavController().navigate(
            R.id.detailsFragment,
            bundleOf(CAR_MODEL to item)
        )
    }
}