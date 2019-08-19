package com.robelseyoum3.weekendasyncassignment

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main_layout.*

class InsertionActivity : AppCompatActivity() {

    private val TAG = "QuickActivity"
    private var numbers: IntArray? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)


        Log.i(TAG, "Please now you are in Insertion activity")

        var intent = intent

        numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)

        MyAsnc().execute()

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
        //arr!!.size
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

    inner class MyAsnc : AsyncTask<IntArray, IntArray, String>(){

        override fun onPreExecute() {

            super.onPreExecute()
            progress_id_second.visibility = View.VISIBLE
        }


        override fun doInBackground(vararg p0: IntArray?): String {

            Thread.sleep(2000)

            // Loop through the first array elements
            var finalResult: String = ""

            val myArray = insertionsort(numbers!!.toMutableList())
            //Log.d("Array", myArray.size.toString())

            for (i in 0 until myArray.size) {
                // Log.d("Array val", myArray[i].toString())
                finalResult = finalResult + myArray[i].toString()+" "
            }

            //Lsog.i(TAG, " Bubble sort doInBackgroung MyAsnc $finalResult")

            return finalResult
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            progress_id_second.visibility = View.GONE
            //set result in textView
            tv_alg_result.text = result

        }

    }
}
