package com.ex2.ktmovies.data.fake

import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieLite
import java.util.Calendar

object FakeData {

    val movieList = listOf(
        MovieLite(
            id = "533535",
            title = "Deadpool & Wolverine",
            rating = 7.8,
            imageUrl = "https://image.tmdb.org/t/p/w500/8cdWjvZQUExUUTzyp4t6EDMubfO.jpg"
        ),
        MovieLite(
            id = "718821",
            title = "Twisters",
            rating = 7.1,
            imageUrl = "https://image.tmdb.org/t/p/w500/pjnD08FlMAIXsfOLKQbvmO0f0MD.jpg"
        ),
        MovieLite(
            id = "1022789",
            title = "Inside Out 2",
            rating = 7.629,
            imageUrl = "https://image.tmdb.org/t/p/w500/vpnVM9B6NMmQpWeZvzLvDESb2QY.jpg"
        ),
        MovieLite(
            id = "519182",
            title = "Despicable Me 4",
            rating = 7.322,
            imageUrl = "https://image.tmdb.org/t/p/w500/wWba3TaojhK7NdycRhoQpsG0FaH.jpg"
        ),
        MovieLite(
            id = "573435",
            title = "Bad Boys: Ride or Die",
            rating = 7.6,
            imageUrl = "https://image.tmdb.org/t/p/w500/oGythE98MYleE6mZlGs5oBGkux1.jpg"
        ),
        MovieLite(
            id = "1160018",
            title = "Kill",
            rating = 7.0,
            imageUrl = "https://image.tmdb.org/t/p/w500/m2zXTuNPkywdYLyWlVyJZW2QOJH.jpg"
        ),
        MovieLite(
            id = "762441",
            title = "A Quiet Place: Day One",
            rating = 6.882,
            imageUrl = "https://image.tmdb.org/t/p/w500/hU42CRk14JuPEdqZG3AWmagiPAP.jpg"
        ),
        MovieLite(
            id = "959092",
            title = "Mayhem!",
            rating = 6.742,
            imageUrl = "https://image.tmdb.org/t/p/w500/u9035lysUz3ccloQt0SeIp1Mu8a.jpg"
        ),
        MovieLite(
            id = "945961",
            title = "Alien: Romulus",
            rating = 7.359,
            imageUrl = "https://image.tmdb.org/t/p/w500/b33nnKl1GSFbao4l3fZDDqsMx0F.jpg"
        ),
        MovieLite(
            id = "1129598",
            title = "Prey",
            rating = 6.459,
            imageUrl = "https://image.tmdb.org/t/p/w500/5wAlO5zZ3IyzLBAf7cp5WejalmG.jpg"
        ),
        MovieLite(
            id = "588648",
            title = "Dragonkeeper",
            rating = 7.122,
            imageUrl = "https://image.tmdb.org/t/p/w500/ggZGnJLzO3BTu7ysuuIzou3Oex5.jpg"
        ),
        MovieLite(
            id = "831815",
            title = "Saving Bikini Bottom: The Sandy Cheeks Movie",
            rating = 6.474,
            imageUrl = "https://image.tmdb.org/t/p/w500/30YnfZdMNIV7noWLdvmcJS0cbnQ.jpg"
        ),
        MovieLite(
            id = "1079091",
            title = "It Ends with Us",
            rating = 7.018,
            imageUrl = "https://image.tmdb.org/t/p/w500/AjV6jFJ2YFIluYo4GQf13AA1tqu.jpg"
        ),
        MovieLite(
            id = "1059064",
            title = "The Instigators",
            rating = 6.5,
            imageUrl = "https://image.tmdb.org/t/p/w500/thI9pM7Qu43f42sOOl5wy75UAo.jpg"
        ),
        MovieLite(
            id = "1281826",
            title = "One Fast Move",
            rating = 6.737,
            imageUrl = "https://image.tmdb.org/t/p/w500/hdBUjfbdr1ymS0kycAT7qguOmWA.jpg"
        ),
        MovieLite(
            id = "748783",
            title = "The Garfield Movie",
            rating = 7.176,
            imageUrl = "https://image.tmdb.org/t/p/w500/xYduFGuch9OwbCOEUiamml18ZoB.jpg"
        ),
        MovieLite(
            id = "653346",
            title = "Kingdom of the Planet of the Apes",
            rating = 7.2,
            imageUrl = "https://image.tmdb.org/t/p/w500/gKkl37BQuKTanygYQG1pyYgLVgf.jpg"
        ),
        MovieLite(
            id = "1066262",
            title = "The Convert",
            rating = 6.255,
            imageUrl = "https://image.tmdb.org/t/p/w500/e5ZqqPlhKstzB4geibpZh38w7Pq.jpg"
        ),
        MovieLite(
            id = "786892",
            title = "Furiosa: A Mad Max Saga",
            rating = 7.6,
            imageUrl = "https://image.tmdb.org/t/p/w500/iADOJ8Zymht2JPMoy3R7xceZprc.jpg"
        ),
        MovieLite(
            id = "1166073",
            title = "Breaking and Re-entering",
            rating = 6.353,
            imageUrl = "https://image.tmdb.org/t/p/w500/qYdS4KIdCmJr3WB4CJYnoGaTVbv.jpg"
        ),
        MovieLite(
            id = "1002088",
            title = "Mission: Cross",
            rating = 6.97,
            imageUrl = "https://image.tmdb.org/t/p/w500/aE9WqOApdRYsowsGE0118dyA4c9.jpg"
        ),
        MovieLite(
            id = "1064375",
            title = "Paradox Effect",
            rating = 6.444,
            imageUrl = "https://image.tmdb.org/t/p/w500/koJFEW997sLjpu4e7wmFioA2mhL.jpg"
        ),
        MovieLite(
            id = "1051891",
            title = "Thelma",
            rating = 6.985,
            imageUrl = "https://image.tmdb.org/t/p/w500/rUcuageYgv9SsJoWuc0seRWG6JC.jpg"
        ),
        MovieLite(
            id = "1225377",
            title = "The Mouse Trap",
            rating = 2.6,
            imageUrl = "https://image.tmdb.org/t/p/w500/3ovFaFeojLFIl5ClqhtgYMDS8sE.jpg"
        ),
        MovieLite(
            id = "1311550",
            title = "House of Ga'a",
            rating = 5.9,
            imageUrl = "https://image.tmdb.org/t/p/w500/6yK9hmS641NMwRkR1wWAALWI34t.jpg"
        ),
        MovieLite(
            id = "974262",
            title = "Descendants: The Rise of Red",
            rating = 7.006,
            imageUrl = "https://image.tmdb.org/t/p/w500/t9u9FWpKlZcp0Wz1qPeV5AIzDsk.jpg"
        ),
        MovieLite(
            id = "1242372",
            title = "Escape from the 21st Century",
            rating = 6.974,
            imageUrl = "https://image.tmdb.org/t/p/w500/nZQPbD7IEKWiUDK7s9GKHwqP88g.jpg"
        ),
        MovieLite(
            id = "799583",
            title = "The Ministry of Ungentlemanly Warfare",
            rating = 7.154,
            imageUrl = "https://image.tmdb.org/t/p/w500/8aF0iAKH9MJMYAZdi0Slg77RYa2.jpg"
        ),
        MovieLite(
            id = "1209290",
            title = "Justice League: Crisis on Infinite Earths Part Three",
            rating = 7.404,
            imageUrl = "https://image.tmdb.org/t/p/w500/a3q8NkM8uTh9E23VsbUOdDSbBeN.jpg"
        ),
        MovieLite(
            id = "1309923",
            title = "Non Negotiable",
            rating = 6.006,
            imageUrl = "https://image.tmdb.org/t/p/w500/bHQG4UsLMFCy91gfLAFRpnCOPdP.jpg"
        ),
        MovieLite(
            id = "823464",
            title = "Godzilla x Kong: The New Empire",
            rating = 7.182,
            imageUrl = "https://image.tmdb.org/t/p/w500/z1p34vh7dEOnLDmyCrlUVLuoDzd.jpg"
        ),
        MovieLite(
            id = "1048241",
            title = "My Spy The Eternal City",
            rating = 6.72,
            imageUrl = "https://image.tmdb.org/t/p/w500/Bf3vCfM94bSJ1saZlyi0UW0e0U.jpg"
        ),
        MovieLite(
            id = "956842",
            title = "Fly Me to the Moon",
            rating = 7.1,
            imageUrl = "https://image.tmdb.org/t/p/w500/gjk8YdXpItoC1in53FCrZMFIuBx.jpg"
        ),
        MovieLite(
            id = "348",
            title = "Alien",
            rating = 8.2,
            imageUrl = "https://image.tmdb.org/t/p/w500/vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg"
        ),
        MovieLite(
            id = "1219685",
            title = "An Ideal Father",
            rating = 6.538,
            imageUrl = "https://image.tmdb.org/t/p/w500/4xJd3uwtL1vCuZgEfEc8JXI9Uyx.jpg"
        ),
        MovieLite(
            id = "1011985",
            title = "Kung Fu Panda 4",
            rating = 7.124,
            imageUrl = "https://image.tmdb.org/t/p/w500/kDp1vUBnMpe8ak4rjgl3cLELqjU.jpg"
        ),
        MovieLite(
            id = "14836",
            title = "Coraline",
            rating = 7.877,
            imageUrl = "https://image.tmdb.org/t/p/w500/4jeFXQYytChdZYE9JYO7Un87IlW.jpg"
        ),
        MovieLite(
            id = "1041613",
            title = "Immaculate",
            rating = 6.345,
            imageUrl = "https://image.tmdb.org/t/p/w500/fdZpvODTX5wwkD0ikZNaClE4AoW.jpg"
        ),
        MovieLite(
            id = "929590",
            title = "Civil War",
            rating = 6.964,
            imageUrl = "https://image.tmdb.org/t/p/w500/sh7Rg8Er3tFcN9BpKIPOMvALgZd.jpg"
        ),
        MovieLite(
            id = "646683",
            title = "The Exorcism",
            rating = 4.582,
            imageUrl = "https://image.tmdb.org/t/p/w500/ar2h87jlTfMlrDZefR3VFz1SfgH.jpg"
        )
    )

    val movieDetail = MovieDetails(
        id = "718821", // Mapped from JSON
        title = "Twisters", // Mapped from JSON
        rating = 7.1, // Mapped from JSON
        summary = "As storm season intensifies, the paths of former storm chaser Kate Carter and reckless social-media superstar Tyler Owens collide when terrifying phenomena never seen before are unleashed. The pair and their competing teams find themselves squarely in the paths of multiple storm systems converging over central Oklahoma in the fight of their lives.", // Mapped from JSON
        releaseDate = Calendar.getInstance().apply { set(2024, 6, 10) },
        runTime = 120,
        genre = "Action",
        covers = listOf(
            "https://image.tmdb.org/t/p/w500/58D6ZAvOKxlHjyX9S8qNKSBE9Y.jpg"
        ),
        images = listOf(
            "https://image.tmdb.org/t/p/w500/pjnD08FlMAIXsfOLKQbvmO0f0MD.jpg"
        ),
        related = movieList.subList(3, 8)
    )
}