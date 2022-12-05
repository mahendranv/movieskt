# Dev Logs

## Remember to do clean build when you're stuck with a Dagger issue
At some point I was doing injection with Qualifiers and hilt/dagger couldn't detect he dependency anymore. In fact, Android studio was able to pick the qualified dependency - but there was compile time failure. After spending 1 hour realized it was just a plain old mistake of not doing a clean build.

## Using a string constant `Named` variable is a bad idea
Again!! using Named(MY_CONSTANT) was showing the mapping in AndroidStudio. But for compile time, only Named("io_dispatcher") is the way to go approach.

## Binding Navigation graph with bottom navigation bar
Bottom navigation bar has a convenience method to setup with nav graph with a simple setup method call to navController. However, there is a catch to ut.
1. FragmentContainerView can't return nav controller - even though the container is
   set with NavHostFragment. Workaround is to use find fragment by id and cast to NavHostFragment
2. For setupWithNavController to work, both the menu xml and navigation xml should
   carry the same id-s. i.e homeFragment vs homeFragment
```kotlin
 // Where R.id.container is the res id of FragmentContainerView
 val navHostFragment =
     supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
 navController = navHostFragment.navController
 binding.mainNavBar.setupWithNavController(navController!!)
```

```xml
  <!-- main_nav.xml -->
  <fragment
      android:id="@+id/homeFragment"
      android:name="com.ex2.ktmovies.presentation.home.HomeFragment"
      android:label="HomeFragment"
      tools:layout="@layout/fragment_home"/>
  <!-- menu_bottom_nav -->
   <item
      android:id="@+id/homeFragment"
      android:icon="@drawable/ic_outline_home_24"
      android:title="@string/home" />

```