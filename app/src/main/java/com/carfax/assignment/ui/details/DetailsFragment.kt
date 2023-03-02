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
import com.carfax.assignment.data.model.CarRemoteModel
import com.carfax.assignment.databinding.FragmentDetailsBinding
import com.carfax.assignment.utils.Constants
import com.carfax.assignment.utils.Constants.CAR_MODEL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private var listingItem: CarRemoteModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
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

    private fun initData() {
        listingItem = arguments?.getParcelable(CAR_MODEL)
        binding.item = listingItem
    }

    private fun startCall(phoneNumber: String) {
        val dialIntent = Intent(Intent.ACTION_CALL)
        dialIntent.data = Uri.parse("tel:$phoneNumber")
        requireActivity().startActivity(dialIntent)
    }

}