package com.robelseyoum3.weekendasyncassignment

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.second_main_layout.*

class BubbleActivity : AppCompatActivity() {

    private val TAG = "BubbleActivity_Roba"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main_layout)

        Log.i(TAG, "Please now you are in bubble activity")

        var sortedResult: Int = 0

        var intent = intent


        var numbers = intent.getIntArrayExtra(Constants.INTENT_CALL1)


        //Log.i(TAG, " Bubble Robel Acitivity ARRAY VALUES $numbers" )

        val myArray = bubbleSort(numbers)

        // Loop through the first array elements
        for (element in myArray){
            tv_alg_result.text = tv_alg_result.text.toString() + element + ", "
        }


    }


    //bubble sort
    fun bubbleSort(arr:IntArray):IntArray{
        var swap = true
        while(swap){
            swap = false
            for(i in 0 until arr.size-1){
                if(arr[i] > arr[i+1]){
                    val temp = arr[i]
                    arr[i] = arr[i+1]
                    arr[i + 1] = temp

                    swap = true
                }
            }
        }
        return arr
    }

}