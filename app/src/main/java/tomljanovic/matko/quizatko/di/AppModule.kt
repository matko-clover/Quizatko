package tomljanovic.matko.quizatko.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import tomljanovic.matko.quizatko.data.local.QuizatkoDatabase
import tomljanovic.matko.quizatko.data.remote.QuizatkoApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideRetrofitClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideQuizatkoApi(client: OkHttpClient): QuizatkoApi {
        return Retrofit.Builder()
            .baseUrl(QuizatkoApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideQuizatkoDatabase(app: Application): QuizatkoDatabase {
        return Room.databaseBuilder(app, QuizatkoDatabase::class.java, "quizatkodb.db").build()
    }
}
