package com.example.appq

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class videoplayer : AppCompatActivity() {
    var videoUrl:String? = null
    lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoplayer)

        videoUrl = intent.extras?.getString("videoUrl")

        videoView = findViewById(R.id.videoview);

        val uri: Uri = Uri.parse(videoUrl)

        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)

        mediaController.setMediaPlayer(videoView)

        videoView.setMediaController(mediaController)
        videoView.start()

    }
}