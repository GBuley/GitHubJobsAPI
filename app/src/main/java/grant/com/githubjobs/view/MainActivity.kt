package grant.com.githubjobs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import grant.com.githubjobs.R
import grant.com.githubjobs.view.SearchFragment
import grant.com.githubjobs.databinding.ActivityMainBinding
import grant.com.githubjobs.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var jobDescription : String
    private lateinit var jobLocation : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
//        viewModel.getJobsByLocation("Remote")
        loadFragment()

        //TODO: Get the description from the fragment
        viewModel.description.observe(this, Observer<String> { it
            jobDescription = it
        })

        viewModel.location.observe(this, Observer<String> { location: String ->
            jobLocation = location
        })

    }
    private fun loadFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.search_fragment, SearchFragment.newInstance(), "SearchFragment")
            .commit()
    }



}