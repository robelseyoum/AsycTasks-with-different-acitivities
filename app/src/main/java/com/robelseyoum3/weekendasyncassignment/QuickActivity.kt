package com.robelseyoum3.weekendasyncassignment

import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main_layout.*

class QuickActivity : AppCompatActivity() {

    private val TAG = "QuickActivity"
    var numbers: IntArray = intArrayOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)

        Log.i(TAG, "Please now you are in QuickActivity activity")

        var intent = intent

        numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)

        MyAsnc().execute()

    }

    fun quickSort(array: IntArray, left: Int, right: Int) {

        val index = partition (array, left, right)

        if(left < index-1) { // 2) Sorting left half
            quickSort(array, left, index-1)
        }
        if(index < right) { // 3) Sorting right half
            quickSort(array,index, right)
        }
    }

    fun partition(array: IntArray, l: Int, r: Int): Int {
        var left = l
        var right = r
        val pivot = array[(left + right)/2] // 4) Pivot Point
        while (left <= right) {
            while (array[left] < pivot) left++ // 5) Find the elements on left that should be on right

            while (array[right] > pivot) right-- // 6) Find the elements on right that should be on left

            // 7) Swap elements, and move left and right indices
            if (left <= right) {
                swapArray(array, left,right)
                left++
                right--
            }
        }
        return left
    }

    fun swapArray(a: IntArray, b: Int, c: Int) {
        val temp = a[b]
        a[b] = a[c]
        a[c] = temp
    }


    inner class MyAsnc : AsyncTask<IntArray, IntArray, String>() {


        override fun onPreExecute() {
            super.onPreExecute()
            progress_id_second.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: IntArray?): String {

            Thread.sleep(2000)

            // Loop through the first array elements
            var finalResult: String = ""

            quickSort(numbers, 0, numbers.size-1)
            //Log.d("Array", myArray.size.toString())

            for (i in 0 until numbers.size) {
                // Log.d("Array val", myArray[i].toString())
                finalResult = finalResult + numbers[i].toString()+" "
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
