package com.ex2.ktmovies.data.fake

import com.ex2.ktmovies.domain.model.MovieDetails
import com.ex2.ktmovies.domain.model.MovieLite
import com.ex2.ktmovies.domain.model.MovieResult
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

    val searchResults = listOf(
        MovieResult(
            id = "1002088",
            title = "Mission: Cross",
            rating = 6.97,
            imageUrl = "https://image.tmdb.org/t/p/w500/aE9WqOApdRYsowsGE0118dyA4c9.jpg",
            overview = "A thrilling action-packed adventure as a secret agent is on a mission to uncover a conspiracy.",
            genres = "Action, Thriller",
            releaseDate = Calendar.getInstance().apply { set(2024, 7, 15) },
            numberOfRatings = 12345,
            runTime = 120
        ),
        MovieResult(
            id = "1064375",
            title = "Paradox Effect",
            rating = 6.444,
            imageUrl = "https://image.tmdb.org/t/p/w500/koJFEW997sLjpu4e7wmFioA2mhL.jpg",
            overview = "A mind-bending journey through time as a scientist tries to alter the past with unexpected consequences.",
            genres = "Science Fiction, Drama",
            releaseDate = Calendar.getInstance().apply { set(2024, 8, 10) },
            numberOfRatings = 8345,
            runTime = 110
        ),
        MovieResult(
            id = "1051891",
            title = "Thelma",
            rating = 6.985,
            imageUrl = "https://image.tmdb.org/t/p/w500/rUcuageYgv9SsJoWuc0seRWG6JC.jpg",
            overview = "A psychological thriller about a woman who begins to experience mysterious seizures.",
            genres = "Thriller, Drama",
            releaseDate = Calendar.getInstance().apply { set(2024, 6, 23) },
            numberOfRatings = 9456,
            runTime = 115
        ),
        MovieResult(
            id = "1225377",
            title = "The Mouse Trap",
            rating = 2.6,
            imageUrl = "https://image.tmdb.org/t/p/w500/3ovFaFeojLFIl5ClqhtgYMDS8sE.jpg",
            overview = "A comedic tale of a group of friends caught in a series of misadventures involving a mischievous mouse.",
            genres = "Comedy, Family",
            releaseDate = Calendar.getInstance().apply { set(2024, 5, 12) },
            numberOfRatings = 2345,
            runTime = 90
        ),
        MovieResult(
            id = "1311550",
            title = "House of Ga'a",
            rating = 5.9,
            imageUrl = "https://image.tmdb.org/t/p/w500/6yK9hmS641NMwRkR1wWAALWI34t.jpg",
            overview = "A haunting horror film about a cursed house and the family that must confront its dark secrets.",
            genres = "Horror, Mystery",
            releaseDate = Calendar.getInstance().apply { set(2024, 10, 31) },
            numberOfRatings = 7567,
            runTime = 105
        ),
        MovieResult(
            id = "974262",
            title = "Descendants: The Rise of Red",
            rating = 7.006,
            imageUrl = "https://image.tmdb.org/t/p/w500/t9u9FWpKlZcp0Wz1qPeV5AIzDsk.jpg",
            overview = "The next chapter in the Descendants saga, focusing on the rise of a new villain.",
            genres = "Adventure, Family",
            releaseDate = Calendar.getInstance().apply { set(2024, 12, 18) },
            numberOfRatings = 11234,
            runTime = 120
        ),
        MovieResult(
            id = "1242372",
            title = "Escape from the 21st Century",
            rating = 6.974,
            imageUrl = "https://image.tmdb.org/t/p/w500/nZQPbD7IEKWiUDK7s9GKHwqP88g.jpg",
            overview = "A sci-fi thriller about a group of people who find themselves trapped in a futuristic dystopia.",
            genres = "Science Fiction, Thriller",
            releaseDate = Calendar.getInstance().apply { set(2024, 9, 20) },
            numberOfRatings = 9876,
            runTime = 130
        ),
        MovieResult(
            id = "799583",
            title = "The Ministry of Ungentlemanly Warfare",
            rating = 7.154,
            imageUrl = "https://image.tmdb.org/t/p/w500/8aF0iAKH9MJMYAZdi0Slg77RYa2.jpg",
            overview = "A historical drama based on the true story of a covert WWII operation.",
            genres = "War, Drama",
            releaseDate = Calendar.getInstance().apply { set(2024, 11, 15) },
            numberOfRatings = 6534,
            runTime = 140
        ),
        MovieResult(
            id = "1209290",
            title = "Justice League: Crisis on Infinite Earths Part Three",
            rating = 7.404,
            imageUrl = "https://image.tmdb.org/t/p/w500/a3q8NkM8uTh9E23VsbUOdDSbBeN.jpg",
            overview = "The epic conclusion to the Crisis on Infinite Earths saga, where heroes from different universes unite.",
            genres = "Action, Superhero",
            releaseDate = Calendar.getInstance().apply { set(2024, 3, 25) },
            numberOfRatings = 14856,
            runTime = 150
        ),
        MovieResult(
            id = "1309923",
            title = "Non Negotiable",
            rating = 6.006,
            imageUrl = "https://image.tmdb.org/t/p/w500/bHQG4UsLMFCy91gfLAFRpnCOPdP.jpg",
            overview = "A gritty crime drama about a negotiator who faces his toughest case yet.",
            genres = "Crime, Drama",
            releaseDate = Calendar.getInstance().apply { set(2024, 4, 5) },
            numberOfRatings = 4321,
            runTime = 125
        ),
        MovieResult(
            id = "823464",
            title = "Godzilla x Kong: The New Empire",
            rating = 7.182,
            imageUrl = "https://image.tmdb.org/t/p/w500/z1p34vh7dEOnLDmyCrlUVLuoDzd.jpg",
            overview = "The epic showdown between two legendary titans continues in this blockbuster sequel.",
            genres = "Action, Sci-Fi",
            releaseDate = Calendar.getInstance().apply { set(2024, 6, 15) },
            numberOfRatings = 17654,
            runTime = 140
        ),
        MovieResult(
            id = "1048241",
            title = "My Spy The Eternal City",
            rating = 6.72,
            imageUrl = "https://image.tmdb.org/t/p/w500/Bf3vCfM94bSJ1saZlyi0UW0e0U.jpg",
            overview = "A spy comedy where an undercover agent faces a new mission in the heart of Rome.",
            genres = "Comedy, Action",
            releaseDate = Calendar.getInstance().apply { set(2024, 7, 22) },
            numberOfRatings = 9456,
            runTime = 100
        ),
        MovieResult(
            id = "956842",
            title = "Fly Me to the Moon",
            rating = 7.1,
            imageUrl = "https://image.tmdb.org/t/p/w500/gjk8YdXpItoC1in53FCrZMFIuBx.jpg",
            overview = "A romantic drama set against the backdrop of the space race, focusing on love and ambition.",
            genres = "Romance, Drama",
            releaseDate = Calendar.getInstance().apply { set(2024, 8, 30) },
            numberOfRatings = 12678,
            runTime = 135
        ),
        MovieResult(
            id = "348",
            title = "Alien",
            rating = 8.2,
            imageUrl = "https://image.tmdb.org/t/p/w500/vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg",
            overview = "A classic sci-fi horror film where a crew encounters a deadly alien creature.",
            genres = "Horror, Sci-Fi",
            releaseDate = Calendar.getInstance().apply { set(1979, 4, 25) },
            numberOfRatings = 200000,
            runTime = 117
        ),
        MovieResult(
            id = "1219685",
            title = "An Ideal Father",
            rating = 6.538,
            imageUrl = "https://image.tmdb.org/t/p/w500/4xJd3uwtL1vCuZgEfEc8JXI9Uyx.jpg",
            overview = "A touching drama about a man striving to be the perfect father amidst life's challenges.",
            genres = "Drama, Family",
            releaseDate = Calendar.getInstance().apply { set(2024, 5, 8) },
            numberOfRatings = 7865,
            runTime = 112
        ),
        MovieResult(
            id = "1011985",
            title = "Kung Fu Panda 4",
            rating = 7.124,
            imageUrl = "https://image.tmdb.org/t/p/w500/kDp1vUBnMpe8ak4rjgl3cLELqjU.jpg",
            overview = "Po returns for another exciting adventure, facing new challenges and discovering his true potential.",
            genres = "Animation, Adventure",
            releaseDate = Calendar.getInstance().apply { set(2024, 2, 9) },
            numberOfRatings = 14321,
            runTime = 95
        ),
        MovieResult(
            id = "14836",
            title = "Coraline",
            rating = 7.877,
            imageUrl = "https://image.tmdb.org/t/p/w500/4jeFXQYytChdZYE9JYO7Un87IlW.jpg",
            overview = "A dark fantasy film where a young girl discovers a secret door to an alternate world.",
            genres = "Fantasy, Animation",
            releaseDate = Calendar.getInstance().apply { set(2009, 1, 6) },
            numberOfRatings = 156789,
            runTime = 100
        ),
        MovieResult(
            id = "1041613",
            title = "Immaculate",
            rating = 6.345,
            imageUrl = "https://image.tmdb.org/t/p/w500/fdZpvODTX5wwkD0ikZNaClE4AoW.jpg",
            overview = "A gripping mystery that follows a detective investigating a series of inexplicable events.",
            genres = "Mystery, Thriller",
            releaseDate = Calendar.getInstance().apply { set(2024, 11, 3) },
            numberOfRatings = 6543,
            runTime = 108
        ),
        MovieResult(
            id = "929590",
            title = "Civil War",
            rating = 6.964,
            imageUrl = "https://image.tmdb.org/t/p/w500/sh7Rg8Er3tFcN9BpKIPOMvALgZd.jpg",
            overview = "A historical epic set during a civil war, focusing on the lives of those caught in the conflict.",
            genres = "Drama, History",
            releaseDate = Calendar.getInstance().apply { set(2024, 4, 30) },
            numberOfRatings = 9786,
            runTime = 180
        ),
        MovieResult(
            id = "646683",
            title = "The Exorcism",
            rating = 4.582,
            imageUrl = "https://image.tmdb.org/t/p/w500/ar2h87jlTfMlrDZefR3VFz1SfgH.jpg",
            overview = "A horror film about a young priest who must confront a terrifying demonic possession.",
            genres = "Horror, Thriller",
            releaseDate = Calendar.getInstance().apply { set(2024, 10, 10) },
            numberOfRatings = 5432,
            runTime = 98
        )
    )
}