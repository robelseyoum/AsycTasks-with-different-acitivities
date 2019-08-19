package com.robelseyoum3.weekendasyncassignment

import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main_layout.*

class MergeActivity : AppCompatActivity(){

    private val TAG = "MergeActivity"
    private var numbers: IntArray? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)


        Log.i(TAG, "Please now you are in MergeActivity activity")

        var sortedResult: Int = 0

        var intent = intent

        numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)

        MyAsnc().execute()
    }


    //Mereg Sort in Kotlin
    fun mergeSort(list: List<Int>): List<Int> {
        if (list.size <= 1) {
            return list
        }

        val middle = list.size / 2
        var left = list.subList(0,middle);
        var right = list.subList(middle,list.size);

        return merge(mergeSort(left), mergeSort(right))
    }

    fun merge(left: List<Int>, right: List<Int>): List<Int>  {
        var indexLeft = 0
        var indexRight = 0
        var newList : MutableList<Int> = mutableListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }
        return newList;
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


            val myArray = mergeSort(numbers!!.toMutableList())
            //Log.d("Array", myArray.size.toString())

            for (i in 0 until myArray.size) {
                // Log.d("Array val", myArray[i].toString())
                finalResult = finalResult + myArray[i].toString()+" "
            }

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