package com.example.newsappkotlin.network



data class ArticlesJSON(
    var articles : List<Article>
)


data class Article(
    var author : String,
    var title: String,
    var publishedAt: String,
    var url: String
)
