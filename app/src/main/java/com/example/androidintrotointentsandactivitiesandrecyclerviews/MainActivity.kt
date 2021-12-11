package com.example.androidintrotointentsandactivitiesandrecyclerviews
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.androidintrotointentsandactivitiesandrecyclerviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_main)
        setContentView(binding!!.root)
        binding!!.share.setOnClickListener {

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Share with?")
            startActivity(shareIntent)
        }
        binding!!.next.setOnClickListener {

            val nextActivity = Intent(this, Contentview::class.java)
            startActivity(nextActivity)

        }

        binding!!.selectimage.setOnClickListener {
//           val intent = Intent(Intent.ACTION_PICK)
//            intent.type="image/*"
//            startActivity(intent)
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type="image/*"
                startActivityForResult(it,0)
            }
        }
        binding!!.btncamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK && requestCode==0)
        {
//           binding!!.imageView.setImageURI(data?.data)
            var uri=data?.data
            var imagefile= binding!!.imageView.setImageURI(uri)
        }

    }
}

