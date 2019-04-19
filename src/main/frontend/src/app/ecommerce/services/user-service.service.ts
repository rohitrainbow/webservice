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
    return this.http.post(`http://localhost/users/register`, user, { responseType: 'text'});
}
}
