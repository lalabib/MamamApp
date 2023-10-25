package com.lalabib.mamamapp.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.lalabib.mamamapp.R
import com.lalabib.mamamapp.adapter.MealsAdapter
import com.lalabib.mamamapp.data.remote.network.Result
import com.lalabib.mamamapp.databinding.ActivityHomeBinding
import com.lalabib.mamamapp.databinding.BottomSheetFilterBinding
import com.lalabib.mamamapp.databinding.ContentHomeBinding
import com.lalabib.mamamapp.ui.detail.DetailActivity
import com.lalabib.mamamapp.ui.favorite.FavoriteActivity
import com.lalabib.mamamapp.utils.SharedObject.DEFAULT_VALUE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeContentBinding: ContentHomeBinding
    private lateinit var bsBinding: BottomSheetFilterBinding

    private lateinit var mealsAdapter: MealsAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeContentBinding = binding.contentHome

        setupAction()
        setupMealsByCategory(DEFAULT_VALUE)
        search()
    }


    private fun setupAction() {
        mealsAdapter = MealsAdapter { meal ->
            Intent(this@HomeActivity, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_DATA, meal.idMeal)
                startActivity(this)
            }
        }

        homeContentBinding.rvMeals.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = mealsAdapter
        }

        binding.apply {
            icFilter.setOnClickListener {
                setupBottomSheet()
            }
            icFavorite.setOnClickListener {
                moveToFavorite()
            }
        }

    }

    @SuppressLint("InflateParams")
    private fun setupBottomSheet() {
        val dialog = BottomSheetDialog(this)
        val inflater = LayoutInflater.from(this)
        bsBinding = BottomSheetFilterBinding.inflate(inflater)

        bsBinding.apply {
            //dropdown filter, category and area
            setupFilterDropdown(edtFilter)
            setupCategoryDropdown(edtCategory)
            setupAreaDropdown(edtArea)

            //condition filter
            edtFilter.setOnItemClickListener { parent, _, position, _ ->
                val selectedFilter = parent.getItemAtPosition(position).toString()
                val isCategorySelected = selectedFilter == getString(R.string.category)

                tvFilterCategory.visibility = if (isCategorySelected) View.VISIBLE else View.GONE
                tfCategory.visibility = if (isCategorySelected) View.VISIBLE else View.GONE
                edtCategory.visibility = if (isCategorySelected) View.VISIBLE else View.GONE

                tvFilterArea.visibility = if (!isCategorySelected) View.VISIBLE else View.GONE
                tfArea.visibility = if (!isCategorySelected) View.VISIBLE else View.GONE
                edtArea.visibility = if (!isCategorySelected) View.VISIBLE else View.GONE
            }


            btnSubmit.setOnClickListener {
                val selectedCategory = edtCategory.text.toString()
                val selectedArea = edtArea.text.toString()

                if (selectedCategory.isNotEmpty()) setupMealsByCategory(selectedCategory)
                if (selectedArea.isNotEmpty()) setupMealsByArea(selectedArea)

                dialog.dismiss()
            }
        }

        dialog.setCancelable(true)
        dialog.setContentView(bsBinding.root)
        dialog.show()
    }

    private fun setupFilterDropdown(edtFilter: AutoCompleteTextView) {
        val filter = resources.getStringArray(R.array.filter)
        val arrayAdapterFilter = ArrayAdapter(this@HomeActivity, R.layout.dropdown_item, filter)
        edtFilter.setAdapter(arrayAdapterFilter)
    }

    private fun setupCategoryDropdown(edtCategory: AutoCompleteTextView) {
        homeViewModel.getCategories.observe(this@HomeActivity) { category ->
            if (category != null) {
                when (category) {
                    is Result.Loading -> {
                        showLoading(true)
                    }

                    is Result.Success -> {
                        showLoading(false)
                        val categoryList = category.data.map { it.strCategory }
                        val adapterCategory =
                            ArrayAdapter(this@HomeActivity, R.layout.dropdown_item, categoryList)
                        edtCategory.setAdapter(adapterCategory)

                    }

                    is Result.Error -> {
                        showLoading(false)
                        Toast.makeText(
                            this@HomeActivity,
                            getString(R.string.error_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun setupAreaDropdown(edtArea: AutoCompleteTextView) {
        homeViewModel.getAreas.observe(this@HomeActivity) { area ->
            if (area != null) {
                when (area) {
                    is Result.Loading -> {
                        showLoading(true)
                    }

                    is Result.Success -> {
                        showLoading(false)
                        val areaList = area.data.map { it.strArea }
                        val adapterArea =
                            ArrayAdapter(this@HomeActivity, R.layout.dropdown_item, areaList)
                        edtArea.setAdapter(adapterArea)
                    }

                    is Result.Error -> {
                        showLoading(false)
                        Toast.makeText(
                            this@HomeActivity,
                            getString(R.string.error_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun setupMealsByCategory(c: String) {
        homeViewModel.getMealsByCategory(c).observe(this@HomeActivity) { meals ->
            if (meals != null) {
                when (meals) {
                    is Result.Loading -> {
                        showLoading(true)
                    }

                    is Result.Success -> {
                        showLoading(false)
                        mealsAdapter.submitList(meals.data)
                    }

                    is Result.Error -> {
                        showLoading(false)
                        Toast.makeText(
                            this@HomeActivity,
                            getString(R.string.error_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun setupMealsByArea(a: String) {
        homeViewModel.getMealsByArea(a).observe(this@HomeActivity) { meals ->
            if (meals != null) {
                when (meals) {
                    is Result.Loading -> {
                        showLoading(true)
                    }

                    is Result.Success -> {
                        showLoading(false)
                        mealsAdapter.submitList(meals.data)
                    }

                    is Result.Error -> {
                        showLoading(false)
                        Toast.makeText(
                            this@HomeActivity,
                            getString(R.string.error_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun search() {
        val search = binding.searchView
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                handleSearchQuery(query)
                search.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    handleSearchQuery("")
                }
                return false
            }
        })
    }

    private fun handleSearchQuery(name: String) {
        homeViewModel.getMealsByName(name).observe(this@HomeActivity) { nameMeals ->
            if (nameMeals != null) {
                when (nameMeals) {
                    is Result.Loading -> {
                        showLoading(true)
                    }

                    is Result.Success -> {
                        showLoading(false)
                        mealsAdapter.submitList(nameMeals.data)
                    }

                    is Result.Error -> {
                        showLoading(false)
                        Toast.makeText(
                            this@HomeActivity,
                            getString(R.string.search_error),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

        }
    }

    private fun moveToFavorite() {
        Intent(this@HomeActivity, FavoriteActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        homeContentBinding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}