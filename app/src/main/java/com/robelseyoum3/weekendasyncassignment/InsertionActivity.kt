package com.robelseyoum3.weekendasyncassignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main_layout.*

class InsertionActivity : AppCompatActivity() {

    private val TAG = "QuickActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)


        Log.i(TAG, "Please now you are in Insertion activity")

        var sortedResult: Int = 0

        var intent = intent

        var numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)


        //Log.i(TAG, " Insertion Robel Acitivity ARRAY VALUES $numbers" )



        //val myArray = insertionsort(numbers)

        val myArray = insertionsort(numbers.toMutableList())

        // Loop through the first array elements
        for (element in myArray){
            tv_alg_result.text = tv_alg_result.text.toString() + element + ", "
        }


    }

    //Insertion Sort in Kotlin
//    fun insertionsort(arr:IntArray):IntArray{
//
//        for (j in 1..arr.size - 1){
//            var i = j - 1
//            val processedValue = arr[j]
//            while ( (i >= 0) && (arr[i] > processedValue) ){
//                arr[i + 1] = arr[i]
//                i--
//            }
//            arr[i + 1] = processedValue
//        }
//        return arr
//    }

    fun insertionsort(items:MutableList<Int>):List<Int>{
        if (items.isEmpty() || items.size<2){
            return items
        }
        for (count in 1..items.count() - 1){
            // println(items)
            val item = items[count]
            var i = count
            while (i>0 && item < items[i - 1]){
                items[i] = items[i - 1]
                i -= 1
            }
            items[i] = item
        }
        return items
    }
}
