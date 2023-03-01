package com.carfax.assignment.ui.details


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.carfax.assignment.data.model.ListingsRemoteModel
import com.carfax.assignment.databinding.FragmentDetailsBinding
import com.carfax.assignment.utils.Constants
import com.carfax.assignment.utils.Constants.CAR_MODEL


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