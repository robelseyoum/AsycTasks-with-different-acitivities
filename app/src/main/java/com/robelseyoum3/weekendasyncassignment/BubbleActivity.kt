package com.robelseyoum3.weekendasyncassignment

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.second_main_layout.*

class BubbleActivity : AppCompatActivity() {

    private val TAG = "BubbleActivity"
    private var numbers: IntArray? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)

        Log.i(TAG, "Please now you are in bubble activity")

        var sortedResult: Int = 0

        var intent = intent

        numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)
        //Log.i(TAG, " Bubble Robel Acitivity ARRAY VALUES $numbers" )

        MyAsnc().execute()

    }

    //bubble sort
    fun bubbleSort(arr: IntArray?): IntArray {
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until arr!!.size - 1) {
                if (arr[i] > arr[i + 1]) {
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp

                    swap = true
                }
            }
        }
        return arr!!
    }


    inner class MyAsnc : AsyncTask<IntArray, IntArray, String>() {


        override fun onPreExecute() {

            super.onPreExecute()
            progress_id_second.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg arr: IntArray?): String {

            Thread.sleep(2000)

            // Loop through the first array elements
            var finalResult: String = ""

            val myArray = bubbleSort(numbers)
            //Log.d("Array", myArray.size.toString())

            for (i in 0 until myArray.size) {
               // Log.d("Array val", myArray[i].toString())
                finalResult = finalResult + myArray[i].toString()+" "
            }

            //Log.i(TAG, " Bubble sort doInBackgroung MyAsnc $finalResult")

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