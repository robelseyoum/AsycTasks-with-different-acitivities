package com.robelseyoum3.weekendasyncassignment

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main_layout.*

class QuickActivity : AppCompatActivity() {

    private val TAG = "QuickActivity"
    var numbers: IntArray = intArrayOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)



        Log.i(TAG, "Please now you are in QuickActivity activity")

        var sortedResult: Int = 0

        var intent = intent

        numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)


        //Log.i(TAG, " Insertion Robel Acitivity ARRAY VALUES $numbers" )

        quickSort(numbers, 0, numbers.size-1)


        // Loop through the first array elements
        for (element in numbers){
            tv_alg_result.text = tv_alg_result.text.toString() + element + ", "
        }
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



}
