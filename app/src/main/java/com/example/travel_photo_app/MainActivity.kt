package com.example.travel_photo_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var currentImageNo = 0
    lateinit var currentImage : ImageView
    val titleArray = arrayOf("Janakpurdham", "Pokhara", "Lumbini Temple", "Pashupatinath Temple", "Chitwan National Park", "Swayambhunath  Temple")
    val descriptionArray = arrayOf("Janakpurdham Temple, also known as Janaki Mandir, is a historic Hindu temple located in Janakpur, Nepal. It is dedicated to Goddess Sita, the consort of Lord Rama, and is renowned for its exquisite architecture, combining Mughal and Koiri styles. The temple is a significant pilgrimage site, attracting devotees from across Nepal and India, particularly during the Vivah Panchami festival celebrating the divine marriage of Sita and Rama.","Pokhara, nestled in the heart of Nepal, is renowned for its stunning natural beauty, including the serene Phewa Lake and the breathtaking views of the Annapurna mountain range. It's a hub for adventure tourism, offering activities like trekking, paragliding, and boating. This vibrant city also boasts a rich cultural heritage with charming temples and bustling local markets.","Lumbini Temple, located in Nepal, is the birthplace of Lord Buddha and a UNESCO World Heritage Site. It features the Maya Devi Temple, marking the exact spot of Buddha's birth, and is surrounded by tranquil gardens and ancient ruins. This sacred site attracts pilgrims and tourists from around the world, offering a serene and spiritual atmosphere.","Pashupatinath Temple, located in Kathmandu, Nepal, is a revered Hindu shrine dedicated to Lord Shiva, attracting thousands of pilgrims annually. This UNESCO World Heritage Site is famous for its stunning architecture and sacred atmosphere. The temple complex, situated on the banks of the Bagmati River, is also a significant cremation site, symbolizing the cycle of life and death.","Chitwan National Park, located in the subtropical Inner Terai lowlands of Nepal, is renowned for its rich biodiversity and is home to numerous endangered species, including the Bengal tiger and one-horned rhinoceros. Established in 1973, it spans 932 square kilometers and features a diverse landscape of forests, marshes, and grasslands. Recognized as a UNESCO World Heritage Site.","Swayambhunath, also known as the Monkey Temple, is a historic and sacred site located atop a hill in the Kathmandu Valley of Nepal. This ancient stupa, is renowned for its stunning architecture and panoramic views of the city. It holds deep spiritual significance for both Buddhists and Hindus, featuring a majestic golden spire adorned with the all-seeing eyes of Buddha.")

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextbtn = findViewById<ImageButton>(R.id.btnNext)
        val previousbtn = findViewById<ImageButton>(R.id.btnPrevious)

        nextbtn.setOnClickListener {
            var currentImageString = "pic"+currentImageNo
            var currentImageInt = this.resources.getIdentifier(currentImageString, "id", this.packageName)
            currentImage = findViewById(currentImageInt)
            currentImage.alpha = 0f

            currentImageNo = (6+currentImageNo + 1)%6

            var imageToShowString = "pic" + currentImageNo
            var imageToShowInt = this.resources.getIdentifier(imageToShowString, "id",this.packageName)
            currentImage = findViewById(imageToShowInt)
            currentImage.alpha = 1f

            val title = findViewById<TextView>(R.id.title1)
            title.text = titleArray[currentImageNo]

            val description = findViewById<TextView>(R.id.description1)
            description.text = descriptionArray[currentImageNo]

        }

        previousbtn.setOnClickListener {
            var currentImageString = "pic$currentImageNo"
            var currentImageInt = this.resources.getIdentifier(currentImageString, "id", packageName)
            currentImage = findViewById(currentImageInt)
            currentImage.alpha = 0f

            currentImageNo = (6+currentImageNo - 1)%6

            var imageToShowString = "pic$currentImageNo"
            var imageToShowInt = this.resources.getIdentifier(imageToShowString, "id",packageName)
            currentImage = findViewById(imageToShowInt)
            currentImage.alpha = 1f

            val title = findViewById<TextView>(R.id.title1)
            title.text = titleArray[currentImageNo]

            val description = findViewById<TextView>(R.id.description1)
            description.text = descriptionArray[currentImageNo]
        }
    }
}