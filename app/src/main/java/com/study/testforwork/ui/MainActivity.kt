package com.study.testforwork.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.study.testforwork.databinding.ActivityMainBinding
import com.study.testforwork.domain.extensions.load
import com.study.testforwork.domain.model.UsersModel
import com.study.testforwork.domain.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        initObserver()
        initListeners()

    }


    private fun initListeners() {
        with(binding){
            btnUpdate.setOnClickListener {
                viewModel.getUsersFromApi()
            }
        }
    }

    private fun bindUserInfo(users: UsersModel){
        with(binding){
            sivProfile.load(url = users.picture)
            tvTitle.text = users.name
        }
    }

    private fun bindUserError(){
        Toast.makeText(this, "Unknown Error watafok", Toast.LENGTH_SHORT).show()
    }

    private fun initObserver() {
        viewModel.userState.observe(this) {
            when(it){
                is Resource.Success -> bindUserInfo(users = it.data!!)
                is Resource.Error -> bindUserError()
            }
        }

        viewModel.isLoading.observe(this){ trueOrFalse ->
            handleLoading(trueOrFalse)
        }
    }

    private fun handleLoading(isLoading: Boolean){
        with(binding){
            if (isLoading) {
                pbIndicator.visibility = View.VISIBLE
            } else {
                userInfo.visibility= View.VISIBLE
                pbIndicator.visibility = View.GONE
            }
        }
    }

}