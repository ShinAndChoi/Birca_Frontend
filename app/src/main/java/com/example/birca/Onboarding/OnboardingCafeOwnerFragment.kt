package com.example.birca.Onboarding

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewModelScope
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentOnboardingCafeOwnerBinding
import com.example.birca.retrofit.APIS
import com.example.birca.retrofit.RetrofitInstance
import com.example.birca.sharedPreference.MyApplication
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File


class OnboardingCafeOwnerFragment :
    BaseFragment<FragmentOnboardingCafeOwnerBinding>(R.layout.fragment_onboarding_cafe_owner) {

    private lateinit var API: APIS


    var text_cafe_owner_name = ""
    var cafename = ""
    var number = ""
    lateinit var bitmap :Bitmap
    companion object {
        private const val PICK_IMAGE_REQUEST = 1
        private val galleryPermissionCode = 1

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Registers a photo picker activity launcher in single-select mode.
        val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            // Callback is invoked after the user selects a media item or closes the
            // photo picker.
            if (uri != null) {
                Log.d("PhotoPicker", "Selected URI: $uri")

                bitmap = BitmapFactory.decodeStream(
                    requireContext().contentResolver.openInputStream(uri)
                )
                binding.image.setImageBitmap(bitmap)
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

        //업로드 버튼 클릭
        binding.btnUpload.setOnClickListener {
//            requestGalleryPermission()
//            openGallery()
            // Launch the photo picker and let the user choose only images.
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))


        }

        //제출하기 버튼 클릭
        binding.btnSendCafeOwnerInfo.setOnClickListener {
            text_cafe_owner_name = binding.textCafeOwnerName.text.toString()
            cafename = binding.textCafename.text.toString()
            number =
                "${binding.textPhoneNum1.text}-${binding.textPhoneNum2.text}-${binding.textPhoneNum3.text}"

            Log.d("ownerinfo", "$text_cafe_owner_name, $cafename, $number")
//            val bitmap = binding.image.drawable.toBitmap()
            uploadImageToServer(text_cafe_owner_name, cafename, number, bitmap)
        }

    }

//    private fun openGallery() {
//
//        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//        startActivityForResult(intent, PICK_IMAGE_REQUEST)
//    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
//            data?.data?.let { imageUri ->
//                val bitmap = BitmapFactory.decodeStream(
//                    requireContext().contentResolver.openInputStream(imageUri)
//                )
//                binding.image.setImageBitmap(bitmap)
//            }
//        }
//    }

    private fun uploadImageToServer(
        cafeOwnerName: String,
        cafeName: String,
        number: String,
        bitmap: Bitmap
    ) {
        val mediaType = "image/jpeg".toMediaType()

        // Bitmap을 파일로 저장
        val file = File(requireContext().cacheDir, "image.jpg")
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val byteArray = stream.toByteArray()
        file.writeBytes(byteArray)

        val requestBody = file.asRequestBody(mediaType)
        val imagePart = MultipartBody.Part.createFormData("image", file.name, requestBody)

        Log.d("imagePart",imagePart.toString())
        API = RetrofitInstance.retrofitInstance().create(APIS::class.java)

        val accessToken = MyApplication.preferences.getString("accessToken", "")


        try {
            API.postCafeOwnerInfo(accessToken, cafeOwnerName, cafeName, number, imagePart).enqueue(
                object : Callback<Unit> {

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.isSuccessful) {


                            Log.d(
                                "postCafeOwnerInfo : ",
                                " success , ${response.body().toString()}"
                            )
                        } else {

                            Log.d(
                                "postCafeOwnerInfo Response : ",
                                "fail 1 ${
                                    response.body().toString()
                                } , ${response.message()}, ${response.errorBody().toString()}"
                            )
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Log.d("postCafeOwnerInfo Response : ", " fail 2 , ${t.message.toString()}")
                    }
                })
        } catch (e: Exception) {
            Log.d("postCafeOwnerInfo response : ", " fail 3 , ${e.message}")
        }

    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == galleryPermissionCode) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // 권한이 허용된 경우, 갤러리 접근 코드를 실행
//                // (예: 갤러리 열기)
//                openGallery()
//            } else {
//                // 사용자가 권한을 거부한 경우, 적절한 조치를 취할 수 있음
//            }
//        }
//    }

    // 갤러리 액세스 권한을 요청하는 함수
//    private fun requestGalleryPermission() {
//        if (ContextCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.READ_EXTERNAL_STORAGE
//            )
//            != PackageManager.PERMISSION_GRANTED
//        ) {
//            // 권한이 없는 경우, 권한 요청 다이얼로그를 표시
//            ActivityCompat.requestPermissions(
//                requireActivity(),
//                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                galleryPermissionCode
//            )
//        } else {
//            // 이미 권한이 허용된 경우, 갤러리 접근 코드를 실행
//            // (예: 갤러리 열기)
//            openGallery()
//        }
//    }


}