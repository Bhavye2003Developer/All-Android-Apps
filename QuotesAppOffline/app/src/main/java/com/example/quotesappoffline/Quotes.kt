package com.example.quotesappoffline

class Quotes {
    private val quotes = listOf(
        "The only way to do great work is to love what you do. - Steve Jobs",
        "Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill",
        "Believe you can and you're halfway there. - Theodore Roosevelt",
        "Don't count the days; make the days count. - Muhammad Ali",
        "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt",
        "In the middle of every difficulty lies opportunity. - Albert Einstein",
        "It does not matter how slowly you go as long as you do not stop. - Confucius",
        "The only thing that stands between you and your dream is the will to try and the belief that it is actually possible. - Joel Brown",
        "Do not wait for the perfect moment, take the moment and make it perfect. - Unknown",
        "Your time is limited, don't waste it living someone else's life. - Steve Jobs",
        "You miss 100% of the shots you don't take. - Wayne Gretzky",
        "The best way to predict the future is to create it. - Peter Drucker",
        "The only person you are destined to become is the person you decide to be. - Ralph Waldo Emerson",
        "Dream big and dare to fail. - Norman Vaughan",
        "It always seems impossible until it is done. - Nelson Mandela",
        "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
        "You are never too old to set another goal or to dream a new dream. - C.S. Lewis",
        "Success is walking from failure to failure with no loss of enthusiasm. - Winston Churchill",
        "Happiness is not something ready made. It comes from your own actions. - Dalai Lama",
        "The journey of a thousand miles begins with one step. - Lao Tzu"
    )
    fun getQuote(): String {
        return quotes.random()
    }

}