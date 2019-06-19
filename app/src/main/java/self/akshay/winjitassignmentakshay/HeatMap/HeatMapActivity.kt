package self.akshay.winjitassignmentakshay.HeatMap

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import self.akshay.winjitassignmentakshay.R
import self.akshay.winjitassignmentakshay.statelist.pojo.StatesItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.TileOverlay
import com.google.android.gms.maps.model.TileOverlayOptions
import com.google.maps.android.heatmaps.HeatmapTileProvider



class HeatMapActivity : AppCompatActivity(), OnMapReadyCallback {


    private var heatMapData: StatesItem? = null
    private var map: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heat_map)

        setUp()


    }

    private fun setUp() {
        heatMapData = intent.extras?.getParcelable("heatMapData")

        supportActionBar?.title = heatMapData?.nameOfState
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.gmap) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }


    @SuppressLint("CheckResult")
    override fun onMapReady(p0: GoogleMap?) {
        map =p0
        val zoomLevel = 4.5f //This goes up to 21
        map?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(23.264259, 78.871633), zoomLevel))


        val latLngList  = mutableListOf<LatLng>()







        // Add a tile overlay to the map, using the heat map tile provider.

        for (i in 0 ..(heatMapData?.applicants?.size?.minus(1) ?:0 )){

            val  item = heatMapData?.applicants!![i]

                   latLngList.add(LatLng(item?.lat!!,item.lng))

            if (i==heatMapData?.applicants?.size?.minus(1)){
                val mProvider =  HeatmapTileProvider.Builder()
                    .data(latLngList)
                    .build()
                 map?.addTileOverlay(TileOverlayOptions().tileProvider(mProvider))

            }


        }









    }
}
