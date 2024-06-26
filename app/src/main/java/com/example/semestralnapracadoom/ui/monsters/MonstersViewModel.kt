package com.example.semestralnapracadoom.ui.monsters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semestralnapracadoom.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MonstersViewModel : ViewModel() {
    val monsters = listOf(
        Monster(
            "Zombie Man" ,
            "Health: 20\n" +
                    "Minimum damage: 3\n" +
                    "Maximum damage: 15" ,
            R.drawable.zombie_man0,
            R.drawable.zombie_man1,
            R.drawable.zombie_man2,
            R.drawable.zombie_man3,
            R.drawable.zombie_man0
            ),
        Monster(
            "Shotgun Guy" ,
            "Health: 30\n" +
                    "Minimum damage: 9\n" +
                    "Maximum damage: 45" ,
            R.drawable.shotgun_guy0,
            R.drawable.shotgun_guy1,
            R.drawable.shotgun_guy2,
            R.drawable.shotgun_guy3,
            R.drawable.shotgun_guy0
        ),
        Monster(
            "Imp" ,
            "Health: 60\n" +
                    "Minimum damage: 3\n" +
                    "Maximum damage: 24" ,
            R.drawable.imp0,
            R.drawable.imp1,
            R.drawable.imp2,
            R.drawable.imp3,
            R.drawable.imp0
        ),
        Monster(
            "Pinky" ,
            "Health: 150\n" +
                    "Minimum damage: 4\n" +
                    "Maximum damage: 24" ,
            R.drawable.pinky0,
            R.drawable.pinky1,
            R.drawable.pinky2,
            R.drawable.pinky3,
            R.drawable.pinky0
        ),
        Monster(
            "Lost Soul" ,
            "Health: 100\n" +
                    "Minimum damage: 3\n" +
                    "Maximum damage: 24" ,
            R.drawable.lost_soul0,
            R.drawable.lost_soul1,
            R.drawable.lost_soul2,
            R.drawable.lost_soul3,
            R.drawable.lost_soul0
        ),
        Monster(
            "Baron Of Hell" ,
            "Health: 1000\n" +
                    "Minimum damage: 10 (Melee) 8 (Ranged)\n" +
                    "Maximum damage: 80 (Melee) 64 (Ranged)" ,
            R.drawable.baron_of_hell0,
            R.drawable.baron_of_hell1,
            R.drawable.baron_of_hell2,
            R.drawable.baron_of_hell3,
            R.drawable.baron_of_hell0
        ),
        Monster(
            "Caco Demon" ,
            "Health: 400\n" +
                    "Minimum damage: 10 (Melee) 5 (Ranged)\n" +
                    "Maximum damage: 60 (Melee) 40 (Ranged)" ,
            R.drawable.caco_demon0,
            R.drawable.caco_demon1,
            R.drawable.caco_demon2,
            R.drawable.caco_demon3,
            R.drawable.caco_demon0
        ),
        Monster(
            "Cyber Demon" ,
            "Health: 4000\n" +
                    "Minimum damage: 20 (Direct Hit) 0 (Blast Damage)\n" +
                    "Maximum damage: 160 (Direct Hit) 128 (Blast Damage)" ,
            R.drawable.cyber_demon0,
            R.drawable.cyber_demon1,
            R.drawable.cyber_demon2,
            R.drawable.cyber_demon3,
            R.drawable.cyber_demon0
        ),
        Monster(
            "Spider Master Mind" ,
            "Health: 3000\n" +
                    "Minimum damage: 3 (Per Pellet)\n" +
                    "Maximum damage: 15 (Per Pellet)" ,
            R.drawable.spider_master_mind0,
            R.drawable.spider_master_mind1,
            R.drawable.spider_master_mind2,
            R.drawable.spider_master_mind3,
            R.drawable.spider_master_mind0
        )
    )

    init {
        animation()
    }

    fun animation() {
        viewModelScope.launch {
            while (isActive) {
                delay(250) // Pozastaví korutinu na 250 milisekúnd
                monsters.forEach {
                    val nextFrame = when (it.imageResId) {
                        it.image0ResId -> it.image1ResId
                        it.image1ResId -> it.image2ResId
                        it.image2ResId -> it.image3ResId
                        else -> it.image0ResId
                    }
                    it.imageResId = nextFrame
                }
            }
        }
    }
}