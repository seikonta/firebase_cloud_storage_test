package app.takasu.kon.firebasecloudstoragetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class MainActivity : AppCompatActivity() {
    var storage = Firebase.storage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var storageRef = storage.reference
        var imageRef = storageRef.child("images")

        val fileName = "utokyo.png"
        var utokyoRef = imageRef.child(fileName)
//        var utokyoRef = imageRef.child("images/utokyo.png")

        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        nameTextView.text = utokyoRef.name

        val iconImageView = findViewById<ImageView>(R.id.iconImage)

        Glide.with(this)
            .load(utokyoRef)
            .into(iconImageView)
    }
}