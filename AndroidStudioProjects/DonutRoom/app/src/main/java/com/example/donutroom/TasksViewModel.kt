package com.example.donutroom


import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TasksViewModel(val dao: TaskDao):ViewModel() {

    var newTaskValue = ""
    private val tasks : LiveData<List<Task>> = dao.getAll()

    val tasksString = Transformations.map(tasks){

        tasks->formatTasks((tasks))
    }


    fun formatTasks(tasks:List<Task>):String{
        if(tasks.isNotEmpty()) {
            return convertToString(tasks.first())//edited to return most recent value in DB
        } else
            return "No data in database."
    }


    fun convertToString(task:Task):String{//edited to take int
        return "Recent Donuts Consumed: ${task.taskValue}"
    }

    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskValue = newTaskValue.toInt()//edited to expect int
            dao.insert(task)
        }
    }
}