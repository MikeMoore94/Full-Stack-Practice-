import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from "src/app/user";

@Injectable({
    providedIn: 'root',
})
export class UserService {

    private baseURL = "http://localhost:9090/api/v1/users";

    constructor(private httpClient: HttpClient) { }

    getUsers(): Observable<User[]> {
        return this.httpClient.get<User[]>(`${this.baseURL}`);
    }

    createUser(user: User): Observable<Object> {
        return this.httpClient.post(`${this.baseURL}`, user);
    }

    getUserById(id: number): Observable<User> {
        return this.httpClient.get<User>(`${this.baseURL}/${id}`);
    }

    updateUser(id: number, user: User): Observable<Object> {
        return this.httpClient.put(`${this.baseURL}/${id}`, user);
    }

    deleteUser(id: number): Observable<Object>{
        return this.httpClient.delete(`${this.baseURL}/${id}`);
    }
}