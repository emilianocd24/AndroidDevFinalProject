package com.example.androiddevfinalproject

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddevfinalproject.databinding.ActivityTestListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestListBinding
    private lateinit var adapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTestListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
// create our service object val userId = Backendless.UserService.CurrentUser().userId
        val gTalesService =
            GtalesRetrofitHelper.getInstance().create(GtalesService::class.java)
        val gTalesCall = gTalesService.getAllTestEntries()
        val action=supportActionBar
        action?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#000000")))

        gTalesCall.enqueue(object: Callback<List<GtalesEntry>> {
            override fun onResponse(call: Call<List<GtalesEntry>>,
                                    response: Response<List<GtalesEntry>>
            ) {
                // THIS IS WHERE THE CODE GOES FOR WHEN YOU GET YOUR DATA
                // Create your recyclerview adapter HERE
                // response.body() gives you the actual data (in this case
                // the FeatureCollection)
                // if you want to see the json that came back,
                // should be in response.raw()
                Log.d("The data", "onResponse : ${response.raw()}")
                Log.d("HyruleList", "onResponse : ${response.body()}")
                //binding.recyclerViewCompendiumList.adapter = adapter
                adapter = TestAdapter(response.body()?.sortedBy { it.name }!!)
                binding.recyclerViewTestList.adapter = adapter
                binding.recyclerViewTestList.layoutManager = LinearLayoutManager(this@TestListActivity)
//                binding.recyclerViewCompendiumList.layoutManager =
//                    LinearLayoutManager(this@CompendiumListActivity)


                //LinearLayoutManager(this@HyruleActivity)
                Log.d("HyruleList", "onResponse : ${response.body()}")

            }

            override fun onFailure(call: Call<List<GtalesEntry>>, t: Throwable) {
                Log.d("EarthquakeList", "onFailure: ${t.message}")
                t.cause
            }
        })
        // if you try creating your adapter here, we can't guarantee that the network call has finished. so the list might be empty
    }
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.menucompendiumlist, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle item selection.
//
//        return when (item.itemId) {
//            R.id.sort_by_id-> {
//                adapter.dataSet = adapter.dataSet.sortedBy { it.id }.toTypedArray()
//                adapter.notifyDataSetChanged()
//                true
//            }
//            R.id.sort_by_name -> {
//                adapter.dataSet = adapter.dataSet.sortedBy { it.name}.toTypedArray()
//                adapter.notifyDataSetChanged()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}