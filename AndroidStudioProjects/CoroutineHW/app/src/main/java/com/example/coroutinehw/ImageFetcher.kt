package com.example.coroutinehw

import android.webkit.URLUtil
import java.net.URL

class ImageFetcher {

    fun getText(i:Int): String {
        return when (i){
            0 -> "White-sand beaches might not be what comes to mind when you think of Alabama, but a visit to Gulf State Park might change your perspective. From the Gulf Coast's sugar-sand shores you can kayak, bike, or do absolutely nothing — no judgement."
            1 -> "Located near the Superstition Mountains and just about 40 miles east of Phoenix is Arizona's Lost Dutchman State Park. As you might suspect, the park is full of towering red rock formations, cacti, and enough hiking trails to keep you occupied for days."
            2 -> "While technically a state and national park, we'd be remiss to leave this off the list. Here in the Redwoods, you'll find some of the world's tallest trees and endless open coast (keep an eye out for whales and harbor porpoises)."
            3 -> "This beachy state park boasts acres-upon-acres of dunes and beach and an impressive bird sanctuary on Charles Island."
            4 -> "Explore a different side of Florida when you visit the swamps and springs of the state's interior. In Ichetucknee Springs State Park, you can kayak under lush green trees or spend the day tubing down the river, drink in hand."
            5 -> "This Maui park has a little bit of everything — the famous black-sand Paʻiloa Beach, freshwater pools, endless hiking, and sacred ruins."
            6 -> "The sandstone canyons, waterfalls, and wooded trails of Starved Rock State Park make it feel as though you're in another world. And if you happen upon a white-tailed deer or a bald eagle, the effect is only magnified."
            7 -> "From caves and trout fishing to climbing and biking, Backbone State Park has it all. You can spend the morning on the 21-mile trail system before hiding out in the shade of Backbone Cave."
            8 -> "This park is best known for its namesake: Cumberland Falls, one of the few places in the world that regularly produces moonbows, also called white rainbows or lunar rainbows. Before settling in to watch this phenomenon, hike through the forest or book a raft trip down the Cumberland River."
            9 -> "Visited by more than 350,000 people annually, Crane Beach remains a national model for balancing conservation of diverse natural habitats and wildlife—more than 1,200 acres of beachfront, dunes, and maritime forest grace the property—with the management of active public recreation. Whether you want to take a refreshing plunge, play in the sand, or bask in the sun, this unparalleled seaside experience has provided fun and lasting memories for generations."
            else -> "Visited by more than 350,000 people annually, Crane Beach remains a national model for balancing conservation of diverse natural habitats and wildlife—more than 1,200 acres of beachfront, dunes, and maritime forest grace the property—with the management of active public recreation. Whether you want to take a refreshing plunge, play in the sand, or bask in the sun, this unparalleled seaside experience has provided fun and lasting memories for generations."

        }
    }

    fun getImage(i:Int) : String {

        return when (i){
            0 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fgulf-state-park-alabama-STATEPARTS0521.jpg"
            1 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Flost-dutchman-stat-park-arizona-STATEPARTS0521.jpg"
            2 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fredwoods-national-state-parks-california-STATEPARTS0521.jpg"
            3 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fsilver-sands-state-park-connecticut-STATEPARTS0521.jpg"
            4 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fichetucknee-springs-state-park-STATEPARTS0521.jpg"
            5 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fwaianapanapa-state-park-hawaii-STATEPARTS0521.jpg"
            6 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fstarved-rock-state-park-illinois-STATEPARTS0521.jpg"
            7 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fbackbone-state-park-iowa-STATEPARTS0521.jpg"
            8 -> "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F28%2F2021%2F05%2F07%2Fcumberland-falls-state-park-kentucky-STATEPARTS0521.jpg"
            9 -> "https://thetrustees.org/wp-content/uploads/2020/06/Crane-Beach-sunset-922014-scaled.jpg"
            else -> "https://thetrustees.org/wp-content/uploads/2020/06/Crane-Beach-sunset-922014-scaled.jpg"
        }
    }
}