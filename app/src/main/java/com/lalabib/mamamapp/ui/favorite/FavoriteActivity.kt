package com.lalabib.mamamapp.ui.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lalabib.mamamapp.R
import com.lalabib.mamamapp.adapter.FavoriteMealsAdapter
import com.lalabib.mamamapp.databinding.ActivityFavoriteBinding
import com.lalabib.mamamapp.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var mealsAdapter: FavoriteMealsAdapter
    private val favViewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupData()
    }

    private fun setupView() {
        supportActionBar?.apply {
            title = getString(R.string.favorite_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupData() {
        mealsAdapter = FavoriteMealsAdapter {
            Intent(this@FavoriteActivity, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_DATA, it.idMeal)
                startActivity(this)
            }
        }

        favViewModel.getAllFavorites.observe(this@FavoriteActivity) { meal ->
            if (!meal.isNullOrEmpty()) {
                mealsAdapter.submitList(meal)
            } else {
                Toast.makeText(
                    this@FavoriteActivity,
                    getString(R.string.error_data),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        binding.rvMeals.apply {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            adapter = mealsAdapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}