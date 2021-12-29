package app.takasu.kon.firebasecloudstoragetest

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.File

class MainActivity : AppCompatActivity() {
    var storage = Firebase.storage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var storageRef = storage.reference
        var imageRef = storageRef.child("images")

        val fileName = "utokyo.png"
        var utokyoRef = imageRef.child(fileName)

        val iconImageView = findViewById<ImageView>(R.id.iconImage)

        utokyoRef.downloadUrl.addOnSuccessListener { url ->
            Glide.with(this)
                .load(url)
                .placeholder(R.drawable.seiko_icon)
                .into(iconImageView)
        }

//        val ONE_MEGABYTE: Long = 1024*1024
//
//        utokyoRef.getBytes(ONE_MEGABYTE).addOnSuccessListener {
//            val bitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
//            iconImageView.setImageBitmap(bitmap)
//        }

//        val uploadButton = findViewById<Button>(R.id.uploadButton)

//        uploadButton.setOnClickListener {
//            selectImage()
//        }
    }

//    private val launcher = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    )
//
//    private fun selectImage() {
//    }
}