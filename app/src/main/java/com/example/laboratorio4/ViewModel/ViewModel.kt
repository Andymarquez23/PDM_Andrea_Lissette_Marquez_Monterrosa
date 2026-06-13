package com.example.laboratorio4.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio4.DataBase.InitDatabase
import com.example.laboratorio4.Model.Task
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GeneralViewModel : ViewModel() {

    private val dao = InitDatabase.database.taskDao()

    val tasks = dao.getAllTasks().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        emptyList()
    )

    fun addTask(task: Task) {

        viewModelScope.launch {
            dao.insertTask(task)
        }

    }
}