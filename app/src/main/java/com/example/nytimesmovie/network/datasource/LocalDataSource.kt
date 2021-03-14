package com.example.nytimesmovie.network.datasource

import com.example.nytimesmovie.data.model.Model

interface LocalDataSource<T : Model> : DataSource<T>