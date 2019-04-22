import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/user';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  data: any;
  constructor(private http: HttpClient) { }

  register(user: User) {
    this.data = this.http.post(`users/register`, user, { responseType: 'text'});
    return this.data;
}
}
