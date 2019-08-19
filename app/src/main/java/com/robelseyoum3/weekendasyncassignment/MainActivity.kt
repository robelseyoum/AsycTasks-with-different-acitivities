package com.robelseyoum3.weekendasyncassignment

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MyActivity"



    override fun onClick(view: View?) {

        var intent: Intent? = null

        if (et_numbers.text.isEmpty()) {
            tv_title.text = "Please insert the numbers "
        } else {


            var numbs = et_numbers.text.toString().split(",").toTypedArray()

            val numArray = numbs.map { it.toInt() }

            Log.i(TAG, " Main Robel Acitivity ARRAY VALUES $numArray.toIntArray()" )

            when (view!!.id) {

                R.id.btn_bubble -> {
                    intent = Intent(this, BubbleActivity::class.java)

                }

                R.id.btn_insertion -> {
                    intent = Intent(this,InsertionActivity::class.java)
                }

                R.id.btn_quick -> {
                    intent = Intent(this, QuickActivity::class.java)
                }


                R.id.btn_merge -> {
                    intent = Intent(this, MergeActivity::class.java)
                }
            }

            intent!!.putExtra(Constants.INTENT_CALL1, numArray.toIntArray())
            startActivity(intent)
            //progress_id.visibility = View.VISIBLE


        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_bubble.setOnClickListener(this)
        btn_insertion.setOnClickListener(this)
        btn_quick.setOnClickListener(this)
        btn_merge.setOnClickListener(this)

       // progress_id.setVisibility(View.VISIBLE)
    }

    /*

        1,6,20,4,17,19,20,3,14,10,16,2,16,19,17,2,11,1,15,4,8,12,1,15,9,7,12,18,8,1,18,7,16,1217,8,4,1,5,13,15,4,19,20,10,2,
        8,12,1,15,9,7,12,14,10,16,17,816,13,9,10,2,19,17,2,11,1,15,4,8,12,1,15,9,7,12,18,8,1,18,7,16,12,4,1,13,9,10,2,1,6,20,4,17,19,20,3,14,10,16,17,8,4,
       5,13,15,4,19,20,10,2,16,13,9,10,2,19,17,2,11,1,15,4,8,12,1,15,9,7,12,18,8,1,18,7,16,12,1,6,20,4,17,19,20,3,14,10,16,17,8,4,1,5,13,15,4,19,20,10,
        1,5,13,15,4,19,20,10,2,16,13,9,10,2,19,17,2,11,1,15,4,8,12,1,15,9,7,12,18,8,1,18,7,16,12,1,6,20,4,17,19,20,3,14,10,16,17

     */

}
