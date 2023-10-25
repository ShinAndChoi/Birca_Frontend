package com.example.birca.fragment

import android.graphics.Color
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.birca.FragmentActivity
import com.example.birca.R
import com.example.birca.base.BaseFragment
import com.example.birca.databinding.FragmentChooseDateBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.MaterialCalendarView.SELECTION_MODE_MULTIPLE
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter
import java.util.Calendar


class ChooseDateFragment : BaseFragment<FragmentChooseDateBinding>(R.layout.fragment_choose_date) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentActivity = activity as FragmentActivity

        val bottomNav = fragmentActivity.findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

//

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)


        var startTimeCalendar = Calendar.getInstance()
//        var endTimeCalendar = Calendar.getInstance()

        val currentYear = startTimeCalendar.get(Calendar.YEAR)
        val currentMonth = startTimeCalendar.get(Calendar.MONTH)
        val currentDate = startTimeCalendar.get(Calendar.DATE)


        binding.calendar.setTitleFormatter(MonthArrayTitleFormatter(resources.getTextArray(R.array.custom_months)))
        binding.calendar.setWeekDayFormatter(ArrayWeekDayFormatter(resources.getTextArray(R.array.custom_weekdays)))


        binding.calendar.state().edit().setFirstDayOfWeek(Calendar.SUNDAY).commit()

        val stCalendarDay = CalendarDay(currentYear,currentMonth,currentDate)

        val beforeTodayDecorator = BeforeTodayDecorator(stCalendarDay)

        binding.calendar.addDecorator(beforeTodayDecorator)

        binding.calendar.selectionMode = SELECTION_MODE_MULTIPLE

        binding.calendar.setOnDateChangedListener { widget, date, selected ->

//            var dateList = ArrayList<CalendarDay>()
//            dateList.add(date)
            val year = date.year
            val month = date.month+1
            val dayOfMonth = date.day

            var selectedDate = ""

            selectedDate = dateToString(year,month,dayOfMonth)
//            viewModel.addDateList(selectedDate)
//            Log.d("dateList",viewModel.dateList.value.toString())
            Log.d("click",selectedDate)


        }


        binding.btnBack.setOnClickListener {
            val reservedCafeListFragment = ReservedCafeListFragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.frameArea, reservedCafeListFragment)
//                addToBackStack(null)
                commit()
            }
        }






    }

    fun dateToString(y : Int, m : Int, d : Int) : String {
        var year = y.toString()
        var month = m.toString()
        var day = d.toString()
        if(m<10) {
            month = "0${m}"
        }

        if (d<10){
            day = "0${d}"
        }

        return "${year}-${month}-${day}"
    }




}
class BeforeTodayDecorator(min:CalendarDay):DayViewDecorator {

    val minDay = min
    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return (day?.month!! <= minDay.month && day.day < minDay.day) ||(day?.month!! < minDay.month)
    }
    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(object:ForegroundColorSpan(Color.parseColor("#d2d2d2")){})
        view?.setDaysDisabled(true)
    }
}


