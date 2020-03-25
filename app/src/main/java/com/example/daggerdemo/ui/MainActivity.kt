package com.example.daggerdemo.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerdemo.base.MyApplication
import com.example.daggerdemo.R
import com.example.daggerdemo.di.factory.ViewModelFactory
import com.example.daggerdemo.model.DataRP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainAdapter: MainAdapter

    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.getActivitySubComponent().inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getAllDataRP()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(dataList: List<DataRP>){
        progressBar.visibility = View.GONE
        Log.e("Data", "${dataList.size}")
        initRecyclerView(dataList)
    }

    private fun onError(throwable: Throwable){
        Log.e("error", throwable.localizedMessage)
    }

    private fun initRecyclerView(dataList: List<DataRP>) {
        mainRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        mainAdapter.setDataList(dataList)
        mainRecycler.adapter = mainAdapter
    }

}
