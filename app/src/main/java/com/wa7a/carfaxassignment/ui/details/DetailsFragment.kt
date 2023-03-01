package com.wa7a.carfaxassignment.ui.details


import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.wa7a.carfaxassignment.data.model.ListingsRemoteModel
import com.wa7a.carfaxassignment.databinding.FragmentDetailsBinding
import com.wa7a.carfaxassignment.utils.Constants
import com.wa7a.carfaxassignment.utils.Constants.CAR_MODEL


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private var listingItem: ListingsRemoteModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        initViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonDetails.setOnClickListener { onClickButton() }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
        activity?.actionBar?.hide()
        activity?.window?.statusBarColor = resources.getColor(android.R.color.transparent)


    }

    private fun onClickButton() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                context as Activity, arrayOf(Manifest.permission.CALL_PHONE),
                Constants.REQUEST_PHONE_CALL
            )
        } else {
            startCall(requireNotNull(listingItem?.dealer?.phone))
        }
    }

    private fun initViews(): ListingsRemoteModel? {
        listingItem = arguments?.getParcelable<ListingsRemoteModel>(CAR_MODEL)
        binding.item = listingItem
        return listingItem
    }

    private fun startCall(phoneNumber: String) {
        val dialIntent = Intent(Intent.ACTION_CALL)
        dialIntent.data = Uri.parse("tel:$phoneNumber")
        requireContext()?.startActivity(dialIntent)
    }

}