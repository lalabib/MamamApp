package com.lalabib.mamamapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.lalabib.mamamapp.R
import com.lalabib.mamamapp.data.remote.network.Result
import com.lalabib.mamamapp.databinding.ActivityDetailBinding
import com.lalabib.mamamapp.domain.model.DetailMeals
import com.lalabib.mamamapp.utils.SharedObject.loadAvatar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupData()
    }

    private fun setupView() {
        supportActionBar?.apply {
            title = getString(R.string.detail_title)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setupData() {
        val id = intent.getStringExtra(EXTRA_DATA)
        if (id != null) {
            detailViewModel.getDetailMeals(id).observe(this) { detailMeal ->
                if (detailMeal != null) {
                    when (detailMeal) {
                        is Result.Loading -> {

                        }

                        is  Result.Success -> {
                            populateMeals(detailMeal.data[0])
                        }

                        is Result.Error -> {
                            Toast.makeText(
                                this@DetailActivity,
                                getString(R.string.error_data),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun populateMeals(meals: DetailMeals) {
        binding.apply {
            tvTitle.text = meals.strMeal
            tvInstruction.text = meals.strInstructions
            tvCategoryArea.append("${meals.strCategory}\n${meals.strArea}")
            loadAvatar(ivPoster, meals.strMealThumb)

            if (!meals.strIngredient1.isNullOrBlank() && !meals.strMeasure1.isNullOrBlank()) {
                tvIngredient.append("\u2022 ${meals.strIngredient1} ${meals.strMeasure1}")
            }
            if (!meals.strIngredient2.isNullOrBlank() && !meals.strMeasure2.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient2} ${meals.strMeasure2}")
            }
            if (!meals.strIngredient3.isNullOrBlank() && !meals.strMeasure3.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient3} ${meals.strMeasure3}")
            }
            if (!meals.strIngredient4.isNullOrBlank() && !meals.strMeasure4.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient4} ${meals.strMeasure4}")
            }
            if (!meals.strIngredient5.isNullOrBlank() && !meals.strMeasure5.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient5} ${meals.strMeasure5}")
            }
            if (!meals.strIngredient6.isNullOrBlank() && !meals.strMeasure6.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient6} ${meals.strMeasure6}")
            }
            if (!meals.strIngredient7.isNullOrBlank() && !meals.strMeasure7.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient7} ${meals.strMeasure7}")
            }
            if (!meals.strIngredient8.isNullOrBlank() && !meals.strMeasure8.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient8} ${meals.strMeasure8}")
            }
            if (!meals.strIngredient9.isNullOrBlank() && !meals.strMeasure9.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient9} ${meals.strMeasure9}")
            }
            if (!meals.strIngredient10.isNullOrBlank() && !meals.strMeasure10.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient10} ${meals.strMeasure10}")
            }
            if (!meals.strIngredient11.isNullOrBlank() && !meals.strMeasure11.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient11} ${meals.strMeasure11}")
            }
            if (!meals.strIngredient12.isNullOrBlank() && !meals.strMeasure12.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient12} ${meals.strMeasure12}")
            }
            if (!meals.strIngredient13.isNullOrBlank() && !meals.strMeasure13.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient13} ${meals.strMeasure13}")
            }
            if (!meals.strIngredient14.isNullOrBlank() && !meals.strMeasure14.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient14} ${meals.strMeasure14}")
            }
            if (!meals.strIngredient15.isNullOrBlank() && !meals.strMeasure15.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient15} ${meals.strMeasure15}")
            }
            if (!meals.strIngredient16.isNullOrBlank() && !meals.strMeasure16.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient16} ${meals.strMeasure16}")
            }
            if (!meals.strIngredient17.isNullOrBlank() && !meals.strMeasure17.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient17} ${meals.strMeasure17}")
            }
            if (!meals.strIngredient18.isNullOrBlank() && !meals.strMeasure18.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient18} ${meals.strMeasure18}")
            }
            if (!meals.strIngredient19.isNullOrBlank() && !meals.strMeasure19.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient19} ${meals.strMeasure19}")
            }
            if (!meals.strIngredient20.isNullOrBlank() && !meals.strMeasure20.isNullOrBlank()) {
                tvIngredient.append("\n\u2022 ${meals.strIngredient20} ${meals.strMeasure20}")
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}