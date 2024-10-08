# movieskt
Clean architecture/Kotlin/MAD

![movieskt](https://socialify.git.ci/mahendranv/movieskt/image?description=1&font=Inter&owner=1&pattern=Plus&theme=Dark)

Movies KT is an attempt to build a simple movie discovery app using the [TMDB](https://tmdb.apps.quintero.io/) GraphQL API. User can search/bookmark movies and have a clutter free read experience on the plot.

And to go [MAD](https://madscorecard.withgoogle.com/scorecards/2138907411/)...

![image](https://user-images.githubusercontent.com/6584143/134556913-b2388496-37d4-4f6d-89ab-dd31539f0e92.png)

| ![image](https://user-images.githubusercontent.com/6584143/205547183-bd5ba322-532d-4046-8535-245aa377e064.png) | ![image](https://user-images.githubusercontent.com/6584143/205547221-5f6eda04-9e56-45d3-b719-e918ce7e4b79.png) | ![image](https://user-images.githubusercontent.com/6584143/205547566-7ba21612-9bba-4a79-aaf1-8df2a0d559de.jpg) |
|-|-|-|


## Architecture
Overall, the app is built using three modules. Each addresses different business requirement.
1. Android : Platform helpers / extensions to access the system resources placed here.
2. Data-Core: Data classes, service / repo abstractions and respective DI placed here. ViewModel is used as a port to expose APIs to UI layer.
3. UI / App layer: Screens, nav graphs are placed here. App layer consumes the above two modules drives the user front. This layer can choose to use different UI frameworks as long as viewmodel pub-sub pattern is supported in screen component.

All the above modules are bind using Hilt and resources are scoped to Singleton, ViewModel level.

![img.png](docs/diagrams/module.png)

## Features
1. Now playing list
2. Search
3. Details / Similar movies
4. Light/Night mode UI

## ☑️ TODO
1. Gallery
2. Cast info
3. Scrapping plot from wikipedia
4. Bookmark

## ⚒️ Tools

1. Jetpack navigation
2. Apollo GraphQL / OkHttp
3. Hilt
4. ViewModel/Flow
5. Coil
6. Coroutines
7. Kotlin script

## Demo videos:

| Remarks  | Video                                                                                                |
|---|------------------------------------------------------------------------------------------------------|
| V1 - Single paged  | https://user-images.githubusercontent.com/6584143/134550521-890da7e3-20fb-4b3e-88e3-6d71ea44ace4.mp4 |
| V2 - Multi tab + sections | https://user-images.githubusercontent.com/6584143/205542639-11d762ec-48ad-427a-8822-ac0dfbd5cdd8.mp4 |

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

_[🤕What ate up my time](docs/nuances.md)_

## License

[MIT](https://choosealicense.com/licenses/mit/)

```
MIT License

Copyright (c) 2023 Mahendran

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

