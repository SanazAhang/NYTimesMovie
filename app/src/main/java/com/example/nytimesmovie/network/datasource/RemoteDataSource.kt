package com.example.nytimesmovie.network.datasource

import com.example.nytimesmovie.data.model.Model

interface RemoteDataSource<T : Model> : DataSource<T>