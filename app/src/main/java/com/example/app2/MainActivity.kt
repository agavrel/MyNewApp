package com.example.app2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Timestamp
import android.provider.MediaStore
import android.content.Intent
import android.graphics.Bitmap





class MainActivity : AppCompatActivity() {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val extras = data!!.extras
            val imageBitmap = extras!!.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*val i = 0
        for (i in 1..100000000)
        {*/
           // Thread.sleep(1_0000)
       // while (true) {
         //   Thread.sleep(1_0000)
        button.setOnClickListener {
            val n = Timestamp(System.currentTimeMillis()).getTime() % 9//only 3 would work
            if (isPowerOfThree(n)) {
                sample_text.text = debugString("power of three") + n


            } else
                sample_text.text = debugString("regular number") + n
        }

        button2.setOnClickListener {
            dispatchTakePictureIntent()
        }
       // }
            //Thread.sleep(1_000)
       // }

          ;//  (stringFromJNI(3))
        // Example of a call to a native method
//        val n = 8;
        //if (is_powerOfThree(8) == true)//n == 8u) //
           // sample_text.text = stringFromJNI(3)
      //  val n = is_powerOfThree(3)

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //     external fun stringFromJNI(i: ): Boolean
    external fun isPowerOfThree(other: Long): Boolean
    external fun debugString(other: String): String

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }




    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")


        }
    }
}
