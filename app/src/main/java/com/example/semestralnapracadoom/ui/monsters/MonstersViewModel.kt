package com.example.semestralnapracadoom.ui.monsters

import androidx.lifecycle.ViewModel
import com.example.semestralnapracadoom.R

class MonstersViewModel : ViewModel() {
    val monsters = listOf(
        Monster(
            "Zombie Man" ,
            "Basic enemy" ,
            R.drawable.zombie_man
        ),
        Monster(
            "Shotgun Guy" ,
            "Though enemy" ,
            R.drawable.shotgun_guy
        ),
        Monster(
            "Imp" ,
            "Most annoing enemy" ,
            R.drawable.imp
        ),
        Monster(
            "Pinky" ,
            "Frickin Pinky!" ,
            R.drawable.pinky
        ),
        Monster(
            "Lost Soul" ,
            "Second most annoing enemy" ,
            R.drawable.lost_soul
        ),
        Monster(
            "Baron Of Hell" ,
            "Ide bomby!" ,
            R.drawable.baron_of_hell
        ),
        Monster(
            "Caco Demon" ,
            "Frickin Caco Demon!" ,
            R.drawable.caco_demon
        ),
        Monster(
            "Cyber Demon" ,
            "Run run run" ,
            R.drawable.cyber_demon
        ),
        Monster(
            "Spider Master Mind" ,
            "Teenejdz nindza turtls" ,
            R.drawable.spider_master_mind
        )
    )
}