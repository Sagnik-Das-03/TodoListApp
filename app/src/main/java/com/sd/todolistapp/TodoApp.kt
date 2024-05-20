package com.sd.todolistapp

import android.app.Application
import androidx.room.Room
import com.sd.todolistapp.database.TodoDatabase
import com.sd.todolistapp.repositories.TodoRepo
import com.sd.todolistapp.repositories.TodoRepoImpl
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class TodoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    Room
                        .databaseBuilder(this@TodoApp, TodoDatabase::class.java, "db")
                        .build()
                }
                single {
                    TodoRepoImpl(database = get())
                } bind TodoRepo::class
            })
        }
    }
}