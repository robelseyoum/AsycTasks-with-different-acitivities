package com.robelseyoum3.weekendasyncassignment

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main_layout.*

class MergeActivity : AppCompatActivity(){

    private val TAG = "MergeActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)


        Log.i(TAG, "Please now you are in MergeActivity activity")

        var sortedResult: Int = 0

        var intent = intent

        var numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)


        //Log.i(TAG, " Insertion Robel Acitivity ARRAY VALUES $numbers" )


        //val myArray = insertionsort(numbers)


        val myArray = mergeSort(numbers.toMutableList())

        // Loop through the first array elements
        for (element in myArray){
            tv_alg_result.text = tv_alg_result.text.toString() + element + ", "
        }

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




}