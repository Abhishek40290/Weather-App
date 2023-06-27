package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.myapplication.databinding.ActivityCameraBinding


class CameraActivity : AppCompatActivity() {
    private val reqImgCapture = 1
    private lateinit var binding :  ActivityCameraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {
            takePictureIntent()
        }
    }

    private fun takePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, reqImgCapture)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "Camera app not found.", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }

    }

    @Deprecated("deprecated")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == reqImgCapture && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.imgViewer.setImageBitmap(imageBitmap)
        }
    }

}