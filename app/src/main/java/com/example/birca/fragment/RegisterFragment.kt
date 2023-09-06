package com.example.birca.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.birca.R
import com.example.birca.databinding.FragmentRegisterBinding
import com.example.birca.model.cafeRegisterInfoBody


class RegisterFragment : Fragment() {

    //권한 요청 코드
    private val REQUEST_PERMISSION_CODE = 1000

    private var PICK_IMAGE_REQUEST = 1

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    var cafe_name = ""
    var cafe_location = ""
    var cafe_introduction = ""
    var cafe_image_URI = ""
    var cafe_businessLicense_URI = ""
    var cafe_contact = ""

//    var registerInfo = cafeRegisterInfoBody(cafe_name,cafe_introduction,cafe_location,cafe_contact)
    //인스턴스 선언
//    fun newInstance() : RegisterFragment {
//        return RegisterFragment()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        //장소 선택
        binding.selectCafeLocation.setOnClickListener {

            val popupBase = binding.selectCafeLocation

            var pop = PopupMenu(context, popupBase)

            pop.menuInflater?.inflate(R.menu.cafe_loaction_list, pop.menu)

            pop.show()

            pop.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.hongdae_sinchon ->
                        binding.selectCafeLocation.setText("홍대/신촌")
                    R.id.seongsu_gundae ->
                        binding.selectCafeLocation.setText("성수/건대")
                    R.id.gangnam ->
                        binding.selectCafeLocation.setText("강남")
                }
                false
            }

            Log.d("cafe_location", cafe_location)
        }

        //카페 사진 클릭
        binding.btnCafeImage.setOnClickListener {

            when{
                ContextCompat.checkSelfPermission(requireContext(),
                android.Manifest.permission.READ_EXTERNAL_STORAGE) ==PackageManager.PERMISSION_GRANTED ->{
                    //접근 권한 허용 된 경우
                    Log.d("checkSelfPermission", "openGallery")
                    PICK_IMAGE_REQUEST = 3
                    openGallery()
                }

                shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {

                    Log.d("checkSelfPermission", "showPermissionContextPopup1")
                    //접근 권한 허용 필요
                    showPermissionContextPopup()
                }

                else -> {
                    Log.d("checkSelfPermission", "else")
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1000)
                }
            }

//            Log.d("btnCafeImage", "click")
//
//            if (ContextCompat.checkSelfPermission(
//                    requireContext(),
//                    android.Manifest.permission.READ_EXTERNAL_STORAGE
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                Log.d("btnCafeImage", "requestPermission")
//                requestPermission()
//            } else {
//                Log.d("btnCafeImage", "openGallery")
//                // 이미 권한이 부여된 경우 갤러리 열기 또는 다른 작업 수행
//                openGallery()
//            }
//
//            Log.d("btnCafeImage", "nothing")
        }

        //사업자등록증 클릭
        binding.btnBusinessLicense.setOnClickListener {

            when{
                ContextCompat.checkSelfPermission(requireContext(),
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) ==PackageManager.PERMISSION_GRANTED ->{
                    //접근 권한 허용 된 경우
                    Log.d("checkSelfPermission", "openGallery")
                    PICK_IMAGE_REQUEST = 4
                    openGallery()
                }

                shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {

                    Log.d("checkSelfPermission", "showPermissionContextPopup1")
                    //접근 권한 허용 필요
                    showPermissionContextPopup()
                }

                else -> {
                    Log.d("checkSelfPermission", "else")
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1000)
                }
            }
//            if (ContextCompat.checkSelfPermission(
//                    requireContext(),
//                    android.Manifest.permission.READ_EXTERNAL_STORAGE
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                requestPermission()
//            } else {
//                // 이미 권한이 부여된 경우 갤러리 열기 또는 다른 작업 수행
//                PICK_IMAGE_REQUEST = 3
//                openGallery()
//            }
        }

        //등록 버튼
        binding.btnRegister.setOnClickListener {

            cafe_name = binding.edittextCafeName.text.toString()
            cafe_location = binding.selectCafeLocation.text.toString()
            cafe_introduction = binding.edittextCafeInfo.text.toString()
            cafe_contact = binding.edittextCafeContact.text.toString()




            if (cafe_name == "") {
                Toast.makeText(context, "카페이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (cafe_location == "") {
                Toast.makeText(context, "카페장소를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (cafe_introduction == "") {
                Toast.makeText(context, "카페정보를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if (cafe_contact == "") {
                Toast.makeText(context, "카페연락처를 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                //통신하기


                //body에 담기
                var registerInfo =
                    cafeRegisterInfoBody(cafe_name, cafe_introduction, cafe_location, cafe_contact)
            }
        }


        return view
    }




    // 갤러리를 여는 함수
    private fun openGallery() {
        // 갤러리를 열고 이미지를 선택하는 코드를 여기에 추가합니다.
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val selectedImageUri = data.data
            // 이제 selectedImageUri를 사용하여 선택한 이미지의 URI를 처리할 수 있습니다.

            //카페 이미지 클릭시
            //glide로 imageview 적용
            if(PICK_IMAGE_REQUEST==3) {
                Glide.with(requireContext())
                    .load(selectedImageUri)
                    .into(binding.btnCafeImage)
            }

            if(PICK_IMAGE_REQUEST==4) {
                Glide.with(requireContext())
                    .load(selectedImageUri)
                    .into(binding.btnBusinessLicense)
            }


        }
    }

//    private fun requestPermission() {
//        if (shouldShowRequestPermissionRationale(
//                android.Manifest.permission.READ_EXTERNAL_STORAGE
//            )
//        ) {
//
//
//            showPermissionContextPopup()
//        }
//    }

    private fun showPermissionContextPopup() {
        Log.d("showPermissionContextPopup", "showPermissionContextPopup2")
        AlertDialog.Builder(requireContext())
            .setTitle("권한이 필요합니다")
            .setMessage("사진을 선택하려면 권한이 필요합니다.")
            .setPositiveButton("동의하기", {_, _ ->
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1000)
            })
            .setNegativeButton("취소하기",{ _,_ ->})
            .create()
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode) {
            1000-> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //권한 허용 클릭
                    openGallery()
                } else {
                    //권한 거부 클릭
                    Toast.makeText(requireContext(),"권한을 거부하셨습니다.",Toast.LENGTH_SHORT).show()
                }
            } else -> {
                Toast.makeText(requireContext(),"request code nothing",Toast.LENGTH_SHORT).show()
            }
        }
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == REQUEST_PERMISSION_CODE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // 권한이 부여된 경우 갤러리 열기 또는 다른 작업 수행
//                openGallery()
//                Log.d("openGallery???","openGallery???")
//            } else {
//                // 권한이 거부된 경우 사용자에게 알림을 표시하거나 다른 조치를 취할 수 있습니다.
//                Toast.makeText(requireContext(), "권한 거부", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }


}