package com.example.mapas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configuración necesaria para osmdroid
        Configuration.getInstance().userAgentValue = packageName
        setContent {
            OsmMapExample()
        }
    }
}

@Composable
fun OsmMapExample() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = {
                MapView(context).apply {
                    setTileSource(TileSourceFactory.MAPNIK)
                    setMultiTouchControls(true)
                    val center = GeoPoint(2.4448, -76.6147)
                    controller.setZoom(15.0)
                    controller.setCenter(center)
                    
                    val marker = Marker(this)
                    marker.position = center
                    marker.title = "Popayán"
                    overlays.add(marker)
                }
            }
        )
        Text(
            text = "© OpenStreetMap contributors",
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}
