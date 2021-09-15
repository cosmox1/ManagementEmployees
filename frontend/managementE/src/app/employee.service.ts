import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }



  public getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>('http://localhost:8080/employee');
  }

public addEmployee(employee: Employee): Observable<Employee>{
  return this.http.post<Employee>('http://localhost:8080/employee', employee);
}
public deleteEmployee(employeeId: number): Observable<void>{
  return this.http.delete<void>('http://localhost:8080/employee/${employeeId}');
}

public updateEmployee(employee: Employee): Observable<Employee>{
  return this.http.put<Employee>('http://localhost:8080/employee', employee);
}
}
