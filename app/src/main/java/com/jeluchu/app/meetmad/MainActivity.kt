package com.jeluchu.app.meetmad

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Escribe tu publicación...", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                replaceFragmenty(
                        fragment = Fragment1(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                title = "Novedades"
            }
            R.id.nav_gallery -> {
                replaceFragmenty(
                        fragment = Fragment2(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                title = "Galería"
            }
            R.id.nav_slideshow -> {
                replaceFragmenty(
                        fragment = Fragment3(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                title = "Enventos"
            }
            /**R.id.nav_manage -> {
                replaceFragmenty(
                        fragment = Fragment4(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Tools")
            } **/
            R.id.nav_share -> {
                replaceFragmenty(
                        fragment = Fragment5(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                title = "Perfil"
            }
            R.id.nav_send -> {
                replaceFragmenty(
                        fragment = Fragment6(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Cuenta")
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
