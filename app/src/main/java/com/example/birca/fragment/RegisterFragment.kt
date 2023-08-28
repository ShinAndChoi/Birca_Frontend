package com.example.birca.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import com.example.birca.R
import com.example.birca.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    var cafe_name = ""
    var cafe_location = ""
    var cafe_introduction = ""
    var cafe_file = ""
    var cafe_contact =""

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
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        val view = binding.root




        //장소 선택
        binding.selectCafeLocation.setOnClickListener {

            val popupBase = binding.selectCafeLocation

            var pop = PopupMenu(context,popupBase)

            pop.menuInflater?.inflate(R.menu.cafe_loaction_list,pop.menu)

            pop.show()

            pop.setOnMenuItemClickListener { item->
                when(item.itemId){
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


        //등록 버튼
        binding.btnRegister.setOnClickListener {

            cafe_name = binding.edittextCafeName.text.toString()
            cafe_location = binding.selectCafeLocation.text.toString()
            cafe_introduction = binding.edittextCafeInfo.text.toString()
            cafe_contact = binding.edittextCafeContact.text.toString()



            if (cafe_name=="") {
                Toast.makeText(context,"카페이름을 입력해주세요",Toast.LENGTH_SHORT).show()
            } else if( cafe_location =="") {
                Toast.makeText(context,"카페장소를 입력해주세요",Toast.LENGTH_SHORT).show()
            } else if(cafe_introduction=="") {
                Toast.makeText(context,"카페정보를 입력해주세요",Toast.LENGTH_SHORT).show()
            } else if( cafe_contact=="") {
                Toast.makeText(context,"카페연락처를 입력해주세요",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context,"다음페이지 이동",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }


}