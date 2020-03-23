package com.example.daggerdemo.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerdemo.MyApplication
import com.example.daggerdemo.R
import com.example.daggerdemo.di.main.DaggerActivityComponent
import com.example.daggerdemo.di.main.MainAdapterModule
import com.example.daggerdemo.model.ApiRP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainAdapter: MainAdapter

    lateinit var allData: List<ApiRP>

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val app = (application as MyApplication)

        val repo = app.getApiRepository().getApiRP()

        repo.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(allData: List<ApiRP>){
        progressBar.visibility = View.GONE

        initActivityComponent(allData)
        initRecyclerView()

        Log.e("data", "${allData.size}")
    }

    private fun onError(throwable: Throwable){
        Log.e("error", throwable.localizedMessage)
    }


    private fun initActivityComponent(allData: List<ApiRP>) {

        val activityComponent = DaggerActivityComponent
            .builder()
            .appComponent((application as MyApplication).getComponent())
            .mainAdapterModule(MainAdapterModule(allData))
            .build()

        activityComponent.inject(this)
    }

    private fun initRecyclerView() {
        mainRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mainRecycler.adapter = mainAdapter
    }

}
