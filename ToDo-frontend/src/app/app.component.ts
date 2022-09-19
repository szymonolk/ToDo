import {Component, Input} from '@angular/core';
import {TaskModel} from "./model/TaskModel";
import {AppService} from "./app.service";
import {HttpClient } from "@angular/common/http";
import {Observable } from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  taskModel: TaskModel = {title: '', priority: '',status: "No"};
  taskList: TaskModel[] = [];
  title: string = 'ToDoList'
  tasks: Observable<TaskModel[]>;

  constructor(private appService: AppService, private http: HttpClient, private router: Router) { }

  ngOnInit(){
    this.getTask();
  }

  getTask(){
    this.tasks = this.appService.getTasks();
  }

  addTask(){
    this.taskList.push(this.taskModel)
    console.log(this.taskModel)
    console.log(this.taskList)
    this.taskModel = {title: '', priority: '',status: "No"};
  }


  createTask(task: TaskModel){
    this.appService.addTask(task).subscribe(data => this.getTask());
    this.taskModel = {title: '', priority: '',status: "No"};
  }

  deleteTask(task: TaskModel) {
    this.appService.deleteTask(task.id).subscribe(data => this.getTask());
  }

  changeStatus(taskModel: TaskModel){
   this.appService.updateTaskStatus(taskModel.id).subscribe(data => this.getTask());
  }

  changeCssStatus(taskModel: TaskModel){
    switch (taskModel.status) {
      case 'No': {
        return 'btn btn-warning me-1';
      }
      case 'In Progress': {
        return 'btn btn-success me-1'
      }
      case 'Done': {
        return 'btn btn-success me-1 disabled'
      }
    }
  }

}
