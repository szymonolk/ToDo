import {Injectable, Output} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TaskModel} from "./model/TaskModel";
import {Observable} from "rxjs";



@Injectable({
  providedIn: 'root'
})
export class AppService {
  constructor(private http: HttpClient) {
  }

  getTasks(): Observable<TaskModel[]> {
    return this.http.get<TaskModel[]>('http://localhost:8080/task/all');

  }

  addTask(task: TaskModel): Observable<TaskModel> {
    return this.http.post<TaskModel>('http://localhost:8080/task/create', task);
  }

  deleteTask(id: number | undefined): Observable<unknown> {
    const url = 'http://localhost:8080/task/delete/' + id;
    return this.http.delete(url)
  }

  updateTaskStatus(id: number | undefined): Observable<unknown> {
    const url = 'http://localhost:8080/task/update/' + id
    return this.http.put(url, id);
  }
}
